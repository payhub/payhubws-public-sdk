<?php
/**
 * Created by PhpStorm.
 * User: agustin
 * Date: 07/19/16
 * Time: 3:02 PM
 */

class Batch
{
    public static $BATCH_LINK = "batch/";
    private $terminalId;
    private $MSG;
    private $orgnazationId;
    private $batchId;
    private $TRN_RESPONSE;

    public function __construct()
    {
    }

    public static function fromArray($data)
    {
        $settings = new Batch();
        foreach ($data as $key => $value) {
            if (property_exists(get_class($settings), $key)) {
                if ($key == "TRN_RESPONSE") {
                    $_tmp = TransactionResponse::fromArray($value);
                    $settings->{$key} = $_tmp;
                }else{
                    $settings->{$key} = $value;
                }

            }
        }
        return $settings;
    }

    /**
     * @return mixed
     */
    public function getTerminalId()
    {
        return $this->terminalId;
    }

    /**
     * @param mixed $terminalId
     */
    public function setTerminalId($terminalId)
    {
        $this->terminalId = $terminalId;
    }

    /**
     * @return mixed
     */
    public function getMSG()
    {
        return $this->MSG;
    }

    /**
     * @param mixed $MSG
     */
    public function setMSG($MSG)
    {
        $this->MSG = $MSG;
    }

    /**
     * @return mixed
     */
    public function getOrgnazationId()
    {
        return $this->orgnazationId;
    }

    /**
     * @param mixed $orgnazationId
     */
    public function setOrgnazationId($orgnazationId)
    {
        $this->orgnazationId = $orgnazationId;
    }

    /**
     * @return mixed
     */
    public function getBatchId()
    {
        return $this->batchId;
    }

    /**
     * @param mixed $batchId
     */
    public function setBatchId($batchId)
    {
        $this->batchId = $batchId;
    }

    /**
     * @return mixed
     */
    public function getTRNRESPONSE()
    {
        return $this->TRN_RESPONSE;
    }

    /**
     * @param mixed $TRN_RESPONSE
     */
    public function setTRNRESPONSE($TRN_RESPONSE)
    {
        $this->TRN_RESPONSE = $TRN_RESPONSE;
    }


}
class TransactionResponse{
    private $RESPONSE_TEXT;
    private $RESPONSE_CODE;
    private $TRN_DATE_TIME;

    public function __construct()
    {
    }
    public static function fromArray($data)
    {

        $settings = new TransactionResponse();
        foreach ($data as $key => $value) {
            if (property_exists(get_class($settings), $key)) {
                $settings->{$key} = $value;
            }
        }
        return $settings;
    }

    /**
     * @return mixed
     */
    public function getRESPONSETEXT()
    {
        return $this->RESPONSE_TEXT;
    }

    /**
     * @param mixed $RESPONSE_TEXT
     */
    public function setRESPONSETEXT($RESPONSE_TEXT)
    {
        $this->RESPONSE_TEXT = $RESPONSE_TEXT;
    }

    /**
     * @return mixed
     */
    public function getRESPONSECODE()
    {
        return $this->RESPONSE_CODE;
    }

    /**
     * @param mixed $RESPONSE_CODE
     */
    public function setRESPONSECODE($RESPONSE_CODE)
    {
        $this->RESPONSE_CODE = $RESPONSE_CODE;
    }

    /**
     * @return mixed
     */
    public function getTRNDATETIME()
    {
        return $this->TRN_DATE_TIME;
    }

    /**
     * @param mixed $TRN_DATE_TIME
     */
    public function setTRNDATETIME($TRN_DATE_TIME)
    {
        $this->TRN_DATE_TIME = $TRN_DATE_TIME;
    }

}