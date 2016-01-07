/**
 * Copyright 2011,2012 PayHub, Inc.
 */
package com.payhub.ws.vt;

/**
 * The Class RolesVTSettings.
 */
public class RoleSettings{
	public static final String USER_ROLE_LINK = "userRole/roles/";
	public static final String PATCH_USER_ROLE_LINK = "userRole/roles/update/";
	public static final String CREATE_USER_ROLE_LINK = "userRole/roles/create";
	private String roleName;
	private int firstDefaultScreen;
	private Transactions transactions;
	private Reports reports;
	private Help help;
	private MobileVTAcces mobileVTAcces;
	private Admin admin;
	private Customer customer;
	private WebPosAccess webPosAccess;
	
	
	public RoleSettings() {
		
	}
	public static class Transactions{
		
		private boolean checked;
		private TransactionOptions transactionOptions;
		
		public Transactions() {
			
		}
		public static class TransactionOptions{
			private boolean viewHostedShop;
			private boolean viewSubmitBatch;			
			private float txtRefundupto;
			private Single single;
			private RecurringBills recurringBills;
			public TransactionOptions() {
				
			}
			public static class Single{
				private boolean checked;
				private SingleOptions singleOptions;
				
				public Single() {
					
				}
				public static class SingleOptions{
					
					private boolean sales;
					private boolean refund;
					
					public SingleOptions() {
						
					}
					
					/**
					 * @return the sales
					 */
					public boolean isSales() {
						return sales;
					}
					/**
					 * @param sales the sales to set
					 */
					public void setSales(boolean sales) {
						this.sales = sales;
					}
					/**
					 * @return the refund
					 */
					public boolean isRefund() {
						return refund;
					}
					/**
					 * @param refund the refund to set
					 */
					public void setRefund(boolean refund) {
						this.refund = refund;
					}
					
				}
				/**
				 * @return the checked
				 */
				public boolean isChecked() {
					return checked;
				}
				/**
				 * @param checked the checked to set
				 */
				public void setChecked(boolean checked) {
					this.checked = checked;
				}
				/**
				 * @return the singleOptions
				 */
				public SingleOptions getSingleOptions() {
					return singleOptions;
				}
				/**
				 * @param singleOptions the singleOptions to set
				 */
				public void setSingleOptions(SingleOptions singleOptions) {
					this.singleOptions = singleOptions;
				}
				
			}
			
			public static class RecurringBills{
				private boolean checked;
				private RecurringBillOptions recurringBillOptions;
				public RecurringBills() {
					
				}
				public static class RecurringBillOptions{
				
					private boolean edit;
					private boolean add;
					private boolean delete;
					public RecurringBillOptions() {
						
					}
					
					/**
					 * @return the edit
					 */
					public boolean isEdit() {
						return edit;
					}
					/**
					 * @param edit the edit to set
					 */
					public void setEdit(boolean edit) {
						this.edit = edit;
					}
					/**
					 * @return the add
					 */
					public boolean isAdd() {
						return add;
					}
					/**
					 * @param add the add to set
					 */
					public void setAdd(boolean add) {
						this.add = add;
					}
					/**
					 * @return the delete
					 */
					public boolean isDelete() {
						return delete;
					}
					/**
					 * @param delete the delete to set
					 */
					public void setDelete(boolean delete) {
						this.delete = delete;
					}
					
				}
				/**
				 * @return the checked
				 */
				public boolean isChecked() {
					return checked;
				}
				/**
				 * @param checked the checked to set
				 */
				public void setChecked(boolean checked) {
					this.checked = checked;
				}
				/**
				 * @return the recurringBillOptions
				 */
				public RecurringBillOptions getRecurringBillOptions() {
					return recurringBillOptions;
				}
				/**
				 * @param recurringBillOptions the recurringBillOptions to set
				 */
				public void setRecurringBillOptions(RecurringBillOptions recurringBillOptions) {
					this.recurringBillOptions = recurringBillOptions;
				}
				
			}
			/**
			 * @return the viewHostedShop
			 */
			public boolean isViewHostedShop() {
				return viewHostedShop;
			}
			/**
			 * @param viewHostedShop the viewHostedShop to set
			 */
			public void setViewHostedShop(boolean viewHostedShop) {
				this.viewHostedShop = viewHostedShop;
			}
			/**
			 * @return the viewSubmitBatch
			 */
			public boolean isViewSubmitBatch() {
				return viewSubmitBatch;
			}
			/**
			 * @param viewSubmitBatch the viewSubmitBatch to set
			 */
			public void setViewSubmitBatch(boolean viewSubmitBatch) {
				this.viewSubmitBatch = viewSubmitBatch;
			}
			
			/**
			 * @return the txtRefundupto
			 */
			public float getTxtRefundupto() {
				return txtRefundupto;
			}
			/**
			 * @param txtRefundupto the txtRefundupto to set
			 */
			public void setTxtRefundupto(String txtRefundupto) {
				
				this.txtRefundupto = Float.parseFloat(txtRefundupto.replace(",", ""));
			}
			/**
			 * @return the single
			 */
			public Single getSingle() {
				return single;
			}
			/**
			 * @param single the single to set
			 */
			public void setSingle(Single single) {
				this.single = single;
			}
			/**
			 * @return the recurringBills
			 */
			public RecurringBills getRecurringBills() {
				return recurringBills;
			}
			/**
			 * @param recurringBills the recurringBills to set
			 */
			public void setRecurringBills(RecurringBills recurringBills) {
				this.recurringBills = recurringBills;
			}
			
		}

		/**
		 * @return the checked
		 */
		public boolean isChecked() {
			return checked;
		}

		/**
		 * @param checked the checked to set
		 */
		public void setChecked(boolean checked) {
			this.checked = checked;
		}

		/**
		 * @return the transactionOptions
		 */
		public TransactionOptions getTransactionOptions() {
			return transactionOptions;
		}

		/**
		 * @param transactionOptions the transactionOptions to set
		 */
		public void setTransactionOptions(TransactionOptions transactionOptions) {
			this.transactionOptions = transactionOptions;
		}
		
	}
	
	public static class Reports{
		private boolean checked;
		private ReportOptions reportOptions;
		public Reports() {
			
		}
		public static class ReportOptions{
			private Standard standard;
			private boolean custom;
			public ReportOptions() {
				
			}
			public static class Standard{
				private boolean checked;
				private StandardOptions standardOptions;
				public Standard() {
					
				}
				public static class StandardOptions{
					private boolean product;
					private boolean recurrbill;
					private boolean users;
					private boolean transaction;
					private boolean batch;
					private boolean customer;
					public StandardOptions() {
						
					}
					/**
					 * @return the product
					 */
					public boolean isProduct() {
						return product;
					}
					/**
					 * @param product the product to set
					 */
					public void setProduct(boolean product) {
						this.product = product;
					}
					/**
					 * @return the recurrbill
					 */
					public boolean isRecurrbill() {
						return recurrbill;
					}
					/**
					 * @param recurrbill the recurrbill to set
					 */
					public void setRecurrbill(boolean recurrbill) {
						this.recurrbill = recurrbill;
					}
					/**
					 * @return the users
					 */
					public boolean isUsers() {
						return users;
					}
					/**
					 * @param users the users to set
					 */
					public void setUsers(boolean users) {
						this.users = users;
					}
					/**
					 * @return the transaction
					 */
					public boolean isTransaction() {
						return transaction;
					}
					/**
					 * @param transaction the transaction to set
					 */
					public void setTransaction(boolean transaction) {
						this.transaction = transaction;
					}
					/**
					 * @return the batch
					 */
					public boolean isBatch() {
						return batch;
					}
					/**
					 * @param batch the batch to set
					 */
					public void setBatch(boolean batch) {
						this.batch = batch;
					}
					/**
					 * @return the customer
					 */
					public boolean isCustomer() {
						return customer;
					}
					/**
					 * @param customer the customer to set
					 */
					public void setCustomer(boolean customer) {
						this.customer = customer;
					}
					
				}

				/**
				 * @return the checked
				 */
				public boolean isChecked() {
					return checked;
				}

				/**
				 * @param checked the checked to set
				 */
				public void setChecked(boolean checked) {
					this.checked = checked;
				}

				/**
				 * @return the standardOptions
				 */
				public StandardOptions getStandardOptions() {
					return standardOptions;
				}

				/**
				 * @param standardOptions the standardOptions to set
				 */
				public void setStandardOptions(StandardOptions standardOptions) {
					this.standardOptions = standardOptions;
				}
				
			}

			/**
			 * @return the standard
			 */
			public Standard getStandard() {
				return standard;
			}

			/**
			 * @param standard the standard to set
			 */
			public void setStandard(Standard standard) {
				this.standard = standard;
			}

			/**
			 * @return the custom
			 */
			public boolean isCustom() {
				return custom;
			}

			/**
			 * @param custom the custom to set
			 */
			public void setCustom(boolean custom) {
				this.custom = custom;
			}
			
		}

		/**
		 * @return the checked
		 */
		public boolean isChecked() {
			return checked;
		}

		/**
		 * @param checked the checked to set
		 */
		public void setChecked(boolean checked) {
			this.checked = checked;
		}

		/**
		 * @return the reportOptions
		 */
		public ReportOptions getReportOptions() {
			return reportOptions;
		}

		/**
		 * @param reportOptions the reportOptions to set
		 */
		public void setReportOptions(ReportOptions reportOptions) {
			this.reportOptions = reportOptions;
		}
		
	}
	
	public static class Help{
		private boolean checked;
		private HelpOptions helpOptions;
		public Help() {
			
		}
		public static class HelpOptions{
			private Tickets tickets;
			public HelpOptions() {
				
			}
			public static class Tickets{
				private boolean checked;
				private TicketsOptions ticketsOptions;
				public Tickets() {
					
				}
				public static class TicketsOptions{
					private boolean add;
					private boolean edit;
					public TicketsOptions() {
						
					}
					/**
					 * @return the add
					 */
					public boolean isAdd() {
						return add;
					}
					/**
					 * @param add the add to set
					 */
					public void setAdd(boolean add) {
						this.add = add;
					}
					/**
					 * @return the edit
					 */
					public boolean isEdit() {
						return edit;
					}
					/**
					 * @param edit the edit to set
					 */
					public void setEdit(boolean edit) {
						this.edit = edit;
					}
					
				}

				/**
				 * @return the checked
				 */
				public boolean isChecked() {
					return checked;
				}

				/**
				 * @param checked the checked to set
				 */
				public void setChecked(boolean checked) {
					this.checked = checked;
				}

				/**
				 * @return the ticketsOptions
				 */
				public TicketsOptions getTicketsOptions() {
					return ticketsOptions;
				}

				/**
				 * @param ticketsOptions the ticketsOptions to set
				 */
				public void setTicketsOptions(TicketsOptions ticketsOptions) {
					this.ticketsOptions = ticketsOptions;
				}
				
			}

			/**
			 * @return the tickets
			 */
			public Tickets getTickets() {
				return tickets;
			}

			/**
			 * @param tickets the tickets to set
			 */
			public void setTickets(Tickets tickets) {
				this.tickets = tickets;
			}
			
		}

		/**
		 * @return the checked
		 */
		public boolean isChecked() {
			return checked;
		}

		/**
		 * @param checked the checked to set
		 */
		public void setChecked(boolean checked) {
			this.checked = checked;
		}

		/**
		 * @return the helpOptions
		 */
		public HelpOptions getHelpOptions() {
			return helpOptions;
		}

		/**
		 * @param helpOptions the helpOptions to set
		 */
		public void setHelpOptions(HelpOptions helpOptions) {
			this.helpOptions = helpOptions;
		}
		
	}
	
	public static class MobileVTAcces{
		private boolean checked;
		
		public MobileVTAcces() {
			
		}

		/**
		 * @return the checked
		 */
		public boolean isChecked() {
			return checked;
		}

		/**
		 * @param checked the checked to set
		 */
		public void setChecked(boolean checked) {
			this.checked = checked;
		}
		
	}
	
	public static class Admin{
		private boolean checked;
		private AdminOptions adminOptions;
		public Admin() {
			
		}
		public static class AdminOptions{
			private boolean webposSetUp;
			private boolean hostedShopCart;
			private Product product;
			private Users users;
			private RiskAndFraud riskAndFraud;
			private General general;
			public AdminOptions() {
				
			}
			public static class Product{
				private boolean checked;
				private ProductOptions productOptions;
				public Product() {
					
				}
				public static class ProductOptions{
					private boolean edit;
					private boolean add;
					private boolean delete;
					private boolean bulkUpload;
					public ProductOptions() {
						
					}
					/**
					 * @return the edit
					 */
					public boolean isEdit() {
						return edit;
					}
					/**
					 * @param edit the edit to set
					 */
					public void setEdit(boolean edit) {
						this.edit = edit;
					}
					/**
					 * @return the add
					 */
					public boolean isAdd() {
						return add;
					}
					/**
					 * @param add the add to set
					 */
					public void setAdd(boolean add) {
						this.add = add;
					}
					/**
					 * @return the delete
					 */
					public boolean isDelete() {
						return delete;
					}
					/**
					 * @param delete the delete to set
					 */
					public void setDelete(boolean delete) {
						this.delete = delete;
					}
					/**
					 * @return the bulkUpload
					 */
					public boolean isBulkUpload() {
						return bulkUpload;
					}
					/**
					 * @param bulkUpload the bulkUpload to set
					 */
					public void setBulkUpload(boolean bulkUpload) {
						this.bulkUpload = bulkUpload;
					}
					
				}

				/**
				 * @return the checked
				 */
				public boolean isChecked() {
					return checked;
				}

				/**
				 * @param checked the checked to set
				 */
				public void setChecked(boolean checked) {
					this.checked = checked;
				}

				/**
				 * @return the productOptions
				 */
				public ProductOptions getProductOptions() {
					return productOptions;
				}

				/**
				 * @param productOptions the productOptions to set
				 */
				public void setProductOptions(ProductOptions productOptions) {
					this.productOptions = productOptions;
				}
				
			}
			public static class Users{
				private boolean checked;
				private UsersOptions usersOptions;
				public Users() {
					
				}
				public static class UsersOptions{
					private boolean deleteRole;
					private boolean manageRole;
					private boolean editRole;
					private boolean addRole;
				
					private boolean edit;
					private boolean add;
					private boolean delete;
					public UsersOptions() {
						
					}
					/**
					 * @return the deleteRole
					 */
					public boolean isDeleteRole() {
						return deleteRole;
					}
					/**
					 * @param deleteRole the deleteRole to set
					 */
					public void setDeleteRole(boolean deleteRole) {
						this.deleteRole = deleteRole;
					}
					/**
					 * @return the manageRole
					 */
					public boolean isManageRole() {
						return manageRole;
					}
					/**
					 * @param manageRole the manageRole to set
					 */
					public void setManageRole(boolean manageRole) {
						this.manageRole = manageRole;
					}
					/**
					 * @return the editRole
					 */
					public boolean isEditRole() {
						return editRole;
					}
					/**
					 * @param editRole the editRole to set
					 */
					public void setEditRole(boolean editRole) {
						this.editRole = editRole;
					}
					/**
					 * @return the addRole
					 */
					public boolean isAddRole() {
						return addRole;
					}
					/**
					 * @param addRole the addRole to set
					 */
					public void setAddRole(boolean addRole) {
						this.addRole = addRole;
					}
					
					/**
					 * @return the edit
					 */
					public boolean isEdit() {
						return edit;
					}
					/**
					 * @param edit the edit to set
					 */
					public void setEdit(boolean edit) {
						this.edit = edit;
					}
					/**
					 * @return the add
					 */
					public boolean isAdd() {
						return add;
					}
					/**
					 * @param add the add to set
					 */
					public void setAdd(boolean add) {
						this.add = add;
					}
					/**
					 * @return the delete
					 */
					public boolean isDelete() {
						return delete;
					}
					/**
					 * @param delete the delete to set
					 */
					public void setDelete(boolean delete) {
						this.delete = delete;
					}
					
				}

				/**
				 * @return the checked
				 */
				public boolean isChecked() {
					return checked;
				}

				/**
				 * @param checked the checked to set
				 */
				public void setChecked(boolean checked) {
					this.checked = checked;
				}

				/**
				 * @return the usersOptions
				 */
				public UsersOptions getUsersOptions() {
					return usersOptions;
				}

				/**
				 * @param usersOptions the usersOptions to set
				 */
				public void setUsersOptions(UsersOptions usersOptions) {
					this.usersOptions = usersOptions;
				}
				
			}
			
			public static class RiskAndFraud{
				private boolean checked;
				private RiskAndFraudOptions riskAndFraudOptions;
				public RiskAndFraud() {
					
				}
				public static class RiskAndFraudOptions{
					private boolean riskfraudSetting;
					private boolean riskfraudFlagTrn;
					public RiskAndFraudOptions() {
						
					}
					/**
					 * @return the riskfraudSetting
					 */
					public boolean isRiskfraudSetting() {
						return riskfraudSetting;
					}
					/**
					 * @param riskfraudSetting the riskfraudSetting to set
					 */
					public void setRiskfraudSetting(boolean riskfraudSetting) {
						this.riskfraudSetting = riskfraudSetting;
					}
					/**
					 * @return the riskfraudFlagTrn
					 */
					public boolean isRiskfraudFlagTrn() {
						return riskfraudFlagTrn;
					}
					/**
					 * @param riskfraudFlagTrn the riskfraudFlagTrn to set
					 */
					public void setRiskfraudFlagTrn(boolean riskfraudFlagTrn) {
						this.riskfraudFlagTrn = riskfraudFlagTrn;
					}
					
				}

				/**
				 * @return the checked
				 */
				public boolean isChecked() {
					return checked;
				}

				/**
				 * @param checked the checked to set
				 */
				public void setChecked(boolean checked) {
					this.checked = checked;
				}

				/**
				 * @return the riskAndFraudOptions
				 */
				public RiskAndFraudOptions getRiskAndFraudOptions() {
					return riskAndFraudOptions;
				}

				/**
				 * @param riskAndFraudOptions the riskAndFraudOptions to set
				 */
				public void setRiskAndFraudOptions(RiskAndFraudOptions riskAndFraudOptions) {
					this.riskAndFraudOptions = riskAndFraudOptions;
				}
				
			}
			public static class General{
				private boolean checked;
				private GeneralOptions generalOptions;
				public General() {
					
				}
				public static class GeneralOptions{
					private boolean validateDev;
					private boolean thirdParyApi;
					private boolean shippingTax;
					private boolean branding;
					private boolean generalSetting;
					public GeneralOptions() {
						
					}
					/**
					 * @return the validateDev
					 */
					public boolean isValidateDev() {
						return validateDev;
					}
					/**
					 * @param validateDev the validateDev to set
					 */
					public void setValidateDev(boolean validateDev) {
						this.validateDev = validateDev;
					}
					/**
					 * @return the thirdParyApi
					 */
					public boolean isThirdParyApi() {
						return thirdParyApi;
					}
					/**
					 * @param thirdParyApi the thirdParyApi to set
					 */
					public void setThirdParyApi(boolean thirdParyApi) {
						this.thirdParyApi = thirdParyApi;
					}
					/**
					 * @return the shippingTax
					 */
					public boolean isShippingTax() {
						return shippingTax;
					}
					/**
					 * @param shippingTax the shippingTax to set
					 */
					public void setShippingTax(boolean shippingTax) {
						this.shippingTax = shippingTax;
					}
					/**
					 * @return the branding
					 */
					public boolean isBranding() {
						return branding;
					}
					/**
					 * @param branding the branding to set
					 */
					public void setBranding(boolean branding) {
						this.branding = branding;
					}
					/**
					 * @return the generalSetting
					 */
					public boolean isGeneralSetting() {
						return generalSetting;
					}
					/**
					 * @param generalSetting the generalSetting to set
					 */
					public void setGeneralSetting(boolean generalSetting) {
						this.generalSetting = generalSetting;
					}
					
				}

				/**
				 * @return the checked
				 */
				public boolean isChecked() {
					return checked;
				}

				/**
				 * @param checked the checked to set
				 */
				public void setChecked(boolean checked) {
					this.checked = checked;
				}

				/**
				 * @return the generalOptions
				 */
				public GeneralOptions getGeneralOptions() {
					return generalOptions;
				}

				/**
				 * @param generalOptions the generalOptions to set
				 */
				public void setGeneralOptions(GeneralOptions generalOptions) {
					this.generalOptions = generalOptions;
				}
				
			}
			/**
			 * @return the webposSetUp
			 */
			public boolean isWebposSetUp() {
				return webposSetUp;
			}
			/**
			 * @param webposSetUp the webposSetUp to set
			 */
			public void setWebposSetUp(boolean webposSetUp) {
				this.webposSetUp = webposSetUp;
			}
			/**
			 * @return the hostedShopCart
			 */
			public boolean isHostedShopCart() {
				return hostedShopCart;
			}
			/**
			 * @param hostedShopCart the hostedShopCart to set
			 */
			public void setHostedShopCart(boolean hostedShopCart) {
				this.hostedShopCart = hostedShopCart;
			}
			/**
			 * @return the product
			 */
			public Product getProduct() {
				return product;
			}
			/**
			 * @param product the product to set
			 */
			public void setProduct(Product product) {
				this.product = product;
			}
			/**
			 * @return the users
			 */
			public Users getUsers() {
				return users;
			}
			/**
			 * @param users the users to set
			 */
			public void setUsers(Users users) {
				this.users = users;
			}
			/**
			 * @return the riskAndFraud
			 */
			public RiskAndFraud getRiskAndFraud() {
				return riskAndFraud;
			}
			/**
			 * @param riskAndFraud the riskAndFraud to set
			 */
			public void setRiskAndFraud(RiskAndFraud riskAndFraud) {
				this.riskAndFraud = riskAndFraud;
			}
			/**
			 * @return the general
			 */
			public General getGeneral() {
				return general;
			}
			/**
			 * @param general the general to set
			 */
			public void setGeneral(General general) {
				this.general = general;
			}
			
		}

		/**
		 * @return the checked
		 */
		public boolean isChecked() {
			return checked;
		}

		/**
		 * @param checked the checked to set
		 */
		public void setChecked(boolean checked) {
			this.checked = checked;
		}

		/**
		 * @return the adminOptions
		 */
		public AdminOptions getAdminOptions() {
			return adminOptions;
		}

		/**
		 * @param adminOptions the adminOptions to set
		 */
		public void setAdminOptions(AdminOptions adminOptions) {
			this.adminOptions = adminOptions;
		}
		
	}
	
	public static class Customer{
		private boolean checked;
		private CustomerOptions customerOptions;
		public Customer() {
			
		}
		/**
		 * @return the checked
		 */
		public boolean isChecked() {
			return checked;
		}

		/**
		 * @param checked the checked to set
		 */
		public void setChecked(boolean checked) {
			this.checked = checked;
		}

		/**
		 * @return the customerOptions
		 */
		public CustomerOptions getCustomerOptions() {
			return customerOptions;
		}

		/**
		 * @param customerOptions the customerOptions to set
		 */
		public void setCustomerOptions(CustomerOptions customerOptions) {
			this.customerOptions = customerOptions;
		}

		public static class CustomerOptions{
			private boolean add;
			private boolean edit;
			private boolean delete;
			
			public CustomerOptions() {
				
			}
			/**
			 * @return the add
			 */
			public boolean isAdd() {
				return add;
			}
			/**
			 * @param add the add to set
			 */
			public void setAdd(boolean add) {
				this.add = add;
			}
			/**
			 * @return the edit
			 */
			public boolean isEdit() {
				return edit;
			}
			/**
			 * @param edit the edit to set
			 */
			public void setEdit(boolean edit) {
				this.edit = edit;
			}
			/**
			 * @return the delete
			 */
			public boolean isDelete() {
				return delete;
			}
			/**
			 * @param delete the delete to set
			 */
			public void setDelete(boolean delete) {
				this.delete = delete;
			}
			
			
		}
	}
	public static class WebPosAccess{
		private boolean checked;
		private WebPosAccessOptions webPosAccessOptions;
		public WebPosAccess() {
			
		}
		/**
		 * @return the checked
		 */
		public boolean isChecked() {
			return checked;
		}

		/**
		 * @param checked the checked to set
		 */
		public void setChecked(boolean checked) {
			this.checked = checked;
		}

		/**
		 * @return the webPosAccessOptions
		 */
		public WebPosAccessOptions getWebPosAccessOptions() {
			return webPosAccessOptions;
		}

		/**
		 * @param webPosAccessOptions the webPosAccessOptions to set
		 */
		public void setWebPosAccessOptions(WebPosAccessOptions webPosAccessOptions) {
			this.webPosAccessOptions = webPosAccessOptions;
		}

		public static class WebPosAccessOptions{
			private boolean quitPos;
			private boolean manualPriceChange;
			private AdminWebPos admin;
			public WebPosAccessOptions() {
				
			}
			/**
			 * @return the quitPos
			 */
			public boolean isQuitPos() {
				return quitPos;
			}

			/**
			 * @param quitPos the quitPos to set
			 */
			public void setQuitPos(boolean quitPos) {
				this.quitPos = quitPos;
			}

			/**
			 * @return the manualPriceChange
			 */
			public boolean isManualPriceChange() {
				return manualPriceChange;
			}

			/**
			 * @param manualPriceChange the manualPriceChange to set
			 */
			public void setManualPriceChange(boolean manualPriceChange) {
				this.manualPriceChange = manualPriceChange;
			}

			/**
			 * @return the admin
			 */
			public AdminWebPos getAdmin() {
				return admin;
			}

			/**
			 * @param admin the admin to set
			 */
			public void setAdmin(AdminWebPos admin) {
				this.admin = admin;
			}

			public static class AdminWebPos{
				private boolean checked;
				private AdminWebPosOptions adminOptions;
				public AdminWebPos() {
					
				}
				public static class AdminWebPosOptions{
					private boolean hotKey;
					
					private boolean deviceList;
					private boolean generalSettings;
					private boolean tills;
					private boolean display;
					private boolean customPrompt;
					private boolean customMessage;
					public AdminWebPosOptions() {
						
					}
					/**
					 * @return the hotKey
					 */
					public boolean isHotKey() {
						return hotKey;
					}
					/**
					 * @param hotKey the hotKey to set
					 */
					public void setHotKey(boolean hotKey) {
						this.hotKey = hotKey;
					}
				
					/**
					 * @return the deviceList
					 */
					public boolean isDeviceList() {
						return deviceList;
					}
					/**
					 * @param deviceList the deviceList to set
					 */
					public void setDeviceList(boolean deviceList) {
						this.deviceList = deviceList;
					}
					/**
					 * @return the generalSettings
					 */
					public boolean isGeneralSettings() {
						return generalSettings;
					}
					/**
					 * @param generalSettings the generalSettings to set
					 */
					public void setGeneralSettings(boolean generalSettings) {
						this.generalSettings = generalSettings;
					}
					/**
					 * @return the tills
					 */
					public boolean isTills() {
						return tills;
					}
					/**
					 * @param tills the tills to set
					 */
					public void setTills(boolean tills) {
						this.tills = tills;
					}
					/**
					 * @return the display
					 */
					public boolean isDisplay() {
						return display;
					}
					/**
					 * @param display the display to set
					 */
					public void setDisplay(boolean display) {
						this.display = display;
					}
					/**
					 * @return the customPrompt
					 */
					public boolean isCustomPrompt() {
						return customPrompt;
					}
					/**
					 * @param customPrompt the customPrompt to set
					 */
					public void setCustomPrompt(boolean customPrompt) {
						this.customPrompt = customPrompt;
					}
					/**
					 * @return the customMessage
					 */
					public boolean isCustomMessage() {
						return customMessage;
					}
					/**
					 * @param customMessage the customMessage to set
					 */
					public void setCustomMessage(boolean customMessage) {
						this.customMessage = customMessage;
					}
					
					
				}
				/**
				 * @return the checked
				 */
				public boolean isChecked() {
					return checked;
				}
				/**
				 * @param checked the checked to set
				 */
				public void setChecked(boolean checked) {
					this.checked = checked;
				}
				/**
				 * @return the adminOptions
				 */
				public AdminWebPosOptions getAdminOptions() {
					return adminOptions;
				}
				/**
				 * @param adminOptions the adminOptions to set
				 */
				public void setAdminOptions(AdminWebPosOptions adminOptions) {
					this.adminOptions = adminOptions;
				}
				
			}
		}
	}
	/**
	 * @return the roleName
	 */
	public String getRoleName() {
		return roleName;
	}
	/**
	 * @param roleName the roleName to set
	 */
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	/**
	 * @return the firstDefaultScreen
	 */
	public int getFirstDefaultScreen() {
		return firstDefaultScreen;
	}
	/**
	 * @param firstDefaultScreen the firstDefaultScreen to set
	 * @throws RolesVTExceptionHandler 
	 */
	public void setFirstDefaultScreen(int firstDefaultScreen) throws Exception {
		if(firstDefaultScreen>0 && firstDefaultScreen<3){
		this.firstDefaultScreen = firstDefaultScreen;
		}else{
			throw new Exception("Invalid Value for firstDefaultScreen - Must be between 1 and 3");
		}
		
	}
	/**
	 * @return the transactions
	 */
	public Transactions getTransactions() {
		return transactions;
	}
	/**
	 * @param transactions the transactions to set
	 */
	public void setTransactions(Transactions transactions) {
		this.transactions = transactions;
	}
	/**
	 * @return the reports
	 */
	public Reports getReports() {
		return reports;
	}
	/**
	 * @param reports the reports to set
	 */
	public void setReports(Reports reports) {
		this.reports = reports;
	}
	/**
	 * @return the help
	 */
	public Help getHelp() {
		return help;
	}
	/**
	 * @param help the help to set
	 */
	public void setHelp(Help help) {
		this.help = help;
	}
	/**
	 * @return the mobileVTAcces
	 */
	public MobileVTAcces getMobileVTAcces() {
		return mobileVTAcces;
	}
	/**
	 * @param mobileVTAcces the mobileVTAcces to set
	 */
	public void setMobileVTAcces(MobileVTAcces mobileVTAcces) {
		this.mobileVTAcces = mobileVTAcces;
	}
	/**
	 * @return the admin
	 */
	public Admin getAdmin() {
		return admin;
	}
	/**
	 * @param admin the admin to set
	 */
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	/**
	 * @return the customer
	 */
	public Customer getCustomer() {
		return customer;
	}
	/**
	 * @param customer the customer to set
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	/**
	 * @return the webPosAccess
	 */
	public WebPosAccess getWebPosAccess() {
		return webPosAccess;
	}
	/**
	 * @param webPosAccess the webPosAccess to set
	 */
	public void setWebPosAccess(WebPosAccess webPosAccess) {
		this.webPosAccess = webPosAccess;
	}
	
	
}