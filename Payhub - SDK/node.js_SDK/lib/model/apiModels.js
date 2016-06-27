/**
 * Created by agustinb on 06/16/16.
 */
'use strict';


function Sale (){
    this.sale_id_link=function(){return "sale/"};
    var args = Array.prototype.slice.call(arguments);
    var merchant="",customer="",bill="",card_data="";

    if(args.length<3){
        throw "Merchant, Bill,and Card are Required"
    }
    args.forEach(function(item){
        if(item instanceof Merchant){
            merchant=item;
        }else if(item instanceof Customer){
            customer=item;
        }else if(item instanceof Bill){
            bill=item;
        }else if(item instanceof CardData) {
            card_data = item;
        }
    });
    this.merchant=merchant;
    this.bill=bill;
    this.customer=customer;
    this.card_data=card_data;

}
Sale.prototype = {
    constructor: Sale
    , getSale_id_link: function() {return this.sale_id_link()}
    , merchant: this.merchant
    , bill: this.bill
    , card_data: this.card_data
    , customer: this.customer
};
module.exports.Sale=Sale;

function AuthOnly (merchant,bill,card_data,customer){
    this.authonly_id_link=function(){return "authonly/"};
    var args = Array.prototype.slice.call(arguments);
    var merchant="",customer="",bill="",card_data="";

    if(args.length<3){
        throw "Merchant, Bill,and Card are Required"
    }
    args.forEach(function(item){
        if(item instanceof Merchant){
            merchant=item;
        }else if(item instanceof Customer){
            customer=item;
        }else if(item instanceof Bill){
            bill=item;
        }else if(item instanceof CardData) {
            card_data = item;
        }
    });
    this.merchant=merchant;
    this.bill=bill;
    this.customer=customer;
    this.card_data=card_data;
}
AuthOnly.prototype = {
    constructor: AuthOnly
    , getAuthonly_id_link: function() {return this.authonly_id_link()}
    , merchant: function() {return this.merchant}
    , bill: function() {return this.bill}
    , card_data: function ()  {return this.card_data}
    , customer: function ()  {return this.customer}
};
module.exports.AuthOnly=AuthOnly;

function Capture (merchant,bill,transactionId){
    this.capture_id_link=function(){return "capture/"};
    this.merchant=merchant;
    this.bill=bill;
    this.transactionId=transactionId;
}
Capture.prototype = {
    constructor: Capture
    , getCapture_id_link: function() {return this.capture_id_link()}
    , merchant: function() {return this.merchant}
    , bill: function() {return this.bill}
    , transactionId: function ()  {return this.transactionId}
};
module.exports.Capture=Capture;

function RecurringBill(){
    this.RecurringBill_id_link=function(){return "recurring-bill/";};
    var args = Array.prototype.slice.call(arguments);
    var merchant=null,customer=null,bill=null,card_data=null,schedule=null;

    args.forEach(function(item){
        if(item instanceof Merchant){
            merchant=item;
        }else if(item instanceof Customer){
            customer=item;
        }else if(item instanceof Bill){
            bill=item;
        }else if(item instanceof CardData) {
            card_data = item;
        }else if(item instanceof Schedule) {
            schedule = item;
        }
    });
    this.merchant=merchant;
    this.bill=bill;
    this.customer=customer;
    this.card_data=card_data;
    this.schedule=schedule;
}
RecurringBill.prototype = {
    constructor: RecurringBill
    , getRecurring_bill_id_link: function() {return this.RecurringBill_id_link()}
    , merchant: this.merchant
    , customer: this.customer
    , bill: this.bill
    , card_data: this.card_data
    , schedule:this.schedule
};
module.exports.RecurringBill=RecurringBill;

function Refund(transaction_id,merchant,customer,bill,card_data){
    this.Refund_id_link=function(){return "refund/"};
    this.merchant=merchant instanceof Merchant? merchant:null;
    this.bill=bill instanceof Bill? bill:null;
    this.customer=customer instanceof Customer? customer:null;
    this.card_data=card_data instanceof CardData? card_data:null;
    this.transaction_id=transaction_id;
}
Refund.prototype = {
    constructor: Refund
    , getRefund_id_link: function() {return this.Refund_id_link()}
    , merchant: this.merchant
    , customer: this.customer
    , bill: this.bill
    , card_data: this.card_data
    , transaction_id:this.transaction_id
};
module.exports.Refund=Refund;

function Verify(){
    this.verify_id_link=function(){return "verify/"};
    var args = Array.prototype.slice.call(arguments);
    var merchant="",customer="",card_data="";
    if(args.length!=3){
        throw "Merchant,Card,and Customer are Required"
    }
    args.forEach(function(item){
        if(item instanceof Merchant){
            merchant=item;
        }else if(item instanceof Customer){
            customer=item;
        }else if(item instanceof CardData) {
            card_data = item;
        }
    });
    this.merchant=merchant;
    this.customer=customer;
    this.card_data=card_data;
}
Verify.prototype = {
    constructor: Verify
    , getVerify_id_link: function() {return this.verify_id_link()}
    , merchant: this.merchant
    , customer: this.customer
    , card_data: this.card_data
};
module.exports.Verify=Verify;

function VoidTransaction(merchant,transaction_id){
    this.void_id_link=function(){return "void/"};
    this.merchant=merchant;
    this.transaction_id=transaction_id;
}
VoidTransaction.prototype = {
    constructor: VoidTransaction
    , getVoid_id_link: function() {return this.void_id_link()}
    , merchant: this.merchant
    , transaction_id: this.transaction_id
};
module.exports.VoidTransaction=VoidTransaction;

function Amount(amount){
    this.amount=isValid(amount)? amount:0.00;
    function isValid(value){
        return (String(value).match(/^[\d.]+$/));
    }
}


Amount.prototype={
    constructor: Amount,
    getAmount:function(){return this.amount;}
};
module.exports.Amount=Amount;

function Bill(){
    this.note;
    this.po_number;
    this.invoice_number;
    this.customerId;
    this.customerCardId;
    this.tax_amount;
    this.base_amount=new Amount(0.00);
    this.billingReferences;
    this.totalAmount=new Amount(0.00);
    this.shipping_amount=new Amount(0.00);
}
Bill.prototype= {
    constructor: Bill
    ,note:this.note,invoice_number:this.invoice_number,po_number:this.po_number,
    customerCardId:this.customerCardId,tax_amount:this.tax_amount,base_amount:this.base_amount,
    billingReferences:this.billingReferences,totalAmount:this.totalAmount,shipping_amount:this.shipping_amount
};
module.exports.Bill=Bill;

function Merchant(){
    this.organization_id;
    this.terminal_id;
}
Merchant.prototype={constructor:Merchant,organization_id:this.organization_id,terminal_id:this.terminal_id};
module.exports.Merchant=Merchant;

function CardData() {
    this.cvv_data;
    this.track1_data = null;
    this.track2_data = null;
    this.encrypted_track_data = null;
    this.card_number;
    this.card_expiry_date;
    this.tokenized_card;
    this.billing_address_1;
    this.billing_address_2;
    this.billing_city;
    this.billing_state;
    this.billing_zip;
}
CardData.prototype={
    constructor:CardData,
    cvv_data:this.cvv_data,
    track1_data:this.track1_data,
    track2_data :this.track2_data,
    encrypted_track_data:this.encrypted_track_data,
    card_number:this.card_number,
    card_expiry_date:this.card_expiry_date,
    tokenized_card:this.tokenized_card,
    billing_address_1:this.billing_address_1,
    billing_address_2:this.billing_address_2,
    billing_city:this.billing_city,
    billing_state:this.billing_state,
    billing_zip:this.billing_zip
};
module.exports.CardData =CardData;

function Customer() {
    this.first_name;
    this.last_name;
    this.email_address;
    this.phone_number;
    this.phone_ext="";
    this.phone_type;
    this.company_name;
    this.job_title;
    this.web_address;
    this.customerReference;
    this.customerId;
}
Customer.prototype={
    constructor:Customer
    ,first_name:this.first_name
    ,last_name:this.last_name
    ,email_address:this.email_address
    ,phone_number:this.phone_number
    ,phone_ext:this.phone_ext
    ,phone_type:this.phone_type
    ,company_name:this.company_name
    ,job_title:this.job_title
    ,web_address:this.web_address
    ,customerReference:this.customerReference
    ,customerId:this.customerId
};
module.exports.Customer = Customer;

function EncryptedTrackData() {
    this.encrypted_track="";this.swiper_band;this.swiper_model;
}
EncryptedTrackData.prototype={
    constructor:EncryptedTrackData
    ,encrypted_track:this.encrypted_track
    ,swiper_band:this.swiper_band
    ,swiper_model:this.swiper_model
};
module.exports.EncryptedTrackData = EncryptedTrackData;


// RB Schedules:
function Schedule(schedule_type){
    if(!schedule_type && schedule_type!="M" && schedule_type!="D" && schedule_type!="Y" && schedule_type!="W" && schedule_type!="S"){
        throw "The type of schedule being set up, ['M' or 'D' or 'Y' or 'W' or 'S']: 'M' (='Monthly'), 'D' (='Daily'), 'Y' (='Yearly'), 'W' (='Weekly'), S=Specific Dates.";
    }
    this.schedule_type=schedule_type;
    this.bill_generation_interval;
    this.schedule_start_and_end;
    this.monthly_schedule;
    this.yearly_schedule;
    this.weekly_schedule;
    this.specific_dates_schedule;
}
Schedule.prototype={
    constructor:Schedule,
    schedule_type:this.schedule_type,
    bill_generation_interval:this.bill_generation_interval,
    schedule_start_and_end:this.schedule_start_and_end,
    monthly_schedule:this.monthly_schedule,
    yearly_schedule:this.yearly_schedule,
    weekly_schedule:this.weekly_schedule,
    specific_dates_schedule:this.specific_dates_schedule
};
module.exports.Schedule = Schedule;

function ScheduleStartAndEnd(start_date,end_date_type,end_date){
    this.start_date=start_date;
    this.end_date_type=end_date_type;
    this.end_date=end_date;
}
ScheduleStartAndEnd.prototype={
    constructor:ScheduleStartAndEnd,
    start_date:this.start_date,
    end_date_type:this.end_date_type,
    end_date:this.end_date
};
module.exports.ScheduleStartAndEnd = ScheduleStartAndEnd;

function SpecificDatesSchedule(){
    this.specific_dates= [];
}
SpecificDatesSchedule.prototype={
    constructor:SpecificDatesSchedule,
    specific_dates:this.specific_dates
};
module.exports.SpecificDatesSchedule = SpecificDatesSchedule;

function MonthlySchedule(){
    this.monthly_type;this.monthly_each_days=[];this.monthly_on_the_day_of_week_in_month;this.monthly_day_of_week;
}
MonthlySchedule.prototype={
    constructor:MonthlySchedule
    ,monthly_type:this.monthly_type
    ,monthly_each_days:this.monthly_each_days
    ,monthly_on_the_day_of_week_in_month:this.monthly_on_the_day_of_week_in_month
    ,monthly_day_of_week:this.monthly_day_of_week
};
module.exports.MonthlySchedule = MonthlySchedule;

function WeeklySchedule(weekly_bill_days){
    this.weekly_bill_days=weekly_bill_days
}
WeeklySchedule.prototype={
    constructor:WeeklySchedule
    ,weekly_bill_days:this.weekly_bill_days
};
module.exports.WeeklySchedule = WeeklySchedule;

function YearlySchedule(){
    this.year_to_start;
    this.yearly_bill_on_month_number;
    this.yearly_bill_on_day_of_month;
}
YearlySchedule.prototype={
    constructor:YearlySchedule,
    year_to_start:this.year_to_start,
    yearly_bill_on_month_number:this.yearly_bill_on_month_number,
    yearly_bill_on_day_of_month:this.yearly_bill_on_day_of_month

};
module.exports.YearlySchedule=YearlySchedule;

function TransactionSearchParameters(){
    this.batchIdFrom;
    this.batchIdTo;
    this.transactionType;
    this.responseCode;
    this.amountFrom;
    this.amountTo;
    this.firstName;
    this.lastName;
    this.trnDateFrom;
    this.trnDateTo;
    this.cardType;
    this.cardLast4Digits;
    this.cardToken;
    this.authAmountFrom;
    this.authAmountTo;
    this.swiped;
    this.source;
    this.phoneNumber;
    this.email;
    this.note ;
    this.transactionStatus;
    this.customerId;
}
TransactionSearchParameters.prototype={
    constructor:TransactionSearchParameters,
    batchIdFrom:this.batchIdFrom,
    batchIdTo:this.batchIdTo,
    transactionType:this.transactionType,
    responseCode:this.responseCode,
    amountFrom:this.amountFrom,
    amountTo:this.amountTo,
    firstName:this.firstName,
    lastName:this.lastName,
    trnDateFrom:this.trnDateFrom,
    trnDateTo:this.trnDateTo,
    cardType:this.cardType,
    cardLast4Digits:this.cardLast4Digits,
    cardToken:this.cardToken,
    authAmountFrom:this.authAmountFrom,
    authAmountTo:this.authAmountTo,
    swiped:this.swiped,
    source:this.source,
    phoneNumber:this.phoneNumber,
    email:this.email,
    note:this.note,
    transactionStatus:this.transactionStatus,
    customerId:this.customerId

};
module.exports.TransactionSearchParameters=TransactionSearchParameters;
