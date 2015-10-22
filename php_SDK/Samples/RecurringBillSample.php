<?php
/* The current url, oauth_token, orgId and Terminal Id provided in this example, are only for testing purposes
*  For development purposes you need to contact the Payhub Integration Support team. They will provide you with  *   all you need.
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

