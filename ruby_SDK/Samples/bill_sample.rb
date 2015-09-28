require 'PayHubSDK/com/payhub/ws/extra/include_classes'
wsURL="https://staging-api.payhub.com/api/v2/"
oauth_token = "bb96358e-2aa8-4c6c-8a2e-901b676e979d"

merchant = Merchant.new
merchant.organization_id=10127
merchant.terminal_id=215
transaction = TransactionManager.new(wsURL,oauth_token,merchant)

bill = BillInformation.new(transaction)
bill.getBillForRecurringBillInformationById("1196")
puts bill.inspect
