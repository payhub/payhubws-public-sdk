<?php

/**
 * Created by PhpStorm.
 * User: agustin
 * Date: 24/07/2015
 * Time: 11:26
 */
class MontlySchedule
{
    public $monthly_type;
    public $monthly_each_days;

    public static function fromArray($data){
        if(!is_null($data)) {
            $schedule = new MontlySchedule();
            foreach ($data as $key => $value) {
                if (property_exists(get_class($schedule), $key)) {
                    $schedule->{$key} = $value;
                }
            }
            return $schedule;
        }
    }
}