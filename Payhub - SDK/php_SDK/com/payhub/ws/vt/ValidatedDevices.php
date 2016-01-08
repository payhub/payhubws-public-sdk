<?php

/**
 * Created by PhpStorm.
 * User: agustin
 * Date: 12/18/15
 * Time: 1:33 PM
 */
class ValidatedDevices
{
    public static $VALIDATED_DEVICES_LINK="adminSettings/validatedDevices";
    public $enforce_device_validation;
    private $devices=[];

    /**
     * ValidatedDevices constructor.
     */
    public function __construct()
    {
    }

    /**
     * @return mixed
     */
    public function getEnforceDeviceValidation()
    {
        return $this->enforce_device_validation;
    }

    /**
     * @param mixed $enforce_device_validation
     */
    public function setEnforceDeviceValidation($enforce_device_validation)
    {
        $this->enforce_device_validation = $enforce_device_validation;
    }

    /**
     * @return mixed
     */
    public function getDevices()
    {
        return $this->devices;
    }

    /**
     * @param mixed $devices
     */
    public function setDevices($devices)
    {
        $this->devices = $devices;
    }



    public static function fromArray($data)
    {
        $vd = new ValidatedDevices();
        foreach ($data as $key => $value) {
            if($key=="devices"){
                $vd->{$key}=Devices::fromArray($value);
            }else{
                $vd->{$key} = $value;
            }
        }
        return $vd;
    }

    public function object_unset_nulls_for_send()
    {
        $object = (object) array_filter((array) $this, function ($val) {
            return !is_null($val);
        });
        return $object;
    }
}

class Devices{
    public $product;
    public $nick_name;
    public $platform;
    public $details;
    public $date_added;
    public $device_id;

    /**
     * Devices constructor.
     */
    public function __construct()
    {
    }

    /**
     * @return mixed
     */
    public function getProduct()
    {
        return $this->product;
    }

    /**
     * @param mixed $product
     */
    public function setProduct($product)
    {
        $this->product = $product;
    }

    /**
     * @return mixed
     */
    public function getNickName()
    {
        return $this->nick_name;
    }

    /**
     * @param mixed $nick_name
     */
    public function setNickName($nick_name)
    {
        $this->nick_name = $nick_name;
    }

    /**
     * @return mixed
     */
    public function getPlatform()
    {
        return $this->platform;
    }

    /**
     * @param mixed $platform
     */
    public function setPlatform($platform)
    {
        $this->platform = $platform;
    }

    /**
     * @return mixed
     */
    public function getDetails()
    {
        return $this->details;
    }

    /**
     * @param mixed $details
     */
    public function setDetails($details)
    {
        $this->details = $details;
    }

    /**
     * @return mixed
     */
    public function getDateAdded()
    {
        return $this->date_added;
    }

    /**
     * @param mixed $date_added
     */
    public function setDateAdded($date_added)
    {
        $this->date_added = $date_added;
    }

    /**
     * @return mixed
     */
    public function getDeviceId()
    {
        return $this->device_id;
    }

    /**
     * @param mixed $device_id
     */
    public function setDeviceId($device_id)
    {
        $this->device_id = $device_id;
    }

    public static function fromArray($data){
        foreach ($data as $devices){
            $devices_tmp= new Devices();
            foreach ($devices as $key => $value) {
                if (property_exists(get_class($devices_tmp), $key)) {
                    $devices_tmp->{$key} = $value;
                }
            }
            $devicesList[]=$devices_tmp;
        }
        return $devicesList;
    }

}