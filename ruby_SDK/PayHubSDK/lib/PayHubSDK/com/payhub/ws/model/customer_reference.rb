class CustomerReference
  include JsonSerializer
  ATTRS=[:customerId,:customerEmail,:customerPhones]
  attr_accessor *ATTRS
  def initialize

  end
end