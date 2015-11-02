class SaleResponseInformation
  include JsonSerializer
  ATTRS = [:saleResponse,:_links,:errors,:metaData]
  attr_accessor *ATTRS
  attr_reader :billInformation,:cardDataInformation,:customerInformation,:merchantInformation
  attr_writer :transactionManager

  def initialize

  end

  def billInformation
    if (@billInformation==nil)
      b=BillInformation.new(@transactionManager)
      b.url =@transactionManager.url+"sale/"
      b.getBillForSaleInformationByTransactionId(@saleResponse.saleId)
      @billInformation=b
    end
    return @billInformation
  end

  def cardDataInformation
    if (@cardDataInformation==nil)
      c=CardDataInformation.new(@transactionManager)
      c.getDataByTransaction(TransactionType::Sale,@saleResponse.saleId)
      @cardDataInformation=c
    end
    return @cardDataInformation
  end

  def customerInformation
    if (@customerInformation==nil)
      customer=CustomerInformation.new(@transactionManager)
      customer.url =@transactionManager.url+"sale/"
      customer.getCustomerForSaleInformationByTransactionId(@saleResponse.saleId)
      @customerInformation=customer
    end
    return @customerInformation
  end
  def merchantInformation
    if (@merchantInformation==nil)
      merchant=MerchantInformation.new(@transactionManager)
      merchant.getDataByTransaction(TransactionType::Sale,@saleResponse.saleId)
      @merchantInformation=merchant
    end
    return @merchantInformation
  end
end