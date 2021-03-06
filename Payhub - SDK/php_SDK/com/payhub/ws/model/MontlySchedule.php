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
    public $monthly_on_the_day_of_week_in_month;
    public $monthly_day_of_week;

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