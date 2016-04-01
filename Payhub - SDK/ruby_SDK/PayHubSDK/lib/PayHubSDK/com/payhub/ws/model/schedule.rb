class Schedule
  include JsonSerializer
  ATTRS=[:schedule_type,:bill_generation_interval,:schedule_start_and_end,:monthly_schedule,:yearly_schedule,:weekly_schedule,:specific_dates_schedule]
  attr_accessor *ATTRS
  def initialize(schedule_type)
    Util::validate_params(self.class.name, schedule_type)
    @schedule_type=schedule_type
  end
end