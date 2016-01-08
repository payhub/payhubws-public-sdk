<?php
/**
 * Created by PhpStorm.
 * User: agustin
 * Date: 28/07/2015
 * Time: 17:40
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

// bill data
$bill= new Bill();
$bill->setBaseAmount(1.00);
$bill->setShippingAmount(1.00);
$bill->setTaxAmount(1.00);
$bill->setNote("this a sample note");
$bill->setInvoiceNumber("this is an invoice");
$bill->setPoNumber("a test po number");
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


$object = new Sale($merchant,$customer,$bill,$card_data);

$transaction = new TransactionManager($merchant,$WsURL,$oauth_token);
$result = $transaction->doSale($object);
if($result->getErrors()==null){
    $transactionId = $result->getSaleResponse()->getSaleId();
	$datos = "{\"order\": {\"id\": 465, \"invoice\":\"MyIncoice\", \"lines\": [{\"City\": \"Cordoba\"}, {\"Neighborhood\": \"Nueva Cordoba\"}]}}";
	$resultMetadata=$transaction->addMetaData($datos, TransactionType::Sale, $transactionId);
	var_dump($resultMetadata);
}else{
  var_dump($result->getErrors());
}
