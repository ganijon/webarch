package edu.mum.coffee.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

public class Orderline {

	private Long id;
	private int quantity;
	private Product product;
	@JsonBackReference
	private Order order;

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public double getSubtotal() {
		return quantity * product.getPrice();
	}

	public double getPrice() {
		return product.getPrice();
	}

	public Long getId() {
		return id;
	}

}
