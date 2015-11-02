<?php

/**
 * Created by PhpStorm.
 * User: agustin
 * Date: 23/07/2015
 * Time: 15:30
 */
class Merchant
{
    public static $TERMINAL_ID_FIELD = "terminal_id";

    public static $ORGANIZATION_ID_FIELD = "organization_id";

    public $organization_id;

    public $terminal_id;

    private $api_username;

    private $api_password;

    /**
     * @return mixed
     */
    public function getOrganizationId()
    {
        return $this->organization_id;
    }

    /**
     * @param mixed $organization_id
     */
    public function setOrganizationId($organization_id)
    {
        $this->organization_id = $organization_id;
    }

    /**
     * @return mixed
     */
    public function getTerminalId()
    {
        return $this->terminal_id;
    }

    /**
     * @param mixed $terminal_id
     */
    public function setTerminalId($terminal_id)
    {
        $this->terminal_id = $terminal_id;
    }

    /**
     * @return mixed
     */
    public function getApiUsername()
    {
        return $this->api_username;
    }

    /**
     * @param mixed $api_username
     */
    public function setApiUsername($api_username)
    {
        $this->api_username = $api_username;
    }

    /**
     * @return mixed
     */
    public function getApiPassword()
    {
        return $this->api_password;
    }

    /**
     * @param mixed $api_password
     */
    public function setApiPassword($api_password)
    {
        $this->api_password = $api_password;
    }

    public static function fromArray($data){
        if(!is_null($data)) {
            $merchant = new Merchant();
            foreach ($data as $key => $value) {
                if (property_exists(get_class($merchant), $key)) {
                    $merchant->{$key} = $value;
                }
            }
            return $merchant;
        }
    }
}