class GeneralSettings
  include JsonSerializer
  ATTRS=[:inactivityHour,:terminalList,:errors]
  attr_accessor *ATTRS
  GENERAL_SETTINGS_LINK="adminSettings/generalSettings"

  def initialize

  end
end
class TerminalList
  include JsonSerializer
  ATTRS=[:nickName,:terminalType,:settlementTime]
  attr_accessor *ATTRS

  def initialize

  end

end