<?php

/**
 * Created by PhpStorm.
 * User: agustin
 * Date: 23/07/2015
 * Time: 13:04
 */
class WsConnections
{
    private $token;

    /**
     * WsConnections constructor.
     * @param $token
     */

    public function __construct($token)
    {
        if(!is_null($token)) {
            $this->token = $token;
        }
        else{
            $this->token="";
        }
    }

    /**
     * @return string
     */
    public function getToken()
    {
        return $this->token;
    }

    /**
     * @param string $token
     */
    public function setToken($token)
    {
        $this->token = $token;
    }


    public function setHeadersPost($WsURL,$token)
    {
        $this->token=$token;
        $request = curl_init();
        curl_setopt($request, CURLOPT_URL, $WsURL);
        curl_setopt($request, CURLOPT_HEADER, 1);
        curl_setopt($request, CURLOPT_CUSTOMREQUEST, "POST");
        curl_setopt($request, CURLOPT_HTTPHEADER, array(
                'Content-Type: application/json',
                'Accept: application/json',
                'Authorization: Bearer '. $this->token)
        );
        curl_setopt($request, CURLOPT_FOLLOWLOCATION, 1);
        curl_setopt($request, CURLOPT_RETURNTRANSFER, 1);
        curl_setopt($request, CURLOPT_SSL_VERIFYPEER, 0);
        return $request;
    }

    public function setHeadersGet($WsURL,$token)
    {
        $this->token=$token;
        $request = curl_init();
        curl_setopt($request, CURLOPT_URL, $WsURL);
       // curl_setopt($request, CURLOPT_HEADER, 1);
        curl_setopt($request, CURLOPT_CUSTOMREQUEST, "GET");
        curl_setopt($request, CURLOPT_HTTPHEADER, array(
                'Content-Type: application/json',
                'Accept: application/json',
                'Authorization: Bearer '. $this->token)
        );
     //   curl_setopt($request, CURLOPT_FOLLOWLOCATION, 1);
        curl_setopt($request, CURLOPT_RETURNTRANSFER, 1);
        curl_setopt($request, CURLOPT_SSL_VERIFYPEER, 0);
        return $request;
    }

    public function setHeadersPut($WsURL,$token)
    {
        echo $WsURL;

        $this->token=$token;
        $request = curl_init();
        curl_setopt($request, CURLOPT_URL, $WsURL);
        curl_setopt($request, CURLOPT_CUSTOMREQUEST, "PUT");
        curl_setopt($request, CURLOPT_HTTPHEADER, array(
                'Content-Type: application/json',
                'Accept: application/json',
                'Authorization: Bearer '. $this->token)
        );
        curl_setopt($request, CURLOPT_RETURNTRANSFER, 1);
        curl_setopt($request, CURLOPT_HEADER, 1);
        curl_setopt($request, CURLOPT_SSL_VERIFYPEER, 0);

        return $request;
    }

    public function setHeadersPatch($WsURL,$token)
    {
        $this->token=$token;
        $request = curl_init();
        curl_setopt($request, CURLOPT_URL, $WsURL);
        curl_setopt($request, CURLOPT_CUSTOMREQUEST, "PATCH");
        curl_setopt($request, CURLOPT_HTTPHEADER, array(
                'Content-Type: application/json',
                'Accept: application/json',
                'Authorization: Bearer '. $this->token)
        );
        curl_setopt($request, CURLOPT_RETURNTRANSFER, 1);
        curl_setopt($request, CURLOPT_HEADER, 1);
        curl_setopt($request, CURLOPT_SSL_VERIFYPEER, 0);

        return $request;
    }

    public function doPost($request, $_url){
        $response = curl_exec($request);
        $curl_info = curl_getinfo($request);
        $httpcode = curl_getinfo($request, CURLINFO_HTTP_CODE);
        curl_close($request);
        if ($httpcode==201){
            //find the url of the sale (Location header in the response)
//            $header = substr($response, 0, $header_size);
            $headers = substr($response, 0, $curl_info["header_size"]);
            preg_match("!\r\n(?:Location): *(.*?) *\r\n!", $headers, $matches);
            //$url contains the URL to GET the data from the Web Service
            $url = $matches[1];
            $request = $this->setHeadersGet($url,$this->getToken());
            $array = $this->doGet($request);
            return $array;
        }
        //There was an error with the WS
        else{
            $p = strpos($response, "\r\n\r\n");
            if( $p !== false ) {
                $rawHeades = substr($response, 0, $p);
                $rawBody = substr($response, $p + 4);
            }
            $data = json_decode($rawBody, true);
            return $data;
        }
    }
    public function doGet($request){
        $response = curl_exec($request);
        $httpcode = curl_getinfo($request, CURLINFO_HTTP_CODE);
        curl_close($request);
        if ($httpcode>=200 && $httpcode< 400){
            $data = json_decode($response, true);
            return $data;
        } else {
            $rawBody="{\"errors\":[{\"status\":\"BAD_REQUEST\",\"code\": \"9995\",\"location\": \"404 Page not found.\",\"reason\": \"\",\"severity\": \"ERROR\"}]}";
            $data = json_decode($rawBody, true);
            return $data;
        }
    }
    public function doPut($request,$json){
        echo $json;
        curl_setopt($request, CURLOPT_POSTFIELDS, $json);
        $response = curl_exec($request);
        $p = strpos($response, "\r\n\r\n");
        if( $p !== false ) {
            $rawBody = substr($response, $p + 4);
        }
        $data = json_decode($rawBody, true);
        return $data;
    }

    public function doPatch($request,$json){
        curl_setopt($request, CURLOPT_POSTFIELDS, $json);
        $response = curl_exec($request);
        $httpcode = curl_getinfo($request, CURLINFO_HTTP_CODE);
        if ($httpcode>=200 && $httpcode< 400){
            return true;
        }else{
            return false;
        }

    }
    public function doPostForRoles($request,$json){
        curl_setopt($request, CURLOPT_POSTFIELDS, $json);

        $response = curl_exec($request);
        $header_size = curl_getinfo($request, CURLINFO_HEADER_SIZE);
        $header = substr($response, 0, $header_size);
        $body = substr($response, $header_size);
        $data = json_decode($body, true);
        return $data;

    }
    public function findTransactionReports($request,$json){
        $json=preg_replace('/,\s*"[^"]+":null|"[^"]+":null,?/', '', $json);
        curl_setopt($request, CURLOPT_POSTFIELDS, $json);
        $response = curl_exec($request);
        $httpcode = curl_getinfo($request, CURLINFO_HTTP_CODE);
        curl_close($request);
        $p = strpos($response, "\r\n\r\n");
        if( $p !== false ) {
            $rawHeades = substr($response, 0, $p);
            $rawBody = substr($response, $p + 4);
        }
        $data = json_decode($rawBody, true);
        return $data;
    }
}