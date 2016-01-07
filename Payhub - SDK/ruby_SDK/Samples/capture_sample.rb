require 'PayHubSDK/com/payhub/ws/extra/include_classes'

wsURL="https://staging-api.payhub.com/api/v2/"
oauth_token = "107d74ab-4a18-4713-88ff-69bd05710086"

merchant = Merchant.new
merchant.organization_id=10127
merchant.terminal_id=215
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

