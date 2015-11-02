require 'date'

class Util
  def self.validate_params(class_name, *params)
    raise ArgumentError.new "Invalid Number of Parameters in #{class_name}" if params.compact.length != params.length
  end
end