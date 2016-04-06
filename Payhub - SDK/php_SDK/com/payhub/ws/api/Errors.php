<?php

/**
 * Created by PhpStorm.
 * User: agustin
 * Date: 24/07/2015
 * Time: 10:42
 */
class Errors
{
    public $status;
    public $code;
    public $location;
    public $reason;
    public $severity;

    public static function fromArray($data){
        foreach ($data as $error) {
            $errors_tmp = new Errors();
            foreach ($error as $key => $value) {
                if($key=="error"){
                    $errors_tmp->{"location"} = $value;
                }elseif($key=="error_description"){
                    $errors_tmp->{"reason"} = $value;
                }elseif($key=="cause"){
                    $errors_tmp->{"location"} = $value;
                }elseif($key=="message"){
                    $errors_tmp->{"reason"} = $value;
                }else{
                    $errors_tmp->{$key} = $value;
                }

            }
            $errors[]=$errors_tmp;
        }

        return $errors;
    }
    public static function fromArrayForUnautenticated($data){
        $errors_tmp = new Errors();
        foreach ($data as $key => $value) {
            if($key=="error"){
                $errors_tmp->{"location"} = $value;
            }elseif($key=="error_description"){
                $errors_tmp->{"reason"} = $value;
            }elseif($key=="cause"){
                $errors_tmp->{"location"} = $value;
            }elseif($key=="message"){
                $errors_tmp->{"reason"} = $value;
            }else{
                $errors_tmp->{$key} = $value;
            }
        }
        $errors_aux["errors"][]=$errors_tmp;

        return $errors_aux;
    }

    public static function fromArrayForBadRequest($data){
        if(array_key_exists('errors',$data)){
            return $data;
        }else {
            $errors_tmp = new Errors();
            foreach ($data as $key => $value) {
                if ($key == "error") {
                    $errors_tmp->{"location"} = $value;
                } elseif ($key == "error_description") {
                    $errors_tmp->{"reason"} = $value;
                } elseif ($key == "cause") {
                    $errors_tmp->{"location"} = $value;
                } elseif ($key == "message") {
                    $errors_tmp->{"reason"} = $value;
                } else {
                    $errors_tmp->{$key} = $value;
                }
            }
            $errors_aux["errors"][] = $errors_tmp;

            return $errors_aux;
        }
    }
}