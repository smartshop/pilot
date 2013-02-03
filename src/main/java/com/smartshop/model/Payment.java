package com.smartshop.model;

import org.joda.time.DateTime;

public class Payment {
	

	public enum PaymentStatus {

		notpaid,
		inProgress,
		approved,
		declined;
	}
	

	private Integer id;
	private PaymentStatus paymentStatus;
	private DateTime paymentDate;
	private paymentDetails paymentDetails;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public PaymentStatus getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(PaymentStatus paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	public DateTime getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(DateTime paymentDate) {
		this.paymentDate = paymentDate;
	}
	public paymentDetails getPaymentDetails() {
		return paymentDetails;
	}
	public void setPaymentDetails(paymentDetails paymentDetails) {
		this.paymentDetails = paymentDetails;
	}
	
	

}
