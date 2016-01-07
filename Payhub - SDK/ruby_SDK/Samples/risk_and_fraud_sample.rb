require 'PayHubSDK/com/payhub/ws/extra/include_classes'

wsURL="https://sandbox-api.payhub.com/api/v2/"
oauth_token = "2a5d6a73-d294-4fba-bfba-957a4948d4a3"

merchant = Merchant.new
merchant.organization_id=10074
merchant.terminal_id=134

transaction = TransactionManager.new(wsURL,oauth_token,merchant)
response = transaction.getRiskFraudSettings()


if response.errors==nil
	puts response.inspect
	response.transaction_volume_settings.hours_trn_number_more_than.option=2
	response.transaction_volume_settings.hours_trn_number_more_than.value=265
	response.transaction_volume_settings.checked=true
	response.address_verification_system.checked=true
	response=transaction.patchRiskFraudSettings(response)
	response2=transaction.getRiskFraudSettings()
  puts response2.inspect

else
	puts response.errors.inspect
end
