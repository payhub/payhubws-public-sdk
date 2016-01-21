class RefundResponse
  include JsonSerializer
  ATTRS=[:saleTransactionId,:refundTransactionId,:token,:approvalCode,:processedDateTime,:avsResultCode,:verificationResultCode,:batchId,:responseCode,:responseText,:cisNote,:riskStatusResponseText,:riskStatusRespondeCode,:refundDateTime,:billingReferences,:customerReference]
  attr_accessor *ATTRS
  def initialize

  end
end