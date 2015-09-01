class VoidTransaction < WsConnections
  include JsonSerializer
  ATTRS=[:transaction_id, :merchant]
  attr_accessor :url_basePath,*ATTRS
  @url=""
  VOID_ID_LINK = "void/"

  def initialize (merchant, transaction_id)
    Util::validate_params(self.class.name, merchant, transaction_id)
    @merchant=merchant
    @transaction_id=transaction_id
  end

  def url=(str)
    @url_basePath = str
  end

  def url
    return @url_basePath+VOID_ID_LINK
  end

  def performVoidTransaction(http,request)
    json = self.serialize_to_json
    request.body = json
    response = JSON.parse(doPost(http,request))
    result=VoidResponseInformation.new
    if not response.include?('errors')
      result=VoidResponseInformation.from_json(JSON.generate(response))
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