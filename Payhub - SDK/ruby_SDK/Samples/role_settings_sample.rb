require 'PayHubSDK/com/payhub/ws/extra/include_classes'

wsURL="https://sandbox-api.payhub.com/api/v2/"
oauth_token = "2a5d6a73-d294-4fba-bfba-957a4948d4a3"

merchant = Merchant.new
merchant.organization_id=10074
merchant.terminal_id=134

transaction = TransactionManager.new(wsURL,oauth_token,merchant)
response = transaction.getAllUserRoles

if response.errors==nil
	roleId=response.userRoles[1].roleId
	response = transaction.getUserRolesById(roleId)
	response.customer.checked=true
	response.firstDefaultScreen=2
	response.roleName="testFromRuby"
	response = transaction.postUserRoles(response)
else
	puts response.errors.inspect
end
