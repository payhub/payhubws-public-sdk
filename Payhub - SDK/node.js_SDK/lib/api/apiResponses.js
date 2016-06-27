/**
 * Created by agustinb on 06/16/16.
 */
'use strict'
var ws = require('../utils/wsConnections');

function SaleResponseInformation(response,params){
    var wsConnections =new ws.WsConnections();
    var billInformation = null;
    var cardDataInformation=null;
    var customerInformation=null;
    var merchantInformation=null;

    response.billInformation = function(){
        if(!billInformation){
            var res = wsConnections.getTrnRequest(params.url+"/sale/"+response.saleResponse.saleId+"/bill",params.token)
            billInformation=res;
            return billInformation;
        }else{return billInformation;}
    };

    response.cardDataInformation = function(){
        if(!cardDataInformation){
            var res = wsConnections.getTrnRequest(params.url+"/sale/"+response.saleResponse.saleId+"/card_data",params.token)
            cardDataInformation=res;
            return cardDataInformation;
        }else{return cardDataInformation;}
    };
    response.customerInformation = function(){
        if(!customerInformation){
            var res = wsConnections.getTrnRequest(params.url+"/sale/"+response.saleResponse.saleId+"/customer",params.token)
            customerInformation=res;
            return customerInformation;
        }else{return customerInformation;}
    };
    response.merchantInformation = function(){
        if(!merchantInformation){
            var res = wsConnections.getTrnRequest(params.url+"/sale/"+response.saleResponse.saleId+"/merchant",params.token)
            merchantInformation=res;
            return merchantInformation;
        }else{return merchantInformation;}
    };

    return response;
}

function AuthorizationResponseInformation(response,params){
    var wsConnections =new ws.WsConnections();
    var billInformation = null;
    var cardDataInformation=null;
    var customerInformation=null;
    var merchantInformation=null;

    response.billInformation = function(){
        if(!billInformation){
            var res = wsConnections.getTrnRequest(params.url+"/authonly/"+response.authOnlyResponse.transactionId+"/bill",params.token)
            billInformation=res;
            return billInformation;
        }else{return billInformation;}
    };

    response.cardDataInformation = function(){
        if(!cardDataInformation){
            var res = wsConnections.getTrnRequest(params.url+"/authonly/"+response.authOnlyResponse.transactionId+"/card_data",params.token)
            cardDataInformation=res;
            return cardDataInformation;
        }else{return cardDataInformation;}
    };
    response.customerInformation = function(){
        if(!customerInformation){
            var res = wsConnections.getTrnRequest(params.url+"/authonly/"+response.authOnlyResponse.transactionId+"/customer",params.token)
            customerInformation=res;
            return customerInformation;
        }else{return customerInformation;}
    };
    response.merchantInformation = function(){
        if(!merchantInformation){
            var res = wsConnections.getTrnRequest(params.url+"/authonly/"+response.authOnlyResponse.transactionId+"/merchant",params.token)
            merchantInformation=res;
            return merchantInformation;
        }else{return merchantInformation;}
    };

    return response;
}


function RecurringBillResponseInformation(response,params){
    var wsConnections =new ws.WsConnections();
    var billInformation = null;
    var cardDataInformation=null;
    var customerInformation=null;
    var merchantInformation=null;
    var scheduleInformation=null;
    var statusInformation=null;

    response.billInformation = function(){
        if(!billInformation){
            var res = wsConnections.getTrnRequest(params.url+"/recurring-bill/"+response.lastRecurringBillResponse.recurringBillId+"/bill",params.token)
            billInformation=res;
            return billInformation;
        }else{return billInformation;}
    };

    response.cardDataInformation = function(){
        if(!cardDataInformation){
            var res = wsConnections.getTrnRequest(params.url+"/recurring-bill/"+response.lastRecurringBillResponse.recurringBillId+"/card_data",params.token)
            cardDataInformation=res;
            return cardDataInformation;
        }else{return cardDataInformation;}
    };
    response.customerInformation = function(){
        if(!customerInformation){
            var res = wsConnections.getTrnRequest(params.url+"/recurring-bill/"+response.lastRecurringBillResponse.recurringBillId+"/customer",params.token)
            customerInformation=res;
            return customerInformation;
        }else{return customerInformation;}
    };
    response.merchantInformation = function(){
        if(!merchantInformation){
            var res = wsConnections.getTrnRequest(params.url+"/recurring-bill/"+response.lastRecurringBillResponse.recurringBillId+"/merchant",params.token)
            merchantInformation=res;
            return merchantInformation;
        }else{return merchantInformation;}
    };
    response.scheduleInformation = function(){
        if(!scheduleInformation){
            var res = wsConnections.getTrnRequest(params.url+"/recurring-bill/"+response.lastRecurringBillResponse.recurringBillId+"/schedule",params.token)
            scheduleInformation=res;
            return scheduleInformation;
        }else{return scheduleInformation;}
    };

    response.statusInformation = function(){
        if(!statusInformation){
            var res = wsConnections.getTrnRequest(params.url+"/recurring-bill/"+response.lastRecurringBillResponse.recurringBillId+"/status",params.token)
            statusInformation=res;
            return statusInformation;
        }else{return statusInformation;}
    };

    return response;
}

function VerfyResponseInformation(response,params){
    var wsConnections =new ws.WsConnections();
    var cardDataInformation=null;
    var customerInformation=null;
    var merchantInformation=null;

    response.cardDataInformation = function(){
        if(!cardDataInformation){
            var res = wsConnections.getTrnRequest(params.url+"/verify/"+response.verifyResponse.verifyId+"/card_data",params.token)
            cardDataInformation=res;
            return cardDataInformation;
        }else{return cardDataInformation;}
    };
    response.customerInformation = function(){
        if(!customerInformation){
            var res = wsConnections.getTrnRequest(params.url+"/verify/"+response.verifyResponse.verifyId+"/customer",params.token)
            customerInformation=res;
            return customerInformation;
        }else{return customerInformation;}
    };
    response.merchantInformation = function(){
        if(!merchantInformation){
            var res = wsConnections.getTrnRequest(params.url+"/verify/"+response.verifyResponse.verifyId+"/merchant",params.token)
            merchantInformation=res;
            return merchantInformation;
        }else{return merchantInformation;}
    };
    return response;
}

function CaptureResponseInformation(response,params){
    var wsConnections =new ws.WsConnections();
    var billInformation=null;
    var merchantInformation=null;

    response.billInformation = function(){
        if(!billInformation){
            var res = wsConnections.getTrnRequest(params.url+"/capture/"+response.lastCaptureResponse.transactionId+"/bill",params.token)
            billInformation=res;
            return billInformation;
        }else{return billInformation;}
    };
    response.merchantInformation = function(){
        if(!merchantInformation){
            var res = wsConnections.getTrnRequest(params.url+"/capture/"+response.lastCaptureResponse.transactionId+"/merchant",params.token)
            merchantInformation=res;
            return merchantInformation;
        }else{return merchantInformation;}
    };
    return response;
}


function VoidResponseInformation(response,params){
    var wsConnections =new ws.WsConnections();
    var merchantInformation=null;

    response.merchantInformation = function(){
        if(!merchantInformation){
            var res = wsConnections.getTrnRequest(params.url+"/void/"+response.lastVoidResponse.voidTransactionId+"/merchant",params.token)
            merchantInformation=res;
            return merchantInformation;
        }else{return merchantInformation;}
    };
    return response;
}

function RefundInformation(response,params){
    var wsConnections =new ws.WsConnections();
    var merchantInformation=null;

    response.merchantInformation = function(){
        if(!merchantInformation){
            var res = wsConnections.getTrnRequest(params.url+"/refund/"+response.lastRefundResponse.refundTransactionId+"/merchant",params.token)
            merchantInformation=res;
            return merchantInformation;
        }else{return merchantInformation;}
    };
    return response;
}

module.exports.SaleResponseInformation=SaleResponseInformation;
module.exports.AuthorizationResponseInformation=AuthorizationResponseInformation;
module.exports.RecurringBillResponseInformation=RecurringBillResponseInformation;
module.exports.VerfyResponseInformation=VerfyResponseInformation;
module.exports.CaptureResponseInformation=CaptureResponseInformation;
module.exports.VoidResponseInformation=VoidResponseInformation;
module.exports.RefundInformation=RefundInformation;
