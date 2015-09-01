class CaptureResponseInformation
  include JsonSerializer
  ATTRS=[:lastCaptureResponse,:_links,:errors,:metaData]
  attr_accessor *ATTRS
  attr_reader :billInformation,:merchantInformation
  attr_writer :transactionManager

  def initialize

  end

  def billInformation
    if (@billInformation==nil)
      b=BillInformation.new(@transactionManager)
      b.url =@transactionManager.url+"capture/"
      b.getBillForSaleInformationByTransactionId(@lastCaptureResponse.transactionId)
      @billInformation=b
    end
    return @billInformation
  end

  def merchantInformation
    if (@merchantInformation==nil)
      merchant=MerchantInformation.new(@transactionManager)
      merchant.getDataByTransaction(TransactionType::Capture,@lastCaptureResponse.transactionId)
      @merchantInformation=merchant
    end
    return @merchantInformation
  end

end