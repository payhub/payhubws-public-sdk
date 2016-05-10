using PayHubWS;
using PayHubWS.Samples;
using PayHubWS_sample_app.Samples;
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
            EmailConfigurationSample lists = new EmailConfigurationSample();
            lists.getAndPatchEmailConfiguration();
        }
    }
}
