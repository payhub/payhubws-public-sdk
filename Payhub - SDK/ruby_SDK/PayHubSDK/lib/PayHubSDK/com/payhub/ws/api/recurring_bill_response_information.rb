class RecurringBillResponseInformation
  include JsonSerializer
  ATTRS=[:lastRecurringBillResponse,:_links,:errors,:metaData]
  attr_accessor *ATTRS

  attr_reader :billInformation,:cardDataInformation,:customerInformation,:merchantInformation,:scheduleInformation,:statusInformation
  attr_writer :transactionManager

  def initialize

  end

  def billInformation
    if (@billInformation==nil)
      b=BillInformation.new(@transactionManager)
      b.url =@transactionManager.url+"recurring-bill/"
      b.getBillForSaleInformationByTransactionId(@lastRecurringBillResponse.recurringBillId)
      @billInformation=b
    end
    return @billInformation
  end

  def cardDataInformation
    if (@cardDataInformation==nil)
      c=CardDataInformation.new(@transactionManager)
      c.getDataByTransaction(TransactionType::RecurringBill,@lastRecurringBillResponse.recurringBillId)
      @cardDataInformation=c
    end
    return @cardDataInformation
  end

  def customerInformation
    if (@customerInformation==nil)
      customer=CustomerInformation.new(@transactionManager)
      customer.url =@transactionManager.url+"recurring-bill/"
      customer.getCustomerForSaleInformationByTransactionId(@lastRecurringBillResponse.recurringBillId)
      @customerInformation=customer
    end
    return @customerInformation
  end
  def merchantInformation
    if (@merchantInformation==nil)
      merchant=MerchantInformation.new(@transactionManager)
      merchant.getDataByTransaction(TransactionType::RecurringBill  ,@lastRecurringBillResponse.recurringBillId)
      @merchantInformation=merchant
    end
    return @merchantInformation
  end
  def scheduleInformation
    if (@scheduleInformation==nil)
      schedule=ScheduleInformation.new(@transactionManager)
      schedule.getDataByTransaction(TransactionType::RecurringBill  ,@lastRecurringBillResponse.recurringBillId)
      @scheduleInformation=schedule
    end
    return @scheduleInformation
  end

  def statusInformation
    if (@statusInformation==nil)
      status=StatusInformation.new(@transactionManager)
      status.getDataByTransaction(TransactionType::RecurringBill  ,@lastRecurringBillResponse.recurringBillId)
      @statusInformation=status
    end
    return @statusInformation
  end

end