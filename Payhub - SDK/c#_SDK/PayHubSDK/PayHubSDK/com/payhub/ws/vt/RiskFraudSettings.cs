using PayHubSDK.com.payhub.ws.util;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Runtime.Serialization;
using PayHubSDK.com.payhub.ws.api;

namespace PayHubSDK.com.payhub.ws.vt
{
    [DataContract]
    public class RiskFraudSettings
    {
        public static string RISK_FRAUD_PATCH_SETTINGS_LINK = "adminSettings/riskFraudDetection";
        [DataMember]
	    public TrnVolSet transaction_volume_settings;
        [DataMember]
        public CardFiltering card_filtering;
        [DataMember]
        public RiskEmail email;
        [DataMember]
        public CreditCardSecurityCodes credit_card_security_codes;
        [DataMember]
        public Avs address_verification_system;
        [DataMember]
        public List<Errors> errors;
   
        [DataContract]
	    public class OptionAndValue{
            [DataMember]
            public float value;
            [DataMember]
            public int option;		
	    }
        [DataContract]
	    public class TrnVolSet{
            [DataMember]
            public OptionAndValue refund_trn_amount_below;
            [DataMember]
            public OptionAndValue hours_trn_number_more_than;
            [DataMember]
            public OptionAndValue days_trn_amount_more_than;
            [DataMember]
            public OptionAndValue sale_trn_amount_below;
            [DataMember]
            public OptionAndValue refund_trn_amount_above;
            [DataMember]
            public OptionAndValue days_trn_number_more_than;
            [DataMember]
            public OptionAndValue sale_trn_amount_above;
            [DataMember]
            public Boolean Checked;
		
	    }
        [DataContract]
	    public class CardFiltering{
            [DataMember]
            public Boolean Checked;
	    }
        [DataContract]
	    public class RiskEmail{
            [DataMember]
            public Boolean Checked;
            [DataMember]
            public string email_address;		
	    }
        [DataContract]
	    public class CreditCardSecurityCodes{
            [DataMember]
            public OptionAndValue cvv_mismatch;
            [DataMember]
            public Boolean Checked;		
	    }
        [DataContract]
	    public class Avs{
            [DataMember]
            public OptionAndValue avs_mismatch_street_and_zip_code;
            [DataMember]
            public OptionAndValue avs_mismatch_street;
            [DataMember]
            public OptionAndValue avs_mismatch_zip_code;
            [DataMember]
            public Boolean Checked;		
	    }
    }
}
