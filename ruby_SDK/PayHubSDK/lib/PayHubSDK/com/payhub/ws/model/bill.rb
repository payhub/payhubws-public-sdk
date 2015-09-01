class Bill
  include JsonSerializer
  ATTRS=[:note,:po_number,:invoice_number,:customerId,:customerCardId,:tax_amount,:base_amount,:billingReferences,:totalAmount,:shipping_amount]
  attr_accessor *ATTRS
  def initialize
  end

  def tax_amount=(amount)
    @tax_amount=TransactionAmount.new(amount)
  end
  def base_amount=(amount)
    @base_amount=TransactionAmount.new(amount)
  end
  def totalAmount=(amount)
    @totalAmount=TransactionAmount.new(amount)
  end
  def shipping_amount=(amount)
    @shipping_amount=TransactionAmount.new(amount)
  end
end