﻿using PayHubWS.Samples;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace PayHubWS_sample_app
{
    class Program
    {
        static void Main(string[] args)
        {
            TransactionReportSample sale = new TransactionReportSample();
            sale.findReports();
        }
    }
}
