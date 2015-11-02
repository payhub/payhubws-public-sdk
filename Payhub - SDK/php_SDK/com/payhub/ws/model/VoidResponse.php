<?php

/**
 * Created by PhpStorm.
 * User: agustin
 * Date: 24/07/2015
 * Time: 11:12
 */
class VoidResponse
{
    public $saleTransactionId;
    public $voidTransactionId;
    public $token;

    /**
     * @return mixed
     */
    public function getSaleTransactionId()
    {
        return $this->saleTransactionId;
    }

    /**
     * @param mixed $saleTransactionId
     */
    public function setSaleTransactionId($saleTransactionId)
    {
        $this->saleTransactionId = $saleTransactionId;
    }

    /**
     * @return mixed
     */
    public function getVoidTransactionId()
    {
        return $this->voidTransactionId;
    }

    /**
     * @param mixed $voidTransactionId
     */
    public function setVoidTransactionId($voidTransactionId)
    {
        $this->voidTransactionId = $voidTransactionId;
    }

    /**
     * @return mixed
     */
    public function getToken()
    {
        return $this->token;
    }

    /**
     * @param mixed $token
     */
    public function setToken($token)
    {
        $this->token = $token;
    }


    public static function fromArray($data){
        if(!is_null($data)) {
            $void = new VoidResponse();

            foreach ($data as $key => $value) {
                if (property_exists(get_class($void), $key)) {
                    $void->{$key} = $value;
                }
            }
            return $void;
        }
    }
}