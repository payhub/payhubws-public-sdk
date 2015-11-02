<?php

/**
 * Created by PhpStorm.
 * User: agustin
 * Date: 23/07/2015
 * Time: 15:27
 */
class CardData
{
    
    public $cvv_data;
    public $track1_data = null;
    public $track2_data = null;
    public $encrypted_track_data = null;
    public $card_number;
    public $card_expiry_date;
    public $tokenized_card;
    public $billing_address_1;
    public $billing_address_2;
    public $billing_city;
    public $billing_state;
    public $billing_zip;

    /**
     * @return mixed
     */
    public function getCvvData()
    {
        return $this->cvv_data;
    }

    /**
     * @param mixed $cvv_data
     */
    public function setCvvData($cvv_data)
    {
        $this->cvv_data = $cvv_data;
    }

    /**
     * @return null
     */
    public function getTrack1Data()
    {
        return $this->track1_data;
    }

    /**
     * @param null $track1_data
     */
    public function setTrack1Data($track1_data)
    {
        $this->track1_data = $track1_data;
    }

    /**
     * @return null
     */
    public function getTrack2Data()
    {
        return $this->track2_data;
    }

    /**
     * @param null $track2_data
     */
    public function setTrack2Data($track2_data)
    {
        $this->track2_data = $track2_data;
    }

    /**
     * @return null
     */
    public function getEncryptedTrackData()
    {
        return $this->encrypted_track_data;
    }

    /**
     * @param null $encrypted_track_data
     */
    public function setEncryptedTrackData($encrypted_track_data)
    {
        $this->encrypted_track_data = $encrypted_track_data;
    }

    /**
     * @return mixed
     */
    public function getCardNumber()
    {
        return $this->card_number;
    }

    /**
     * @param mixed $card_number
     */
    public function setCardNumber($card_number)
    {
        $this->card_number = $card_number;
    }

    /**
     * @return mixed
     */
    public function getCardExpiryDate()
    {
        return $this->card_expiry_date;
    }

    /**
     * @param mixed $card_expiry_date
     */
    public function setCardExpiryDate($card_expiry_date)
    {
        $this->card_expiry_date = $card_expiry_date;
    }

    /**
     * @return mixed
     */
    public function getTokenizedCard()
    {
        return $this->tokenized_card;
    }

    /**
     * @param mixed $tokenized_card
     */
    public function setTokenizedCard($tokenized_card)
    {
        $this->tokenized_card = $tokenized_card;
    }

    /**
     * @return mixed
     */
    public function getBillingAddress1()
    {
        return $this->billing_address_1;
    }

    /**
     * @param mixed $billing_address_1
     */
    public function setBillingAddress1($billing_address_1)
    {
        $this->billing_address_1 = $billing_address_1;
    }

    /**
     * @return mixed
     */
    public function getBillingAddress2()
    {
        return $this->billing_address_2;
    }

    /**
     * @param mixed $billing_address_2
     */
    public function setBillingAddress2($billing_address_2)
    {
        $this->billing_address_2 = $billing_address_2;
    }

    /**
     * @return mixed
     */
    public function getBillingCity()
    {
        return $this->billing_city;
    }

    /**
     * @param mixed $billing_city
     */
    public function setBillingCity($billing_city)
    {
        $this->billing_city = $billing_city;
    }

    /**
     * @return mixed
     */
    public function getBillingState()
    {
        return $this->billing_state;
    }

    /**
     * @param mixed $billing_state
     */
    public function setBillingState($billing_state)
    {
        $this->billing_state = $billing_state;
    }

    /**
     * @return mixed
     */
    public function getBillingZip()
    {
        return $this->billing_zip;
    }

    /**
     * @param mixed $billing_zip
     */
    public function setBillingZip($billing_zip)
    {
        $this->billing_zip = $billing_zip;
    }

    public static function fromArray($data){
        if(!is_null($data)) {
            $capture = new CardData();
            foreach ($data as $key => $value) {
                if (property_exists(get_class($capture), $key)) {
                    $capture->{$key} = $value;
                }
            }
            return $capture;
        }
    }
}