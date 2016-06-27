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

var card_data = new models.CardData()
card_data.card_number="5466410004374507";
card_data.cvv_data="998"
card_data.card_expiry_date="202011"
card_data.billing_address_1="2350 Kerner Blvd"
card_data.billing_city="San Rafael"
card_data.billing_state="CA"
card_data.billing_zip="99997"

var customer=new models.Customer()
customer.first_name="testJS"
customer.last_name="testJS"
customer.email_address="testJS@testJS.com"

var verify = new models.Verify(merchant,card_data,customer)

var transactionManager = new trnManager.TransactionManager(merchant,WsURL,oauth_token);
var verifyResponse = transactionManager.doVerify(verify);
if(!(verifyResponse[0] instanceof errors.Errors)){
    var verifyId = verifyResponse.verifyResponse.verifyId;
    var getverifyResponse  = transactionManager.getVerifyInformation(verifyId);
    if(!(getverifyResponse[0]instanceof errors.Errors)){
        console.log(getverifyResponse);
    }else{console.log(getverifyResponse[0])}
}else{console.log(verifyResponse[0])}





