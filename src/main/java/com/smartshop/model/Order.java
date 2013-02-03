package com.smartshop.model;

import org.joda.time.DateTime;

import com.smartshop.catalog.Customer;

public class Order {
	
	public enum OrderType {
		customerOrder,
		supplierOrder;

	}
	public enum OrderStatus {
		notStarted,
		inProgress,
		completed,
		processed;
		
	}
	private Integer id;
	private Customer customer;
	private DateTime orderDate;
	private OrderStatus status;
	private Payment payment;
	private Delivery delivery;
	private OrderType orderType;
	private OrderDetails orderDetails;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public DateTime getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(DateTime orderDate) {
		this.orderDate = orderDate;
	}
	public OrderStatus getStatus() {
		return status;
	}
	public void setStatus(OrderStatus status) {
		this.status = status;
	}
	public Payment getPayment() {
		return payment;
	}
	public void setPayment(Payment payment) {
		this.payment = payment;
	}
	public Delivery getDelivery() {
		return delivery;
	}
	public void setDelivery(Delivery delivery) {
		this.delivery = delivery;
	}
	public OrderType getOrderType() {
		return orderType;
	}
	public void setOrderType(OrderType orderType) {
		this.orderType = orderType;
	}
	public OrderDetails getOrderDetails() {
		return orderDetails;
	}
	public void setOrderDetails(OrderDetails orderDetails) {
		this.orderDetails = orderDetails;
	}
	
	

}
