class Schedule
  include JsonSerializer
  ATTRS=[:schedule_type,:bill_generation_interval,:schedule_start_and_end,:monthly_schedule]
  attr_accessor *ATTRS
  def initialize(schedule_start_and_end,monthly_schedule)
    Util::validate_params(self.class.name, schedule_start_and_end,monthly_schedule)
    @schedule_start_and_end=schedule_start_and_end
    @monthly_schedule=monthly_schedule
  end
end