class Verify < WsConnections
  include JsonSerializer
  ATTRS=[:customer, :merchant, :card_data]
  attr_accessor :url_basePath,*ATTRS
  @url=""
  VERIFY_ID_LINK = "verify/"
  def initialize(merchant, customer, card_data)
    Util::validate_params(self.class.name,merchant, customer,card_data)
    @merchant=merchant
    @customer=customer
    @card_data=card_data
  end

  def url=(str)
    @url_basePath = str
  end

  def url
    return @url_basePath+VERIFY_ID_LINK
  end

  def performVerifyTransaction(http,request)
    json = self.serialize_to_json
    puts json
    request.body = json
    response = JSON.parse(doPost(http,request))
    result=VerfyResponseInformation.new
    if not response.include?('errors')
      result=VerfyResponseInformation.from_json(JSON.generate(response))
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