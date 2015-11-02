class RecurringBillResponse
  include JsonSerializer
  ATTRS=[:recurringBillId,:customerReference,:billingReferences]
  attr_accessor *ATTRS
  def initialize

  end
end