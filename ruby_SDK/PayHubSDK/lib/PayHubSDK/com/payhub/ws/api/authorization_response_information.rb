class AuthorizationResponseInformation
  include JsonSerializer
  ATTRS=[:authOnlyResponse,:_links,:errors,:metaData]
  attr_accessor *ATTRS
  attr_reader :billInformation,:cardDataInformation,:customerInformation,:merchantInformation
  attr_writer :transactionManager

  def initialize

  end

  def billInformation
    if (@billInformation==nil)
      b=BillInformation.new(@transactionManager)
      b.url =@transactionManager.url+"authonly/"
      b.getBillForSaleInformationByTransactionId(@authOnlyResponse.transactionId)
      @billInformation=b
    end
    return @billInformation
  end

  def cardDataInformation
    if (@cardDataInformation==nil)
      c=CardDataInformation.new(@transactionManager)
      c.getDataByTransaction(TransactionType::AuthOnly,@authOnlyResponse.transactionId)
      @cardDataInformation=c
    end
    return @cardDataInformation
  end

  def customerInformation
    if (@customerInformation==nil)
      customer=CustomerInformation.new(@transactionManager)
      customer.url =@transactionManager.url+"authonly/"
      customer.getCustomerForSaleInformationByTransactionId(@authOnlyResponse.transactionId)
      @customerInformation=customer
    end
    return @customerInformation
  end
  def merchantInformation
    if (@merchantInformation==nil)
      merchant=MerchantInformation.new(@transactionManager)
      merchant.getDataByTransaction(TransactionType::AuthOnly,@authOnlyResponse.transactionId)
      @merchantInformation=merchant
    end
    return @merchantInformation
  end
end