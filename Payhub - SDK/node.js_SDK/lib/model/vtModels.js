/**
 * Created by Agustin Breit <agustin.breit@silice.biz> on 06/24/16.
 */
'use strict';

function EmailConfiguration(){
    this.emailRbFailTransaction;
    this.emailRbSuccessTransaction;
    this.emailBatchFail;
    this.emailBatchSuccess;
    this.emailTrnReceipt;
    this.emailExpPsw;
    this.customBatchReport;
    this.pdfOrCsvForBatch;
    this.customRBReport;
    this.pdfOrCsvForRB;
}
EmailConfiguration.prototype={
    constructor:EmailConfiguration,
    emailRbFailTransaction:this.emailRbFailTransaction,
    emailRbSuccessTransaction:this.emailRbSuccessTransaction,
    emailBatchFail:this.emailBatchFail,
    emailBatchSuccess:this.emailBatchSuccess,
    emailTrnReceipt:this.emailTrnReceipt,
    emailExpPsw:this.emailExpPsw,
    customBatchReport:this.customBatchReport,
    pdfOrCsvForBatch:this.pdfOrCsvForBatch,
    customRBReport:this.customRBReport,
    pdfOrCsvForRB:this.pdfOrCsvForRB
};
module.exports.EmailConfiguration=EmailConfiguration;
function OptionAndValue(){
    this.option;
    this.value;
}
OptionAndValue.prototype={
    constructor:OptionAndValue,
    option:this.option,
    value:this.value
};

module.exports.OptionAndValue=OptionAndValue;

function RiskFraudSettings(){
    this.transaction_volume_settings=new TransactionVolumeSettings();
    this.card_filtering=new CardFiltering();
    this.email=new Email();
    this.credit_card_security_codes=new Credit_card_security_codes();
    this.address_verification_system=new Address_verification_system();
}

RiskFraudSettings.prototype={
    constructor:RiskFraudSettings,
    transaction_volume_settings:this.transaction_volume_settings,
    card_filtering:this.card_filtering,
    email:this.email,
    credit_card_security_codes:this.credit_card_security_codes,
    address_verification_system:this.address_verification_system

};
module.exports.RiskFraudSettings=RiskFraudSettings;

function TransactionVolumeSettings(){
    this.hours_trn_number_more_than=new OptionAndValue();
    this.days_trn_amount_more_than=new OptionAndValue();
    this.sale_trn_amount_below=new OptionAndValue();
    this.days_trn_number_more_than=new OptionAndValue();
    this.refund_trn_amount_above=new OptionAndValue();
    this.refund_trn_amount_below=new OptionAndValue();
    this.sale_trn_amount_above=new OptionAndValue();
    this.checked;
}
TransactionVolumeSettings.prototype={
    constructor:TransactionVolumeSettings,
    hours_trn_number_more_than:this.hours_trn_number_more_than,
    days_trn_amount_more_than:this.days_trn_amount_more_than,
    sale_trn_amount_below:this.sale_trn_amount_below,
    days_trn_number_more_than:this.days_trn_number_more_than,
    refund_trn_amount_above:this.refund_trn_amount_above,
    refund_trn_amount_below:this.refund_trn_amount_below,
    sale_trn_amount_above:this.sale_trn_amount_above,
    checked:this.checked
};
module.exports.TransactionVolumeSettings=TransactionVolumeSettings;

function CardFiltering(){
    this.checked;
}
CardFiltering.prototype={
    constructor:CardFiltering,
    checked:this.checked
};
module.exports.CardFiltering=CardFiltering;

function Email(){
    this.checked;
    this.email_address;
}
Email.prototype={
    constructor:Email,
    checked:this.checked,
    email_addres:this.email_addres
};
module.exports.Email=Email;

function Credit_card_security_codes(){
    this.checked;
    this.cvv_mismatch=new OptionAndValue();
}
Credit_card_security_codes.prototype={
    constructor:Credit_card_security_codes,
    checked:this.checked,
    cvv_mismatch:this.cvv_mismatch
};
module.exports.Credit_card_security_codes=Credit_card_security_codes;

function Address_verification_system(){
    this.checked;
    this.avs_mismatch_street_and_zip_code=new OptionAndValue();
    this.avs_mismatch_street=new OptionAndValue();
    this.avs_mismatch_zip_code=new OptionAndValue();
}
Address_verification_system.prototype={
    constructor:Address_verification_system,
    checked:this.checked,
    avs_mismatch_street_and_zip_code:this.avs_mismatch_street_and_zip_code,
    avs_mismatch_street:this.avs_mismatch_street,
    avs_mismatch_zip_code:this.avs_mismatch_zip_code
};
module.exports.Address_verification_system=Address_verification_system;

function ValidatedDevices(){
    this.enforce_device_validation;
    this.devices;
}
ValidatedDevices.prototype={
    constructor:ValidatedDevices,
    enforce_device_validation:this.enforce_device_validation,
    devices:this.devices
};
module.exports.ValidatedDevices=ValidatedDevices;


function WebhookConfiguration(){
    this.endPoint;
    this.mobileHub;
    this.recurringBill;
    this.virtualHub;
    this.webhookActive;
    this.api;
    this.batchIsActive;
}
WebhookConfiguration.prototype={
    constructor:WebhookConfiguration,
    endPoint:this.endPoint,
    mobileHub:this.mobileHub,
    recurringBill:this.recurringBill,
    virtualHub:this.virtualHub,
    webhookActive:this.webhookActive,
    api:this.api,
    batchIsActive:this.batchIsActive
};
module.exports.WebhookConfiguration=WebhookConfiguration;

function RoleSettings(){
    this.roleName;
    this.firstDefaultScreen;
    this.transactions=new Transactions();
    this.reports=new Reports();
    this.help=new Help();
    this.mobileVTAcces=new MobileVTAcces();
    this.admin=new Admin();
    this.customer=new Customer();
    this.webPosAccess=new WebPosAccess();
}
RoleSettings.prototype={
    constructor:RoleSettings,
    roleName:this.roleName,
    firstDefaultScreen:this.firstDefaultScreen,
    transactions:this.transactions,
    reports:this.reports,
    help:this.help,
    mobileVTAcces:this.mobileVTAcces,
    admin:this.admin,
    customer:this.customer,
    webPosAccess:this.webPosAccess
};

module.exports.RoleSettings=RoleSettings;

function Transactions(){
    this.checked;
    this.transactionOptions=new TransactionOptions();
}
Transactions.prototype={
    constructor:Transactions,
    checked:this.checked,
    transactionOptions:this.transactionOptions
};
module.exports.Transactions=Transactions;


function TransactionOptions(){
    this.viewHostedShop;
    this.viewSubmitBatch;
    this.txtRefundupto;
    this.single=new Single();
    this.recurringBills=new RecurringBills();
}
TransactionOptions.prototype={
    constructor:TransactionOptions,
    viewHostedShop:this.viewHostedShop,
    viewSubmitBatch:this.viewSubmitBatch,
    txtRefundupto:this.txtRefundupto,
    single:this.single,
    recurringBills:this.recurringBills
};
module.exports.TransactionOptions=TransactionOptions;

//SINGLE//
function Single(){
    this.checked;
    this.singleOptions=new SingleOptions();
}
Single.prototype={
    constructor:Single,
    checked:this.checked,
    singleOptions:this.singleOptions
};
module.exports.Single=Single;


function SingleOptions(){
    this.sales;
    this.refund;
}
SingleOptions.prototype={
    constructor:SingleOptions,
    sales:this.sales,
    refund:this.refund
};
module.exports.SingleOptions=SingleOptions;

//RECURRINGBILLS
function RecurringBills(){
    this.checked;
    this.recurringBillOptions=new RecurringBillOptions();
}
RecurringBills.prototype={
    constructor:RecurringBills,
    checked:this.checked,
    recurringBillOptions:this.recurringBillOptions
};
module.exports.RecurringBills=RecurringBills;


function RecurringBillOptions(){
    this.edit;
    this.add;
    this.delete;
}
RecurringBillOptions.prototype={
    constructor:RecurringBillOptions,
    edit:this.edit,
    add:this.add,
    delete:this.delete
};
module.exports.RecurringBillOptions=RecurringBillOptions;

//REPORT//
function Reports(){
    this.checked;
    this.reportOptions=new ReportOptions();
}
Reports.prototype={
    constructor:Reports,
    checked:this.checked,
    reportOptions:this.reportOptions
};
module.exports.Reports=Reports;


function ReportOptions(){
    this.standard=new Standard();
    this.custom;
}
ReportOptions.prototype={
    constructor:ReportOptions,
    standard:this.standard,
    custom:this.custom
};
module.exports.ReportOptions=ReportOptions;

//Standard//
function Standard(){
    this.checked;
    this.standardOptions=new StandardOptions();
}
Standard.prototype={
    constructor:Standard,
    checked:this.checked,
    standardOptions:this.standardOptions
};
module.exports.Standard=Standard;


function StandardOptions(){
    this.product;
    this.users;
    this.recurrbill;
    this.transaction;
    this.batch;
    this.customer;
}
StandardOptions.prototype={
    constructor:StandardOptions,
    product:this.product,
    users:this.users,
    recurrbill:this.recurrbill,
    transaction:this.transaction,
    batch:this.batch,
    customer:this.customer

};
module.exports.StandardOptions=StandardOptions;


//HELP//
function Help(){
    this.checked;
    this.helpOptions=new HelpOptions();
}
Help.prototype={
    constructor:Help,
    checked:this.checked,
    helpOptions:this.helpOptions
};
module.exports.Help=Help;


function HelpOptions(){
    this.tickets=new Tickets();
}
HelpOptions.prototype={
    constructor:HelpOptions,
    tickets:this.tickets
};
module.exports.HelpOptions=HelpOptions;


function Tickets(){
    this.checked;
    this.ticketsOptions=new TicketsOptions();
}
Tickets.prototype={
    constructor:Tickets,
    checked:this.checked,
    ticketsOptions:this.ticketsOptions
};
module.exports.Tickets=Tickets;


function TicketsOptions(){
    this.edit;
    this.add;
}
TicketsOptions.prototype={
    constructor:TicketsOptions,
    edit:this.edit,
    add:this.add
};
module.exports.TicketsOptions=TicketsOptions;

function MobileVTAcces(){
    this.checked;
}
MobileVTAcces.prototype={
    constructor:MobileVTAcces,
    checked:this.checked
};
module.exports.MobileVTAcces=MobileVTAcces;

//ADMIN//
function Admin(){
    this.checked;
    this.adminOptions=new AdminOptions();
}
Admin.prototype={
    constructor:Admin,
    checked:this.checked,
    adminOptions:this.adminOptions
};
module.exports.Admin=Admin;

function AdminOptions(){
    this.hostedShopCart;
    this.product=new Product();
    this.users=new Users();
    this.riskAndFraud=new RiskAndFraud();
    this.general=new General();
    this.webposSetUp;
}
AdminOptions.prototype={
    constructor:AdminOptions,
    hostedShopCart:this.hostedShopCart,
    product:this.product,
    users:this.users,
    riskAndFraud:this.riskAndFraud,
    general:this.general,
    webposSetUp:this.webposSetUp
};
module.exports.AdminOptions=AdminOptions;

function Product(){
    this.checked;
    this.productOptions=new ProductOptions();
}
Product.prototype={
    constructor:Product,
    checked:this.checked,
    productOptions:this.productOptions
};
module.exports.Product=Product;

function ProductOptions(){
    this.delete;
    this.edit;
    this.add;
    this.bulkUpload;
}
ProductOptions.prototype={
    constructor:ProductOptions,
    delete:this.delete,
    edit:this.edit,
    add:this.add,
    bulkUpload:this.bulkUpload
};
module.exports.ProductOptions=ProductOptions;

//USERS//

function Users(){
    this.checked;
    this.usersOptions=new UsersOptions();
}
Users.prototype={
    constructor:Users,
    checked:this.checked,
    usersOptions:this.usersOptions
};
module.exports.Users=Users;

function UsersOptions(){
    this.deleteRole;
    this.manageRole;
    this.editRole;
    this.delete;
    this.edit;
    this.addRole;
    this.add;
}
UsersOptions.prototype={
    constructor:UsersOptions,
    deleteRole:this.deleteRole,
    manageRole:this.manageRole,
    editRole:this.editRole,
    delete:this.delete,
    edit:this.edit,
    addRole:this.addRole,
    add:this.add
};
module.exports.UsersOptions=UsersOptions;

//RISK AND FRAUD//
function RiskAndFraud(){
    this.checked;
    this.riskAndFraudOptions=new RiskAndFraudOptions();
}
RiskAndFraud.prototype={
    constructor:RiskAndFraud,
    checked:this.checked,
    riskAndFraudOptions:this.riskAndFraudOptions
};
module.exports.RiskAndFraud=RiskAndFraud;

function RiskAndFraudOptions(){
    this.riskfraudSetting;
    this.riskfraudFlagTrn;
}
RiskAndFraudOptions.prototype={
    constructor:RiskAndFraudOptions,
    riskfraudSetting:this.riskfraudSetting,
    riskfraudFlagTrn:this.riskfraudFlagTrn
};
module.exports.RiskAndFraudOptions=RiskAndFraudOptions;

//GENERAL//
function General(){
    this.checked;
    this.generalOptions=new GeneralOptions();
}
General.prototype={
    constructor:General,
    checked:this.checked,
    generalOptions:this.generalOptions
};
module.exports.General=General;

function GeneralOptions(){
    this.validateDev;
    this.thirdParyApi;
    this.shippingTax;
    this.branding;
    this.generalSetting;
}
GeneralOptions.prototype={
    constructor:GeneralOptions,
    validateDev:this.validateDev,
    thirdParyApi:this.thirdParyApi,
    shippingTax:this.shippingTax,
    branding:this.branding,
    generalSetting:this.generalSetting
};
module.exports.GeneralOptions=GeneralOptions;

//CUSTOMER//
function Customer(){
    this.checked;
    this.customerOptions=new CustomerOptions();
}
Customer.prototype={
    constructor:Customer,
    checked:this.checked,
    customerOptions:this.customerOptions
};
module.exports.Customer=Customer;

function CustomerOptions(){
    this.edit;
    this.delete;
    this.add;
}
CustomerOptions.prototype={
    constructor:CustomerOptions,
    delete:this.delete,
    edit:this.edit,
    add:this.add
};
module.exports.CustomerOptions=CustomerOptions;

//WEBPOSS ACCESS//

function WebPosAccess(){
    this.checked;
    this.webPosAccessOptions=new WebPosAccessOptions();
}
WebPosAccess.prototype={
    constructor:WebPosAccess,
    checked:this.checked,
    webPosAccessOptions:this.webPosAccessOptions
};
module.exports.WebPosAccess=WebPosAccess;

function WebPosAccessOptions(){
    this.admin=new WebPosAdmin;
    this.quitPos;
    this.manualPriceChange;
}
WebPosAccessOptions.prototype={
    constructor:WebPosAccessOptions,
    admin:this.admin,
    quitPos:this.quitPos,
    manualPriceChange:this.manualPriceChange
};
module.exports.WebPosAccessOptions=WebPosAccessOptions;

//WebPosAdmin//
function WebPosAdmin(){
    this.checked;
    this.adminOptions=new WebPosAdminOptions();
}
WebPosAdmin.prototype={
    constructor:WebPosAdmin,
    checked:this.checked,
    adminOptions:this.adminOptions
};
module.exports.WebPosAdmin=WebPosAdmin;

function WebPosAdminOptions(){
    this.hotKey;
    this.deviceList;
    this.display;
    this.tills;
    this.generalSettings;
    this.customPrompt;
    this.customMessage;
}
WebPosAdminOptions.prototype={
    constructor:WebPosAdminOptions,
    hotKey:this.hotKey,
    deviceList:this.deviceList,
    display:this.display,
    tills:this.tills,
    generalSettings:this.generalSettings,
    customPrompt:this.customPrompt,
    customMessage:this.customMessage
};
module.exports.WebPosAdminOptions=WebPosAdminOptions;
