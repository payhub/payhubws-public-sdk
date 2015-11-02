class CaptureResponse
  include JsonSerializer
  ATTRS=[:batchId,:transactionId,:billingReferences]
  attr_accessor *ATTRS
  def initialize

  end
end