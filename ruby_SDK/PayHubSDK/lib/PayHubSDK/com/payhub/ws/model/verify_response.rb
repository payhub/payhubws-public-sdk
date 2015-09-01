class VerifyResponse
  include JsonSerializer
  ATTRS=[:verifyId,:approvalCode,:processedDateTime,:avsResultCode,:verificationResultCode,:responseCode,:responseText,:cisNote,:riskStatusResponseText,:riskStatusRespondeCode,:saleDateTime,:tokenizedCard,:customerReference]
  attr_accessor *ATTRS
  def initialize

  end
end