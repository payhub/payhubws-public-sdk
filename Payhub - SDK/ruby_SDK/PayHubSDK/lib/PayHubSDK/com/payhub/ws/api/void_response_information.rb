class VoidResponseInformation
  include JsonSerializer
  ATTRS = [:transaction_id,:lastVoidResponse,:merchantOrganizationId,:_links,:errors,:metaData]
  attr_accessor *ATTRS

  attr_reader :merchantInformation

  attr_writer :transactionManager

  def initialize

  end

  def merchantInformation
    if (@merchantInformation==nil)
      merchant=MerchantInformation.new(@transactionManager)
      merchant.getDataByTransaction(TransactionType::VoidTransaction,@lastVoidResponse.voidTransactionId)
      @merchantInformation=merchant
    end
    return @merchantInformation
  end
end