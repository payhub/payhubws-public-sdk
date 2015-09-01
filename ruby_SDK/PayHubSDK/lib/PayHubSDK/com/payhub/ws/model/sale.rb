
class Sale < WsConnections
  include JsonSerializer
  ATTRS = [:merchant,:card_data,:bill,:customer]
  attr_accessor :url_basePath,*ATTRS
  @url = nil
  SALE_ID_LINK = "sale/"

  def initialize(merchant,customer,bill,card_data)
    Util::validate_params(self.class.name, merchant,customer,bill,card_data)
    @merchant=merchant
    @customer=customer
    @bill=bill
    @card_data=card_data
  end

  def url=(str)
    @url_basePath = str
  end

  def url
    return @url_basePath+SALE_ID_LINK
  end

  def doSale(http,request)
    json=self.serialize_to_json
    request.body = json
    response = JSON.parse(doPost(http,request))
    result=SaleResponseInformation.new
    if not response.include?('errors')
    result=SaleResponseInformation.from_json(JSON.generate(response))
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