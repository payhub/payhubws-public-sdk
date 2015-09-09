require 'uri'
require 'net/http'
require 'openssl'

class WsConnections
  # this is a set
  attr_writer :token

  def initialize(token=nil)
    @token=token
  end

  def setHeadersPost(operationUrl, token)

    url = URI(operationUrl)
    @token=token
    http = Net::HTTP.new(url.host, url.port)
    http.use_ssl = true
    http.verify_mode = OpenSSL::SSL::VERIFY_NONE
    request = Net::HTTP::Post.new(url)
    request["content-type"] = 'application/json'
    request["accept"] = 'application/json'
    request["authorization"] = 'Bearer '+@token
    return http,request
  end

  def setHeadersGet(operationUrl, token)
    url = URI(operationUrl)
    @token=token
    http = Net::HTTP.new(url.host, url.port)
    http.use_ssl = true
    http.verify_mode = OpenSSL::SSL::VERIFY_NONE
    request = Net::HTTP::Get.new(url)
    request["content-type"] = 'application/json'
    request["accept"] = 'application/json'
    request["authorization"] = 'Bearer '+@token
    return http,request
  end
  def setHeadersPut(operationUrl, token)
    url = URI(operationUrl)
    @token=token
    http = Net::HTTP.new(url.host, url.port)
    http.use_ssl = true
    http.verify_mode = OpenSSL::SSL::VERIFY_NONE
    request = Net::HTTP::Put.new(url)
    request["content-type"] = 'application/json'
    request["accept"] = 'application/json'
    request["authorization"] = 'Bearer '+@token
    return http,request
  end
  def setHeadersPatch(operationUrl, token)
    url = URI(operationUrl)
    @token=token
    http = Net::HTTP.new(url.host, url.port)
    http.use_ssl = true
    http.verify_mode = OpenSSL::SSL::VERIFY_NONE
    request = Net::HTTP::Patch.new(url)
    request["content-type"] = 'application/json'
    request["accept"] = 'application/json'
    request["authorization"] = 'Bearer '+@token
    request.body = "{ \n\t\"recurring_bill_status\": \"CANCELED\"\n}"
    return http,request
  end
  def doPost(http,request)
    response = http.request(request)
    puts "post result: "+response.code
    case response.code.to_i
      when 200..399
        result = doGet(response['location'],@token)
        return result;
      else
        return response.read_body
    end
  end

  def doGet(url,token)
    http,request=setHeadersGet(url,token)
    response = http.request(request)
    puts "get result: "+response.code
    return response.read_body
  end

# @param [Object] http
# @param [Object] request
  def doPut(http,request)
    response = http.request(request)
    return response
  end

  # @param [Object] http
  # @param [Object] request
  # @param [Object] parameters
  def findTransactionReports(http, request, parameters)
    json = parameters.serialize_to_json #tojson
    request.body=json
    response = http.request(request)
    return response.read_body
  end
# @param [Object] http
# @param [Object] request
  def doPatch(http,request)
    response = http.request(request)
    case response.code.to_i
      when 200..399
        return true;
      else
        return false
    end
  end
end