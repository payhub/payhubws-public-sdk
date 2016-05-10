<?php

/**
 * Created by PhpStorm.
 * User: agustin
 * Date: 12/18/15
 * Time: 1:33 PM
 */
class EmailConfiguration
{
    public static $EMAIL_LINK = "adminSettings/emailConfiguration";
    public $emailRbFailTransaction;
    public $emailRbSuccessTransaction;
    public $emailBatchFail;
    public $emailBatchSuccess;
    public $emailTrnReceipt;
    public $emailExpPsw;
    public $customBatchReport;
    public $pdfOrCsvForBatch;
    public $customRBReport;
    public $pdfOrCsvForRB;
    /**
     * EmailConfiguration constructor.
     */
    public function __construct()
    {
    }

    /**
     * @return mixed
     */
    public function getEmailRbFailTransaction()
    {
        return $this->emailRbFailTransaction;
    }

    /**
     * @param mixed $emailRbFailTransaction
     */
    public function setEmailRbFailTransaction($emailRbFailTransaction)
    {
        $this->emailRbFailTransaction = $emailRbFailTransaction;
    }

    /**
     * @return mixed
     */
    public function getEmailRbSuccessTransaction()
    {
        return $this->emailRbSuccessTransaction;
    }

    /**
     * @param mixed $emailRbSuccessTransaction
     */
    public function setEmailRbSuccessTransaction($emailRbSuccessTransaction)
    {
        $this->emailRbSuccessTransaction = $emailRbSuccessTransaction;
    }

    /**
     * @return mixed
     */
    public function getEmailBatchFail()
    {
        return $this->emailBatchFail;
    }

    /**
     * @param mixed $emailBatchFail
     */
    public function setEmailBatchFail($emailBatchFail)
    {
        $this->emailBatchFail = $emailBatchFail;
    }

    /**
     * @return mixed
     */
    public function getEmailBatchSuccess()
    {
        return $this->emailBatchSuccess;
    }

    /**
     * @param mixed $emailBatchSuccess
     */
    public function setEmailBatchSuccess($emailBatchSuccess)
    {
        $this->emailBatchSuccess = $emailBatchSuccess;
    }

    /**
     * @return mixed
     */
    public function getEmailTrnReceipt()
    {
        return $this->emailTrnReceipt;
    }

    /**
     * @param mixed $emailTrnReceipt
     */
    public function setEmailTrnReceipt($emailTrnReceipt)
    {
        $this->emailTrnReceipt = $emailTrnReceipt;
    }

    /**
     * @return mixed
     */
    public function getEmailExpPsw()
    {
        return $this->emailExpPsw;
    }

    /**
     * @param mixed $emailExpPsw
     */
    public function setEmailExpPsw($emailExpPsw)
    {
        $this->emailExpPsw = $emailExpPsw;
    }

    /**
     * @return mixed
     */
    public function getCustomBatchReport()
    {
        return $this->customBatchReport;
    }

    /**
     * @param mixed $customBatchReport
     */
    public function setCustomBatchReport($customBatchReport)
    {
        $this->customBatchReport = $customBatchReport;
    }

    /**
     * @return mixed
     */
    public function getPdfOrCsvForBatch()
    {
        return $this->pdfOrCsvForBatch;
    }

    /**
     * @param mixed $pdfOrCsvForBatch
     */
    public function setPdfOrCsvForBatch($pdfOrCsvForBatch)
    {
        $this->pdfOrCsvForBatch = $pdfOrCsvForBatch;
    }

    /**
     * @return mixed
     */
    public function getCustomRBReport()
    {
        return $this->customRBReport;
    }

    /**
     * @param mixed $customRBReport
     */
    public function setCustomRBReport($customRBReport)
    {
        $this->customRBReport = $customRBReport;
    }

    /**
     * @return mixed
     */
    public function getPdfOrCsvForRB()
    {
        return $this->pdfOrCsvForRB;
    }

    /**
     * @param mixed $pdfOrCsvForRB
     */
    public function setPdfOrCsvForRB($pdfOrCsvForRB)
    {
        $this->pdfOrCsvForRB = $pdfOrCsvForRB;
    }

    public static function fromArray($data)
    {
        $wh = new EmailConfiguration();
        foreach ($data as $key => $value) {
            if (property_exists(get_class($wh), $key)) {
                    $wh->{$key} = $value;
            }
        }
        return $wh;
    }

    public function object_unset_nulls_for_send()
    {
        $object = (object) array_filter((array) $this, function ($val) {
            return !is_null($val);
        });
        return $object;
    }

}