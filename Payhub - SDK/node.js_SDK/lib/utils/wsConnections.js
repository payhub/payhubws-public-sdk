/**
 * Created by agustinb on 06/16/16.
 */
'use strict';

var request = require("sync-request");
var errors = require('../model/errors');

WsConnections.prototype={constructor: WsConnections};
module.exports.WsConnections=WsConnections;
function replacer(key, value)
{
    if (value==null)
    {
        return undefined;
    }
    else return value;
}

function WsConnections(){
    this.postTrnRequest = function (data,url,token) {
        var data = JSON.stringify(data, replacer);
        var options = {
            headers: {
                'cache-control': 'no-cache',
                authorization: 'Bearer ' + token,
                accept: 'application/json',
                'content-type': 'application/json'
            },
            body: data
        };
        var res = request("POST", url, options);
        if (res.statusCode == 201) {
            var location = (res.headers['location']);
            var resGet = this.getTrnRequest(location, token);
            return resGet;
        } else if (res.statusCode == 401) {
            var error = JSON.parse(res.body.toString('utf-8'));
            var _errors = new Array();
            _errors.push(new errors.Errors("", "", error.error, error.error_description, "Error"))
            return _errors
        } else if (res.statusCode == 400) {
            var error = JSON.parse(res.body.toString('utf-8'));
            var _errors = new Array();
            if (error.message) {
                _errors.push(new errors.Errors("", "", "", error.message, "Error"))
                return _errors
            } else {
                var _errors = new Array();
                error.errors.forEach(function (key) {
                    _errors.push(new errors.Errors(key.status, key.code, key.location, key.reason, key.severity))
                });
                return _errors
            }
        }
    }

    this.getTrnRequest = function(url,token){
        var options = {
            headers:
            {  'cache-control': 'no-cache',
                accept: 'application/json',
                'content-type': 'application/json',
                authorization: 'Bearer '+token }
        };
        var response = request('GET',url,options)
        if (response.statusCode == 200 ||response.statusCode == 201 ||response.statusCode == 204) {
            return JSON.parse(response.body.toString('utf-8'));
        }else if(response.statusCode == 401){
            var error = JSON.parse(response.body.toString('utf-8'));
            var _errors = new Array();
            _errors.push(new errors.Errors("","",error.error,error.error_description,"Error"))
            return _errors;

        }else if(response.statusCode == 400){
            var error = JSON.parse(response.body.toString('utf-8'));
            var _errors = new Array();
            if(error.message){
                _errors.push(new errors.Errors("","","",error.message,"Error"))
                return _errors
            }else{
                var _errors = new Array();
                error.errors.forEach(function(key){
                    _errors.push(new errors.Errors(key.status,key.code,key.location,key.reason,key.severity))
                });
                return _errors
            }
        }else if(response.statusCode == 404) {
            var error = JSON.parse(response.body.toString('utf-8'));
            var _errors = new Array();
            _errors.push(new errors.Errors("", "404", "", "not found", "Error"))
            return _errors
        }
    }

    this.doPatch=function (data,url,token) {
        var data = JSON.stringify(data, replacer);
        var options = {
            headers: {
                'cache-control': 'no-cache',
                authorization: 'Bearer ' + token,
                accept: 'application/json',
                'content-type': 'application/json'
            },
            body: data
        };
        var res = request("PATCH", url, options);
        if (res.statusCode == 200 || res.statusCode == 201 || res.statusCode==204) {
            return true;
        } else if (res.statusCode == 401) {
            var error = JSON.parse(res.body.toString('utf-8'));
            var _errors = new Array();
            _errors.push(new errors.Errors("", "", error.error, error.error_description, "Error"))
            return _errors
        } else if (res.statusCode == 400) {
            var error = JSON.parse(res.body.toString('utf-8'));
            var _errors = new Array();
            if (error.message) {
                _errors.push(new errors.Errors("", "", "", error.message, "Error"))
                return _errors
            } else {
                var _errors = new Array();
                error.errors.forEach(function (key) {
                    _errors.push(new errors.Errors(key.status, key.code, key.location, key.reason, key.severity))
                });
                return _errors
            }
        }
    }

    this.postRptRequest = function (data,url,token) {
        var data = JSON.stringify(data, replacer);
        var options = {
            headers: {
                'cache-control': 'no-cache',
                authorization: 'Bearer ' + token,
                accept: 'application/json',
                'content-type': 'application/json'
            },
            body: data
        };
        var res = request("POST", url, options);

        if (res.statusCode == 200) {
            return JSON.parse(res.body.toString('utf-8'));
        } else if (res.statusCode == 401) {
            var error = JSON.parse(res.body.toString('utf-8'));
            var _errors = new Array();
            _errors.push(new errors.Errors("", "", error.error, error.error_description, "Error"))
            return _errors
        } else if (res.statusCode == 400) {
            var error = JSON.parse(res.body.toString('utf-8'));
            var _errors = new Array();
            if (error.message) {
                _errors.push(new errors.Errors("", "", "", error.message, "Error"))
                return _errors
            } else {
                var _errors = new Array();
                error.errors.forEach(function (key) {
                    _errors.push(new errors.Errors(key.status, key.code, key.location, key.reason, key.severity))
                });
                return _errors
            }
        }
    }

    this.putMetadata = function (data,url,token) {
        var data = JSON.stringify(data, replacer);
        var options = {
            headers: {
                'cache-control': 'no-cache',
                authorization: 'Bearer ' + token,
                accept: 'application/json',
                'content-type': 'application/json'
            },
            body: data
        };
        var res = request("PUT", url, options);
        if (res.statusCode == 200) {
            return JSON.parse(res.body.toString('utf-8'));
        } else if (res.statusCode == 401) {
            var error = JSON.parse(res.body.toString('utf-8'));
            var _errors = new Array();
            _errors.push(new errors.Errors("", "", error.error, error.error_description, "Error"))
            return _errors
        } else if (res.statusCode == 400) {
            var error = JSON.parse(res.body.toString('utf-8'));
            var _errors = new Array();
            if (error.message) {
                _errors.push(new errors.Errors("", "", "", error.message, "Error"))
                return _errors
            } else {
                var _errors = new Array();
                error.errors.forEach(function (key) {
                    _errors.push(new errors.Errors(key.status, key.code, key.location, key.reason, key.severity))
                });
                return _errors
            }
        }
    }

    this.postUsrRoles = function (data,url,token) {
        var data = JSON.stringify(data, replacer);
        var options = {
            headers: {
                'cache-control': 'no-cache',
                authorization: 'Bearer ' + token,
                accept: 'application/json',
                'content-type': 'application/json'
            },
            body: data
        };
        var res = request("POST", url, options);
        if (res.statusCode == 201) {
            return true;
        } else if (res.statusCode == 401) {
            var error = JSON.parse(res.body.toString('utf-8'));
            var _errors = new Array();
            _errors.push(new errors.Errors("", "", error.error, error.error_description, "Error"))
            return _errors
        } else if (res.statusCode == 400) {
            var error = JSON.parse(res.body.toString('utf-8'));
            var _errors = new Array();
            if (error.message) {
                _errors.push(new errors.Errors("", "", "", error.message, "Error"))
                return _errors
            } else {
                var _errors = new Array();
                error.errors.forEach(function (key) {
                    _errors.push(new errors.Errors(key.status, key.code, key.location, key.reason, key.severity))
                });
                return _errors
            }
        }
    }
}

