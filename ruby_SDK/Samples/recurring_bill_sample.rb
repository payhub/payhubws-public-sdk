require 'PayHubSDK/com/payhub/ws/extra/include_classes'

=begin
wsURL="https://staging-api.payhub.com/api/v2/"
oauth_token = "107d74ab-4a18-4713-88ff-69bd05710086"
=end
wsURL="http://localhost:8251/payhubws/api/v2/"
oauth_token = "af28ce9b-7366-4dfa-b643-44e9897ebc2b"

merchant = Merchant.new
merchant.organization_id=10002
merchant.terminal_id=2

# bill data
bill= Bill.new
bill.base_amount=1.00

#Credit card data
card_data = CardData.new
card_data.card_number="4055011111111111"
card_data.card_expiry_date="202012"
card_data.billing_zip="99997-0003"
# Customer data
customer = Customer.new
customer.first_name="First"
customer.last_name="Contact"
customer.phone_number="844-217-1631"
customer.phone_type="W"

montly_s=MonthlySchedule.new("E",15)
start=Date.new(2015,9,29)
type="O"
endDate=Date.new(2016,8,29)
scheduleSandE=ScheduleStartAndEnd.new(start,type,endDate)
schedule = Schedule.new(scheduleSandE,montly_s)
schedule.schedule_type="M"
schedule.bill_generation_interval=1

transaction = TransactionManager.new(wsURL,oauth_token,merchant)
recurringBill = RecurringBill.new(merchant,customer,bill,card_data,schedule)
response = transaction.doRecurringBill(recurringBill)
if response.errors==nil
  puts response.inspect
else
  puts response.errors.inspect
end
resultList = transaction.getAllRecurringBillInformation()
puts resultList.at(0).inspect


