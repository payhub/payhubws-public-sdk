class Merchant
  include JsonSerializer
  ATTRS=[:organization_id,:terminal_id,:bill,:api_username,:api_password]
  attr_accessor *ATTRS
  def initialize
  end
end