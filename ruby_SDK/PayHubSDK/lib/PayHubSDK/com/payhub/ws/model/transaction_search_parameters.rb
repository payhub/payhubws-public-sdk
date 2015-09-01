class TransactionSearchParameters
  include JsonSerializer
  ATTRS=[:batchIdFrom,:batchIdTo,:transactionType,:responseCode,:amountFrom,:amountTo,:firstName,:lastName,:trnDateFrom,:trnDateTo,:cardType,:cardLast4Digits,:cardToken,:authAmountFrom,:authAmountTo,:swiped,:source,:phoneNumber,:email,:note ,:transactionStatus]
  attr_accessor *ATTRS
  def initialize

  end
end