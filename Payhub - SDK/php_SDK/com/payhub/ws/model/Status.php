<?php

/**
 * Created by PhpStorm.
 * User: agustin
 * Date: 24/07/2015
 * Time: 11:16
 */
class Status
{
    public $id;
    public $version;
    public $createdAt;
    public $lastModified;
    public $createdBy;
    public $lastModifiedBy;
    public $nextBillDate;
    public $recurring_bill_status;
    public $statusLastChangedOn;

    public static function fromArray($data){
        if(!is_null($data)) {
            $status = new Status();
            foreach ($data as $key => $value) {
                if (property_exists(get_class($status), $key)) {
                    $status->{$key} = $value;
                }
            }
            return $status;
        }
    }
}