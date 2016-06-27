/**
 * Created by Agustin Breit <agustin.breit@silice.biz> on 06/17/16.
 */
'use strict'


function Errors (status,code,location,reason,severity){
    this.status=status;
    this.code=code;
    this.location=location;
    this.reason=reason;
    this.severity=severity
}
Errors.prototype = {
    constructor: Errors,status:this.status,code:this.code,location:this.location,reason:this.reason,severity:this.severity
}
module.exports.Errors=Errors;
