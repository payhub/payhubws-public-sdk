class ValidatedDevices
  include JsonSerializer
  ATTRS=[:enforce_device_validation,:devices,:errors]
  attr_accessor *ATTRS
  VALIDATED_DEVICES_LINK="adminSettings/validatedDevices"
  def initialize
    @devices=Array.new
  end
end
class Devices
  include JsonSerializer
  ATTRS=[:product,:nick_name,:platform,:details,:date_added,:device_id]
  attr_accessor *ATTRS
  def initialize
  end
end