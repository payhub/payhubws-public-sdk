package com.payhub.ws.vt;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ValidatedDevices {
	
		public final static String VALIDATED_DEVICES_LINK="adminSettings/validatedDevices";
		private boolean enforce_device_validation;
		private List<Devices> devices;
		
		public ValidatedDevices(){}
		
		public static class Devices{
			public String product;
			public String nick_name;
			public String platform;
			public String details;
			public String date_added;
			public Long device_id;
			public Devices(){}
			/**
			 * @return the product
			 */
			public String getProduct() {
				return product;
			}
			/**
			 * @param product the product to set
			 */
			public void setProduct(String product) {
				this.product = product;
			}
			/**
			 * @return the nick_name
			 */
			public String getNick_name() {
				return nick_name;
			}
			/**
			 * @param nick_name the nick_name to set
			 */
			public void setNick_name(String nick_name) {
				this.nick_name = nick_name;
			}
			/**
			 * @return the platform
			 */
			public String getPlatform() {
				return platform;
			}
			/**
			 * @param platform the platform to set
			 */
			public void setPlatform(String platform) {
				this.platform = platform;
			}
			/**
			 * @return the details
			 */
			public String getDetails() {
				return details;
			}
			/**
			 * @param details the details to set
			 */
			public void setDetails(String details) {
				this.details = details;
			}
			/**
			 * @return the date_added
			 */
			public String getDate_added() {
				return date_added;
			}
			/**
			 * @param date_added the date_added to set
			 */
			public void setDate_added(String date_added) {
				this.date_added = date_added;
			}
			/**
			 * @return the device_id
			 */
			public Long getDevice_id() {
				return device_id;
			}
			/**
			 * @param device_id the device_id to set
			 */
			public void setDevice_id(Long device_id) {
				this.device_id = device_id;
			}
			
			
		}
		
		
		/**
		 * @return the enforce_device_validation
		 */
		public boolean isEnforce_device_validation() {
			return enforce_device_validation;
		}


		/**
		 * @param enforce_device_validation the enforce_device_validation to set
		 */
		public void setEnforce_device_validation(boolean enforce_device_validation) {
			this.enforce_device_validation = enforce_device_validation;
		}


		/**
		 * @return the devices
		 */
		public List<Devices> getDevices() {
			return devices;
		}


		/**
		 * @param devices the devices to set
		 */
		public void setDevices(List<Devices> devices) {
			this.devices = devices;
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
