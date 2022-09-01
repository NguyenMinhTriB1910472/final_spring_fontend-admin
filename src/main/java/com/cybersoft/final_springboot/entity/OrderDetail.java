package com.cybersoft.final_springboot.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity(name="order_detail")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class OrderDetail {
	
	public OrderDetail(int id,int status, int amount) {
		super();
		this.status = status;
		this.amount = amount;
		this.id=id;
	}
	public OrderDetail() {
		super();
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="status")
	private int status;
	
	@Column(name="amount")
	private int amount;
	
	public OrderDetail(int id, int status, int amount, Order order, Product product) {
		super();
		this.id = id;
		this.status = status;
		this.amount = amount;
		this.order = order;
		this.product = product;
	}
	@ManyToOne
	@JoinColumn(name="orders_id")
	Order order;
	
	@ManyToOne
	@JoinColumn(name="product_id")
	Product product;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	
}
