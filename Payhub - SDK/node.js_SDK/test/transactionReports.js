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

var tsp=new models.TransactionSearchParameters();
tsp.amountFrom="0.99";
tsp.amountTo="5.00";

var transactionManager = new trnManager.TransactionManager(merchant,WsURL,oauth_token);
var transactionReportReponse = transactionManager.findTransactions(tsp);
console.log(transactionReportReponse[0]);
var transactionTotals = transactionManager.findTotals(tsp);
console.log(transactionTotals);







