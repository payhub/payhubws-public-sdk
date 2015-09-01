class ScheduleInformation< AbstractInfo
  include JsonSerializer
  attr_accessor :schedule
  # @param [Object] transactionManager
  def initialize(transactionManager=nil)
    @transactionManager=transactionManager
    @transactionType=TransactionType::Schedule
  end

  def convertData(json)
    @schedule = Schedule.from_json(json)
  end

  def getUrlForTransactionType(type)
    url=nil
    if(TransactionType::Sale==(type))
      url =  "sale/"
    end
    if(TransactionType::AuthOnly==(type))
      url =  "authonly/"
    end
    if(TransactionType::Capture==(type))
      url =  "capture/"
    end
    if(TransactionType::Bill==(type))
      url =  "bill"
    end
    if(TransactionType::CardData==(type))
      url =  "carddata/"
    end
    if(TransactionType::Customer==(type))
      url =  "customer/"
    end
    if(TransactionType::Merchant==(type))
      url =  "merchant/"
    end
    if(TransactionType::RecurringBill==(type))
      url =  "recurring-bill/"
    end
    if(TransactionType::Schedule==(type))
      url =  "schedule/"
    end
    if(TransactionType::Refund==(type))
      url =  "refund/"
    end
    if(TransactionType::VoidTransaction==(type))
      url =  "void/"
    end
    if(TransactionType::Verify==(type))
      url =  "verify/"
    end
    return url
  end

end