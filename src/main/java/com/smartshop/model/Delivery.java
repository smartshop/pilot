package com.smartshop.model;

import org.joda.time.DateTime;

import com.smartshop.catalog.Address;

public class Delivery {
	
	
	public enum DeliveryType {
		
		pickUp,
		doorDelivery,
		ship;
		

	}
	public enum DeliveryStatus {
		notReady,
		inFlight,
		delivered,
		rejected,
		returned;

	}
	private Integer id;
	private DeliveryStatus deliveryStatus;
	private String otherDetails;
	private Address DeliverAddress;
	private DateTime deliveryDate;
	private DeliveryType deliveryType;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public DeliveryStatus getDeliveryStatus() {
		return deliveryStatus;
	}
	public void setDeliveryStatus(DeliveryStatus deliveryStatus) {
		this.deliveryStatus = deliveryStatus;
	}
	public String getOtherDetails() {
		return otherDetails;
	}
	public void setOtherDetails(String otherDetails) {
		this.otherDetails = otherDetails;
	}
	public Address getDeliverAddress() {
		return DeliverAddress;
	}
	public void setDeliverAddress(Address deliverAddress) {
		DeliverAddress = deliverAddress;
	}
	public DateTime getDeliveryDate() {
		return deliveryDate;
	}
	public void setDeliveryDate(DateTime deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
	public DeliveryType getDeliveryType() {
		return deliveryType;
	}
	public void setDeliveryType(DeliveryType deliveryType) {
		this.deliveryType = deliveryType;
		
	}
	
	
}
