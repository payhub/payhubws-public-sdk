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
public class EncryptedTrackData {
	private static final long serialVersionUID = -4271069669709145533L;
	public static final String ENCRYPTED_DATA_FIELD = "encrypted_track";
	public static final String ENCRYPTED_DATA_FIELD_SWIPER_BRAND = "swiper_brand";
	public static final String ENCRYPTED_DATA_FIELD_SWIPER_MODEL = "swiper_model";

	private String encrypted_track = "";
	private String swiper_brand = "IDTECH";
	private String swiper_model = "UNIMAGII";
	
	// So far these enums are not used, but in the future if there are more supported brands we will use them
	public enum SwiperBrandVal {
		IDTECH("IDTECH"),
		UNKNOWN("UNKNOWN");
		
		private String value;

		SwiperBrandVal(String value) {
			this.value=value;
		}
		
		public String getValue() {
			return value;
		}
		
		public static SwiperBrandVal getForValue(String value) {
			for (SwiperBrandVal swiperBrand : SwiperBrandVal.values()) {
				if (swiperBrand.getValue().equals(value)) {
					return swiperBrand;
				}
			}
			// If some other options are added, this default value should be UNKNOWN
			return IDTECH;
		}
	}
	public enum SwiperModelVal {
		UNIMAGII("UNIMAGII"),
		UNKNOWN("UNKNOWN");
		
		private String value;

		SwiperModelVal(String value) {
			this.value=value;
		}
		
		public String getValue() {
			return value;
		}
		
		public static SwiperModelVal getForValue(String value) {
			for (SwiperModelVal swiperModel : SwiperModelVal.values()) {
				if (swiperModel.getValue().equals(value)) {
					return swiperModel;
				}
			}
			// If some other options are added, this default value should be UNKNOWN
			return UNIMAGII;
		}
	}
	public String getEncrypted_track() {
		return encrypted_track;
	}
	public void setEncrypted_track(String encrypted_track) {
		this.encrypted_track = encrypted_track;
	}
	public String getSwiper_brand() {
		return swiper_brand;
	}
	public void setSwiper_brand(String swiper_brand) {
		this.swiper_brand = swiper_brand;
	}
	public String getSwiper_model() {
		return swiper_model;
	}
	public void setSwiper_model(String swiper_model) {
		this.swiper_model = swiper_model;
	}
	
}
