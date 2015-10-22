<?php
/* The current url, oauth_token, orgId and Terminal Id provided in this example, are only for testing purposes
*  For development purposes you need to contact the Payhub Integration Support team. They will provide you with  *  all you need.
*  Thanks.
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

$void = new VoidTransaction($merchant,'{someSaleId}');
$transaction = new TransactionManager($merchant,$WsURL,$oauth_token);


if($result->getErrors()==null){
  $transactionId = $result->getVerifyResponse()->getVoidId();
  $result2 = $transaction->getVoidInformation($transactionId);
  var_dump($result2);
}else{
  var_dump($result->getErrors());
}

