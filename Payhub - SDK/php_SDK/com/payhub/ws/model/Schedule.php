<?php

/**
 * Created by PhpStorm.
 * User: agustin
 * Date: 24/07/2015
 * Time: 11:23
 */
class Schedule
{
    public $schedule_type;
    public $bill_generation_interval;
    public $schedule_start_and_end;
    public $monthly_schedule;
    public $yearly_schedule;
    public $weekly_schedule;
    public $specific_dates_schedule;

    /**
     * Schedule constructor.
     * @param $schedule_type
     */
    public function __construct($schedule_type)
    {
        if(!is_null($schedule_type)) {
            $this->schedule_type = $schedule_type;
        }
    }
    public static function fromArray($data){
        if(!is_null($data)) {
            $schedule = new Schedule(null,null);
            foreach ($data as $key => $value) {
                if (property_exists(get_class($schedule), $key)) {
                    if ($key == "schedule_start_and_end") {
                        $schedule->{$key} = ScheduleSartAndEnd::fromArray($value);
                    } elseif ($key == "monthly_schedule") {
                        $schedule->{$key} = MontlySchedule::fromArray($value);
                    } elseif ($key == "yearly_schedule") {
                        $schedule->{$key} = YearlySchedule::fromArray($value);
                    }elseif ($key == "weekly_schedule") {
                        $schedule->{$key} = WeeklySchedule::fromArray($value);
                    }elseif ($key == "specific_dates_schedule") {
                        $schedule->{$key} = SpecificDatesSchedule::fromArray($value);
                    }else {
                        $schedule->{$key} = $value;
                    }
                }
            }
            return $schedule;
        }
    }

}