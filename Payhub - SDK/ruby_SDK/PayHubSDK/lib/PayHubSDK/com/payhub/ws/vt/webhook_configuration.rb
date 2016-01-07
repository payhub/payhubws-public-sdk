class WebhookConfiguration
  include JsonSerializer
  ATTRS=[:endPoint,:mobileHub,:recurringBill,:virtualHub,:webhookActive,:api,:batchIsActive,:errors]
  WEBHOOK_LINK = "adminSettings/webhookConfiguration"
  attr_accessor *ATTRS
  def initialize

  end

end