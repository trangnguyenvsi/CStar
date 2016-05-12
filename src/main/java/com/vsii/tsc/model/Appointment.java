package com.vsii.tsc.model;

public class Appointment {
	private String appointmentCode;
	private String appointmentTime;
	private String sequence;
	private String siteName;
	private String screeningCode;
	private String screeningDate;
	private PPackage product;
	public String getAppointmentCode() {
		return appointmentCode;
	}
	public void setAppointmentCode(String appointmentCode) {
		this.appointmentCode = appointmentCode;
	}
	public String getAppointmentTime() {
		return appointmentTime;
	}
	public void setAppointmentTime(String appointmentTime) {
		this.appointmentTime = appointmentTime;
	}
	public String getSequence() {
		return sequence;
	}
	public void setSequence(String sequence) {
		this.sequence = sequence;
	}
	public String getSiteName() {
		return siteName;
	}
	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}
	public String getScreeningCode() {
		return screeningCode;
	}
	public void setScreeningCode(String screeningCode) {
		this.screeningCode = screeningCode;
	}
	public String getScreeningDate() {
		return screeningDate;
	}
	public void setScreeningDate(String screeningDate) {
		this.screeningDate = screeningDate;
	}
	public PPackage getProduct() {
		return product;
	}
	public void setProduct(PPackage product) {
		this.product = product;
	}


}
