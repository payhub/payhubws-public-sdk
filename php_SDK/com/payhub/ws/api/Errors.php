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
                $errors_tmp->{$key} = $value;
            }
            $errors[]=$errors_tmp;
        }
        return $errors;
    }
}