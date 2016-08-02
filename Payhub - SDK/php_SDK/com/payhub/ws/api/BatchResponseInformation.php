<?php

/**
 * Created by PhpStorm.
 * User: agustin
 * Date: 24/07/2015
 * Time: 10:42
 */
class BatchResponseInformation
{
    public $transactions_detail;
    public $batch_status;
    public $batch_settled_on;
    public $batch_info;
    public $errors;

    public function __construct()
    {
    }

    public static function fromArray($data){
        $batch = new BatchResponseInformation();

        foreach ($data as $key => $value){
            if( property_exists( get_class($batch), $key ) ) {
                if($key=="transactions_detail"){
                    $myArray=array();
                    foreach ($value as $keys => $val) {
                        $_tmp = TransactionReportInformation::fromArray($val);
                        $myArray[] = $_tmp;
                    }
                    $batch->{$key}=$myArray;
                }elseif($key=="errors"){
                    $batch->{$key}=Errors::fromArray($value);
                }elseif($key=="batch_info"){
                    $batch->{$key}=BatchInfo::fromArray($value);
                }
                else{
                    $batch->{$key} = $value;
                }
            }
        }
        return $batch;
    }
}

class BatchInfo{
    public $all_transactions;
    public $credit_cards;

    public function __construct()
    {
    }

    public static function fromArray($data){
        $batch = new BatchInfo();

        foreach ($data as $key => $value){
            if( property_exists( get_class($batch), $key ) ) {
                if($key=="credit_cards"){
                    $_tmp = new CreditCards();
                    foreach ($value as $keys => $val) {
                        $_tmp = CreditCards::fromArray($val);
                        $myArray[] = $_tmp;
                    }
                    $batch->{$key} = $myArray;
                }elseif($key=="all_transactions"){
                    $batch->{$key}=AllTransactions::fromArray($value);
                }
            }
        }
        return $batch;
    }
}

class CreditCards{
    public $transactions_no;
    public $card_type;
    public $sales_total;
    public $refunds_total;
    public $transactions_total_net;

    public function __construct()
    {
    }
    public static function fromArray($data)
    {

        $settings = new CreditCards();
        foreach ($data as $key => $value) {
            if (property_exists(get_class($settings), $key)) {
                $settings->{$key} = $value;
            }
        }
        return $settings;
    }
}

class AllTransactions{
    public $transactions_no;
    public $sales_total;
    public $refunds_total;
    public $transactions_total_net;

    public function __construct()
    {
    }
    public static function fromArray($data)
    {

        $settings = new AllTransactions();
        foreach ($data as $key => $value) {
            if (property_exists(get_class($settings), $key)) {
                $settings->{$key} = $value;
            }
        }
        return $settings;
    }
}

class TransactionTotals{
    public $all_transactions;
    public $credit_cards;
    public $errors;

    public function __construct()
    {
    }
    public static function fromArray($data){
        $trn = new TransactionTotals();
        foreach ($data as $key => $value){
            if( property_exists( get_class($trn), $key ) ) {
                if($key=="credit_cards"){
                    $_tmp = new CreditCards();
                    foreach ($value as $keys => $val) {
                        $_tmp = CreditCards::fromArray($val);
                        $myArray[] = $_tmp;
                    }
                    $trn->{$key} = $myArray;
                }elseif($key=="all_transactions"){
                    $trn->{$key}=AllTransactions::fromArray($value);
                }elseif($key=="errors"){
                    $trn->{$key}=$value;
                }
            }
        }
        return $trn;
    }


}