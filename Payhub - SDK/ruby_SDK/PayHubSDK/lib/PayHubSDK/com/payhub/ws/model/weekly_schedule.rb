class WeeklySchedule

  include JsonSerializer
  ATTRS=[:weekly_bill_days]
  attr_accessor *ATTRS
  def initialize(weekly_bill_days)
    Util::validate_params(self.class.name, weekly_bill_days)
    @weekly_bill_days=weekly_bill_days
  end

end