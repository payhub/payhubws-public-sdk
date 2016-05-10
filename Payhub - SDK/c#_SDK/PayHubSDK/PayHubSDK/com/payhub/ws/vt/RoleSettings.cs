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
    public class RoleSettings
    {
	    public static string USER_ROLE_LINK = "userRole/roles/";
	    public static string PATCH_USER_ROLE_LINK = "userRole/roles/update/";
	    public static string CREATE_USER_ROLE_LINK = "userRole/roles/create";

        [DataMember]
        public string roleName;
        [DataMember]
        public int firstDefaultScreen;
        [DataMember]
        public Transactions transactions;
        [DataMember]
        public Reports reports;
        [DataMember]
        public Help help;
        [DataMember]
        public MobileVTAcces mobileVTAcces;
        [DataMember]
        public Admin admin;
        [DataMember]
        public Customer customer;
        [DataMember]
        public WebPosAccess webPosAccess;

        [DataMember]
        public List<Errors> errors;

        [DataContract]
        public class Transactions{
        [DataMember(Name = "checked")]
		public Boolean Checked;
            [DataMember]
		public TransactionOptions transactionOptions;
		
		public Transactions() {
			
		}
        [DataContract]
		public class TransactionOptions{
            [DataMember]
			public Boolean viewHostedShop;
            [DataMember]
            public Boolean viewSubmitBatch;
            [DataMember]
            public float txtRefundupto;
            [DataMember]
            public Single single;
            [DataMember]
            public RecurringBills recurringBills;
			public TransactionOptions() {
				
			}
            [DataContract]
			public class Single{
                [DataMember(Name = "checked")]
                public Boolean Checked;
                [DataMember]
                public SingleOptions singleOptions;
				
				public Single() {
					
				}
                [DataContract]
				public class SingleOptions{
                    [DataMember]
                    public Boolean sales;
                    [DataMember]
                    public Boolean refund;										
				}
			}
			
            [DataContract]
			public class RecurringBills{
                [DataMember(Name = "checked")]
                public Boolean Checked;
                [DataMember]
                public RecurringBillOptions recurringBillOptions;
				public RecurringBills() {
					
				}
                [DataContract]
				public class RecurringBillOptions{

                    [DataMember]
                    public Boolean edit;
                    [DataMember]
                    public Boolean add;
                    [DataMember]
                    public Boolean delete;
				}
			}
		}
	}
	[DataContract]
	public class Reports{
        [DataMember(Name = "checked")]
        public Boolean Checked;
        [DataMember]
        public ReportOptions reportOptions;	

	    [DataContract]
		public class ReportOptions{
            [DataMember]
            public Standard standard;
            [DataMember]
            public Boolean custom;
			
            [DataContract]
			public class Standard{
                [DataMember(Name = "checked")]
                public Boolean Checked;
                [DataMember]
                public StandardOptions standardOptions;
				
                [DataContract]
				public class StandardOptions{
                    [DataMember]
                    public Boolean product;
                    [DataMember]
                    public Boolean recurrbill;
                    [DataMember]
                    public Boolean users;
                    [DataMember]
                    public Boolean transaction;
                    [DataMember]
                    public Boolean batch;
                    [DataMember]
                    public Boolean customer;					
				}
			}
		}
	}
	[DataContract]
	public class Help{
        [DataMember(Name = "checked")]
        public Boolean Checked;
        [DataMember]
        public HelpOptions helpOptions;
		
        [DataContract]
		public class HelpOptions{
            [DataMember]
            public Tickets tickets;
			
            [DataContract]
			public class Tickets{
                [DataMember(Name = "checked")]
                public Boolean Checked;
                [DataMember]
                public TicketsOptions ticketsOptions;
				
                [DataContract]
				public class TicketsOptions{
                    [DataMember]
                    public Boolean add;
                    [DataMember]
                    public Boolean edit;					
				}
            }
		}
	}
	[DataContract]
	public class MobileVTAcces{
        [DataMember(Name = "checked")]
        public Boolean Checked;		
	}
	
    [DataContract]
	public class Admin{
        [DataMember(Name = "checked")]
        public Boolean Checked;
        [DataMember]
        public AdminOptions adminOptions;
		
        [DataContract]
		public class AdminOptions{
            [DataMember]
            public Boolean webposSetUp;
            [DataMember]
            public Boolean hostedShopCart;
            [DataMember]
            public Product product;
            [DataMember]
            public Users users;
            [DataMember]
            public RiskAndFraud riskAndFraud;
            [DataMember]
            public General general;
			
            [DataContract]
			public class Product{
                [DataMember(Name = "checked")]
                public Boolean Checked;
                [DataMember]
                public ProductOptions productOptions;
				
                [DataContract]
				public class ProductOptions{
                    [DataMember]
                    public Boolean edit;
                    [DataMember]
                    public Boolean add;
                    [DataMember]
                    public Boolean delete;
                    [DataMember]
                    public Boolean bulkUpload;					
				}
			}
            [DataContract]
			public class Users{
                [DataMember(Name = "checked")]
                public Boolean Checked;
                [DataMember]
                public UsersOptions usersOptions;
				
                [DataContract]
				public class UsersOptions{
                    [DataMember]
                    public Boolean deleteRole;
                    [DataMember]
                    public Boolean manageRole;
                    [DataMember]
                    public Boolean editRole;
                    [DataMember]
                    public Boolean addRole;
                    [DataMember]
					public Boolean edit;
                    [DataMember]
                    public Boolean add;
                    [DataMember]
                    public Boolean delete;				
				}
			}
			[DataContract]
			public class RiskAndFraud{
                [DataMember(Name = "checked")]
                public Boolean Checked;
                [DataMember]
                public RiskAndFraudOptions riskAndFraudOptions;
				public RiskAndFraud() {
					
				}
                [DataContract]
				public class RiskAndFraudOptions{
                    [DataMember]
                    public Boolean riskfraudSetting;
                    [DataMember]
                    public Boolean riskfraudFlagTrn;					
				}	
			}
            [DataContract]
			public class General{
                [DataMember(Name = "checked")]
                public Boolean Checked;
                [DataMember]
                public GeneralOptions generalOptions;
				public General() {
					
				}
                [DataContract]
				public class GeneralOptions{
                    [DataMember]
                    public Boolean validateDev;
                    [DataMember]
                    public Boolean thirdParyApi;
                    [DataMember]
                    public Boolean shippingTax;
                    [DataMember]
                    public Boolean branding;
                    [DataMember]
                    public Boolean generalSetting;
					public GeneralOptions() {						
					}	
				}
			}
		}
	}
	[DataContract]
	public class Customer{
        [DataMember(Name = "checked")]
        public Boolean Checked;
        [DataMember]
        public CustomerOptions customerOptions;
		
        [DataContract]
		public class CustomerOptions{
            [DataMember]
            public Boolean add;
            [DataMember]
            public Boolean edit;
            [DataMember]
            public Boolean delete;			
	    }
    }
        [DataContract]
	public class WebPosAccess{
            [DataMember(Name = "checked")]
            public Boolean Checked;
            [DataMember]
            public WebPosAccessOptions webPosAccessOptions;
		
            [DataContract]
		public class WebPosAccessOptions{
                [DataMember]
                public Boolean quitPos;
                [DataMember]
                public Boolean manualPriceChange;
                [DataMember]
                public AdminWebPos admin;

			[DataContract]
			public class AdminWebPos{
                [DataMember(Name = "checked")]
                public Boolean Checked;
                [DataMember]
                public AdminWebPosOptions adminOptions;
				
                [DataContract]
				public class AdminWebPosOptions{
                    [DataMember]
                    public Boolean hotKey;
                    [DataMember]
                    public Boolean deviceList;
                    [DataMember]
                    public Boolean generalSettings;
                    [DataMember]
                    public Boolean tills;
                    [DataMember]
                    public Boolean display;
                    [DataMember]
                    public Boolean customPrompt;
                    [DataMember]
                    public Boolean customMessage;				
				}
				
			}
		}
	    }
    }
    
}
