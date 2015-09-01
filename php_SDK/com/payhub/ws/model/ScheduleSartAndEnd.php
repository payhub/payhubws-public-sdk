<?php

/**
 * Created by PhpStorm.
 * User: agustin
 * Date: 24/07/2015
 * Time: 11:21
 */
class ScheduleSartAndEnd
{
    public $start_date;
    public $end_date_type;
    public $end_date;

    public static function fromArray($data){
        if(!is_null($data)) {
            $schedule = new ScheduleSartAndEnd();
            foreach ($data as $key => $value) {
                if (property_exists(get_class($schedule), $key)) {
                        $schedule->{$key} = $value;
                }
            }
            return $schedule;
        }
    }
}