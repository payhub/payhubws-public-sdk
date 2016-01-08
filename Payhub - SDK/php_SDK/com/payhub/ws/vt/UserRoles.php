<?php

/**
 * Created by PhpStorm.
 * User: agustin
 * Date: 12/21/15
 * Time: 4:07 PM
 */
class UserRoles
{
    public static $ALL_USER_ROLE_LINK="userRole/roles";
    public $userRoles=[];

    /**
     * UserRoles constructor.
     */
    public function __construct()
    {
    }

    public static function fromArray($data)
    {
        $settings = new UserRoles();
        foreach ($data as $key => $value) {
            if (property_exists(get_class($settings), $key)) {
                if ($key == "userRoles") {
                    $_tmp = new Roles();
                    foreach ($value as $keys => $val) {
                        $_tmp = Roles::fromArray($val);
                        $myArray[] = $_tmp;
                        }
                    $settings->{$key} = $myArray;
                    //var_dump($myArray);

                    }

            }
        }
       // var_dump($settings);
        return $settings;
    }

    /**
     * @return array
     */
    public function getUserRoles()
    {
        return $this->userRoles;
    }

    /**
     * @param array $userRoles
     */
    public function setUserRoles($userRoles)
    {
        $this->userRoles = $userRoles;
    }

}

class Roles{
    public $numberOfUsers;
    public $roleName;
    public $roleId;
    /**
     * UserRoles constructor.
     */
    public function __construct()
    {
    }
    public static function fromArray($data)
    {

        $settings = new Roles();
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
    public function getNumberOfUsers()
    {
        return $this->numberOfUsers;
    }

    /**
     * @param mixed $numberOfUsers
     * @return Roles
     */
    public function setNumberOfUsers($numberOfUsers)
    {
        $this->numberOfUsers = $numberOfUsers;
        return $this;
    }

    /**
     * @return mixed
     */
    public function getRoleName()
    {
        return $this->roleName;
    }

    /**
     * @param mixed $roleName
     * @return Roles
     */
    public function setRoleName($roleName)
    {
        $this->roleName = $roleName;
        return $this;
    }

    /**
     * @return mixed
     */
    public function getRoleId()
    {
        return $this->roleId;
    }

    /**
     * @param mixed $roleId
     * @return Roles
     */
    public function setRoleId($roleId)
    {
        $this->roleId = $roleId;
        return $this;
    }



}