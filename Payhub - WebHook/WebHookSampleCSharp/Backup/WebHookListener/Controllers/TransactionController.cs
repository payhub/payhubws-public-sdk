using System;
using System.Net;
using System.Net.Http;
using System.Web;
using System.Web.Http;
using WebHookListener.Models;
using Newtonsoft.Json.Linq;
using System.IO;

namespace WebHookListener.Controllers
{
    public class TransactionController : ApiController
    {
        [HttpPost]
        public HttpResponseMessage Post(JObject jsonData)
        {
            try
            {
               // dynamic json = jsonData;
               /* JObject jTransaction = json.transaction;

                var transaction = jTransaction.ToObject<Transaction>();
                var response = Request.CreateResponse<Transaction>(System.Net.HttpStatusCode.Created, transaction);
                string transactionText = "";
                transactionText = "Transaction Id: " + transaction.transactionId + 
                    " Transaction Type: " + transaction.transactionType + "."+
                    " Card Obscured: " + transaction.cardObscured + "."+
                    " Response Text: " + transaction.responseText + "."+
                    " Source: " + transaction.source + "."+
                    " Org Id: " + transaction.orgId + "."+
                    " Response Code: " + transaction.responseCode + ".";*/

                string path = @"C:\Transactions.txt";
                // This text is added only once to the file.
                if (!File.Exists(path))
                {
                    // Create a file to write to.
                    using (StreamWriter sw = File.CreateText(path))
                    {
                        sw.WriteLine(jsonData);
                    }
                }

                else
                {
                    using (StreamWriter sw = File.AppendText(path))
                    {
                        sw.WriteLine(jsonData);
                    }
                }
               	
                var response = Request.CreateResponse<JObject>(System.Net.HttpStatusCode.Created, jsonData);
                return response;
            }
            catch (Exception e)
            {
                HttpStatusCode badRequest= HttpStatusCode.BadRequest;
                return new HttpResponseMessage(badRequest);
            }
            
        }

    }
}