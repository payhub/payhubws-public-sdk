require 'PayHubSDK/com/payhub/ws/extra/include_classes'

wsURL="https://staging-api.payhub.com/api/v2/"
oauth_token = "107d74ab-4a18-4713-88ff-69bd05710086"

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
	puts response.inspect
else
	puts response.errors.inspect
end

