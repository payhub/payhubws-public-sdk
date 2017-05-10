<?php
/**
 * Created by:
 * User: agustin breit
 * Date: 10/05/2017
 */
$path_to_IncludeClases="../com/payhub/ws/extra/includeClasses.php";
include_once $path_to_IncludeClases;
//Defining the Web Service URL
$oauth_token = your_api_token_here;

// Merchant data (obtained from the payHub Virtual Terminal (3rd party integration)
$merchant = new Merchant();
$merchant->setOrganizationId(your_org_id_here);
$merchant->setTerminalId(your_terminal_id_here);


$transaction = new TransactionManager($merchant,$WsURL,$oauth_token);
$response = $transaction->getAllRecurringBillInformation(0,5);
var_dump($response[0]);
echo "<br>";echo "<br>";
$recurringBillId=$response[0]->getLastRecurringBillResponse()->getRecurringBillId();
$statusInfo = $response[0]->getStatusInformation()->getStatus();
var_dump($statusInfo->recurring_bill_status);
echo "<br>";
echo "<br>";
$response2 = $transaction->updateRecurringBillStatus($recurringBillId,"PAUSED");
 var_dump($response2);

