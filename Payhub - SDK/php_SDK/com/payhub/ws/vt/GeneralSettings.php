<?php

/**
 * Created by PhpStorm.
 * User: agustin
 * Date: 12/18/15
 * Time: 12:01 PM
 */
class GeneralSettings
{
    public static $GENERAL_SETTINGS_LINK="adminSettings/generalSettings";
    public $inactivityHour;

    public $terminalList=[];
    public function __construct(){
        settype($inactivityHour, "bool");
    }
    public static function fromArray($data){
        $settings= new GeneralSettings();
        foreach ($data as $key => $value){
            if( property_exists( get_class($settings), $key ) ) {
                if(is_array($value)) {
                    if ($key == "terminalList") {
                        $settings->{$key} = TerminalList::fromArray($value);
                    }
                }else{
                    $settings->{$key} = $value;
                }
            }
        }
        return $settings;
    }
    /**
     * @return string
     */
    public static function getGENERALSETTINGSLINK()
    {
        return self::$GENERAL_SETTINGS_LINK;
    }

    /**
     * @param string $GENERAL_SETTINGS_LINK
     */
    public static function setGENERALSETTINGSLINK($GENERAL_SETTINGS_LINK)
    {
        self::$GENERAL_SETTINGS_LINK = $GENERAL_SETTINGS_LINK;
    }

    /**
     * @return mixed
     */
    public function getInactivityHour()
    {
        return $this->inactivityHour;
    }

    /**
     * @param mixed $inactivityHour
     */
    public function setInactivityHour($inactivityHour)
    {
        $this->inactivityHour = $inactivityHour;
    }

    /**
     * @return array
     */
    public function getTerminalList()
    {
        return $this->terminalList;
    }

    /**
     * @param array $terminalList
     */
    public function setTerminalList($terminalList)
    {
        $this->terminalList = $terminalList;
    }


}
class TerminalList {
    public $nickName;
    public $terminalType;
    public $settlementTime;
    public function __construct(){
    }

    /**
     * @return mixed
     */
    public function getNickName()
    {
        return $this->nickName;
    }

    /**
     * @param mixed $nickName
     */
    public function setNickName($nickName)
    {
        $this->nickName = $nickName;
    }

    /**
     * @return mixed
     */
    public function getTerminalType()
    {
        return $this->terminalType;
    }

    /**
     * @param mixed $terminalType
     */
    public function setTerminalType($terminalType)
    {
        $this->terminalType = $terminalType;
    }

    /**
     * @return mixed
     */
    public function getSettlementTime()
    {
        return $this->settlementTime;
    }

    /**
     * @param mixed $settlementTime
     */
    public function setSettlementTime($settlementTime)
    {
        $this->settlementTime = $settlementTime;
    }

    public static function fromArray($data){
        foreach ($data as $terminal){
            $terminalList_tmp= new TerminalList();
            foreach ($terminal as $key => $value) {
                if (property_exists(get_class($terminalList_tmp), $key)) {
                    $terminalList_tmp->{$key} = $value;
                }
            }
            $terminalList[]=$terminalList_tmp;
        }
        return $terminalList;
    }

}
