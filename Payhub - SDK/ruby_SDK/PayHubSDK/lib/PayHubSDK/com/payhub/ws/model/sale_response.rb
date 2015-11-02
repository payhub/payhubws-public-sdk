class SaleResponse
  include JsonSerializer
  ATTRS=[:saleId,:approvalCode,:processedDateTime,:avsResultCode,:verificationResultCode,:batchId,:responseCode,:responseText,:cisNote,:riskStatusResponseText,:riskStatusRespondeCode,:saleDateTime,:tokenizedCard,:billingReferences,:customerReference]
  attr_accessor *ATTRS
  def initialize

  end
end