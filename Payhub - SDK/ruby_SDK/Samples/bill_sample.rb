require 'PayHubSDK/com/payhub/ws/extra/include_classes'
wsURL="https://staging-api.payhub.com/api/v2/"
oauth_token = "107d74ab-4a18-4713-88ff-69bd05710086"

merchant = Merchant.new
merchant.organization_id=10127
merchant.terminal_id=215
transaction = TransactionManager.new(wsURL,oauth_token,merchant)

bill = BillInformation.new(transaction)
bill.getBillForRecurringBillInformationById("1196")
puts bill.inspect
