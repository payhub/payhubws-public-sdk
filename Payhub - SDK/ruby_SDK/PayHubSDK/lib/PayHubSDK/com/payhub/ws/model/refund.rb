class Refund  < WsConnections
  include JsonSerializer
  ATTRS=[:transaction_id, :merchant, :record_format]
  attr_accessor :url_basePath,*ATTRS
  @url=""
  REFUND_ID_LINK = "refund/"
  def initialize(transaction_id, merchant, record_format)
    Util::validate_params(self.class.name,transaction_id, merchant, record_format)
    @transaction_id=transaction_id
    @merchant=merchant
    @record_format=record_format
  end

  def url=(str)
    @url_basePath = str
  end

  def url
    return @url_basePath+REFUND_ID_LINK
  end

  def performRefund(http,request)
    json = self.serialize_to_json
    request.body = json
    response = JSON.parse(doPost(http,request))
    result=RefundInformation.new
    if not response.include?('errors')
      result=RefundInformation.from_json(JSON.generate(response))
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