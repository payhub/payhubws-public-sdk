class RecurringBill  < WsConnections
  include JsonSerializer
  ATTRS=[:bill, :customer, :merchant, :schedule, :card_data]
  attr_accessor :url_basePath,*ATTRS
  @url=""
  RECURRENT_BILL_ID_LINK= "recurring-bill/"

  # def initialize(merchant, customer, bill, card_data, schedule)
  #   Util::validate_params(self.class.name, merchant, customer, bill, card_data, schedule)
  #   @merchant=merchant
  #   @customer=customer
  #   @bill=bill
  #   @card_data=card_data
  #   @schedule=schedule
  # end

  def initialize(*args)
      args.each do |argument|
        if argument.instance_of?(Merchant)
          @merchant=argument
        elsif argument.instance_of?(Customer)
          @customer=argument
        elsif argument.instance_of?(Bill)
          @bill=argument
        elsif argument.instance_of?(CardData)
          @card_data=argument
        elsif argument.instance_of?(Schedule)
          @schedule=argument
        end
      end
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
    result=RecurringBillResponseInformation.from_json(JSON.generate(response))
    return result
  end
end