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

    /**
     * Schedule constructor.
     * @param $schedule_start_and_end
     * @param $monthly_schedule
     */
    public function __construct($schedule_start_and_end, $monthly_schedule)
    {
        if(!is_null($schedule_start_and_end) && !is_null($monthly_schedule)) {
            $this->schedule_start_and_end = $schedule_start_and_end;
            $this->monthly_schedule = $monthly_schedule;
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
                    } else {
                        $schedule->{$key} = $value;
                    }
                }
            }
            return $schedule;
        }
    }

}