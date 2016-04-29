require 'PayHubSDK/com/payhub/ws/extra/include_classes'

wsURL="https://staging-api.payhub.com/api/v2/"
oauth_token = "107d74ab-4a18-4713-88ff-69bd05710086"

merchant = Merchant.new
merchant.organization_id=10127
merchant.terminal_id=215


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

montly_s=MonthlySchedule.new("E")
start=Date.new(2016,8,29)
montly_s.monthly_each_days=Array.new
montly_s.monthly_each_days.push(15)
type="O"
endDate=Date.new(2017,8,29)
scheduleSandE=ScheduleStartAndEnd.new(start,type,endDate)
schedule = Schedule.new("M")
schedule.bill_generation_interval=1
schedule.monthly_schedule=montly_s
schedule.schedule_start_and_end=scheduleSandE



transaction = TransactionManager.new(wsURL,oauth_token,merchant)
recurringBill = RecurringBill.new(merchant,customer,bill,card_data,schedule)
response = transaction.doRecurringBill(recurringBill)
if response.errors==nil
  id=response.lastRecurringBillResponse.recurringBillId
  bill.base_amount=2.00
  recForUpdate=RecurringBill.new()
  recForUpdate.bill=bill
  canUpdate = transaction.updateRecurringBill(id,recForUpdate)
  #if can update is an array, then there is an error, if not, the update was successful
  if canUpdate.is_a?(Array)
    puts canUpdate.inspect
  end
end