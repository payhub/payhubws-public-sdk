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
$WsURL="https://staging-api.payhub.com/api/v2/";
$oauth_token = "bb96358e-2aa8-4c6c-8a2e-901b676e979d";

//Defining data for the SALE transaction
// Merchant data (obtained from the payHub Virtual Terminal (3rd party integration)
$merchant = new Merchant();
$merchant->setOrganizationId(10127);
$merchant->setTerminalId(215);

// bill data
$bill= new Bill();
$bill->setBaseAmount(10.0);
$bill->setShippingAmount(1.23);
$bill->setTaxAmount(1.00);
$bill->setNote("this a sample note");
$bill->setInvoiceNumber("a-00240");
$bill->setPoNumber("56");
//Credit card data
$card_data = new CardData();
$card_data->setCardNumber("5466410004374507");
$card_data->setCardExpiryDate("202011");
$card_data->setCvvData("988");
$card_data->setBillingAddress1("2350 Kerner Blvd");
$card_data->setBillingAddress2("On the corner");
$card_data->setBillingCity("San Rafael");
$card_data->setBillingState("CA");
$card_data->setBillingZip("94901");
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

$authorization = new AuthOnly($merchant,$bill,$card_data,$customer);
$transaction = new TransactionManager($merchant,$WsURL,$oauth_token);
$result = $transaction->doAuthonly($authorization);

if($result->getErrors()==null){
  $transactionId = $result->getAuthOnlyResponse()->getTransactionId();
  $capture = new Capture($merchant,$transactionId,$bill);
  $responseCapture= $transaction->doCapture($capture);
  var_dump($responseCapture);
}else{
  var_dump($result->getErrors());
}
