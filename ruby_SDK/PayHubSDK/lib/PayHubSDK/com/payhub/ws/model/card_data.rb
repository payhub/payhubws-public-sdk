class CardData
  include JsonSerializer
  ATTRS=[:cvv_data,:track1_data,:track2_data,:encrypted_track_data,:card_number,:card_expiry_date,:tokenized_card,:billing_address_1,:billing_address_2,:billing_city,:billing_state,:billing_zip]
  attr_accessor *ATTRS
  def initialize
  end
end