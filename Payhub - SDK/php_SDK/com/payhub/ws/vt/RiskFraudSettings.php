<?php

/**
 * Created by PhpStorm.
 * User: agustin
 * Date: 12/18/15
 * Time: 1:33 PM
 */
class RiskFraudSettings
{
    public static $RISK_FRAUD_SETTINGS_LINK="adminSettings/riskFraud";
    public static $RISK_FRAUD_PATCH_SETTINGS_LINK = "adminSettings/riskFraudDetection";
    public $transaction_volume_settings;
    public $card_filtering;
    public $email;
    public $credit_card_security_codes;
    public $address_verification_system;

    /**
     * RiskFraudSettings constructor.
     */
    public function __construct()
    {
    }

    public function object_unset_nulls_for_send()
    {
        $array = $this->getStripped($this);
        return $array;

    }
    private function getStripped($obj) {
        $objVars = get_object_vars($obj);

        if(count($objVars) > 0) {
            foreach($objVars as $propName => $propVal) {
                if(gettype($propVal) == "object") {
                    $cObj = $this->getStripped($propVal);
                    if($cObj == null) {
                        unset($obj->$propName);
                    } else {
                        $obj->$propName = $cObj;
                    }
                } else {
                    if(empty($propVal)) {
                        unset($obj->$propName);
                    }
                }
            }
        } else {
            return null;
        }
        return $obj;
    }
    /**
     * @return mixed
     */
    public function getTransactionVolumeSettings()
    {
        return $this->transaction_volume_settings;
    }

    /**
     * @param mixed $transaction_volume_settings
     */
    public function setTransactionVolumeSettings($transaction_volume_settings)
    {
        $this->transaction_volume_settings = $transaction_volume_settings;
    }

    /**
     * @return mixed
     */
    public function getCardFiltering()
    {
        return $this->card_filtering;
    }

    /**
     * @param mixed $card_filtering
     */
    public function setCardFiltering($card_filtering)
    {
        $this->card_filtering = $card_filtering;
    }

    /**
     * @return mixed
     */
    public function getEmail()
    {
        return $this->email;
    }

    /**
     * @param mixed $email
     */
    public function setEmail($email)
    {
        $this->email = $email;
    }

    /**
     * @return mixed
     */
    public function getCreditCardSecurityCodes()
    {
        return $this->credit_card_security_codes;
    }

    /**
     * @param mixed $credit_card_security_codes
     */
    public function setCreditCardSecurityCodes($credit_card_security_codes)
    {
        $this->credit_card_security_codes = $credit_card_security_codes;
    }

    /**
     * @return mixed
     */
    public function getAddressVerificationSystem()
    {
        return $this->address_verification_system;
    }

    /**
     * @param mixed $address_verification_system
     */
    public function setAddressVerificationSystem($address_verification_system)
    {
        $this->address_verification_system = $address_verification_system;
    }



    public static function fromArray($data)
    {
        $rf = new RiskFraudSettings();
        foreach ($data as $key => $value) {
            if($key=="transaction_volume_settings"){
                $rf->{$key}=TrnVolSet::fromArray($value);
            }if($key=="card_filtering"){
                $rf->{$key}=CardFiltering::fromArray($value);
            }if($key=="email"){
                $rf->{$key}=RiskEmail::fromArray($value);
            }if($key=="credit_card_security_codes"){
                $rf->{$key}=CreditCardSecurityCodes::fromArray($value);
            }if($key=="address_verification_system"){
                $rf->{$key}=Avs::fromArray($value);
            }
        }
        return $rf;
    }
}

class TrnVolSet{
    public $refund_trn_amount_below;
    public $hours_trn_number_more_than;
    public $days_trn_amount_more_than;
    public $sale_trn_amount_below;
    public $refund_trn_amount_above;
    public $days_trn_number_more_than;
    public $sale_trn_amount_above;
    public $checked;

    /**
     * TrnVolSet constructor.
     */
    public function __construct()
    {
    }

    /**
     * @return mixed
     */
    public function getRefundTrnAmountBelow()
    {
        return $this->refund_trn_amount_below;
    }

    /**
     * @param mixed $refund_trn_amount_below
     */
    public function setRefundTrnAmountBelow($refund_trn_amount_below)
    {
        $this->refund_trn_amount_below = $refund_trn_amount_below;
    }

    /**
     * @return mixed
     */
    public function getHoursTrnNumberMoreThan()
    {
        return $this->hours_trn_number_more_than;
    }

    /**
     * @param mixed $hours_trn_number_more_than
     */
    public function setHoursTrnNumberMoreThan($hours_trn_number_more_than)
    {
        $this->hours_trn_number_more_than = $hours_trn_number_more_than;
    }

    /**
     * @return mixed
     */
    public function getDaysTrnAmountMoreThan()
    {
        return $this->days_trn_amount_more_than;
    }

    /**
     * @param mixed $days_trn_amount_more_than
     */
    public function setDaysTrnAmountMoreThan($days_trn_amount_more_than)
    {
        $this->days_trn_amount_more_than = $days_trn_amount_more_than;
    }

    /**
     * @return mixed
     */
    public function getSaleTrnAmountBelow()
    {
        return $this->sale_trn_amount_below;
    }

    /**
     * @param mixed $sale_trn_amount_below
     */
    public function setSaleTrnAmountBelow($sale_trn_amount_below)
    {
        $this->sale_trn_amount_below = $sale_trn_amount_below;
    }

    /**
     * @return mixed
     */
    public function getRefundTrnAmountAbove()
    {
        return $this->refund_trn_amount_above;
    }

    /**
     * @param mixed $refund_trn_amount_above
     */
    public function setRefundTrnAmountAbove($refund_trn_amount_above)
    {
        $this->refund_trn_amount_above = $refund_trn_amount_above;
    }

    /**
     * @return mixed
     */
    public function getDaysTrnNumberMoreThan()
    {
        return $this->days_trn_number_more_than;
    }

    /**
     * @param mixed $days_trn_number_more_than
     */
    public function setDaysTrnNumberMoreThan($days_trn_number_more_than)
    {
        $this->days_trn_number_more_than = $days_trn_number_more_than;
    }

    /**
     * @return mixed
     */
    public function getSaleTrnAmountAbove()
    {
        return $this->sale_trn_amount_above;
    }

    /**
     * @param mixed $sale_trn_amount_above
     */
    public function setSaleTrnAmountAbove($sale_trn_amount_above)
    {
        $this->sale_trn_amount_above = $sale_trn_amount_above;
    }

    /**
     * @return mixed
     */
    public function getChecked()
    {
        return $this->checked;
    }

    /**
     * @param mixed $checked
     */
    public function setChecked($checked)
    {
        $this->checked = $checked;
    }


    public static function fromArray($data){
        $trn_tmp= new TrnVolSet();
        foreach ($data as $key => $value){
            if($key=="checked"){
                $trn_tmp->{$key} = $value;
            }else{
                $trn_tmp->{$key}=OptionAndValue::fromArray($value);
            }
        }
        return $trn_tmp;
    }
}

class CardFiltering{
    public $checked;
    /**
     * CardFiltering constructor.
     */
    public function __construct()
    {
    }

    /**
     * @return mixed
     */
    public function getChecked()
    {
        return $this->checked;
    }

    /**
     * @param mixed $checked
     */
    public function setChecked($checked)
    {
        $this->checked = $checked;
    }


    public static function fromArray($data)
    {
        $vd = new CardFiltering();
        foreach ($data as $key => $value) {
                $vd->{$key} = $value;
        }
        return $vd;
    }
}

class RiskEmail{
    public $checked;
    public $email_address;

    /**
     * RiskEmail constructor.
     */
    public function __construct()
    {
    }

    /**
     * @return mixed
     */
    public function getChecked()
    {
        return $this->checked;
    }

    /**
     * @param mixed $checked
     */
    public function setChecked($checked)
    {
        $this->checked = $checked;
    }

    /**
     * @return mixed
     */
    public function getEmailAddress()
    {
        return $this->email_address;
    }

    /**
     * @param mixed $email_address
     */
    public function setEmailAddress($email_address)
    {
        $this->email_address = $email_address;
    }

    public static function fromArray($data)
    {
        $vd = new RiskEmail();
        foreach ($data as $key => $value) {
            $vd->{$key} = $value;
        }
        return $vd;
    }
}
class CreditCardSecurityCodes {
    public $cvv_mismatch;
    public $checked;

    /**
     * CreditCardSecurityCodes constructor.
     */
    public function __construct()
    {
    }

    /**
     * @return mixed
     */
    public function getCvvMismatch()
    {
        return $this->cvv_mismatch;
    }

    /**
     * @param mixed $cvv_mismatch
     */
    public function setCvvMismatch($cvv_mismatch)
    {
        $this->cvv_mismatch = $cvv_mismatch;
    }

    /**
     * @return mixed
     */
    public function getChecked()
    {
        return $this->checked;
    }

    /**
     * @param mixed $checked
     */
    public function setChecked($checked)
    {
        $this->checked = $checked;
    }

    public static function fromArray($data){
        $trn_tmp= new CreditCardSecurityCodes();
        foreach ($data as $key=>$value){
            if($key=="checked"){
                $trn_tmp->{$key} = $value;
            }else{
                $trn_tmp->{$key}=OptionAndValue::fromArray($value);
            }
        }
        return $trn_tmp;
    }
}
class Avs{

    public $avs_mismatch_street_and_zip_code;
    public $avs_mismatch_street;
    public $avs_mismatch_zip_code;
    public $checked;

    /**
     * Avs constructor.
     */
    public function __construct()
    {
    }

    /**
     * @return mixed
     */
    public function getAvsMismatchStreetAndZipCode()
    {
        return $this->avs_mismatch_street_and_zip_code;
    }

    /**
     * @param mixed $avs_mismatch_street_and_zip_code
     */
    public function setAvsMismatchStreetAndZipCode($avs_mismatch_street_and_zip_code)
    {
        $this->avs_mismatch_street_and_zip_code = $avs_mismatch_street_and_zip_code;
    }

    /**
     * @return mixed
     */
    public function getAvsMismatchStreet()
    {
        return $this->avs_mismatch_street;
    }

    /**
     * @param mixed $avs_mismatch_street
     */
    public function setAvsMismatchStreet($avs_mismatch_street)
    {
        $this->avs_mismatch_street = $avs_mismatch_street;
    }

    /**
     * @return mixed
     */
    public function getAvsMismatchZipCode()
    {
        return $this->avs_mismatch_zip_code;
    }

    /**
     * @param mixed $avs_mismatch_zip_code
     */
    public function setAvsMismatchZipCode($avs_mismatch_zip_code)
    {
        $this->avs_mismatch_zip_code = $avs_mismatch_zip_code;
    }

    /**
     * @return mixed
     */
    public function getChecked()
    {
        return $this->checked;
    }

    /**
     * @param mixed $checked
     */
    public function setChecked($checked)
    {
        $this->checked = $checked;
    }


    public static function fromArray($data){
        $trn_tmp= new Avs();
        foreach ($data as $key => $value){
                if (property_exists(get_class($trn_tmp), $key)) {
                    if($key=="checked"){
                        $trn_tmp->{$key} = $value;
                    }else{
                        $trn_tmp->{$key}=OptionAndValue::fromArray($value);
                    }
                }
        }
        return $trn_tmp;
    }
}

class OptionAndValue{

    public $value;
    public $option;

    /**
     * OptionAndValue constructor.
     */
    public function __construct()
    {
    }

    /**
     * @return mixed
     */
    public function getValue()
    {
        return $this->value;
    }

    /**
     * @param mixed $value
     */
    public function setValue($value)
    {
        $this->value = $value;
    }

    /**
     * @return mixed
     */
    public function getOption()
    {
        return $this->option;
    }

    /**
     * @param mixed $option
     */
    public function setOption($option)
    {
        $this->option = $option;
    }


    public static function fromArray($data)
    {

        $vd = new OptionAndValue();
        foreach ($data as $key => $value) {
            $vd->{$key} = $value;
        }
        return $vd;
    }
}