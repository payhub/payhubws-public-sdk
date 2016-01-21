class RefundInformation
  include JsonSerializer
  ATTRS=[:transaction_id,:lastRefundResponse,:_links,:errors,:metaData,:merchantOrganizationId,:settlementStatus]
  attr_accessor *ATTRS

  attr_reader :merchantInformation

  attr_writer :transactionManager

  def initialize

  end

  def merchantInformation
    if (@merchantInformation==nil)
      merchant=MerchantInformation.new(@transactionManager)
      merchant.getDataByTransaction(TransactionType::Refund,@lastRefundResponse.refundTransactionId)
      @merchantInformation=merchant
    end
    return @merchantInformation
  end

end