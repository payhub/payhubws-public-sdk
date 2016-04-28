<?php
/* The current url, oauth_token, orgId and Terminal Id provided in this example, are only for testing purposes
*  For development purposes you need to contact the Payhub Integration Support team. They will provide you with  *   all you need.
*  Thanks.
*/
$path_to_IncludeClases="../com/payhub/ws/extra/includeClasses.php";
include_once $path_to_IncludeClases;

//Defining the Web Service URL
//$WsURL="https://sandbox-api.payhub.com/api/v2/";
//$oauth_token = "2a5d6a73-d294-4fba-bfba-957a4948d4a3";
$WsURL="http://localhost:8251/payhubws/api/v2/";
$oauth_token = "43d50993-cc59-4f01-8e93-a53e0e2e59c0";

//Defining data for the SALE transaction
// Merchant data (obtained from the payHub Virtual Terminal (3rd party integration)
$merchant = new Merchant();
$merchant->setOrganizationId(10002);
$merchant->setTerminalId(2);

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
$montly_s->monthly_each_days=array(1,15);

$start=new DateTime("2016-4-29");
$start=$start->format('Y-m-d');
$type="O";
$endDate=new DateTime("2016-8-29");
$endDate=$endDate->format('Y-m-d');
$scheduleSandE=new ScheduleSartAndEnd();
$scheduleSandE->start_date=$start;
$scheduleSandE->end_date_type=$type;
$scheduleSandE->end_date=$endDate;

$schedule =new Schedule("M");
$schedule->monthly_schedule=$montly_s;
$schedule->schedule_start_and_end=$scheduleSandE;
$schedule->bill_generation_interval=1;

$recurringBill=new RecurringBill($merchant,$customer,$bill,$card_data,$schedule);
$transaction = new TransactionManager($merchant,$WsURL,$oauth_token);
$response = $transaction->doRecurringBill($recurringBill);

if($response->getErrors()==null){
    $transactionId = $response->getLastRecurringBillResponse()->getRecurringBillId();
    $bill->setBaseAmount(2.00);
    $recurringBill2 = new RecurringBill($bill);
    $canUpdate=$transaction->updateRecurringBill($transactionId,$recurringBill2);
    if(!is_array($canUpdate)){
        $statusUpdated = $transaction->getRecurringBillInformation($transactionId);
        var_dump($statusUpdated);
        if($statusUpdated->getErrors()==null){
            var_dump($statusUpdated->getBillInformation());
        }
    }else{
        var_dump($canUpdate);
    }
}else{
    var_dump($response->getErrors());
}
