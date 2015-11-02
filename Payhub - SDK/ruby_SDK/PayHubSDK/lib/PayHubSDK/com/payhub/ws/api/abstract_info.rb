class AbstractInfo
  include JsonSerializer
  ATTRS=[:version,:createdAt,:lastModified,:createdBy,:lastModifiedBy,:metaData]
  attr_accessor :url,:transactionManager,:errors,*ATTRS

  def getDataByID(id)
    url = @transactionManager.url+getUrlForTransactionType(@transactionType)+id.to_s
    request = @transactionManager.setHeadersGet(url, @transactionManager.token)
    json=@transactionManager.doGet(request)
    return nil if json==nil or json==""
    convertData(json_encode(json))
    convertAbstractData(json_encode(json))
  end

  def getDataByTransaction(type,transactionId)
    url=nil
    if TransactionType::CardData==@transactionType
    url = @transactionManager.url+getUrlForTransactionType(type)+transactionId.to_s+"/card_data"
    else
        url = @transactionManager.url+getUrlForTransactionType(type)+transactionId.to_s+"/"+getUrlForTransactionType(@transactionType)
    end
    #request = @transactionManager.setHeadersGet(url, @transactionManager.token)
    json=@transactionManager.doGet(url, @transactionManager.token)
    return nil if json==nil or json==""
    result=JSON.parse(json)
    errors ||= Array.new
    if result.include?('errors')
      result['errors'].each do |error|
        response_tmp = Errors.from_json(JSON.generate(error))
        errors.push(response_tmp)
      end
      @errors=errors
      return @errors
    end
    convertData(json)
    convertAbstractData(json)
    end
  def convertAbstractData(json)
    obj = JSON.parse(json)
    @version=obj['version']
    @createdAt=obj['createdAt']
    @lastModified=obj['lastModified']
    @createdBy=obj['createdBy']
    @lastModifiedBy=obj['lastModifiedBy']
    @metaData=obj['metaData']
  end

end