<?php
/**
 * Created by PhpStorm.
 * User: agustin
 * Date: 27/07/2015
 * Time: 12:34
 */

$path_to_IncludeClases="../com/payhub/ws/extra/includeClasses.php";
include_once $path_to_IncludeClases;

//Defining the Web Service URL
$WsURL="https://sandbox-api.payhub.com/api/v2/";
$oauth_token = "2a5d6a73-d294-4fba-bfba-957a4948d4a3";
//Defining data for the SALE transaction
// Merchant data (obtained from the payHub Virtual Terminal (3rd party integration)
$merchant = new Merchant();
$merchant->setOrganizationId(10074);
$merchant->setTerminalId(134);

$transaction = new TransactionManager($merchant,$WsURL,$oauth_token);
$ur = $transaction->getAllUserRoles();

$roleId=$ur->getUserRoles()[1]->getRoleId();

$rs = new RoleSettings();
$rs=$transaction->getUserRolesById($roleId);
//var_dump($rs);
$rs->setFirstDefaultScreen(2);
$rs->setRoleName("testFromPHP");
$rs->getReports()->setChecked(true);
$rs->getReports()->getReportOptions()->setCustom(false);

$result = $transaction->postUserRoles($rs);
if(is_array($result)){
    //var_dump($result);
}else{
    $result = $transaction->getAllUserRoles();
    //var_dump($result);
}


