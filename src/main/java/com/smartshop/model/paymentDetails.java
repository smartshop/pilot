package com.smartshop.model;

import org.joda.time.DateTime;

import com.smartshop.catalog.Address;


public class paymentDetails {

	public enum PaymentType {

		cash,
		credit,
		check,
		visa,
		masterCard,
		americanExpress;

	}
	public enum Currency {
		
		INR;
		
	}
	
	private Integer id;
	private PaymentType paymentType;
	private Currency currency;
	private Double paymentValue;
	private Long cardNumber;
	private Long CheckNumber;
	private String bank;
	private Long RoutingNumber;
	private String FirstName;
	private String LastName;
	private Address billingAddress;
	private DateTime expDate;
	private Long securityKey;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public PaymentType getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(PaymentType paymentType) {
		this.paymentType = paymentType;
	}
	public Currency getCurrency() {
		return currency;
	}
	public void setCurrency(Currency currency) {
		this.currency = currency;
	}
	public Double getPaymentValue() {
		return paymentValue;
	}
	public void setPaymentValue(Double paymentValue) {
		this.paymentValue = paymentValue;
	}
	public Long getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(Long cardNumber) {
		this.cardNumber = cardNumber;
	}
	public Long getCheckNumber() {
		return CheckNumber;
	}
	public void setCheckNumber(Long checkNumber) {
		CheckNumber = checkNumber;
	}
	public String getBank() {
		return bank;
	}
	public void setBank(String bank) {
		this.bank = bank;
	}
	public Long getRoutingNumber() {
		return RoutingNumber;
	}
	public void setRoutingNumber(Long routingNumber) {
		RoutingNumber = routingNumber;
	}
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public Address getBillingAddress() {
		return billingAddress;
	}
	public void setBillingAddress(Address billingAddress) {
		this.billingAddress = billingAddress;
	}
	public DateTime getExpDate() {
		return expDate;
	}
	public void setExpDate(DateTime expDate) {
		this.expDate = expDate;
	}
	public Long getSecurityKey() {
		return securityKey;
	}
	public void setSecurityKey(Long securityKey) {
		this.securityKey = securityKey;
	}
	
	

}
