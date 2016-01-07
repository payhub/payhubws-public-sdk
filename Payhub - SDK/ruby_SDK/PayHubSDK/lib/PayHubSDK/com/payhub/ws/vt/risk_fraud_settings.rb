class RiskFraudSettings
  include JsonSerializer
  ATTRS=[:transaction_volume_settings,:card_filtering,:email,:credit_card_security_codes,:address_verification_system,:errors]
  attr_accessor *ATTRS
  RISK_FRAUD_SETTINGS_LINK="adminSettings/riskFraud"
  RISK_FRAUD_PATCH_SETTINGS_LINK = "adminSettings/riskFraudDetection"
  def initialize
  end
end

class Transaction_volume_settings
  include JsonSerializer
  ATTRS=[:hours_trn_number_more_than,:days_trn_amount_more_than,:sale_trn_amount_below,:days_trn_number_more_than,:refund_trn_amount_above,:refund_trn_amount_below,:sale_trn_amount_above,:checked]
  attr_accessor *ATTRS
  def initialize
  end
end

class Card_filtering
  include JsonSerializer
  ATTRS=[:checked]
  attr_accessor *ATTRS

  def initialize
  end
end

class Email
  include JsonSerializer
  ATTRS=[:checked,:email_address]
  attr_accessor *ATTRS
  def initialize
  end
end
class Credit_card_security_codes
  include JsonSerializer
  ATTRS=[:checked,:cvv_mismatch]
  attr_accessor *ATTRS
  def initialize
  end
end
class Address_verification_system
  include JsonSerializer
  ATTRS=[:checked,:avs_mismatch_street_and_zip_code,:avs_mismatch_street,:avs_mismatch_zip_code]
  attr_accessor *ATTRS
  def initialize
  end
end

class OptionAndValue
  include JsonSerializer
  ATTRS=[:option,:value]
  attr_accessor *ATTRS
  def initialize
  end
end

class Hours_trn_number_more_than<OptionAndValue
end
class Days_trn_amount_more_than <OptionAndValue
end
class Sale_trn_amount_below <OptionAndValue
end
class Days_trn_number_more_than <OptionAndValue
end
class Refund_trn_amount_above <OptionAndValue
end
class Refund_trn_amount_below<OptionAndValue
end
class Sale_trn_amount_above<OptionAndValue
end
class Cvv_mismatch<OptionAndValue
end
class Avs_mismatch_street_and_zip_code<OptionAndValue
end
class Avs_mismatch_street<OptionAndValue
end
class Avs_mismatch_zip_code<OptionAndValue
end