class VoidResponse
  include JsonSerializer
  ATTRS = [:saleTransactionId,:voidTransactionId,:token]
  attr_accessor *ATTRS
  def initialize

  end
end