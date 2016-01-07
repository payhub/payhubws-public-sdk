import java.io.IOException;

import com.payhub.ws.api.TransactionManager;
import com.payhub.ws.model.Merchant;
import com.payhub.ws.vt.ValidatedDevices;


import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.xml.ws.Response;

import com.payhub.ws.api.AuthorizationResponseInformation;
import com.payhub.ws.api.CaptureResponseInformation;
import com.payhub.ws.api.TransactionType;
import com.payhub.ws.api.SaleResponseInformation;
import com.payhub.ws.model.AuthOnly;
import com.payhub.ws.model.Bill;
import com.payhub.ws.model.Capture;
import com.payhub.ws.model.CardData;
import com.payhub.ws.model.Customer;

import com.payhub.ws.model.TransactionAmount;

public class ValidatedDevicesSample {

	public static void main(String[] args) throws IOException {
		
		    	 /* The current url, oauth_token, orgId and Terminal Id provided in this example, are only for testing purposes
				 *  For development purposes you need to contact the Payhub Integration Support team. They will provide you with  *  all you need.
				 *  Thanks.
				 */
				 //Defining the Web Service URL
		         String url = "https://sandbox-api.payhub.com/api/v2/";
		         String oauth = "2a5d6a73-d294-4fba-bfba-957a4948d4a3";

		        
		         Merchant merchant = new Merchant();
		         merchant.setOrganization_id(10074);
		         merchant.setTerminal_id(134);
		         		         
		         TransactionManager transaction = new TransactionManager(url, oauth, merchant);
		         try {
					ValidatedDevices vd= new ValidatedDevices();
					vd.setEnforce_device_validation(false);
					transaction.patchValidatedDevices(vd);
					ValidatedDevices validatedDevices = transaction.getValidatedDevices();		         
					System.out.println(validatedDevices.toString());
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}

}
