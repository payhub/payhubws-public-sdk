using System.Runtime.Serialization;
using System;
using System.Globalization;

namespace PayHubSDK.com.payhub.ws.model
{
    ///  @author Agustin Breit 
    /// 
    [DataContract]
	public class TransactionAmount 
	{
		///  
		/// 
		private static readonly long serialVersionUID = -635976989093261428L;

		private static readonly string CURRENCY_CODE= "en-US";

       // public static readonly Currency USD = new Currency.getInstance("USD");

		//private string currency = USD.getCurrencyCode();
        [DataMember]
        private decimal amount;
        
        public decimal Amount { 
            get { return this.amount; }
            set
            {this.amount = value;}
        }

        //private CultureInfo culture = CultureInfo.GetCultureInfo("en-US");
       
        private NumberFormatInfo USD = NumberFormatInfo.GetInstance(CultureInfo.GetCultureInfo("en-US"));



        public void setTransactionAmount(decimal amount, NumberFormatInfo USD)
        {
            // TODO: Complete member initialization
            this.amount = amount;
            this.USD = USD;
        }
        public TransactionAmount(decimal amount){
             setTransactionAmount(amount, NumberFormatInfo.GetInstance(CultureInfo.GetCultureInfo("en-US")));
        }
    }

}

