<?php
/**
 * Created by PhpStorm.
 * User: agustin
 * Date: 28/07/2015
 * Time: 13:13
 */
$path_to_IncludeClases="../com/payhub/ws/extra/includeClasses.php";
include_once $path_to_IncludeClases;
//Defining the Web Service URL
$WsURL="https://staging-api.payhub.com/api/v2/";
$oauth_token = "bb96358e-2aa8-4c6c-8a2e-901b676e979d";

//Defining data for the SALE transaction
// Merchant data (obtained from the payHub Virtual Terminal (3rd party integration)
$merchant = new Merchant();
$merchant->setOrganizationId(10127);
$merchant->setTerminalId(215);

//'{someSaleId}' is the Id for the sale that is going to be refunded, each refund transaction will be valid only if the batch has been settled
//'{someRecordFormat}' like CREDIT_CARD
$refund = new Refund('{someSaleId}',$merchant,'{someRecordFormat}');
$transaction = new TransactionManager($merchant,$WsURL,$oauth_token);
$result=$transaction->getRefundInformation("{someSaleId}");
var_dump($result);
$result2=$transaction->getAllRefundInformation();
var_dump($result2);
