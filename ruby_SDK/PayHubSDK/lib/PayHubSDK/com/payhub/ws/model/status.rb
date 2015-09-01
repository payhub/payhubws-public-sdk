class Status
  include JsonSerializer
  ATTRS=[:id,:version,:createdAt,:lastModified,:createdBy,:lastModifiedBy,:nextBillDate,:recurring_bill_status,:statusLastChangedOn]
  attr_accessor *ATTRS
  def initialize

  end
end