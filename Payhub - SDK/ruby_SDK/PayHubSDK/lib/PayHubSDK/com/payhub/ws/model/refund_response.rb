class RefundResponse
  include JsonSerializer
  ATTRS=[:saleTransactionId,:refundTransactionId,:token]
  attr_accessor *ATTRS
  def initialize

  end
end