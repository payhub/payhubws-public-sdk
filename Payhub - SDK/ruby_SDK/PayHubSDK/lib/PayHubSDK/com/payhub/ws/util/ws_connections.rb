require 'uri'
require 'net/http'
require 'openssl'
require 'json'

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
    return http,request
  end
  def doPost(http,request)
    response = http.request(request)
    case response.code.to_i
      when 200..399
        result = doGet(response['location'],@token)
        return result;
      else
        return generateErrorResponse(response)
    end
  end

  def doGet(url,token)
    http,request=setHeadersGet(url,token)
    response = http.request(request)
    case response.code.to_i
      when 200..399
        return response.read_body
      else
        return generateErrorResponse(response)
    end
  end

# @param [Object] http
# @param [Object] request
  def doPut(http,request)
    response = http.request(request)
    case response.code.to_i
      when 200..399
        return response
      else
        return generateErrorResponse(response)
    end
  end

  def doPatch(http,request)
    response = http.request(request)
    case response.code.to_i
      when 200..399
        return true
      else
        return generateErrorResponse(response)
    end
  end
  def doPostForRoles(http,request)
    response = http.request(request)
    case response.code.to_i
      when 200..399
        return response
      else
        return generateErrorResponse(response)
    end
  end
  # @param [Object] http
  # @param [Object] request
  # @param [Object] parameters
  def findTransactionReports(http, request, parameters)
    json = parameters.serialize_to_json #tojson
    request.body=json
    response = http.request(request)
    case response.code.to_i
      when 200..399
        return response.read_body
      else
        return generateErrorResponse(response)
    end
  end


  def generateErrorResponse(response)
    response2 = JSON.parse(response.read_body)
    if response2.include?('errors')
      return response.read_body
    elsif response2.to_s.empty?
      errors ||= Array.new
      error=Errors.new
      error.status="BAD_REQUEST"
      error.code="9995"
      error.severity="ERROR"
      error.location="404 no results"
      error.reason="No results for query"

      error = {"status"=>error.status,"code"=>error.code,"severity"=>error.severity,"location"=>error.location,"reason"=>error.reason}
      errors.push(error)
      informationToSend = {"errors"=>errors}
      result  = JSON.generate(informationToSend)
      return result.gsub('\\','').gsub('"{','{').gsub('}"','}')
    else
      errors ||= Array.new
      error=Errors.new
      error.status="BAD_REQUEST"
      error.code="9995"
      error.severity="ERROR"
      if response2.include?('cause') or response2.include?('message')
        error.location=response2['cause']
        error.reason=response2['message']
      end

      if response2.include?('error') or  response2.include?('error_description')
        error.location=response2['error']
        error.reason=response2['error_description']
      end
      error = {"status"=>error.status,"code"=>error.code,"severity"=>error.severity,"location"=>error.location,"reason"=>error.reason}
      errors.push(error)
      informationToSend = {"errors"=>errors}
      result  = JSON.generate(informationToSend)
      return result.gsub('\\','').gsub('"{','{').gsub('}"','}')
    end
  end
  def doPatchForBatch(http,request)
    response = http.request(request)
    case response.code.to_i
      when 200..399
        return response.read_body
      else
        return generateErrorResponse(response)
    end
  end
end