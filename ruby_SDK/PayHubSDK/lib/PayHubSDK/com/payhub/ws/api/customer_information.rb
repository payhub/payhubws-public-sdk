class CustomerInformation
  include JsonSerializer
  ATTRS=[:version,:createdAt,:lastModified,:createdBy,:lastModifiedBy,:metaData]
  attr_accessor :url,:transactionManager,:customer,:errors,*ATTRS
  # @param [Object] transactionManager
  def initialize(transactionManager=nil)
    @transactionManager=transactionManager
    @transactionType=TransactionType::Customer
  end

  def convertData(json)
    obj = JSON.parse(json)
    @version=obj['version']
    @createdAt=obj['createdAt']
    @lastModified=obj['lastModified']
    @createdBy=obj['createdBy']
    @lastModifiedBy=obj['lastModifiedBy']
    @metaData=obj['metaData']

  end

  def convertDataToCustomer(json)
    @customer = Customer.from_json(json)
  end
  private :convertData, :convertDataToCustomer

  def getCustomerForSaleInformationByTransactionId(saleId)
    url = @transactionManager.url+Sale::SALE_ID_LINK+saleId.to_s+"/customer"
    response = @transactionManager.doGet(url, @transactionManager.token)
    return nil if response==nil or response==""
    result=JSON.parse(response)
    errors ||= Array.new
    if result.include?('errors')
      result['errors'].each do |error|
        response_tmp = Errors.from_json(JSON.generate(error))
        errors.push(response_tmp)
      end
      @errors=errors
      return @errors
    end
    convertData(response)
    convertDataToCustomer(response)
  end

  def getCustomerForSaleInformationById(id)
    url = @transactionManager.url+"customer-for-sale/"+id.to_s
    response = @transactionManager.doGet(url, @transactionManager.token)
    return nil if response==nil or response==""
    result=JSON.parse(response)
    errors ||= Array.new
    if result.include?('errors')
      result['errors'].each do |error|
        response_tmp = Errors.from_json(JSON.generate(error))
        errors.push(response_tmp)
      end
      @errors=errors
      return @errors
    end
    convertData(response)
    convertDataToBill(response)
  end

  def getCustomerForRecurringCustomerInformationByTransactionId(id)
    url = @transactionManager.url+RecurringBill::RECURRENT_BILL_ID_LINK+id.to_s+"/customer"
    response = @transactionManager.doGet(url, @transactionManager.token)
    return nil if response==nil or response==""
    result=JSON.parse(response)
    errors ||= Array.new
    if result.include?('errors')
      result['errors'].each do |error|
        response_tmp = Errors.from_json(JSON.generate(error))
        errors.push(response_tmp)
      end
      @errors=errors
      return @errors
    end
    convertData(response)
    convertDataToBill(response)
  end

  def getCustomerForRecurringCustomerInformationById(id)
    url = @transactionManager.url+"customer/"+id.to_s
    response = @transactionManager.doGet(url, @transactionManager.token)
    return nil if response==nil or response==""
    result=JSON.parse(response)
    errors ||= Array.new
    if result.include?('errors')
      result['errors'].each do |error|
        response_tmp = Errors.from_json(JSON.generate(error))
        errors.push(response_tmp)
      end
      @errors=errors
      return @errors
    end
    convertData(response)
    convertDataToBill(response)
  end

end