require 'PayHubSDK/com/payhub/ws/extra/include_classes'

# The current url, oauth_token, orgId and Terminal Id provided in this example, are only for testing purposes
# For development purposes you need to contact the Payhub Integration Support team. They will provide you with all you need.
# Thanks.

wsURL="https://sandbox-api.payhub.com/api/v2/"
oauth_token = "2a5d6a73-d294-4fba-bfba-957a4948d4a3"

merchant = Merchant.new
merchant.organization_id=10074
merchant.terminal_id=134


transactionId="181586"

# bill data
bill= Bill.new
bill.base_amount=1.00
bill.shipping_amount=1.00
bill.tax_amount=1.00
bill.note="this a sample note"
bill.invoice_number="this is an invoice"
bill.po_number="a test po number"

transaction = TransactionManager.new(wsURL,oauth_token,merchant)

bill = BillInformation.new(transaction)
bill.getBillForSaleInformationById("181586")
puts bill.errors.inspect
if bill.errors==nil
  capture = Capture.new(merchant,transactionId,bill.bill)
  response = transaction.doCapture(capture)
  puts response.inspect
end

