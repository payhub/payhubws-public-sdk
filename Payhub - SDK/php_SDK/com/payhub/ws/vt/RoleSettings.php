<?php

/**
 * Created by PhpStorm.
 * User: agustin
 * Date: 12/18/15
 * Time: 12:01 PM
 */
class RoleSettings
{
    public static $USER_ROLE_LINK = "userRole/roles/";
    public static $PATCH_USER_ROLE_LINK = "userRole/roles/update/";
    public static $CREATE_USER_ROLE_LINK = "userRole/roles/create";
    public $roleName;
    public $firstDefaultScreen;
    public $transactions;
    public $reports;
    public $help;
    public $mobileVTAcces;
    public $admin;
    public $customer;
    public $webPosAccess;

    public static function fromArray($data)
    {
        $settings = new RoleSettings();
        foreach ($data as $key => $value) {
            if (property_exists(get_class($settings), $key)) {
                if(is_array($value)){
                    if ($key == "transactions") {
                        $settings->{$key} = Transactions::fromArray($value);
                    }if ($key == "reports") {
                        $settings->{$key} = Reports::fromArray($value);
                    }if ($key == "help") {
                        $settings->{$key} = Help::fromArray($value);
                    }if ($key == "mobileVTAccess") {
                        $settings->{$key} = MobileVTAcces::fromArray($value);
                    }if ($key == "admin") {
                        $settings->{$key} = Admin::fromArray($value);
                    }if ($key == "customer") {
                        $settings->{$key} = Customers::fromArray($value);
                    }if ($key == "webPosAccess") {
                        $settings->{$key} = WebPosAccess::fromArray($value);
                    }
                }else {
                    $settings->{$key} = $value;
                }
            }
        }
        return $settings;
    }
    public function object_unset_nulls_for_send()
    {
        $array = $this->getStripped($this);
        return $array;

    }
    private function getStripped($obj) {
        $objVars = get_object_vars($obj);

        if(count($objVars) > 0) {
            foreach($objVars as $propName => $propVal) {
                if(gettype($propVal) == "object") {
                    $cObj = $this->getStripped($propVal);
                    if($cObj == null) {
                        unset($obj->$propName);
                    } else {
                        $obj->$propName = $cObj;
                    }
                } else {
                    if(empty($propVal)) {
                        unset($obj->$propName);
                    }
                }
            }
        } else {
            return null;
        }
        return $obj;
    }
    /**
     * GeneralSettings constructor.
     */
    public function __construct()
    {
    }

    /**
     * @return mixed
     */
    public function getRoleName()
    {
        return $this->roleName;
    }

    /**
     * @param mixed $roleName
     */
    public function setRoleName($roleName)
    {
        $this->roleName = $roleName;
    }

    /**
     * @return mixed
     */
    public function getFirstDefaultScreen()
    {
        return $this->firstDefaultScreen;
    }

    /**
     * @param mixed $firstDefaultScreen
     */
    public function setFirstDefaultScreen($firstDefaultScreen)
    {
        $this->firstDefaultScreen = $firstDefaultScreen;
    }

    /**
     * @return mixed
     */
    public function getTransactions()
    {
        return $this->transactions;
    }

    /**
     * @param mixed $transactions
     */
    public function setTransactions($transactions)
    {
        $this->transactions = $transactions;
    }

    /**
     * @return mixed
     */
    public function getReports()
    {
        return $this->reports;
    }

    /**
     * @param mixed $reports
     */
    public function setReports($reports)
    {
        $this->reports = $reports;
    }

    /**
     * @return mixed
     */
    public function getHelp()
    {
        return $this->help;
    }

    /**
     * @param mixed $help
     */
    public function setHelp($help)
    {
        $this->help = $help;
    }

    /**
     * @return mixed
     */
    public function getMobileVTAcces()
    {
        return $this->mobileVTAcces;
    }

    /**
     * @param mixed $mobileVTAcces
     */
    public function setMobileVTAcces($mobileVTAcces)
    {
        $this->mobileVTAcces = $mobileVTAcces;
    }

    /**
     * @return mixed
     */
    public function getAdmin()
    {
        return $this->admin;
    }

    /**
     * @param mixed $admin
     */
    public function setAdmin($admin)
    {
        $this->admin = $admin;
    }

    /**
     * @return mixed
     */
    public function getCustomer()
    {
        return $this->customer;
    }

    /**
     * @param mixed $customer
     */
    public function setCustomer($customer)
    {
        $this->customer = $customer;
    }

    /**
     * @return mixed
     */
    public function getWebPosAccess()
    {
        return $this->webPosAccess;
    }

    /**
     * @param mixed $webPosAccess
     */
    public function setWebPosAccess($webPosAccess)
    {
        $this->webPosAccess = $webPosAccess;
    }



}

class Transactions
{
    public $checked;
    public $transactionOptions;

    public function __construct()
    {
    }
    public static function fromArray($data)
    {
        $settings = new Transactions();
        foreach ($data as $key => $value) {
            if (property_exists(get_class($settings), $key)) {
                if(is_array($value)) {
                    if ($key == "transactionOptions") {
                        $settings->{$key} = TransactionOptions::fromArray($value);
                    }
                }else {
                    $settings->{$key} = $value;
                }
            }
        }
        return $settings;
    }

    /**
     * @return mixed
     */
    public function getChecked()
    {
        return $this->checked;
    }

    /**
     * @param mixed $checked
     */
    public function setChecked($checked)
    {
        $this->checked = $checked;
    }

    /**
     * @return mixed
     */
    public function getTransactionOptions()
    {
        return $this->transactionOptions;
    }

    /**
     * @param mixed $transactionOptions
     */
    public function setTransactionOptions($transactionOptions)
    {
        $this->transactionOptions = $transactionOptions;
    }

}

class TransactionOptions{
    public $viewHostedShop;
    public $viewSubmitBatch;
    public $txtRefundupto;
    public $single;
    public $recurringBills;

    public static function fromArray($data)
    {
        $settings = new TransactionOptions();
        foreach ($data as $key => $value) {
            if (property_exists(get_class($settings), $key)) {
                if(is_array($value)) {
                    if ($key == "single") {
                        $settings->{$key} = Single::fromArray($value);
                    }
                    if ($key == "recurringBills") {
                        $settings->{$key} = RecurringBills::fromArray($value);
                    }
                }else {
                    $settings->{$key} = $value;
                }
            }
        }
        return $settings;
    }
    /**
     * UserRoles constructor.
     */
    public function __construct()
    {
    }

    /**
     * @return mixed
     */
    public function getViewHostedShop()
    {
        return $this->viewHostedShop;
    }

    /**
     * @param mixed $viewHostedShop
     */
    public function setViewHostedShop($viewHostedShop)
    {
        $this->viewHostedShop = $viewHostedShop;
    }

    /**
     * @return mixed
     */
    public function getViewSubmitBatch()
    {
        return $this->viewSubmitBatch;
    }

    /**
     * @param mixed $viewSubmitBatch
     */
    public function setViewSubmitBatch($viewSubmitBatch)
    {
        $this->viewSubmitBatch = $viewSubmitBatch;
    }

    /**
     * @return mixed
     */
    public function getTxtRefundupto()
    {
        return $this->txtRefundupto;
    }

    /**
     * @param mixed $txtRefundupto
     */
    public function setTxtRefundupto($txtRefundupto)
    {
        $this->txtRefundupto = $txtRefundupto;
    }

    /**
     * @return mixed
     */
    public function getSingle()
    {
        return $this->single;
    }

    /**
     * @param mixed $single
     */
    public function setSingle($single)
    {
        $this->single = $single;
    }

    /**
     * @return mixed
     */
    public function getRecurringBills()
    {
        return $this->recurringBills;
    }

    /**
     * @param mixed $recurringBills
     */
    public function setRecurringBills($recurringBills)
    {
        $this->recurringBills = $recurringBills;
    }


}
class Single
{
    public $checked;
    public $singleOptions;
    public static function fromArray($data)
    {
        $settings = new Single();
        foreach ($data as $key => $value) {
            if (property_exists(get_class($settings), $key)) {
                if(is_array($value)) {
                    if ($key == "singleOptions") {
                        $settings->{$key} = SingleOptions::fromArray($value);
                    }
                }else {
                    $settings->{$key} = $value;
                }
            }
        }
        return $settings;
    }
    /**
     * UserRoles constructor.
     */
    public function __construct()
    {
    }

    /**
     * @return mixed
     */
    public function getChecked()
    {
        return $this->checked;
    }

    /**
     * @param mixed $checked
     */
    public function setChecked($checked)
    {
        $this->checked = $checked;
    }

    /**
     * @return mixed
     */
    public function getSingleOptions()
    {
        return $this->singleOptions;
    }

    /**
     * @param mixed $singleOptions
     */
    public function setSingleOptions($singleOptions)
    {
        $this->singleOptions = $singleOptions;
    }

}
class SingleOptions{
    public $sales;
    public $refund;
    public static function fromArray($data)
    {
        $settings = new SingleOptions();

        foreach ($data as $key => $value) {
            if (property_exists(get_class($settings), $key)) {
                    $settings->{$key} = $value;
                }
        }
        return $settings;
    }
    /**
     * UserRoles constructor.
     */
    public function __construct()
    {
    }

    /**
     * @return mixed
     */
    public function getSales()
    {
        return $this->sales;
    }

    /**
     * @param mixed $sales
     */
    public function setSales($sales)
    {
        $this->sales = $sales;
    }

    /**
     * @return mixed
     */
    public function getRefund()
    {
        return $this->refund;
    }

    /**
     * @param mixed $refund
     */
    public function setRefund($refund)
    {
        $this->refund = $refund;
    }

}
class RecurringBills{
    public $checked;
    public $recurringBillOptions;
    public static function fromArray($data)
    {
        $settings = new RecurringBills();
        foreach ($data as $key => $value) {
            if (property_exists(get_class($settings), $key)) {
                if(is_array($value)) {
                    if ($key == "recurringBillOptions") {
                        $settings->{$key} = RecurringBillOptions::fromArray($value);
                    }
                }else {
                    $settings->{$key} = $value;
                }
            }
        }
        return $settings;
    }
    /**
     * UserRoles constructor.
     */
    public function __construct()
    {
    }

    /**
     * @return mixed
     */
    public function getChecked()
    {
        return $this->checked;
    }

    /**
     * @param mixed $checked
     */
    public function setChecked($checked)
    {
        $this->checked = $checked;
    }

    /**
     * @return mixed
     */
    public function getRecurringBillOptions()
    {
        return $this->recurringBillOptions;
    }

    /**
     * @param mixed $recurringBillOptions
     */
    public function setRecurringBillOptions($recurringBillOptions)
    {
        $this->recurringBillOptions = $recurringBillOptions;
    }

}
class RecurringBillOptions{
    public $edit;
    public $add;
    public $delete;
    public static function fromArray($data)
    {
        $settings = new RecurringBillOptions();
        foreach ($data as $key => $value) {
            if (property_exists(get_class($settings), $key)) {
                    $settings->{$key} = $value;
            }
        }
        return $settings;
    }
    /**
     * UserRoles constructor.
     */
    public function __construct()
    {
    }

    /**
     * @return mixed
     */
    public function getEdit()
    {
        return $this->edit;
    }

    /**
     * @param mixed $edit
     */
    public function setEdit($edit)
    {
        $this->edit = $edit;
    }

    /**
     * @return mixed
     */
    public function getAdd()
    {
        return $this->add;
    }

    /**
     * @param mixed $add
     */
    public function setAdd($add)
    {
        $this->add = $add;
    }

    /**
     * @return mixed
     */
    public function getDelete()
    {
        return $this->delete;
    }

    /**
     * @param mixed $delete
     */
    public function setDelete($delete)
    {
        $this->delete = $delete;
    }

}

class Reports{
    public $checked;
    public $reportOptions;
    public static function fromArray($data)
    {

        $settings = new Reports();
        foreach ($data as $key => $value) {
            if (property_exists(get_class($settings), $key)) {
                if(is_array($value)) {
                    if ($key == "reportOptions") {
                        $settings->{$key} = ReportOptions::fromArray($value);
                    }
                }else {
                    $settings->{$key} = $value;
                }
            }
        }

        return $settings;
    }
    /**
     * UserRoles constructor.
     */
    public function __construct()
    {
    }

    /**
     * @return mixed
     */
    public function getChecked()
    {
        return $this->checked;
    }

    /**
     * @param mixed $checked
     */
    public function setChecked($checked)
    {
        $this->checked = $checked;
    }

    /**
     * @return mixed
     */
    public function getReportOptions()
    {
        return $this->reportOptions;
    }

    /**
     * @param mixed $reportOptions
     */
    public function setReportOptions($reportOptions)
    {
        $this->reportOptions = $reportOptions;
    }

}
class ReportOptions
{
    public $standard;
    public $custom;

    public static function fromArray($data)
    {
        $settings = new ReportOptions();
        foreach ($data as $key => $value) {
            if (property_exists(get_class($settings), $key)) {
                if(is_array($value)) {
                    if ($key == "standard") {
                        $settings->{$key} = Standard::fromArray($value);
                    }
                }else {
                    $settings->{$key} = $value;
                }
            }
        }
        return $settings;
    }
    /**
     * UserRoles constructor.
     */
    public function __construct()
    {
    }

    /**
     * @return mixed
     */
    public function getStandard()
    {
        return $this->standard;
    }

    /**
     * @param mixed $standard
     */
    public function setStandard($standard)
    {
        $this->standard = $standard;
    }

    /**
     * @return mixed
     */
    public function getCustom()
    {
        return $this->custom;
    }

    /**
     * @param mixed $custom
     */
    public function setCustom($custom)
    {
        $this->custom = $custom;
    }

}
class Standard{
    public $checked;
    public $standardOptions;
    public static function fromArray($data)
    {
        $settings = new Standard();
        foreach ($data as $key => $value) {
            if (property_exists(get_class($settings), $key)) {
                if(is_array($value)) {
                    if ($key == "standardOptions") {
                        $settings->{$key} = StandardOptions::fromArray($value);
                    }
                }else {
                    $settings->{$key} = $value;
                }
            }
        }
        return $settings;
    }
    /**
     * UserRoles constructor.
     */
    public function __construct()
    {
    }

    /**
     * @return mixed
     */
    public function getChecked()
    {
        return $this->checked;
    }

    /**
     * @param mixed $checked
     */
    public function setChecked($checked)
    {
        $this->checked = $checked;
    }

    /**
     * @return mixed
     */
    public function getStandardOptions()
    {
        return $this->standardOptions;
    }

    /**
     * @param mixed $standardOptions
     */
    public function setStandardOptions($standardOptions)
    {
        $this->standardOptions = $standardOptions;
    }

}
class StandardOptions{
    public $product;
    public $recurrbill;
    public $users;
    public $transaction;
    public $batch;
    public $customer;

    public static function fromArray($data)
    {
        $settings = new StandardOptions();
        foreach ($data as $key => $value) {
            if (property_exists(get_class($settings), $key)) {
                    $settings->{$key} = $value;
            }
        }
        return $settings;
    }
    /**
     * UserRoles constructor.
     */
    public function __construct()
    {
    }

    /**
     * @return mixed
     */
    public function getProduct()
    {
        return $this->product;
    }

    /**
     * @param mixed $product
     */
    public function setProduct($product)
    {
        $this->product = $product;
    }

    /**
     * @return mixed
     */
    public function getRecurrbill()
    {
        return $this->recurrbill;
    }

    /**
     * @param mixed $recurrbill
     */
    public function setRecurrbill($recurrbill)
    {
        $this->recurrbill = $recurrbill;
    }

    /**
     * @return mixed
     */
    public function getUsers()
    {
        return $this->users;
    }

    /**
     * @param mixed $users
     */
    public function setUsers($users)
    {
        $this->users = $users;
    }

    /**
     * @return mixed
     */
    public function getTransaction()
    {
        return $this->transaction;
    }

    /**
     * @param mixed $transaction
     */
    public function setTransaction($transaction)
    {
        $this->transaction = $transaction;
    }

    /**
     * @return mixed
     */
    public function getBatch()
    {
        return $this->batch;
    }

    /**
     * @param mixed $batch
     */
    public function setBatch($batch)
    {
        $this->batch = $batch;
    }

    /**
     * @return mixed
     */
    public function getCustomer()
    {
        return $this->customer;
    }

    /**
     * @param mixed $customer
     */
    public function setCustomer($customer)
    {
        $this->customer = $customer;
    }

}

class Help{
    public $checked;
    public $helpOptions;
    public static function fromArray($data)
    {
        $settings = new Help();
        foreach ($data as $key => $value) {
            if (property_exists(get_class($settings), $key)) {
                if(is_array($value)) {
                    if ($key == "helpOptions") {
                        $settings->{$key} = HelpOptions::fromArray($value);
                    }
                }else {
                    $settings->{$key} = $value;
                }
            }
        }
        return $settings;
    }
    /**
     * UserRoles constructor.
     */
    public function __construct()
    {
    }

    /**
     * @return mixed
     */
    public function getChecked()
    {
        return $this->checked;
    }

    /**
     * @param mixed $checked
     */
    public function setChecked($checked)
    {
        $this->checked = $checked;
    }

    /**
     * @return mixed
     */
    public function getHelpOptions()
    {
        return $this->helpOptions;
    }

    /**
     * @param mixed $helpOptions
     */
    public function setHelpOptions($helpOptions)
    {
        $this->helpOptions = $helpOptions;
    }

}
class HelpOptions
{
    public $tickets;
    public static function fromArray($data)
    {
        $settings = new HelpOptions();
        foreach ($data as $key => $value) {
            if (property_exists(get_class($settings), $key)) {
                if ($key == "tickets") {
                    $settings->{$key} = Tickets::fromArray($value);
                }
            }
        }
        return $settings;
    }
    /**
     * UserRoles constructor.
     */
    public function __construct()
    {
    }

    /**
     * @return mixed
     */
    public function getTickets()
    {
        return $this->tickets;
    }

    /**
     * @param mixed $tickets
     */
    public function setTickets($tickets)
    {
        $this->tickets = $tickets;
    }

}
class Tickets{
    public $checked;
    public $ticketsOptions;
    public static function fromArray($data)
    {
        $settings = new Tickets();
        foreach ($data as $key => $value) {
            if (property_exists(get_class($settings), $key)) {
                if(is_array($value)) {
                    if ($key == "ticketsOptions") {
                        $settings->{$key} = TicketsOptions::fromArray($value);
                    }
                }else {
                    $settings->{$key} = $value;
                }
            }
        }
        return $settings;
    }
    /**
     * UserRoles constructor.
     */
    public function __construct()
    {
    }

    /**
     * @return mixed
     */
    public function getChecked()
    {
        return $this->checked;
    }

    /**
     * @param mixed $checked
     */
    public function setChecked($checked)
    {
        $this->checked = $checked;
    }

    /**
     * @return mixed
     */
    public function getTicketsOptions()
    {
        return $this->ticketsOptions;
    }

    /**
     * @param mixed $ticketsOptions
     */
    public function setTicketsOptions($ticketsOptions)
    {
        $this->ticketsOptions = $ticketsOptions;
    }

}
class TicketsOptions{
    public $add;
    public $edit;
    public static function fromArray($data)
    {
        $settings = new TicketsOptions();
        foreach ($data as $key => $value) {
            if (property_exists(get_class($settings), $key)) {
               $settings->{$key} = $value;
            }
        }
        return $settings;
    }
    /**
     * UserRoles constructor.
     */
    public function __construct()
    {
    }

    /**
     * @return mixed
     */
    public function getAdd()
    {
        return $this->add;
    }

    /**
     * @param mixed $add
     */
    public function setAdd($add)
    {
        $this->add = $add;
    }

    /**
     * @return mixed
     */
    public function getEdit()
    {
        return $this->edit;
    }

    /**
     * @param mixed $edit
     */
    public function setEdit($edit)
    {
        $this->edit = $edit;
    }

}

class MobileVTAcces
{
    public $checked;
    public static function fromArray($data)
    {
        $settings = new MobileVTAcces();
        foreach ($data as $key => $value) {
            if (property_exists(get_class($settings), $key)) {
                $settings->{$key} = $value;
            }
        }
        return $settings;
    }
    /**
     * UserRoles constructor.
     */
    public function __construct()
    {
    }

    /**
     * @return mixed
     */
    public function getChecked()
    {
        return $this->checked;
    }

    /**
     * @param mixed $checked
     */
    public function setChecked($checked)
    {
        $this->checked = $checked;
    }

}
class Admin
{
    public $checked;
    public $adminOptions;
    public static function fromArray($data)
    {
        $settings = new Admin();
        foreach ($data as $key => $value) {
            if (property_exists(get_class($settings), $key)) {
                if(is_array($value)) {
                    if ($key == "adminOptions") {
                        $settings->{$key} = AdminOptions::fromArray($value);
                    }
                }else {
                    $settings->{$key} = $value;
                }
            }
        }
        return $settings;
    }
    /**
     * UserRoles constructor.
     */
    public function __construct()
    {
    }

    /**
     * @return mixed
     */
    public function getChecked()
    {
        return $this->checked;
    }

    /**
     * @param mixed $checked
     */
    public function setChecked($checked)
    {
        $this->checked = $checked;
    }

    /**
     * @return mixed
     */
    public function getAdminOptions()
    {
        return $this->adminOptions;
    }

    /**
     * @param mixed $adminOptions
     */
    public function setAdminOptions($adminOptions)
    {
        $this->adminOptions = $adminOptions;
    }

}
class AdminOptions{
public $webposSetUp;
public $hostedShopCart;
public $product;
public $users;
public $riskAndFraud;
public $general;

    public static function fromArray($data)
    {
        $settings = new AdminOptions();
        foreach ($data as $key => $value) {

            if (property_exists(get_class($settings), $key)) {
                    if(is_array($value)) {
                        if ($key == "product") {
                            $settings->{$key} = Product::fromArray($value);
                        }
                        if ($key == "users") {
                            $settings->{$key} = Users::fromArray($value);
                        }
                        if ($key == "riskAndFraud") {
                            $settings->{$key} = RiskAndFraud::fromArray($value);
                        }
                        if ($key == "general") {
                            $settings->{$key} = General::fromArray($value);
                        }
                    }else {
                    $settings->{$key} = $value;
                }
            }
        }
        return $settings;
    }
    /**
     * UserRoles constructor.
     */
    public function __construct()
    {
    }

    /**
     * @return mixed
     */
    public function getWebposSetUp()
    {
        return $this->webposSetUp;
    }

    /**
     * @param mixed $webposSetUp
     */
    public function setWebposSetUp($webposSetUp)
    {
        $this->webposSetUp = $webposSetUp;
    }

    /**
     * @return mixed
     */
    public function getHostedShopCart()
    {
        return $this->hostedShopCart;
    }

    /**
     * @param mixed $hostedShopCart
     */
    public function setHostedShopCart($hostedShopCart)
    {
        $this->hostedShopCart = $hostedShopCart;
    }

    /**
     * @return mixed
     */
    public function getProduct()
    {
        return $this->product;
    }

    /**
     * @param mixed $product
     */
    public function setProduct($product)
    {
        $this->product = $product;
    }

    /**
     * @return mixed
     */
    public function getUsers()
    {
        return $this->users;
    }

    /**
     * @param mixed $users
     */
    public function setUsers($users)
    {
        $this->users = $users;
    }

    /**
     * @return mixed
     */
    public function getRiskAndFraud()
    {
        return $this->riskAndFraud;
    }

    /**
     * @param mixed $riskAndFraud
     */
    public function setRiskAndFraud($riskAndFraud)
    {
        $this->riskAndFraud = $riskAndFraud;
    }

    /**
     * @return mixed
     */
    public function getGeneral()
    {
        return $this->general;
    }

    /**
     * @param mixed $general
     */
    public function setGeneral($general)
    {
        $this->general = $general;
    }

}

class Product{
    public $checked;
    public $productOptions;
    public static function fromArray($data)
    {
        $settings = new Product();
        foreach ($data as $key => $value) {
            if (property_exists(get_class($settings), $key)) {
                if(is_array($value)) {
                    if ($key == "productOptions") {
                        $settings->{$key} = ProductOptions::fromArray($value);
                    }
                }else {
                    $settings->{$key} = $value;
                }
            }
        }

        return $settings;
    }
    /**
     * UserRoles constructor.
     */
    public function __construct()
    {
    }

    /**
     * @return mixed
     */
    public function getChecked()
    {
        return $this->checked;
    }

    /**
     * @param mixed $checked
     */
    public function setChecked($checked)
    {
        $this->checked = $checked;
    }

    /**
     * @return mixed
     */
    public function getProductOptions()
    {
        return $this->productOptions;
    }

    /**
     * @param mixed $productOptions
     */
    public function setProductOptions($productOptions)
    {
        $this->productOptions = $productOptions;
    }


}
class ProductOptions{
    public $edit;
    public $add;
    public $delete;
    public $bulkUpload;

    public static function fromArray($data)
    {
        $settings = new ProductOptions();
        foreach ($data as $key => $value) {
            if (property_exists(get_class($settings), $key)) {
               $settings->{$key} = $value;
            }
        }
        return $settings;
    }
    /**
     * UserRoles constructor.
     */
    public function __construct()
    {
    }

    /**
     * @return mixed
     */
    public function getEdit()
    {
        return $this->edit;
    }

    /**
     * @param mixed $edit
     */
    public function setEdit($edit)
    {
        $this->edit = $edit;
    }

    /**
     * @return mixed
     */
    public function getAdd()
    {
        return $this->add;
    }

    /**
     * @param mixed $add
     */
    public function setAdd($add)
    {
        $this->add = $add;
    }

    /**
     * @return mixed
     */
    public function getDelete()
    {
        return $this->delete;
    }

    /**
     * @param mixed $delete
     */
    public function setDelete($delete)
    {
        $this->delete = $delete;
    }

    /**
     * @return mixed
     */
    public function getBulkUpload()
    {
        return $this->bulkUpload;
    }

    /**
     * @param mixed $bulkUpload
     */
    public function setBulkUpload($bulkUpload)
    {
        $this->bulkUpload = $bulkUpload;
    }

}

class Users{
    public $checked;
    public $usersOptions;
    public static function fromArray($data)
    {
        $settings = new Users();
        foreach ($data as $key => $value) {
            if (property_exists(get_class($settings), $key)) {
                if(is_array($value)) {
                    if ($key == "usersOptions") {
                        $settings->{$key} = UsersOptions::fromArray($value);
                    }
                }else {
                    $settings->{$key} = $value;
                }
            }
        }
        return $settings;
    }
    /**
     * UserRoles constructor.
     */
    public function __construct()
    {
    }

    /**
     * @return mixed
     */
    public function getChecked()
    {
        return $this->checked;
    }

    /**
     * @param mixed $checked
     */
    public function setChecked($checked)
    {
        $this->checked = $checked;
    }

    /**
     * @return mixed
     */
    public function getUsersOptions()
    {
        return $this->usersOptions;
    }

    /**
     * @param mixed $usersOptions
     */
    public function setUsersOptions($usersOptions)
    {
        $this->usersOptions = $usersOptions;
    }

}
class UsersOptions
{
    public $deleteRole;
    public $manageRole;
    public $editRole;
    public $addRole;
    public $edit;
    public $add;
    public $delete;

    public static function fromArray($data)
    {
        $settings = new UsersOptions();
        foreach ($data as $key => $value) {
            if (property_exists(get_class($settings), $key)) {
                $settings->{$key} = $value;
            }
        }
        return $settings;
    }
    /**
     * UserRoles constructor.
     */
    public function __construct()
    {
    }

    /**
     * @return mixed
     */
    public function getDeleteRole()
    {
        return $this->deleteRole;
    }

    /**
     * @param mixed $deleteRole
     */
    public function setDeleteRole($deleteRole)
    {
        $this->deleteRole = $deleteRole;
    }

    /**
     * @return mixed
     */
    public function getManageRole()
    {
        return $this->manageRole;
    }

    /**
     * @param mixed $manageRole
     */
    public function setManageRole($manageRole)
    {
        $this->manageRole = $manageRole;
    }

    /**
     * @return mixed
     */
    public function getEditRole()
    {
        return $this->editRole;
    }

    /**
     * @param mixed $editRole
     */
    public function setEditRole($editRole)
    {
        $this->editRole = $editRole;
    }

    /**
     * @return mixed
     */
    public function getAddRole()
    {
        return $this->addRole;
    }

    /**
     * @param mixed $addRole
     */
    public function setAddRole($addRole)
    {
        $this->addRole = $addRole;
    }

    /**
     * @return mixed
     */
    public function getEdit()
    {
        return $this->edit;
    }

    /**
     * @param mixed $edit
     */
    public function setEdit($edit)
    {
        $this->edit = $edit;
    }

    /**
     * @return mixed
     */
    public function getAdd()
    {
        return $this->add;
    }

    /**
     * @param mixed $add
     */
    public function setAdd($add)
    {
        $this->add = $add;
    }

    /**
     * @return mixed
     */
    public function getDelete()
    {
        return $this->delete;
    }

    /**
     * @param mixed $delete
     */
    public function setDelete($delete)
    {
        $this->delete = $delete;
    }

}

class RiskAndFraud{
    public $checked;
    public $riskAndFraudOptions;
    public static function fromArray($data)
    {
        $settings = new RiskAndFraud();
        foreach ($data as $key => $value) {
            if (property_exists(get_class($settings), $key)) {
                if(is_array($value)) {
                    if ($key == "usersOptions") {
                        $settings->{$key} = RiskAndFraudOptions::fromArray($value);
                    }
                }else {
                    $settings->{$key} = $value;
                }
            }
        }
        return $settings;
    }
    /**
     * UserRoles constructor.
     */
    public function __construct()
    {
    }

    /**
     * @return mixed
     */
    public function getChecked()
    {
        return $this->checked;
    }

    /**
     * @param mixed $checked
     */
    public function setChecked($checked)
    {
        $this->checked = $checked;
    }

    /**
     * @return mixed
     */
    public function getRiskAndFraudOptions()
    {
        return $this->riskAndFraudOptions;
    }

    /**
     * @param mixed $riskAndFraudOptions
     */
    public function setRiskAndFraudOptions($riskAndFraudOptions)
    {
        $this->riskAndFraudOptions = $riskAndFraudOptions;
    }

}
class RiskAndFraudOptions
{
public $riskfraudSetting;
public $riskfraudFlagTrn;

    public static function fromArray($data)
    {
        $settings = new RiskAndFraudOptions();
        foreach ($data as $key => $value) {
            if (property_exists(get_class($settings), $key)) {
                $settings->{$key} = $value;
            }
        }
        return $settings;
    }
    /**
     * UserRoles constructor.
     */
    public function __construct()
    {
    }

    /**
     * @return mixed
     */
    public function getRiskfraudSetting()
    {
        return $this->riskfraudSetting;
    }

    /**
     * @param mixed $riskfraudSetting
     */
    public function setRiskfraudSetting($riskfraudSetting)
    {
        $this->riskfraudSetting = $riskfraudSetting;
    }

    /**
     * @return mixed
     */
    public function getRiskfraudFlagTrn()
    {
        return $this->riskfraudFlagTrn;
    }

    /**
     * @param mixed $riskfraudFlagTrn
     */
    public function setRiskfraudFlagTrn($riskfraudFlagTrn)
    {
        $this->riskfraudFlagTrn = $riskfraudFlagTrn;
    }

}

class General{
    public $checked;
    public $generalOptions;

    public static function fromArray($data)
    {
        $settings = new General();
        foreach ($data as $key => $value) {
            if (property_exists(get_class($settings), $key)) {
                if(is_array($value)) {
                    if ($key == "generalOptions") {
                        $settings->{$key} = GeneralOptions::fromArray($value);
                    }
                }else {
                    $settings->{$key} = $value;
                }
            }
        }
        return $settings;
    }
    /**
     * UserRoles constructor.
     */
    public function __construct()
    {
    }

    /**
     * @return mixed
     */
    public function getChecked()
    {
        return $this->checked;
    }

    /**
     * @param mixed $checked
     */
    public function setChecked($checked)
    {
        $this->checked = $checked;
    }

    /**
     * @return mixed
     */
    public function getGeneralOptions()
    {
        return $this->generalOptions;
    }

    /**
     * @param mixed $generalOptions
     */
    public function setGeneralOptions($generalOptions)
    {
        $this->generalOptions = $generalOptions;
    }

}
class GeneralOptions
{
    public $validateDev;
    public $thirdParyApi;
    public $shippingTax;
    public $branding;
    public $generalSetting;

    public static function fromArray($data)
    {
        $settings = new GeneralOptions();
        foreach ($data as $key => $value) {
            if (property_exists(get_class($settings), $key)) {
               $settings->{$key} = $value;
            }
        }
        return $settings;
    }
    /**
     * UserRoles constructor.
     */
    public function __construct()
    {
    }

    /**
     * @return mixed
     */
    public function getValidateDev()
    {
        return $this->validateDev;
    }

    /**
     * @param mixed $validateDev
     */
    public function setValidateDev($validateDev)
    {
        $this->validateDev = $validateDev;
    }

    /**
     * @return mixed
     */
    public function getThirdParyApi()
    {
        return $this->thirdParyApi;
    }

    /**
     * @param mixed $thirdParyApi
     */
    public function setThirdParyApi($thirdParyApi)
    {
        $this->thirdParyApi = $thirdParyApi;
    }

    /**
     * @return mixed
     */
    public function getShippingTax()
    {
        return $this->shippingTax;
    }

    /**
     * @param mixed $shippingTax
     */
    public function setShippingTax($shippingTax)
    {
        $this->shippingTax = $shippingTax;
    }

    /**
     * @return mixed
     */
    public function getBranding()
    {
        return $this->branding;
    }

    /**
     * @param mixed $branding
     */
    public function setBranding($branding)
    {
        $this->branding = $branding;
    }

    /**
     * @return mixed
     */
    public function getGeneralSetting()
    {
        return $this->generalSetting;
    }

    /**
     * @param mixed $generalSetting
     */
    public function setGeneralSetting($generalSetting)
    {
        $this->generalSetting = $generalSetting;
    }

}

class Customers
{
public $checked;
public $customerOptions;
    public static function fromArray($data)
    {
        $settings = new Customers();
        foreach ($data as $key => $value) {
            if (property_exists(get_class($settings), $key)) {
                if(is_array($value)) {
                    if ($key == "customerOptions") {
                        $settings->{$key} = CustomerOptions::fromArray($value);
                    }
                }else {
                    $settings->{$key} = $value;
                }
            }
        }
        return $settings;
    }
    /**
     * UserRoles constructor.
     */
    public function __construct()
    {
    }

    /**
     * @return mixed
     */
    public function getChecked()
    {
        return $this->checked;
    }

    /**
     * @param mixed $checked
     */
    public function setChecked($checked)
    {
        $this->checked = $checked;
    }

    /**
     * @return mixed
     */
    public function getCustomerOptions()
    {
        return $this->customerOptions;
    }

    /**
     * @param mixed $customerOptions
     */
    public function setCustomerOptions($customerOptions)
    {
        $this->customerOptions = $customerOptions;
    }

}
class CustomerOptions
{
    public $add;
    public $edit;
    public $delete;

    public static function fromArray($data)
    {
        $settings = new CustomerOptions();
        foreach ($data as $key => $value) {
            if (property_exists(get_class($settings), $key)) {
                $settings->{$key} = $value;
            }
        }
        return $settings;
    }
    /**
     * UserRoles constructor.
     */
    public function __construct()
    {
    }

    /**
     * @return mixed
     */
    public function getAdd()
    {
        return $this->add;
    }

    /**
     * @param mixed $add
     */
    public function setAdd($add)
    {
        $this->add = $add;
    }

    /**
     * @return mixed
     */
    public function getEdit()
    {
        return $this->edit;
    }

    /**
     * @param mixed $edit
     */
    public function setEdit($edit)
    {
        $this->edit = $edit;
    }

    /**
     * @return mixed
     */
    public function getDelete()
    {
        return $this->delete;
    }

    /**
     * @param mixed $delete
     */
    public function setDelete($delete)
    {
        $this->delete = $delete;
    }

}
class WebPosAccess
{
    public $checked;
    public $webPosAccessOptions;

    public static function fromArray($data)
    {
        $settings = new WebPosAccess();
        foreach ($data as $key => $value) {
            if (property_exists(get_class($settings), $key)) {
                if(is_array($value)) {
                    if ($key == "webPosAccessOptions") {
                        $settings->{$key} = WebPosAccessOptions::fromArray($value);
                    }
                }else {
                    $settings->{$key} = $value;
                }
            }
        }
        return $settings;
    }
    /**
     * UserRoles constructor.
     */
    public function __construct()
    {
    }

    /**
     * @return mixed
     */
    public function getChecked()
    {
        return $this->checked;
    }

    /**
     * @param mixed $checked
     */
    public function setChecked($checked)
    {
        $this->checked = $checked;
    }

    /**
     * @return mixed
     */
    public function getWebPosAccessOptions()
    {
        return $this->webPosAccessOptions;
    }

    /**
     * @param mixed $webPosAccessOptions
     */
    public function setWebPosAccessOptions($webPosAccessOptions)
    {
        $this->webPosAccessOptions = $webPosAccessOptions;
    }

}
class WebPosAccessOptions
{
    public $quitPos;
    public $manualPriceChange;
    public $admin;
    public static function fromArray($data)
    {
        $settings = new WebPosAccessOptions();
        foreach ($data as $key => $value) {
            if (property_exists(get_class($settings), $key)) {
                if(is_array($value)) {
                    if ($key == "admin") {
                        $settings->{$key} = AdminWebPos::fromArray($value);
                    }
                }else {
                    $settings->{$key} = $value;
                }
            }
        }
        return $settings;
    }
    /**
     * UserRoles constructor.
     */
    public function __construct()
    {
    }

    /**
     * @return mixed
     */
    public function getQuitPos()
    {
        return $this->quitPos;
    }

    /**
     * @param mixed $quitPos
     */
    public function setQuitPos($quitPos)
    {
        $this->quitPos = $quitPos;
    }

    /**
     * @return mixed
     */
    public function getManualPriceChange()
    {
        return $this->manualPriceChange;
    }

    /**
     * @param mixed $manualPriceChange
     */
    public function setManualPriceChange($manualPriceChange)
    {
        $this->manualPriceChange = $manualPriceChange;
    }

    /**
     * @return mixed
     */
    public function getAdmin()
    {
        return $this->admin;
    }

    /**
     * @param mixed $admin
     */
    public function setAdmin($admin)
    {
        $this->admin = $admin;
    }

}
class AdminWebPos
{
    public $checked;
    public $adminOptions;
    public static function fromArray($data)
    {
        $settings = new AdminWebPos();
        foreach ($data as $key => $value) {
            if (property_exists(get_class($settings), $key)) {
                if(is_array($value)) {
                    if ($key == "adminOptions") {
                        $settings->{$key} = AdminWebPosOptions::fromArray($value);
                    }
                }else {
                    $settings->{$key} = $value;
                }
            }
        }
        return $settings;
    }
    /**
     * UserRoles constructor.
     */
    public function __construct()
    {
    }

    /**
     * @return mixed
     */
    public function getChecked()
    {
        return $this->checked;
    }

    /**
     * @param mixed $checked
     */
    public function setChecked($checked)
    {
        $this->checked = $checked;
    }

    /**
     * @return mixed
     */
    public function getAdminOptions()
    {
        return $this->adminOptions;
    }

    /**
     * @param mixed $adminOptions
     */
    public function setAdminOptions($adminOptions)
    {
        $this->adminOptions = $adminOptions;
    }


}
class AdminWebPosOptions
{
    public $hotKey;
    public $deviceList;
    public $generalSettings;
    public $tills;
    public $display;
    public $customPrompt;
    public $customMessage;

    public static function fromArray($data)
    {
        $settings = new AdminWebPosOptions();
        foreach ($data as $key => $value) {
            if (property_exists(get_class($settings), $key)) {
                $settings->{$key} = $value;
            }
        }
        return $settings;
    }

    /**
     * UserRoles constructor.
     */
    public function __construct()
    {
    }

    /**
     * @return mixed
     */
    public function getHotKey()
    {
        return $this->hotKey;
    }

    /**
     * @param mixed $hotKey
     */
    public function setHotKey($hotKey)
    {
        $this->hotKey = $hotKey;
    }

    /**
     * @return mixed
     */
    public function getDeviceList()
    {
        return $this->deviceList;
    }

    /**
     * @param mixed $deviceList
     */
    public function setDeviceList($deviceList)
    {
        $this->deviceList = $deviceList;
    }

    /**
     * @return mixed
     */
    public function getGeneralSettings()
    {
        return $this->generalSettings;
    }

    /**
     * @param mixed $generalSettings
     */
    public function setGeneralSettings($generalSettings)
    {
        $this->generalSettings = $generalSettings;
    }

    /**
     * @return mixed
     */
    public function getTills()
    {
        return $this->tills;
    }

    /**
     * @param mixed $tills
     */
    public function setTills($tills)
    {
        $this->tills = $tills;
    }

    /**
     * @return mixed
     */
    public function getDisplay()
    {
        return $this->display;
    }

    /**
     * @param mixed $display
     */
    public function setDisplay($display)
    {
        $this->display = $display;
    }

    /**
     * @return mixed
     */
    public function getCustomPrompt()
    {
        return $this->customPrompt;
    }

    /**
     * @param mixed $customPrompt
     */
    public function setCustomPrompt($customPrompt)
    {
        $this->customPrompt = $customPrompt;
    }

    /**
     * @return mixed
     */
    public function getCustomMessage()
    {
        return $this->customMessage;
    }

    /**
     * @param mixed $customMessage
     */
    public function setCustomMessage($customMessage)
    {
        $this->customMessage = $customMessage;
    }

}