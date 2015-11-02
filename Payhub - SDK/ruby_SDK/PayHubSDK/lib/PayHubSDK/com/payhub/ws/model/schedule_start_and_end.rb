class ScheduleStartAndEnd
  include JsonSerializer
  ATTRS=[:start_date,:end_date_type,:end_date]
  attr_accessor *ATTRS

  def initialize(start_date,end_date_type,end_date)
    Util::validate_params(self.class.name, start_date,end_date_type,end_date)
    @start_date=start_date.strftime('%F')
    @end_date_type= end_date_type
    @end_date=end_date.strftime('%F')
  end
end