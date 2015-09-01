/**
 * 
 */
package com.payhub.ws.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @author agustin
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)  
public class CustomerReference {
	private static final long serialVersionUID = 2589429954099956905L;

	private Long customerId;
	private String customerEmail;
	private List<CustomerPhone> customerPhones=new ArrayList();
	public CustomerReference(){
		
	}
	public CustomerReference(Long customerId,String customerEmail,List<CustomerPhone> customerPhones) {
		super();
		this.customerId = customerId;
		// HUB-692 shipping address removed
		// this.customerShipId = customerShipId;

		this.customerEmail = customerEmail;
		this.customerPhones = customerPhones;
	}

	public final static class CustomerPhone  implements Serializable {
		
		private static final long serialVersionUID = -7103935583346652431L;

		private String phone;

		private String extension;

		private String type;

		public CustomerPhone(String phone, String extension, String type) {
			super();
			this.phone = phone;
			this.extension = extension;
			this.type = type;
		}

		public String getPhone() {
			return phone;
		}

		public String getExtension() {
			return extension;
		}

		public String getType() {
			return type;
		}

	}

	public Long getCustomerId() {
		return customerId;
	}
}
