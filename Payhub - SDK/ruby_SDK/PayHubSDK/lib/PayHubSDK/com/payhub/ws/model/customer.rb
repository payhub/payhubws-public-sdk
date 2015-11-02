class Customer
  include JsonSerializer
  ATTRS=[:first_name,:last_name,:email_address,:phone_number,:phone_ext,:phone_type,:company_name,:job_title,:web_address,:customerReference,:customerId]
  attr_accessor *ATTRS
  CUSTOMER_ID_FIELD = "customerId"
  def initialize
    @phone_ext=""
  end
end