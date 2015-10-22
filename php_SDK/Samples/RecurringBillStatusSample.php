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

$bill= new Bill();
$bill->setBaseAmount(1.00);
//Credit card data
$card_data = new CardData();
$card_data->setCardNumber("4012881888818888");
$card_data->setCardExpiryDate("202012");
$card_data->setBillingZip("60527");
// Customer data
$customer = new Customer();
$customer->setFirstName("Joe");
$customer->setLastName("Tester");
$customer->setPhoneNumber("844-217-1631");
$customer->setPhoneType("M");

$montly_s = new MontlySchedule();
$montly_s->monthly_type="E";
$montly_s->monthly_each_days=array(15);

$start=new DateTime("2015-9-29");
$start=$start->format('Y-m-d');
$type="O";
$endDate=new DateTime("2016-8-29");
$endDate=$endDate->format('Y-m-d');
$scheduleSandE=new ScheduleSartAndEnd();
$scheduleSandE->start_date=$start;
$scheduleSandE->end_date_type=$type;
$scheduleSandE->end_date=$endDate;

$schedule =new Schedule($scheduleSandE,$montly_s);

$schedule->schedule_type="M";
$schedule->bill_generation_interval=1;

$recurringBill=new RecurringBill($merchant,$customer,$bill,$card_data,$schedule);
$transaction = new TransactionManager($merchant,$WsURL,$oauth_token);
$response = $transaction->doRecurringBill($recurringBill);

if($response->getErrors()==null){
    $transactionId = $response->getLastRecurringBillResponse()->getRecurringBillId();
    $statusInfo = $response->getStatusInformation();
    var_dump($statusInfo);
    echo "Updating...";
    $canUpdate=$transaction->updateRecurringBillStatus($transactionId);
    if($canUpdate){
        $statusUpdated = $transaction->getRecurringBillInformation($transactionId);
        if($statusUpdated->getErrors()==null){
            var_dump($statusUpdated->getStatusInformation());
        }
    }
}else{
    var_dump($response->getErrors());
}
