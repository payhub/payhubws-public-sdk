class BillInformation
  include JsonSerializer
  ATTRS=[:version,:createdAt,:lastModified,:createdBy,:lastModifiedBy,:metaData]
  attr_accessor :url,:transactionManager,:bill,:errors,*ATTRS

  # @param [Object] transactionManager
  def initialize(transactionManager=nil)
    @transactionManager=transactionManager
    @transactionType=TransactionType::Bill
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

  def convertDataToBill(json)
      @bill = Bill.from_json(json)
  end
  private :convertData, :convertDataToBill
  # @param [Object] sale id
  def getBillForSaleInformationByTransactionId(saleId)
    url = @transactionManager.url+Sale::SALE_ID_LINK+saleId.to_s+"/bill"
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

  # @param [Object] bill id
  def getBillForSaleInformationById(id)
    url = @transactionManager.url+"bill-for-sale/"+id.to_s
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
  # @param [Object] recurring bill id
  def getBillForRecurringBillInformationByTransactionId(id)
    url = @transactionManager.url+RecurringBill::RECURRENT_BILL_ID_LINK+id.to_s+"/bill"
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
  # @param [Object] bill id
  def getBillForRecurringBillInformationById(id)
    url = @transactionManager.url+"bill-for-recurring-bill/"+id.to_s
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