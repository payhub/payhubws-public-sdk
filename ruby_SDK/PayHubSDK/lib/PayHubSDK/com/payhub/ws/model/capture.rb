class Capture < WsConnections
  include JsonSerializer
  ATTRS=[:transaction_id, :bill, :merchant]
  attr_accessor :url_basePath,*ATTRS
  CAPTURE_ID_LINK = "capture/"
  @url=nil

  def initialize (merchant, transactionId, bill)
    Util::validate_params(self.class.name, merchant,bill)
    @merchant=merchant
    @transaction_id=transactionId
    @bill=bill
  end

  def url=(str)
    @url_basePath = str
  end

  def url
    return @url_basePath+CAPTURE_ID_LINK
  end

  def doCapture(http,request)
    json = self.serialize_to_json
    request.body = json
    response = JSON.parse(doPost(http,request))
    result=CaptureResponseInformation.new
    if not response.include?('errors')
      result=CaptureResponseInformation.from_json(JSON.generate(response))
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