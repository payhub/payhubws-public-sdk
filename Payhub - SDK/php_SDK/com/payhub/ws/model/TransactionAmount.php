<?php

/**
 * Created by PhpStorm.
 * User: agustin
 * Date: 27/07/2015
 * Time: 11:01
 */
class TransactionAmount
{
    private static $serialVersionUID = "-635976989093261428L";
    private $CURRENCY_CODE= "en-US";
    public $amount;
    private $USD;
	private $currency;

    /**
     * TransactionAmount constructor.
     * @param $amount
     * @param $USD
     */
    public function __construct($amount)
    {
		$this->amount=number_format($amount, 2, '.', ',');
        //$this->amount = $amount;
       // $this->setTransactionAmount($this->amount,new NumberFormatter($this->CURRENCY_CODE, NumberFormatter::CURRENCY));
    }
/*    public function setTransactionAmount($amount, $usd){
        $this->amount=$amount;
        $this->USD=$usd->getTextAttribute(NumberFormatter::CURRENCY_CODE);
    }
*/
    public static function fromArray($data){
        if(!is_null($data)) {
            $transactionAmount = new TransactionAmount($data["amount"]);
            return $transactionAmount;
        }
    }

}