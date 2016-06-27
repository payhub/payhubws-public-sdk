# payhub_sdk
=========

Welcome! In this directory, you'll find the files you need to be able to package up our NodeJs module into your server. 
<br><br>
[Download the Master Repo] (https://github.com/payhub/payhubws-public-sdk/archive/master.zip)

## Installation

  npm install payhub_sdk --save 
  or
  npm install git://github.com/payhubbuilder/payhub-nodejs-sdk.git

## Usage

```javascript
var models = require('../lib/model/apiModels');

var trnManager = require('../lib/utils/transactionManager');

var errors = require('../lib/model/errors');

var WsURL="https://sandbox-api.payhub.com/api/v2/";
var oauth_token = "2a5d6a73-d294-4fba-bfba-957a4948d4a3";


var merchant = new models.Merchant();
merchant.organization_id=10074
merchant.terminal_id=134

var bill = new models.Bill();
bill.base_amount=new models.Amount(1)

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

var sale = new models.Sale(merchant,bill,card_data,customer)

var transactionManager = new trnManager.TransactionManager(merchant,WsURL,oauth_token);
var saleResponse = transactionManager.doSale(sale);
console.log(saleResponse)

```

## Tests

  npm test

## Contributing

Bug reports and pull requests are welcome on GitHub at https://github.com/[USERNAME]/PayHubSDK. This project is intended to be a safe, welcoming space for collaboration, and contributors are expected to adhere to the [Contributor Covenant](contributor-covenant.org) code of conduct.

## Release History

* 1.0.0 Initial release