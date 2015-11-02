class AuthOnlyResponse
  include JsonSerializer
  ATTRS=[:transactionId,:approvalCode,:processedDateTime,:avsResultCode,:verificationResultCode,:batchId,:responseCode,:responseText,:cisNote,:riskStatusResponseText,:riskStatusRespondeCode,:dateTime,:tokenizedCard,:billingReferences,:customerReference]
  attr_accessor *ATTRS
  def initialize

  end
end