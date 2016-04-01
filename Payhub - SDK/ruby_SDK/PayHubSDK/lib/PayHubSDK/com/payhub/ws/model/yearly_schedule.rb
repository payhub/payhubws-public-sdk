class YearlySchedule
  include JsonSerializer
  ATTRS=[:year_to_start,:yearly_bill_on_month_number,:yearly_bill_on_day_of_month]
  attr_accessor *ATTRS
  def initialize

  end
end