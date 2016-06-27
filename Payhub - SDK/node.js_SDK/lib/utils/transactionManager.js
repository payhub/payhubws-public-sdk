/**
 * Created by agustinb on 06/16/16.
 */
'use strict'

var errors = require('../model/errors');
var apiRes=require('../api/apiResponses');

TransactionManager.prototype={constructor: TransactionManager}
module.exports.TransactionManager=TransactionManager;
function replacer(key, value)
{
    if (value==null)
    {
        return undefined;
    }
    else return value;
}

function TransactionManager(merchant,url,token){
    var ws = require('./wsConnections');
    var wsConnections =new ws.WsConnections();
    var merchant=merchant;
    var _url=url;
    var _token = token;

    var params = {
        merchant: merchant,
        url: url,
        token: token
    };
    this.doSale=function(sale){
        var response = wsConnections.postTrnRequest(sale,_url+sale.getSale_id_link(),_token);
        if(typeof response!='array' && !(response[0] instanceof errors.Errors)){
            response = apiRes.SaleResponseInformation(response,params);
        }
        console.log(response);
        return response;
    }
    this.getSale=function(saleId){
        if(arguments.length>1 || !arguments[0] || !(parseInt(arguments[0]))){
            if(arguments.length>1)throw "Parameters don't match: Id. is required";
        }
        var url=_url+"sale/"+saleId
        var response = wsConnections.getTrnRequest(url,_token)
        if(typeof response!='array' && !(response[0] instanceof errors.Errors)){
            response = apiRes.SaleResponseInformation(response,params);
        }
        return response;
    }
    this.getAllSales=function(page,size){
        page = page || 0;
        size = size || 100;
        var url = _url+"/sale"+"?page="+page+"&size="+size + "&sort=id,desc";

        var response = wsConnections.getTrnRequest(url,_token)
        if(!(response[0] instanceof errors.Errors)){
            response._embedded.sales.forEach(function(item){
                item = apiRes.SaleResponseInformation(item,params);
            });
            response = response._embedded.sales
        }
        return response;
    }

    // Auth Only //
    this.doAuthOnly=function(authOnly){
        var response = wsConnections.postTrnRequest(authOnly,_url+authOnly.getAuthonly_id_link(),_token);
        if(typeof response!='array' && !(response[0] instanceof errors.Errors)){
            response = apiRes.AuthorizationResponseInformation(response,params);
        }
        return response;
    }
    this.getAuthOnly=function(id){
        if(arguments.length>1 || !arguments[0] || !(parseInt(arguments[0]))){
            if(arguments.length>1)throw "Parameters don't match: Id. is required";
        }
        var url=_url+"authonly/"+id
        var response = wsConnections.getTrnRequest(url,_token)
        if(typeof response!='array' && !(response[0] instanceof errors.Errors)){
            response = apiRes.AuthorizationResponseInformation(response,params);
        }
        return response;
    }
    this.getAllAuthOnly=function(page,size){
        page = page || 0;
        size = size || 100;
        var url = _url+"/authonly"+"?page="+page+"&size="+size + "&sort=id,desc";

        var response = wsConnections.getTrnRequest(url,_token)
        if(!(response[0] instanceof errors.Errors)){
            response._embedded.authonlys.forEach(function(item){
                item = apiRes.AuthorizationResponseInformation(item,params);
            });
            response = response._embedded.authonlys
        }
        return response;
    }

    // Capture //
    this.doCapture=function(capture){
        var response = wsConnections.postTrnRequest(capture,_url+capture.getCapture_id_link(),_token);
        if(typeof response!='array' && !(response[0] instanceof errors.Errors)){
            response = apiRes.CaptureResponseInformation(response,params);
        }
        return response;
    }
    this.getCapture=function(id){
        if(arguments.length>1 || !arguments[0] || !(parseInt(arguments[0]))){
            if(arguments.length>1)throw "Parameters don't match: Id. is required";
        }
        var url=_url+"capture/"+id
        var response = wsConnections.getTrnRequest(url,_token)
        if(typeof response!='array' && !(response[0] instanceof errors.Errors)){
            response = apiRes.CaptureResponseInformation(response,params);
        }
        return response;
    }
    this.getAllCapture=function(page,size){
        page = page || 0;
        size = size || 100;
        var url = _url+"/capture"+"?page="+page+"&size="+size + "&sort=id,desc";

        var response = wsConnections.getTrnRequest(url,_token)
        if(!(response[0] instanceof errors.Errors)){
            response._embedded.captures.forEach(function(item){
                item = apiRes.CaptureResponseInformation(item,params);
            });
            response = response._embedded.captures
        }
        return response;
    }

    this.doVoid=function(_void){
        var response = wsConnections.postTrnRequest(_void,_url+_void.getVoid_id_link(),_token);
        if(typeof response!='array' && !(response[0] instanceof errors.Errors)){
            response = apiRes.VoidResponseInformation(response,params);
        }
        return response;
    }
    this.getVoid=function(id){
        if(arguments.length>1 || !arguments[0] || !(parseInt(arguments[0]))){
            if(arguments.length>1)throw "Parameters don't match: Id. is required";
        }
        var url=_url+"void/"+id
        var response = wsConnections.getTrnRequest(url,_token)
        if(typeof response!='array' && !(response[0] instanceof errors.Errors)){
            response = apiRes.VoidResponseInformation(response,params);
        }
        return response;
    }
    this.getAllVoids=function(page,size){
        page = page || 0;
        size = size || 100;
        var url = _url+"/void"+"?page="+page+"&size="+size + "&sort=id,desc";

        var response = wsConnections.getTrnRequest(url,_token)
        if(!(response[0] instanceof errors.Errors)){
            response._embedded.voids.forEach(function(item){
                item = apiRes.VoidResponseInformation(item,params);
            });
            response = response._embedded.voids
        }
        return response;
    }

    //VERIFY METHODS//
    this.doVerify=function(verify){
        var response = wsConnections.postTrnRequest(verify,_url+verify.getVerify_id_link(),_token);
        if(typeof response!='array' && !(response[0] instanceof errors.Errors)){
            response = apiRes.VerfyResponseInformation(response,params);
        }
        return response;
    }
    this.getVerifyInformation=function(id){
        if(arguments.length>1 || !arguments[0] || !(parseInt(arguments[0]))){
            if(arguments.length>1)throw "Parameters don't match: Id. is required";
        }
        var url=_url+"verify/"+id
        var response = wsConnections.getTrnRequest(url,_token)
        if(typeof response!='array' && !(response[0] instanceof errors.Errors)){
            response = apiRes.VerfyResponseInformation(response,params);
        }
        return response;
    }
    this.getAllVerifyInformation=function(page,size){
        page = page || 0;
        size = size || 100;
        var url = _url+"/verify"+"?page="+page+"&size="+size + "&sort=id,desc";

        var response = wsConnections.getTrnRequest(url,_token)
        if(!(response[0] instanceof errors.Errors)){
            response._embedded.verifications.forEach(function(item){
                item = apiRes.VerfyResponseInformation(item,params);
            });
            response = response._embedded.verifications
        }
        return response;
    }

    //REFUND METHODS//
    this.doRefund=function(refund){
        var response = wsConnections.postTrnRequest(_void,_url+refund.getRefund_id_link(),_token);
        if(typeof response!='array' && !(response[0] instanceof errors.Errors)){
            response = apiRes.RefundInformation(response,params);
        }
        return response;
    }
    this.getRefundInformation=function(id){
        if(arguments.length>1 || !arguments[0] || !(parseInt(arguments[0]))){
            if(arguments.length>1)throw "Parameters don't match: Id. is required";
        }
        var url=_url+"refund/"+id
        var response = wsConnections.getTrnRequest(url,_token)
        if(typeof response!='array' && !(response[0] instanceof errors.Errors)){
            response = apiRes.RefundInformation(response,params);
        }
        return response;
    }
    this.getAllRefundInformation=function(page,size){
        page = page || 0;
        size = size || 100;
        var url = _url+"/refund"+"?page="+page+"&size="+size + "&sort=id,desc";

        var response = wsConnections.getTrnRequest(url,_token)
        if(!(response[0] instanceof errors.Errors)){
            response._embedded.refunds.forEach(function(item){
                item = apiRes.RefundInformation(item,params);
            });
            response = response._embedded.refunds
        }
        return response;
    }

    //RECURRING BILL METHODS//
    this.doRecurringBill=function(recurringBill){
        var response = wsConnections.postTrnRequest(recurringBill,_url+recurringBill.getRecurring_bill_id_link(),_token);
        if(typeof response!='array' && !(response[0] instanceof errors.Errors)){
            response = apiRes.RecurringBillResponseInformation(response,params);
        }
        return response;
    }
    this.getRecurringBillInformation=function(id){
        if(arguments.length>1 || !arguments[0] || !(parseInt(arguments[0]))){
            if(arguments.length>1)throw "Parameters don't match: Id. is required";
        }
        var url=_url+"recurring-bill/"+id
        var response = wsConnections.getTrnRequest(url,_token)
        if(typeof response!='array' && !(response[0] instanceof errors.Errors)){
            response = apiRes.RecurringBillResponseInformation(response,params);
        }
        return response;
    }
    this.getAllRecurringBillInformation=function(page,size){
        page = page || 0;
        size = size || 100;
        var url = _url+"/recurring-bill"+"?page="+page+"&size="+size + "&sort=id,desc";

        var response = wsConnections.getTrnRequest(url,_token)
        if(!(response[0] instanceof errors.Errors)){
            response._embedded.recurringbills.forEach(function(item){
                item = apiRes.RecurringBillResponseInformation(item,params);
            });
            response = response._embedded.recurringbills
        }
        return response;
    }
    this.findRecurringBillInformationByCustomer=function(id,page,size){
        page = page || 0;
        size = size || 100;
        var url = _url+"/recurring-bill/search/findByCustomerRef?customerId="+id.toString()+"&page="+page+"&size="+size + "&sort=id,desc";

        var response = wsConnections.getTrnRequest(url,_token)
        if(!(response[0] instanceof errors.Errors)){
            response._embedded.recurringbills.forEach(function(item){
                item = apiRes.RecurringBillResponseInformation(item,params);
            });
            response = response._embedded.recurringbills
        }
        return response;
    }

    this.updateRecurringBillStatus = function (id,status) {
        if(arguments.length>2 || !arguments[0] || !(parseInt(arguments[0]))){
            if(arguments.length>2)throw "Parameters don't match: Id,and Status are required";
        }
        var url=_url+"recurring-bill-status/"+id
        var obj = new Object();
        obj.recurring_bill_status = status;
        var response = wsConnections.doPatch(obj,url,_token);
        return response;
    }

    this.updateRecurringBill = function (id,recurringBill) {
        if(arguments.length>2 || !arguments[0] || !(parseInt(arguments[0]))){
            if(arguments.length>2)throw "Parameters don't match: Id,and Status are required";
        }
        var url=_url+"recurring-bill/"+id
        var response = wsConnections.doPatch(recurringBill,url,_token);
        return response;
    }

    //BILL FOR SALE METHOD//
    this.getAllBillForSalesInformation=function(page,size){
        page = page || 0;
        size = size || 100;
        var url = _url+"/bill-for-sale"+"?page="+page+"&size="+size + "&sort=id,desc";

        var response = wsConnections.getTrnRequest(url,_token)
        if(!(response[0] instanceof errors.Errors)){
            response = response._embedded.billforsale
        }
        return response;
    }

    //BILL FOR RECURRING BILL METHOD//
    this.getAllBillForRecurringBillInformation=function(page,size){
        page = page || 0;
        size = size || 100;
        var url = _url+"/bill-for-recurring-bill"+"?page="+page+"&size="+size + "&sort=id,desc";

        var response = wsConnections.getTrnRequest(url,_token)
        if(!(response[0] instanceof errors.Errors)){
            response = response._embedded.billsforrecurringbill
        }
        return response;
    }

    //CUSTOMER FOR SALE METHOD//
    this.getAllCustomerForSalesInformation=function(page,size){
        page = page || 0;
        size = size || 100;
        var url = _url+"/customer-for-sale"+"?page="+page+"&size="+size + "&sort=id,desc";

        var response = wsConnections.getTrnRequest(url,_token)
        if(!(response[0] instanceof errors.Errors)){
            response = response._embedded.customerforsale
        }
        return response;
    }

    //CUSTOMER FOR RECURRING BILL METHOD//
    this.getAllCustomerForRecurringBillInformation=function(page,size){
        page = page || 0;
        size = size || 100;
        var url = _url+"/customer"+"?page="+page+"&size="+size + "&sort=id,desc";

        var response = wsConnections.getTrnRequest(url,_token)
        if(!(response[0] instanceof errors.Errors)){
            response = response._embedded.customers
        }
        return response;
    }
    //FIND TRANSACTIONS METHODS//
    this.findTransactions=function(parameters){
        var url = _url+"report/transactionReport";
        var response = wsConnections.postRptRequest(parameters,url,_token);
        return response;
    }

    this.findTransactionsTotals=function(parameters){
        var url = _url+"report/transactionTotals";
        var response = wsConnections.postRptRequest(parameters,url,_token);
        return response;
    }
    //METADATA METHOD//
    this.addMetadata=function(data, type,operationId){
        var url = null;
        if(type.toUpperCase()==="Sale".toUpperCase()){
            url=_url+"metadata/forSale/"+operationId
        }else if(type.toUpperCase()==="AuthOnly".toUpperCase()){
            url=_url+"metadata/forAuthOnly/"+operationId
        }else if(type.toUpperCase()==="Capture".toUpperCase()){
            url=_url+"metadata/forCapture/"+operationId
        }else if(type.toUpperCase()==="Bill".toUpperCase()){
            url=_url+"metadata/forBill/"+operationId
        }else if(type.toUpperCase()==="CardData".toUpperCase()){
            url=_url+"metadata/forCardData/"+operationId
        }else if(type.toUpperCase()==="Customer".toUpperCase()){
            url=_url+"metadata/forCustomer/"+operationId
        }else if(type.toUpperCase()==="Merchant".toUpperCase()){
            url=_url+"metadata/forMerchant/"+operationId
        }else if(type.toUpperCase()==="RecurringBill".toUpperCase()){
            url=_url+"metadata/forRecurringBill/"+operationId
        }else if(type.toUpperCase()==="Schedule".toUpperCase()){
            url=_url+"metadata/forSchedule/"+operationId
        }else if(type.toUpperCase()==="Refund".toUpperCase()){
            url=_url+"metadata/forRefund/"+operationId
        }else if(type.toUpperCase()==="VoidTransaction".toUpperCase()){
            url=_url+"metadata/forVoid/"+operationId
        }else if(type.toUpperCase()==="Verify".toUpperCase()){
            url=_url+"metadata/forVerify/"+operationId
        }else if(type.toUpperCase()==="Status".toUpperCase()){
            url=_url+"metadata/forStatus/"+operationId
        }
        if(!url){
            throw "Valid Values for Type are: Sale, AuthOnly, Capture, Bill, CardData, Customer, Merchant, RecurringBill, Schedule, Refund, VoidTransaction, Verify, Status"
        }
        var response = wsConnections.putMetadata(data,url,_token);
        return response;
    }
    //ADMIN SETTINGS GET METHODS//
    this.getGeneralSettings=function(){
        var url=_url+"adminSettings/generalSettings";
        var response = wsConnections.getTrnRequest(url,_token);
        return response;
    }
    this.getWebhookConfiguration=function(){
        var url=_url+"adminSettings/webhookConfiguration";
        var response = wsConnections.getTrnRequest(url,_token);
        return response;
    }
    this.getValidatedDevices=function(){
        var url=_url+"adminSettings/validatedDevices";
        var response = wsConnections.getTrnRequest(url,_token);
        return response;
    }
    this.getRiskFraudSettings=function(){
        var url=_url+"adminSettings/riskFraudDetection";
        var response = wsConnections.getTrnRequest(url,_token);
        return response;
    }
    this.getAllUserRoles=function(){
        var url=_url+"userRole/roles";
        var response = wsConnections.getTrnRequest(url,_token);
        return response;
    }
    this.getUserRolesById=function(id){
        if(arguments.length>1 || !arguments[0] || !(parseInt(arguments[0]))){
            if(arguments.length>1)throw "Parameters don't match: Id. is required";
        }
        var url=_url+"userRole/roles/"+id;
        var response = wsConnections.getTrnRequest(url,_token);
        return response;
    }
    this.getEmailConfiguration=function(){
        var url=_url+"adminSettings/emailConfiguration";
        var response = wsConnections.getTrnRequest(url,_token);
        return response;
    }

    //ADMIN SETTINGS PATCH METHODS//
    this.patchWebhookConfiguration=function(webhook){
        var url=_url+"adminSettings/webhookConfiguration";
        var response = wsConnections.doPatch(webhook,url,_token);
        return response;
    }
    this.patchValidatedDevices=function(vd){
        var url=_url+"adminSettings/validatedDevices";
        var response = wsConnections.doPatch(vd,url,_token);
        return response;
    }
    this.patchRiskFraudSettings=function(riskNFraud){
        var url=_url+"adminSettings/riskFraudDetection";
        var response = wsConnections.doPatch(riskNFraud,url,_token);
        return response;
    }
    this.patchEmailConfiguration=function(emailConfig){
        var url=_url+"adminSettings/emailConfiguration";
        var response = wsConnections.doPatch(emailConfig,url,_token);
        return response;
    }
    this.patchUserRoles=function(roleSettings,roleId){
        if(arguments.length>2 || !arguments[0] || !arguments[1] || !(parseInt(arguments[1]))){
           throw "Parameters don't match: User Role Settings, and Id. are required";
        }
        var url=_url+"userRole/roles/update/"+roleId;
        var response = wsConnections.doPatch(roleSettings,url,_token);
        return response;
    }
    //ADMIN SETTINGS POST METHODS//
    this.postUserRoles=function(role){
        var url=_url+"userRole/roles/create";
        var response = wsConnections.postUsrRoles(role,url,_token);
        return response;
    }
}

