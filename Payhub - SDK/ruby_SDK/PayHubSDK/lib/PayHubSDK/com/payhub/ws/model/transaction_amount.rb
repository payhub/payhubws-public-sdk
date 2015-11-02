require 'bigdecimal'
class TransactionAmount
  include JsonSerializer
  ATTRS=[:amount,:currency]
  attr_accessor *ATTRS
  #attr_reader :currency
  @CURRENCY_CODE="en-US"

  def initialize(amount)
    Util::validate_params(self.class.name,amount)
    @amount=BigDecimal.new(amount,2).round(0, BigDecimal::ROUND_HALF_EVEN).to_s('F')
    @currency="USD"
  end

end