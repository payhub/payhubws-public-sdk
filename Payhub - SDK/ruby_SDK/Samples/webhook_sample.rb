require 'PayHubSDK/com/payhub/ws/extra/include_classes'

wsURL="https://sandbox-api.payhub.com/api/v2/"
oauth_token = "2a5d6a73-d294-4fba-bfba-957a4948d4a3"

merchant = Merchant.new
merchant.organization_id=10074
merchant.terminal_id=134

transaction = TransactionManager.new(wsURL,oauth_token,merchant)
response = transaction.getWebhookConfiguration
if response.errors==nil
	puts response.inspect
	response.virtualHub=false
	response.api=false
	puts response.inspect
	response = transaction.patchWebhookConfiguration(response)
else
	puts response.errors.inspect
end