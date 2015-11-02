class CustomerPhones
  include JsonSerializer
  ATTRS=[:phone,:extension,:type]
  attr_accessor *ATTRS
  def initialize

  end
end