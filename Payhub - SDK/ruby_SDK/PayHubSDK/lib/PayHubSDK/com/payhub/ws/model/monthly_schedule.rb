class MonthlySchedule
  include JsonSerializer
  ATTRS=[:monthly_type,:monthly_each_days,:monthly_on_the_day_of_week_in_month,:monthly_day_of_week]
  attr_accessor *ATTRS
  def initialize(monthly_type)
    Util::validate_params(self.class.name, monthly_type)
    @monthly_type=monthly_type
    @monthly_each_days||= Array.new
  end

end