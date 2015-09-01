/**
 * 
 */
package com.payhub.ws.model;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @author agustin
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL) 
public class CardData {
	protected static final long serialVersionUID = -1025520346816831812L;

	public static final String CARD_NUMBER_FIELD = "card_number";
	public static final String CARD_EXPIRY_DATE_FIELD = "card_expiry_date";
	public static final String TRACK1_DATA_FIELD = "track1_data";
	public static final String TRACK2_DATA_FIELD = "track2_data";
	public static final String ENCRYPTED_DATA_FIELD = "encrypted_track_data";
	public static final String TOKENIZED_CARD_DATA_FIELD = "tokenized_card";
	public static final String CVV_FIELD = "cvv_data";
	public static final String CARD_EXPIRY_REGEX = "2[0-9][0-9]{2}(0[1-9]|1[0-2])";
	private static final String ZIP_REG_EX = "^\\d{5}(?:[-\\s]\\d{4})?$";
	
	private String cvv_data;
	private String track1_data = null;
	private String track2_data = null;
	private EncryptedTrackData encrypted_track_data = null;
	private String card_number;
	private String card_expiry_date;
	private String tokenized_card;
	private String billing_address_1;
	private String billing_address_2;
	private String billing_city;
	private String billing_state;
	private String billing_zip;

	public String getCard_number() {
		return card_number;
	}

	public void setCard_number(String card_number) {
		this.card_number = card_number;
	}

	public String getCard_expiry_date() {
		return card_expiry_date;
	}

	public void setCard_expiry_date(String card_expiry_date) {
		this.card_expiry_date = card_expiry_date;
	}

	public String getTokenized_card() {
		return tokenized_card;
	}

	public void setTokenized_card(String tokenized_card) {
		this.tokenized_card = tokenized_card;
	}

	public String getBilling_address_1() {
		return billing_address_1;
	}

	public void setBilling_address_1(String billing_address_1) {
		this.billing_address_1 = billing_address_1;
	}

	public String getBilling_address_2() {
		return billing_address_2;
	}

	public void setBilling_address_2(String billing_address_2) {
		this.billing_address_2 = billing_address_2;
	}

	public String getBilling_city() {
		return billing_city;
	}

	public void setBilling_city(String billing_city) {
		this.billing_city = billing_city;
	}

	public String getBilling_state() {
		return billing_state;
	}

	public void setBilling_state(String billing_state) {
		this.billing_state = billing_state;
	}

	public String getBilling_zip() {
		return billing_zip;
	}

	public void setBilling_zip(String billing_zip) {
		this.billing_zip = billing_zip;
	}

	public String getCvv_data() {
		return cvv_data;
	}

	public void setCvv_data(String cvv_data) {
		this.cvv_data = cvv_data;
	}


	public String getTrack1_data() {
		return track1_data;
	}

	public void setTrack1_data(String track1_data) {
		this.track1_data = track1_data;
	}

	public String getTrack2_data() {
		return track2_data;
	}

	public void setTrack2_data(String track2_data) {
		this.track2_data = track2_data;
	}

	public EncryptedTrackData getEncrypted_track_data() {
		return encrypted_track_data;
	}

	public void setEncrypted_track_data(EncryptedTrackData encrypted_track_data) {
		this.encrypted_track_data = encrypted_track_data;
	}
}
