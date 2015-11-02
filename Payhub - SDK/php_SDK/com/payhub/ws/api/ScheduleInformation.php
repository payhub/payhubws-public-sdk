<?php

/**
 * Created by PhpStorm.
 * User: agustin
 * Date: 24/07/2015
 * Time: 11:05
 */
class ScheduleInformation extends AbstractInfo
{
    private $schedule;
    /**
     * RefundInformation constructor.
     * @param $transactionManager
     */
    public function __construct($transactionManager)
    {
        if(!is_null($transactionManager)) {
            $this->transactionManager = $transactionManager;
        }
        $this->transactionType=TransactionType::Schedule;
    }
    /**
     * @return mixed
     */
    public function getSchedule()
    {
        return $this->schedule;
    }

    /**
     * @param mixed $schedule
     */
    public function setSchedule($schedule)
    {
        $this->schedule = $schedule;
    }

    public function convertData($json)
    {
        $data = json_decode($json, true);
        $this->schedule = Schedule::fromArray($data);
    }

    public function getUrlForTransactionType($type)
    {
        $url=null;
        if(TransactionType::Sale==($type)){
            $url =  "sale/";
        }
        if(TransactionType::AuthOnly==($type)){
            $url =  "authonly/";
        }
        if(TransactionType::Capture==($type)){
            $url =  "capture/";
        }if(TransactionType::Bill==($type)){
        $url =  "bill";
        }if(TransactionType::CardData==($type)){
            $url =  "carddata/";
        }if(TransactionType::Customer==($type)){
            $url =  "customer/";
        }if(TransactionType::Merchant==($type)){
            $url =  "merchant/";
        }if(TransactionType::RecurringBill==($type)){
            $url =  "recurring-bill/";
        }if(TransactionType::Schedule==($type)){
            $url =  "schedule/";
        }if(TransactionType::Refund==($type)){
            $url =  "refund/";
        }if(TransactionType::VoidTransaction==($type)){
            $url =  "void/";
        }
        if(TransactionType::Verify==($type)){
            $url =  "verify/";
        }
        return $url;
    }
}