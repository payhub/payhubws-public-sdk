<?php

/**
 * Created by PhpStorm.
 * User: agustin
 * Date: 27/07/2015
 * Time: 15:42
 */
class CustomerPhones
{
    public $phone;
    public $extension;
    public $type;

    public static function fromArray($data){
        if(!is_null($data)) {
            $cus = new CustomerPhones();
            foreach ($data as $key => $value) {
                $cus->{$key} = $value;
            }
            return $cus;
        }
    }
}