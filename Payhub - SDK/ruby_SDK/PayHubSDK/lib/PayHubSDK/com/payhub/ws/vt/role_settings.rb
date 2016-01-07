  class RoleSettings
    include JsonSerializer
    ATTRS=[:roleName,:firstDefaultScreen,:transactions,:reports,:help,:mobileVTAcces,:admin,:customer,:webPosAccess,:errors]
    attr_accessor *ATTRS
    USER_ROLE_LINK = "userRole/roles/"
    PATCH_USER_ROLE_LINK = "userRole/roles/update/"
    CREATE_USER_ROLE_LINK = "userRole/roles/create"
    def initialize

    end
  end

  class Transactions
    include JsonSerializer
    ATTRS=[:checked,:transactionOptions]
    attr_accessor *ATTRS

    def initialize

    end

  end

  class TransactionOptions
    include JsonSerializer
    ATTRS=[ :viewHostedShop,:viewSubmitBatch,:txtRefundupto,:single,:recurringBills]
    attr_accessor *ATTRS
    def initialize
    end

  end

  class Single
    include JsonSerializer
    ATTRS=[:checked,:singleOptions]
    attr_accessor *ATTRS
    def initialize
    end
  end

  class SingleOptions
    include JsonSerializer
    ATTRS=[:sales,:refund]
    attr_accessor *ATTRS
    def initialize
    end
  end

  class RecurringBills
    include JsonSerializer
    ATTRS=[:checked,:recurringBillOptions]
    attr_accessor *ATTRS
    def initialize
    end
  end

  class RecurringBillOptions
    include JsonSerializer
    ATTRS=[:edit,:add,:delete]
    attr_accessor *ATTRS
    def initialize
    end
  end

  class Reports
    include JsonSerializer
    ATTRS=[:checked,:reportOptions]
    attr_accessor *ATTRS
    def initialize
    end
  end

  class ReportOptions
    include JsonSerializer
    ATTRS=[:standard,:custom]
   attr_accessor *ATTRS
   def initialize
    end
  end

  class Standard
    include JsonSerializer
    ATTRS=[:checked,:standardOptions]
   attr_accessor *ATTRS
   def initialize
   end
  end

  class StandardOptions
    include JsonSerializer
    ATTRS=[:product,:recurrbill,:users,:transaction,:batch,:customer]
   attr_accessor *ATTRS
   def initialize
   end
  end

  class Help
    include JsonSerializer
    ATTRS=[:checked,:helpOptions]
   attr_accessor *ATTRS
   def initialize
   end
  end

  class HelpOptions
    include JsonSerializer
    ATTRS=[:tickets]
   attr_accessor *ATTRS
   def initialize
   end
  end

  class Tickets
    include JsonSerializer
    ATTRS=[:checked,:ticketsOptions]
   attr_accessor *ATTRS
   def initialize
   end
  end

  class TicketsOptions
    include JsonSerializer
    ATTRS=[:add,:edit]
   attr_accessor *ATTRS
   def initialize
   end
  end

  class MobileVTAcces
    include JsonSerializer
    ATTRS=[:checked]
   attr_accessor *ATTRS
   def initialize
   end
  end

  class Admin
    include JsonSerializer
    ATTRS=[:checked,:adminOptions]
   attr_accessor *ATTRS
   def initialize
   end
  end

  class AdminOptions
    include JsonSerializer
    ATTRS=[:webposSetUp,:hostedShopCart,:product,:users,:riskAndFraud,:general]
   attr_accessor *ATTRS
   def initialize
   end
  end

  class Product
    include JsonSerializer
    ATTRS=[:checked,:productOptions]
   attr_accessor *ATTRS
   def initialize
   end
  end

  class ProductOptions
    include JsonSerializer
    ATTRS=[:edit,:add,:delete,:bulkUpload]
   attr_accessor *ATTRS
   def initialize
   end
  end

  class Users
    include JsonSerializer
    ATTRS=[:checked,:usersOptions]
   attr_accessor *ATTRS
   def initialize
   end
  end

  class UsersOptions
    include JsonSerializer
    ATTRS=[:deleteRole,:manageRole,:editRole,:addRole,:edit,:add,:delete]
   attr_accessor *ATTRS
   def initialize
   end
  end

  class RiskAndFraud
    include JsonSerializer
    ATTRS=[:checked,:riskAndFraudOptions]
   attr_accessor *ATTRS
   def initialize
   end
  end

  class RiskAndFraudOptions
    include JsonSerializer
    ATTRS=[:riskfraudSetting,:riskfraudFlagTrn]
   attr_accessor *ATTRS
   def initialize
   end
  end

  class General
    include JsonSerializer
    ATTRS=[:checked,:generalOptions]
   attr_accessor *ATTRS
   def initialize
   end
  end

  class GeneralOptions
    include JsonSerializer
    ATTRS=[:validateDev,:thirdParyApi,:shippingTax,:branding,:generalSetting]
   attr_accessor *ATTRS
   def initialize
   end
  end

  class Customers
    include JsonSerializer
    ATTRS=[:checked,:customerOptions]
   attr_accessor *ATTRS
   def initialize
   end
  end

  class CustomerOptions
    include JsonSerializer
    ATTRS=[:add,:edit,:delete]
   attr_accessor *ATTRS
   def initialize
   end
  end

  class WebPosAccess
    include JsonSerializer
    ATTRS=[:checked,:webPosAccessOptions]
   attr_accessor *ATTRS
   def initialize
   end
  end

  class WebPosAccessOptions
    include JsonSerializer
    ATTRS=[:quitPos,:manualPriceChange,:admin]
   attr_accessor *ATTRS
   def initialize
   end
  end

  class AdminWebPos
    include JsonSerializer
    ATTRS=[:checked,:adminOptions]
    attr_accessor *ATTRS
    def initialize
    end
  end

  class AdminWebPosOptions
    include JsonSerializer
    ATTRS=[:hotKey,:deviceList,:generalSettings,:tills,:display,:customPrompt,:customMessage]
    attr_accessor *ATTRS
    def initialize
    end
  end

