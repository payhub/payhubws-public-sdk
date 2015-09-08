using PayHubSDK.com.payhub.ws.api;
using PayHubSDK.com.payhub.ws.model;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace PayHubWS
{
    class RecurringBillStatusSample
    {
        public void updateStatus()
        {
            string url = "http://localhost:8251/payhubws/api/v2/";
            string oauth = "af28ce9b-7366-4dfa-b643-44e9897ebc2b";
            ScheduleSartAndEnd scheduleSartAndEnd = new ScheduleSartAndEnd();
            scheduleSartAndEnd.Start_date = Convert.ToDateTime("2015-09-08");
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
            merchant.organization_id = 10002;
            merchant.terminal_id = 2;
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
            RecurringBill recurringBill = new RecurringBill(merchant, card_data, customer, schedule, bill);
            recurringBill.Merchant = merchant;
            recurringBill.Card_data = card_data;
            recurringBill.Customer = customer;
            recurringBill.Schedule = schedule;
            recurringBill.Bill = bill;
            TransactionManager transaction = new TransactionManager(url, oauth, merchant);
            RecurringBillInformation response = transaction.doRecurringBill(recurringBill);
            if (response.errors == null) {
                var id = response.lastRecurringBillResponse.RecurringBillId.ToString();
                var update = transaction.updateRecurringBillStatus(id);
                if (update)
                {
                    RecurringBillInformation responseUpdated = transaction.getRecurringBillInformation(id);
                    if (responseUpdated.errors == null)
                    {
                        Console.Write(responseUpdated.rowData);
                    }
                }
            }
          
        }
    }
}
