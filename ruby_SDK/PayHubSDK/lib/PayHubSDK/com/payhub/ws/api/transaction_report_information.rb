class TransactionReportInformation
  include JsonSerializer
  ATTRS=[:transactionID,:batchID,:transactionDate,:customerName,:cardType,:cardLast4Digits,:cardToken,:responseCode,:responseText,:transactionType,:amount,:authAmount,:swiped,:source,:phoneNumber,:email,:note,:transactionStatus,:errors]
  attr_accessor *ATTRS
  def initialize

  end
end