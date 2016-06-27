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

var transactionManager = new trnManager.TransactionManager(merchant,WsURL,oauth_token);
var getGeneralSettings = transactionManager.getGeneralSettings();
console.log(getGeneralSettings);
var getWebhookConfiguration = transactionManager.getWebhookConfiguration();
console.log(getWebhookConfiguration);
var getValidatedDevices = transactionManager.getValidatedDevices();
console.log(getValidatedDevices);
var getRiskFraudSettings = transactionManager.getRiskFraudSettings();
console.log(getRiskFraudSettings);
var getAllUserRoles = transactionManager.getAllUserRoles();
console.log(getAllUserRoles);
var getUserRolesById = transactionManager.getUserRolesById(getAllUserRoles.userRoles[2].roleId);
console.log(getUserRolesById);
var getEmailConfiguration = transactionManager.getEmailConfiguration();
console.log(getEmailConfiguration);







