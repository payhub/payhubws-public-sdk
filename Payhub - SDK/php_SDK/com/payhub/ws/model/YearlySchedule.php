<?php

/**
 * Created by PhpStorm.
 * User: agustin
 * Date: 24/07/2015
 * Time: 11:26
 */
class YearlySchedule
{
    public $year_to_start;
    public $yearly_bill_on_month_number;
    public $yearly_bill_on_day_of_month;

    public static function fromArray($data){
        if(!is_null($data)) {
            $schedule = new YearlySchedule();
            foreach ($data as $key => $value) {
                if (property_exists(get_class($schedule), $key)) {
                    $schedule->{$key} = $value;
                }
            }
            return $schedule;
        }
    }
}