/**
 * 
 */
package com.payhub.ws.model;

/**
 * @author agustin
 *
 */
public class Status {
	private String id;
	private String version;
	private String createdAt;
	private String lastModified;
	private String createdBy;
	private String lastModifiedBy;
	private String nextBillDate;
	private String recurring_bill_status;
	private String statusLastChangedOn;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}
	public String getLastModified() {
		return lastModified;
	}
	public void setLastModified(String lastModified) {
		this.lastModified = lastModified;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getLastModifiedBy() {
		return lastModifiedBy;
	}
	public void setLastModifiedBy(String lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}
	public String getNextBillDate() {
		return nextBillDate;
	}
	public void setNextBillDate(String nextBillDate) {
		this.nextBillDate = nextBillDate;
	}
	public String getRecurring_bill_status() {
		return recurring_bill_status;
	}
	public void setRecurring_bill_status(String recurring_bill_status) {
		this.recurring_bill_status = recurring_bill_status;
	}
	public String getStatusLastChangedOn() {
		return statusLastChangedOn;
	}
	public void setStatusLastChangedOn(String statusLastChangedOn) {
		this.statusLastChangedOn = statusLastChangedOn;
	}
	
	
}
