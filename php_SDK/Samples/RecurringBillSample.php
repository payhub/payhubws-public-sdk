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
$WsURL="https://staging-api.payhub.com/api/v2/";
$oauth_token = "107d74ab-4a18-4713-88ff-69bd05710086";

//Defining data for the SALE transaction
// Merchant data (obtained from the payHub Virtual Terminal (3rd party integration)
$merchant = new Merchant();
$merchant->setOrganizationId(10127);
$merchant->setTerminalId(215);


$transaction = new TransactionManager($merchant,$WsURL,$oauth_token);
$response = $transaction->getRecurringBillInformation("1186");
var_dump($response);

