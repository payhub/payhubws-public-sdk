class VerfyResponseInformation
  include JsonSerializer
  ATTRS=[:verifyResponse,:_links,:errors,:metaData]
  attr_accessor *ATTRS
  attr_reader :cardDataInformation,:customerInformation,:merchantInformation
  attr_writer :transactionManager

  def initialize

  end
  def cardDataInformation
    if (@cardDataInformation==nil)
      c=CardDataInformation.new(@transactionManager)
      c.getDataByTransaction(TransactionType::Verify,@verifyResponse.verifyId)
      @cardDataInformation=c
    end
    return @cardDataInformation
  end

  def customerInformation
    if (@customerInformation==nil)
      customer=CustomerInformation.new(@transactionManager)
      customer.url =@transactionManager.url+"verify/"
      customer.getCustomerForSaleInformationByTransactionId(@verifyResponse.verifyId)
      @customerInformation=customer
    end
    return @customerInformation
  end
  def merchantInformation
    if (@merchantInformation==nil)
      merchant=MerchantInformation.new(@transactionManager)
      merchant.getDataByTransaction(TransactionType::Verify,@verifyResponse.verifyId)
      @merchantInformation=merchant
    end
    return @merchantInformation
  end

end