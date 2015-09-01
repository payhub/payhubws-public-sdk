using PayHubSDK.com.payhub.ws.api;
using PayHubSDK.com.payhub.ws.model;
using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Net;
using System.Text;
using System.Threading.Tasks;
using System.Globalization;


namespace PayHubWS
{
    class RecurringBillingSample
    {
        public void doRecurringBilling()
        {
            string url = "https://staging-api.payhub.com/api/v2/";
            string oauth = "107d74ab-4a18-4713-88ff-69bd05710086";
            ScheduleSartAndEnd scheduleSartAndEnd = new ScheduleSartAndEnd();
            scheduleSartAndEnd.Start_date = Convert.ToDateTime("2015-07-08");
            scheduleSartAndEnd.End_date = Convert.ToDateTime("2016-07-08");
            scheduleSartAndEnd.end_date_type = "O";
            MontlySchedule montlySchedule = new MontlySchedule();
            montlySchedule.Monthly_type = "E";
            List<int> m = new List<int>();
            m.Add(15);
            montlySchedule.Monthly_each_days = m;
            Schedule schedule = new Schedule(scheduleSartAndEnd, montlySchedule);
            schedule.Schedule_type = "M";
            schedule.Bill_generation_interval = 1;
            Merchant merchant = new Merchant();
            merchant.organization_id = 10127;
            merchant.terminal_id = 215;
            Bill bill = new Bill();
            bill.Base_amount = (decimal)19.99m;
            CardData card_data = new CardData();            
            card_data.card_number = "4012881888818888";
            card_data.card_expiry_date = "202012"; //September 2018
            card_data.billing_zip = "60527";
            Customer customer = new Customer();
            customer.first_name = "Joe";
            customer.last_name = "Tester";
            customer.phone_number = "844-217-1631";
            customer.phone_type = "W";
            RecurringBill recurringBill = new RecurringBill(merchant,card_data,customer,schedule,bill);
            recurringBill.Merchant = merchant;
            recurringBill.Card_data = card_data;
            recurringBill.Customer = customer;
            recurringBill.Schedule = schedule;
            recurringBill.Bill = bill;
            TransactionManager transaction = new TransactionManager(url, oauth, merchant);
            RecurringBillInformation response = transaction.doRecurringBill(recurringBill);
            Console.Write(response.rowData);
        }
    }
}
