import java.io.IOException;
import java.util.List;

import com.payhub.ws.api.TransactionManager;
import com.payhub.ws.model.Merchant;
import com.payhub.ws.vt.RoleSettings;
import com.payhub.ws.vt.UserRoles;

public class UserRoleSample {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		 String url = "https://sandbox-api.payhub.com/api/v2/";
		 String oauth = "2a5d6a73-d294-4fba-bfba-957a4948d4a3";

		
		 Merchant merchant = new Merchant();
		 merchant.setOrganization_id(10074);
		 merchant.setTerminal_id(134);
        		         
		TransactionManager transaction = new TransactionManager(url, oauth, merchant);
		UserRoles ur =transaction.getAllUserRoles();
		RoleSettings rs = transaction.getUserRolesById(ur.getUserRoles().get(1).getRoleId());
		
		rs.getReports().setChecked(false);
		
		transaction.patchUserRoles(ur.getUserRoles().get(1).getRoleId(), rs);
		
		rs.setRoleName("testFromSDK");
		rs.setFirstDefaultScreen(2);
		transaction.postUserRoles(rs);
	}

}
