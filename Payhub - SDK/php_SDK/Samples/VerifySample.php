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

//Credit card data
$card_data = new CardData();
$card_data->setCardNumber("5466410004374507");
$card_data->setCardExpiryDate("202011");
$card_data->setCvvData("998");
$card_data->setBillingAddress1("2350 Kerner Blvd");
$card_data->setBillingAddress2("On the corner");
$card_data->setBillingCity("San Rafael");
$card_data->setBillingState("CA");
$card_data->setBillingZip("99997-0003");
// Customer data
$customer = new Customer();
$customer->setFirstName("First");
$customer->setLastName("Contact");
$customer->setCompanyName("Payhub Inc");
$customer->setJobTitle("Software Engineer");
$customer->setEmailAddress("jhon@company.com");
$customer->setWebAddress("http://payhub.com");
$customer->setPhoneNumber("(415) 479 1349");
$customer->setPhoneExt("123");
$customer->setPhoneType("M");


$object = new Verify($merchant,$customer,$card_data);

$transaction = new TransactionManager($merchant,$WsURL,$oauth_token);
$result = $transaction->doVerify($object);
if($result->getErrors()==null){
  $transactionId = $result->getVerifyResponse()->getVerifyId();
  $result2 = $transaction->getVerifyInformation($transactionId);
  var_dump($result2);
}else{
  var_dump($result->getErrors());
}
