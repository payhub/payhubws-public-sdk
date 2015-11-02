require 'PayHubSDK/com/payhub/ws/extra/include_classes'

# The current url, oauth_token, orgId and Terminal Id provided in this example, are only for testing purposes
# For development purposes you need to contact the Payhub Integration Support team. They will provide you with all you need.
# Thanks.

wsURL="https://sandbox-api.payhub.com/api/v2/"
oauth_token = "2a5d6a73-d294-4fba-bfba-957a4948d4a3"

merchant = Merchant.new
merchant.organization_id=10074
merchant.terminal_id=134

merchant = Merchant.new
merchant.organization_id=10127
merchant.terminal_id=215
transaction = TransactionManager.new(wsURL,oauth_token,merchant)

bill = BillInformation.new(transaction)
bill.getBillForRecurringBillInformationById("1196")
puts bill.inspect
