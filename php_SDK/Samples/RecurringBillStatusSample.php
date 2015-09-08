<?php

/**
 * Created by PhpStorm.
 * User: agustin
 * Date: 09/08/15
 * Time: 12:08 PM
 */
$path_to_IncludeClases="../com/payhub/ws/extra/includeClasses.php";
include_once $path_to_IncludeClases;
//Defining the Web Service URL
$WsURL="http://localhost:8251/payhubws/api/v2/";
$oauth_token = "af28ce9b-7366-4dfa-b643-44e9897ebc2b";

//Defining data for the SALE transaction
// Merchant data (obtained from the payHub Virtual Terminal (3rd party integration)
$merchant = new Merchant();
$merchant->setOrganizationId(10002);
$merchant->setTerminalId(2);


$transaction = new TransactionManager($merchant,$WsURL,$oauth_token);
$response = $transaction->getRecurringBillInformation("51");
var_dump($response->status);
$result=$transaction->updateRecurringBillStatus("51");
if($result){
    $response = $transaction->getRecurringBillInformation("51");
    var_dump($response->status);
}