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


$vd = new ValidatedDevices();
$vd->setEnforceDeviceValidation(false);
$result = $transaction->patchValidatedDevices($vd);
if(is_array($result)){
    var_dump($result);
}else{
    $result = $transaction->getValidatedDevices();
    var_dump($result);
}