class SpecificDatesSchedule
  include JsonSerializer
  ATTRS=[:specific_dates]
  attr_accessor *ATTRS
  def initialize(specific_dates)
    Util::validate_params(self.class.name, specific_dates)
    @specific_dates||= Array.new
    @specific_dates.push(specific_dates)
  end

end