<?php
/**
 * Created by PhpStorm.
 * User: agustin
 * Date: 28/07/2015
 * Time: 16:51
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

$tsr = new TransactionSearchParameters();
$tsr->amountFrom="1";
$tsr->amountTo="20";
$tsr->cardLast4Digits="4507";

$transaction = new TransactionManager($merchant,$WsURL,$oauth_token);
$response = $transaction->findTransactions($tsr);
var_dump($response);
