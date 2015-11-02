class RecurringBill  < WsConnections
  include JsonSerializer
  ATTRS=[:bill, :customer, :merchant, :schedule, :card_data]
  attr_accessor :url_basePath,*ATTRS
  @url=""
  RECURRENT_BILL_ID_LINK= "recurring-bill/"

  def initialize(merchant, customer, bill, card_data, schedule)
    Util::validate_params(self.class.name, merchant, customer, bill, card_data, schedule)
    @merchant=merchant
    @customer=customer
    @bill=bill
    @card_data=card_data
    @schedule=schedule
  end

  def url=(str)
    @url_basePath = str
  end

  def url
    return @url_basePath+RECURRENT_BILL_ID_LINK
  end

  def performRecurringBill(http,request)
    json = self.serialize_to_json
    request.body = json
    response = JSON.parse(doPost(http,request))
    result=RecurringBillResponseInformation.new
    if not response.include?('errors')
      result=RecurringBillResponseInformation.from_json(JSON.generate(response))
    else
      errors ||= Array.new
      response['errors'].each do |error|
        errors_aux=Errors.from_json(JSON.generate(error))
        errors.push(errors_aux)
      end
      result.errors=errors
    end
    return result
  end
end