/**
 * Created by Agustin Breit <agustin.breit@silice.biz> on 06/17/16.
 */

var models = require('../lib/model/apiModels');

var trnManager = require('../lib/utils/transactionManager');

var errors = require('../lib/model/errors');

var WsURL="https://sandbox-api.payhub.com/api/v2/";
var oauth_token = "2a5d6a73-d294-4fba-bfba-957a4948d4a3";


var merchant = new models.Merchant();
merchant.organization_id=10074
merchant.terminal_id=134

var bill = new models.Bill();
bill.base_amount=new models.Amount(1);

var card_data = new models.CardData();
card_data.card_number="5466410004374507";
card_data.cvv_data="998";
card_data.card_expiry_date="202011";
card_data.billing_address_1="2350 Kerner Blvd";
card_data.billing_city="San Rafael";
card_data.billing_state="CA";
card_data.billing_zip="99997";

var customer=new models.Customer();
customer.first_name="testJS";
customer.last_name="testJS";
customer.email_address="testJS@testJS.com";

var monthly_s = new models.MonthlySchedule();
monthly_s.monthly_type="E";
monthly_s.monthly_each_days.push(15);

var schedule_start_end=new models.ScheduleStartAndEnd("2016-07-01","N");

var schedule = new models.Schedule("M");
schedule.bill_generation_interval=1;
schedule.schedule_start_and_end=schedule_start_end;
schedule.monthly_schedule=monthly_s;

var recurringBill = new models.RecurringBill(merchant,customer,bill,card_data,schedule);
var transactionManager = new trnManager.TransactionManager(merchant,WsURL,oauth_token);
var rta = transactionManager.doRecurringBill(recurringBill);

if(!(rta[0] instanceof errors.Errors)){
    var rbId = rta.lastRecurringBillResponse.recurringBillId;
    console.log(rta.scheduleInformation());
    var schedule_start_end_new =new models.ScheduleStartAndEnd("2016-08-01","N");
    schedule.schedule_start_and_end=schedule_start_end_new;
    var rbForUpdate = new models.RecurringBill(schedule,card_data);
    rta = transactionManager.updateRecurringBill(rbId,rbForUpdate);
    if(!(rta[0]instanceof errors.Errors && rta==true)){//all the update methods returns true or an instance of Errors.
        console.log(transactionManager.getRecurringBillInformation(rbId).scheduleInformation());
    }else{console.log(rta[0])}
}else{console.log(rta[0])}



//var rta2 = transactionManager.updateRecurringBillStatus(476,"PAUSED");
//console.log(rta2);





