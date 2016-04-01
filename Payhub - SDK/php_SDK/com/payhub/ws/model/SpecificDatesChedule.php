<?php

/**
 * Created by PhpStorm.
 * User: agustin
 * Date: 24/07/2015
 * Time: 11:26
 */
class SpecificDatesSchedule
{
    public $specific_dates;
    public static function fromArray($data){
        if(!is_null($data)) {
            $schedule = new SpecificDatesSchedule();
            foreach ($data as $key => $value) {
                if (property_exists(get_class($schedule), $key)) {
                    $schedule->{$key} = $value;
                }
            }
            return $schedule;
        }
    }
}