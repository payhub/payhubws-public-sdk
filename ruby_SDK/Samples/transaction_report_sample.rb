require 'PayHubSDK/com/payhub/ws/extra/include_classes'

wsURL="https://staging-api.payhub.com/api/v2/"
oauth_token = "107d74ab-4a18-4713-88ff-69bd05710086"

merchant = Merchant.new
merchant.organization_id=10127
merchant.terminal_id=215

tsp = TransactionSearchParameters.new
tsp.amountFrom = "1";
tsp.amountTo = "1002";
tsp.cardLast4Digits = "4507";
tsp.batchIdFrom = "1300";
tsp.batchIdTo = "1320";
tsp.email = "marrighi";
tsp.transactionType = "Sale";
tsp.responseCode = "00";
tsp.firstName = "First";
tsp.lastName = "Cont";
tsp.phoneNumber = "(415) 479 1349";
tsp.trnDateFrom = "2015-04-01 00:00:00";
tsp.trnDateTo = "2015-04-30 00:00:00";
tsp.cardType = "MasterCard";
tsp.cardToken = "9999000000001853";
tsp.swiped = "true";
tsp.source = "3rd Party API";
transaction = TransactionManager.new(wsURL,oauth_token,merchant)

result = transaction.findTransactions(tsp)
puts result.at(0).inspect

