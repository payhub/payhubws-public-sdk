require 'PayHubSDK/com/payhub/ws/extra/include_classes'

wsURL="https://staging-api.payhub.com/api/v2/"
oauth_token = "bb96358e-2aa8-4c6c-8a2e-901b676e979d"

merchant = Merchant.new
merchant.organization_id=10127
merchant.terminal_id=215


# bill data
bill= Bill.new
bill.base_amount=1.00
bill.shipping_amount=1.00
bill.tax_amount=1.00
bill.note="this a sample note"
bill.invoice_number="this is an invoice"
bill.po_number="a test po number"
#Credit card data
card_data = CardData.new
card_data.card_number="4055011111111111"
card_data.card_expiry_date="202012"
card_data.cvv_data="999"
card_data.billing_address_1="2350 Kerner Blvd"
card_data.billing_address_2="On the corner"
card_data.billing_city="San Rafael"
card_data.billing_state="CA"
card_data.billing_zip="99997-0003"
# Customer data
customer = Customer.new
customer.first_name="First"
customer.last_name="Contact"
customer.company_name="Payhub Inc"
customer.job_title="Software Engineer"
customer.email_address="jhon@company.com"
customer.web_address="http://payhub.com"
customer.phone_number="(415) 479 1349"
customer.phone_ext="123"
customer.phone_type="M"

object = Sale.new(merchant,customer,bill,card_data)

transaction = TransactionManager.new(wsURL,oauth_token,merchant)
response = transaction.doSale(object)
if response.errors==nil
	#'{someSaleId}' is the Id for the sale that is going to be refunded, each refund transaction will be valid only if the batch has been settled
	transaction_id=response.saleResponse.saleId
	#'{someRecordFormat}' like CREDIT_CARD
	record_format="CREDIT_CARD"
	# bill data
	billDiff= Bill.new
	billDiff.base_amount=3.00
	billDiff.shipping_amount=3.00
	billDiff.tax_amount=2.00
	billDiff.note="this a sample note"
	billDiff.invoice_number="this is an invoice"
	billDiff.po_number="a test po number"

	responseRefund = transaction.doRefund(Refund.new(transaction_id,billDiff,nil,nil,merchant,record_format))
	if responseRefund.errors==nil
		puts responseRefund.inspect
	else
		puts responseRefund.errors.inspect
	end
else
	puts response.errors.inspect
end
