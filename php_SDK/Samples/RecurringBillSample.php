<?php
/**
 * Created by PhpStorm.
 * User: agustin
 * Date: 29/07/2015
 * Time: 11:16
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
//$response = $transaction->getRecurringBillInformation("1186");
//var_dump($response);
$response = $transaction->getAllRecurringBillInformation();
echo "First Recurring Bill on list";
var_dump($response[0]);
$response2=$transaction->findRecurringBillInformationByMerchantOrganization($merchant->getOrganizationId());
echo "merchant result";
var_dump($response2[0]);
echo "customer result";
$response3=$transaction->findRecurringBillInformationByCustomer($merchant->getTerminalId());
var_dump($response3[0]);

