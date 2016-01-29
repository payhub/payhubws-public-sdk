using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace WebHookListener.Models
{
    public class Transaction
    {
        public string transactionType { get; set; }

        public string recurringBillId { get; set; }

        public string cardObscured { get; set; }

        public string responseText { get; set; }

        public string source { get; set; }

        public string orgId { get; set; }

        public string transactionId { get; set; }

        public string responseCode { get; set; }
    }
}