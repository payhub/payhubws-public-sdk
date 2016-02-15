/**
 * 
 */
package com.payhub.ws.vt;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author agustin
 *
 */
public class RiskFraudSettings {
	public static final String RISK_FRAUD_SETTINGS_LINK="adminSettings/riskFraudDetection";
	public static final String RISK_FRAUD_PATCH_SETTINGS_LINK = "adminSettings/riskFraudDetection";
	private TrnVolSet transaction_volume_settings;
	 private CardFiltering card_filtering;
	 private RiskEmail email;
	 private CreditCardSecurityCodes credit_card_security_codes;
	 private Avs address_verification_system;
	
	public RiskFraudSettings(){
		
	}
	public static class OptionAndValue{
		private float value;

		private int option;
		
		
		public OptionAndValue() {
		}
		/**
		 * @return the value
		 */
		public float getValue() {
			return value;
		}
		/**
		 * @param value the value to set
		 */
		public void setValue(float value) {
			this.value = value;
		}
		/**
		 * @return the option
		 */
		public int getOption() {
			return option;
		}
		/**
		 * @param option the option to set
		 * @throws Exception 
		 */
		public void setOption(int option) throws Exception {
			if(option>=1 && option<=3){
			this.option = option;
			}else{
				throw new Exception("Option must be between 1 and 3");
			}
		}

		
		
	}
	public static class TrnVolSet{
		private OptionAndValue refund_trn_amount_below;
		private OptionAndValue hours_trn_number_more_than;
		private OptionAndValue days_trn_amount_more_than;
		private OptionAndValue sale_trn_amount_below;
		private OptionAndValue refund_trn_amount_above;
		private OptionAndValue days_trn_number_more_than;
		private OptionAndValue sale_trn_amount_above;
		private boolean checked;
		public TrnVolSet() {
		}
		
		/**
		 * @return the refund_trn_amount_below
		 */
		public OptionAndValue getRefund_trn_amount_below() {
			return refund_trn_amount_below;
		}
		/**
		 * @param refund_trn_amount_below the refund_trn_amount_below to set
		 */
		public void setRefund_trn_amount_below(OptionAndValue refund_trn_amount_below) {
			this.refund_trn_amount_below = refund_trn_amount_below;
		}
		/**
		 * @return the hours_trn_number_more_than
		 */
		public OptionAndValue getHours_trn_number_more_than() {
			return hours_trn_number_more_than;
		}
		/**
		 * @param hours_trn_number_more_than the hours_trn_number_more_than to set
		 */
		public void setHours_trn_number_more_than(OptionAndValue hours_trn_number_more_than) {
			this.hours_trn_number_more_than = hours_trn_number_more_than;
		}
		/**
		 * @return the days_trn_amount_more_than
		 */
		public OptionAndValue getDays_trn_amount_more_than() {
			return days_trn_amount_more_than;
		}
		/**
		 * @param days_trn_amount_more_than the days_trn_amount_more_than to set
		 */
		public void setDays_trn_amount_more_than(OptionAndValue days_trn_amount_more_than) {
			this.days_trn_amount_more_than = days_trn_amount_more_than;
		}
		/**
		 * @return the sale_trn_amount_below
		 */
		public OptionAndValue getSale_trn_amount_below() {
			return sale_trn_amount_below;
		}
		/**
		 * @param sale_trn_amount_below the sale_trn_amount_below to set
		 */
		public void setSale_trn_amount_below(OptionAndValue sale_trn_amount_below) {
			this.sale_trn_amount_below = sale_trn_amount_below;
		}
		/**
		 * @return the refund_trn_amount_above
		 */
		public OptionAndValue getRefund_trn_amount_above() {
			return refund_trn_amount_above;
		}
		/**
		 * @param refund_trn_amount_above the refund_trn_amount_above to set
		 */
		public void setRefund_trn_amount_above(OptionAndValue refund_trn_amount_above) {
			this.refund_trn_amount_above = refund_trn_amount_above;
		}
		/**
		 * @return the days_trn_number_more_than
		 */
		public OptionAndValue getDays_trn_number_more_than() {
			return days_trn_number_more_than;
		}
		/**
		 * @param days_trn_number_more_than the days_trn_number_more_than to set
		 */
		public void setDays_trn_number_more_than(OptionAndValue days_trn_number_more_than) {
			this.days_trn_number_more_than = days_trn_number_more_than;
		}
		/**
		 * @return the sale_trn_amount_above
		 */
		public OptionAndValue getSale_trn_amount_above() {
			return sale_trn_amount_above;
		}
		/**
		 * @param sale_trn_amount_above the sale_trn_amount_above to set
		 */
		public void setSale_trn_amount_above(OptionAndValue sale_trn_amount_above) {
			this.sale_trn_amount_above = sale_trn_amount_above;
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
	public static class CardFiltering{
		private boolean checked;
		public CardFiltering() {
			super();
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
	public static class RiskEmail{
		private static final String EMAIL_ADDRESS_REGEX = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,4})$";
		private Pattern pattern;
		private Matcher matcher;
		private boolean checked;
		
		private String email_address;
		
		public RiskEmail() {
			super();
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
		 * @return the email_address
		 */
		public String getEmail_address() {
			return email_address;
		}
		/**
		 * @param email_address the email_address to set
		 */
		public void setEmail_address(String email_address) throws Exception {
			boolean valid = validate(email_address);
			if(valid){
				this.email_address = email_address;	
			}else{
				throw new Exception("Enter an valid Email address");
			}
			
		}
		public boolean validate(final String hex) {
			pattern = Pattern.compile(EMAIL_ADDRESS_REGEX);
			
			matcher = pattern.matcher(hex);
			return matcher.matches();

		}
		
	}
	public static class CreditCardSecurityCodes{
		private OptionAndValue cvv_mismatch;
		private boolean checked;
		
		public CreditCardSecurityCodes() {
			super();
		}
		/**
		 * @return the cvv_mismatch
		 */
		public OptionAndValue getCvv_mismatch() {
			return cvv_mismatch;
		}
		/**
		 * @param cvv_mismatch the cvv_mismatch to set
		 */
		public void setCvv_mismatch(OptionAndValue cvv_mismatch) {
			this.cvv_mismatch = cvv_mismatch;
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
	public static class Avs{
		private OptionAndValue avs_mismatch_street_and_zip_code;
		private OptionAndValue avs_mismatch_street;
		private OptionAndValue avs_mismatch_zip_code;
		private boolean checked;
		
		public Avs() {
			super();
		}
		/**
		 * @return the avs_mismatch_street_and_zip_code
		 */
		public OptionAndValue getAvs_mismatch_street_and_zip_code() {
			return avs_mismatch_street_and_zip_code;
		}
		/**
		 * @param avs_mismatch_street_and_zip_code the avs_mismatch_street_and_zip_code to set
		 */
		public void setAvs_mismatch_street_and_zip_code(OptionAndValue avs_mismatch_street_and_zip_code) {
			this.avs_mismatch_street_and_zip_code = avs_mismatch_street_and_zip_code;
		}
		/**
		 * @return the avs_mismatch_street
		 */
		public OptionAndValue getAvs_mismatch_street() {
			return avs_mismatch_street;
		}
		/**
		 * @param avs_mismatch_street the avs_mismatch_street to set
		 */
		public void setAvs_mismatch_street(OptionAndValue avs_mismatch_street) {
			this.avs_mismatch_street = avs_mismatch_street;
		}
		/**
		 * @return the avs_mismatch_zip_code
		 */
		public OptionAndValue getAvs_mismatch_zip_code() {
			return avs_mismatch_zip_code;
		}
		/**
		 * @param avs_mismatch_zip_code the avs_mismatch_zip_code to set
		 */
		public void setAvs_mismatch_zip_code(OptionAndValue avs_mismatch_zip_code) {
			this.avs_mismatch_zip_code = avs_mismatch_zip_code;
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
	

	 /**
	 * @return the transaction_volume_settings
	 */
	public TrnVolSet getTransaction_volume_settings() {
		return transaction_volume_settings;
	}
	/**
	 * @param transaction_volume_settings the transaction_volume_settings to set
	 */
	public void setTransaction_volume_settings(TrnVolSet transaction_volume_settings) {
		this.transaction_volume_settings = transaction_volume_settings;
	}
	/**
	 * @return the card_filtering
	 */
	public CardFiltering getCard_filtering() {
		return card_filtering;
	}
	/**
	 * @param card_filtering the card_filtering to set
	 */
	public void setCard_filtering(CardFiltering card_filtering) {
		this.card_filtering = card_filtering;
	}
	/**
	 * @return the email
	 */
	public RiskEmail getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(RiskEmail email) {
		this.email = email;
	}
	/**
	 * @return the credit_card_security_codes
	 */
	public CreditCardSecurityCodes getCredit_card_security_codes() {
		return credit_card_security_codes;
	}
	/**
	 * @param credit_card_security_codes the credit_card_security_codes to set
	 */
	public void setCredit_card_security_codes(CreditCardSecurityCodes credit_card_security_codes) {
		this.credit_card_security_codes = credit_card_security_codes;
	}
	/**
	 * @return the address_verification_system
	 */
	public Avs getAddress_verification_system() {
		return address_verification_system;
	}
	/**
	 * @param address_verification_system the address_verification_system to set
	 */
	public void setAddress_verification_system(Avs address_verification_system) {
		this.address_verification_system = address_verification_system;
	}
	
	public String toString(){
		ObjectMapper mapper = new ObjectMapper();
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        String jsonInString;
		try {
			jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(this);
			return jsonInString;
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			return null;
		}
        
	}
}
