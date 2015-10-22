require 'PayHubSDK/com/payhub/ws/extra/include_classes'

# The current url, oauth_token, orgId and Terminal Id provided in this example, are only for testing purposes
# For development purposes you need to contact the Payhub Integration Support team. They will provide you with all you need.
# Thanks.

wsURL="https://sandbox-api.payhub.com/api/v2/"
oauth_token = "2a5d6a73-d294-4fba-bfba-957a4948d4a3"

merchant = Merchant.new
merchant.organization_id=10074
merchant.terminal_id=134


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
  transaction = TransactionManager.new(wsURL,oauth_token,merchant)
  datos = "{\"order\": {\"id\": 465, \"invoice\":\"MyIncoice\", \"lines\": [{\"City\": \"Cordoba\"}, {\"Neighborhood\": \"Nueva Cordoba\"}]}}"
  result=transaction.addMetaData(datos, TransactionType::Sale, response.saleResponse.saleId)
  if result==true
    saleResponseMetadata = transaction.getSaleInformation(response.saleResponse.saleId)
    if saleResponseMetadata.errors==nil
      metadata = saleResponseMetadata.metaData
      puts metadata.inspect
    end
  end
else
  response.errors.inspect
end

