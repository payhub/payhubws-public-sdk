<?php
include_once 'com/payhub/ws/util/WsConnections.php';
include_once 'com/payhub/ws/model/Sale.php';
include_once 'com/payhub/ws/api/TransactionManager.php';
include_once 'com/payhub/ws/api/Errors.php';
include_once 'com/payhub/ws/api/SaleResponseInformation.php';
include_once 'com/payhub/ws/model/SaleResponse.php';
$trans_type = "sale";
$processed = FALSE;
$ERROR_MESSAGE = '';

//Defining the Web Service URL
$WsURL="https://staging-api.payhub.com/api/v2/";

//Defining data for the SALE transaction
// Merchant data (obtained from the payHub Virtual Terminal (3rd party integration)
$organization_id = 10127;
$terminal_id = 215;
$oauth_token = "107d74ab-4a18-4713-88ff-69bd05710086";
// bill data
$base_amount = 10.0;
$shipping_amount = 1.23;
$tax_amount = 1.00;
$note = "this a sample note";
$invoice_number = "a-00240";
$po_number = "56";
//Credit card data
$card_number = "5466410004374507";
$card_expiry_date = "202011";
$cvv_data = "998";
$billing_address_1 = "2350 Kerner Blvd";
$billing_address_2 = "On the corner";
$billing_city = "San Rafael";
$billing_state = "CA";
$billing_zip = "94901";
// Customer data
$first_name = "First";
$last_name = "Contact";
$company_name = "Payhub Inc";
$job_title = "Software Engineer";
$email_address = "jhon@company.com";
$web_address = "http://payhub.com";
$phone_number = "(415) 479 1349";
$phone_ext = "123";
$phone_type = "M";

$data = array();
$data["merchant"] = array("organization_id" => "$organization_id", "terminal_id" => "$terminal_id");
$data["bill"] = array ("base_amount" => array ("currency" => "USD","amount" => $base_amount),
    "shipping_amount" => array ("currency" => "USD","amount" => $shipping_amount),
    "tax_amount" => array ("currency" => "USD","amount" => $tax_amount));
$data["card_data"] = array("card_number" => "$card_number","card_expiry_date" => "$card_expiry_date",
    "cvv_data" => "$cvv_data","billing_address_1" => "$billing_address_1",
    "billing_address_2" => "$billing_address_2","billing_city" => "$billing_city",
    "billing_state" => "$billing_state","billing_zip" => "$billing_zip");
$data ["customer"]=  array("first_name" => "$first_name","last_name" => "$last_name","company_name" => "$company_name",
    "job_title" => "$job_title","email_address" => "$email_address","web_address" => "$web_address",
    "phone_number" => "$phone_number","phone_ext" => "$phone_ext","phone_type" => "$phone_type");

//Convert data to array to send it to the WS as JSON format

$_merchant=$data["merchant"];
$sale = new Sale($data["merchant"],$data["customer"],$data["bill"],$data["card_data"]);

$transaction = new TransactionManager($_merchant,$WsURL,$oauth_token);
//$result = $transaction->doSale($sale);
//$result = $transaction->getSaleInformation("182347");
//$result = $transaction->getAllSalesInformation();
//var_dump($result[0]->getSaleResponse());


/*
$trans_type = "sale";
$processed = FALSE;
$ERROR_MESSAGE = '';

//Defining the Web Service URL
$WsURL="http://staging-api.payhub.com/api/v2/$trans_type";


//Defining data for the SALE transaction
// Merchant data (obtained from the payHub Virtual Terminal (3rd party integration)
$organization_id = 10127;
$terminal_id = 215;
$oauth_token = "107d74ab-4a18-4713-88ff-69bd05710086";
// bill data
$base_amount = 10.0;
$shipping_amount = 1.23;
$tax_amount = 1.00;
$note = "this a sample note";
$invoice_number = "a-00240";
$po_number = "56";
//Credit card data
$card_number = "5466410004374507";
$card_expiry_date = "202011";
$cvv_data = "998";
$billing_address_1 = "2350 Kerner Blvd";
$billing_address_2 = "On the corner";
$billing_city = "San Rafael";
$billing_state = "CA";
$billing_zip = "94901";
// Customer data
$first_name = "First";
$last_name = "Contact";
$company_name = "Payhub Inc";
$job_title = "Software Engineer";
$email_address = "jhon@company.com";
$web_address = "http://payhub.com";
$phone_number = "(415) 479 1349";
$phone_ext = "123";
$phone_type = "M";


//Convert data to array to send it to the WS as JSON format
$data = array();
$data["merchant"] = array("organization_id" => "$organization_id", "terminal_id" => "$terminal_id");
$data["bill"] = array ("base_amount" => array ("currency" => "USD","amount" => $base_amount),
    "shipping_amount" => array ("currency" => "USD","amount" => $shipping_amount),
    "tax_amount" => array ("currency" => "USD","amount" => $tax_amount));
$data["card_data"] = array("card_number" => "$card_number","card_expiry_date" => "$card_expiry_date",
    "cvv_data" => "$cvv_data","billing_address_1" => "$billing_address_1",
    "billing_address_2" => "$billing_address_2","billing_city" => "$billing_city",
    "billing_state" => "$billing_state","billing_zip" => "$billing_zip");
$data ["customer"]=  array("first_name" => "$first_name","last_name" => "$last_name","company_name" => "$company_name",
    "job_title" => "$job_title","email_address" => "$email_address","web_address" => "$web_address",
    "phone_number" => "$phone_number","phone_ext" => "$phone_ext","phone_type" => "$phone_type");

//Convert data from Array to JSON
$data_string = json_encode($data);
//echo "el json es: ".$data_string;
//Creating a CURL object to access the WS
$ch = curl_init();
//Setting the address to connect to
curl_setopt($ch, CURLOPT_URL, $WsURL);
//Setting HTTP method. For a new transaction we need to use POST
curl_setopt($ch, CURLOPT_CUSTOMREQUEST, "POST");
//Setting data in JSON format
curl_setopt($ch, CURLOPT_POSTFIELDS, $data_string);
//Setting the proper header.
//Setting the oauth_token to access the WS with the proper authorization
curl_setopt($ch, CURLOPT_HTTPHEADER, array(
        'Content-Type: application/json',
        'Accept: application/json',
        'Authorization: Bearer '.$oauth_token)
);
//Store the response as a variable and not showing the content as echo $variable
curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
//Set to return the response header, this is to analyze the result and the transaction ID
curl_setopt($ch, CURLOPT_HEADER, true);

//execute connection to the Web Service
$response = curl_exec($ch);
// get some data from the response
$httpcode = curl_getinfo($ch, CURLINFO_HTTP_CODE);
$header_size = curl_getinfo($ch, CURLINFO_HEADER_SIZE);
//Get the header as string.
$header = substr($response, 0, $header_size);
//close connection to the Web Service
curl_close($ch);
echo $httpcode;
//Obtain the data from the sale recently created
if ($httpcode==201){
    //find the url of the sale (Location header in the response)
    preg_match("!\r\n(?:Location): *(.*?) *\r\n!", $header, $matches);
    //$url contains the URL to GET the data from the Web Service
    $url = $matches[1];
    //Once we get the transaction ID we will query for the information of the last transaction
    $ch = curl_init();
    curl_setopt($ch, CURLOPT_URL, $url);
    //Setting HTTP method. To get a transaction response we need to use GET
    curl_setopt($ch, CURLOPT_CUSTOMREQUEST, "GET");
    //Setting the proper header.
    //Setting the oauth_token to access the WS with the proper authorization
    curl_setopt($ch, CURLOPT_HTTPHEADER, array('Authorization: Bearer '.$oauth_token));
    //Store the response as a variable and not showing the content as echo $variable
    curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
    //execute connection to the Web Service
    $response_json=curl_exec($ch);
    //close connection to the Web Service
    curl_close($ch);
    //show result (standard JSON), parse it, process it, etc..
    echo $response_json;
    // now you could parse the json object to array if you preffer: $obj = json_decode($response_json);
    $array = json_decode($response_json);
    echo "<pre>";
    print_r($array);
    echo "</pre>";
}
//There was an error with the WS
else{
    echo "Error creating the ".strtoupper($trans_type).": RESPONSE MESSAGE";
    echo "<pre>";
    echo $response;
    echo "</pre>";
}

*/

?>