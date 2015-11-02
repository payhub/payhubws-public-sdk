class BillingReferences
  include JsonSerializer
  ATTRS=[:cardObscured,:tokenizedCard,:customerId,:customerCardId,:customerBillId]
  attr_accessor *ATTRS
  def initialize()
  end
end