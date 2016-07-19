class BatchResponseInformation
  include JsonSerializer
  ATTRS=[:transactions_detail,:batch_status,:batch_settled_on,:batch_info,:errors]
  attr_accessor *ATTRS

  def initialize

  end

end

class Transactions_detail
    include JsonSerializer
    ATTRS=[:transactionID,:batchID,:transactionDate,:customerName,:cardType,:cardLast4Digits,:cardToken,:responseCode,:responseText,:transactionType,:amount,:authAmount,:swiped,:source,:phoneNumber,:email,:note,:transactionStatus,:errors,:voidedBy,:refundedBy,:isCaptured,:recurringBillId,:settlementStatus]
    attr_accessor *ATTRS
    def initialize

    end
end

class Batch_info
  include JsonSerializer
  ATTRS=[:credit_cards,:all_transactions]
  attr_accessor *ATTRS
  def initialize

  end
end


class Credit_cards
  include JsonSerializer
  ATTRS=[:transactions_no,:transactions_total_net,:sales_total,:refunds_total,:card_type]
  attr_accessor *ATTRS
  def initialize

  end
end


class All_transactions
  include JsonSerializer
  ATTRS=[:transactions_no,:transactions_total_net,:sales_total,:refunds_total]
  attr_accessor *ATTRS
  def initialize

  end
end

class TransactionTotals
  include JsonSerializer
  ATTRS=[:credit_cards,:all_transactions,:errors]
  attr_accessor *ATTRS
  def initialize

  end
end