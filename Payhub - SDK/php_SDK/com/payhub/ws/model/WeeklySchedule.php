<?php

/**
 * Created by PhpStorm.
 * User: agustin
 * Date: 24/07/2015
 * Time: 11:26
 */
class WeeklySchedule
{
    public $weekly_bill_days;

    public static function fromArray($data){
        if(!is_null($data)) {
            $schedule = new WeeklySchedule();
            foreach ($data as $key => $value) {
                if (property_exists(get_class($schedule), $key)) {
                    $schedule->{$key} = $value;
                }
            }
            return $schedule;
        }
    }
}