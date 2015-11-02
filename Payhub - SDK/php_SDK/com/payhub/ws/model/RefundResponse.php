<?php

/**
 * Created by PhpStorm.
 * User: agustin
 * Date: 28/07/2015
 * Time: 09:19
 */
class RefundResponse
{
    public $saleTransactionId;
    public $refundTransactionId;
    public $token;

    public static function fromArray($data){
        if(!is_null($data)) {
            $refund = new RefundResponse();

            foreach ($data as $key => $value) {
                if (property_exists(get_class($refund), $key)) {
                    $refund->{$key} = $value;
                    }
                }
            return $refund;
        }
    }

}