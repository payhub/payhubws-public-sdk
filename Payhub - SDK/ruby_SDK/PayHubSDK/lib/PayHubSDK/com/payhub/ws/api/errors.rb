class Errors
  include JsonSerializer
  ATTRS=[:status,:code,:location,:reason,:severity,:error,:error_description,:cause,:message]
  attr_accessor *ATTRS
  def initialize

  end

end