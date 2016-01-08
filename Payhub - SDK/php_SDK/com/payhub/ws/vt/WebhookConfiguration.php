<?php

/**
 * Created by PhpStorm.
 * User: agustin
 * Date: 12/18/15
 * Time: 1:33 PM
 */
class WebhookConfiguration
{
    public static $WEBHOOK_LINK = "adminSettings/webhookConfiguration";
    public $endPoint;
    public $mobileHub;
    public $recurringBill;
    public $virtualHub;
    public $webhookActive;
    public $api;
    public $batchIsActive;

    /**
     * WebhookConfiguration constructor.
     */
    public function __construct()
    {
    }

    /**
     * @return mixed
     */
    public function getEndPoint()
    {
        return $this->endPoint;
    }

    /**
     * @param mixed $endPoint
     */
    public function setEndPoint($endPoint)
    {
        $this->endPoint = $endPoint;
    }

    /**
     * @return mixed
     */
    public function getMobileHub()
    {
        return $this->mobileHub;
    }

    /**
     * @param mixed $mobileHub
     */
    public function setMobileHub($mobileHub)
    {
        $this->mobileHub = $mobileHub;
    }

    /**
     * @return mixed
     */
    public function getRecurringBill()
    {
        return $this->recurringBill;
    }

    /**
     * @param mixed $recurringBill
     */
    public function setRecurringBill($recurringBill)
    {
        $this->recurringBill = $recurringBill;
    }

    /**
     * @return mixed
     */
    public function getVirtualHub()
    {
        return $this->virtualHub;
    }

    /**
     * @param mixed $virtualHub
     */
    public function setVirtualHub($virtualHub)
    {
        $this->virtualHub = $virtualHub;
    }

    /**
     * @return mixed
     */
    public function getWebhookActive()
    {
        return $this->webhookActive;
    }

    /**
     * @param mixed $webhookActive
     */
    public function setWebhookActive($webhookActive)
    {
        $this->webhookActive = $webhookActive;
    }

    /**
     * @return mixed
     */
    public function getApi()
    {
        return $this->api;
    }

    /**
     * @param mixed $api
     */
    public function setApi($api)
    {
        $this->api = $api;
    }

    /**
     * @return mixed
     */
    public function getBatchIsActive()
    {
        return $this->batchIsActive;
    }

    /**
     * @param mixed $batchIsActive
     */
    public function setBatchIsActive($batchIsActive)
    {
        $this->batchIsActive = $batchIsActive;
    }


    public static function fromArray($data)
    {
        $wh = new WebhookConfiguration();
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