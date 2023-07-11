package com.prototype.webproject.entities;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.prototype.webproject.entities.PK.OrderItemPk;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "Order_Item_Table")
public class OrderItem {

	@EmbeddedId	
	private OrderItemPk id = new OrderItemPk();
	private Integer quantity;
	private Double price;
	
	public OrderItem () {
		
	}

	public OrderItem(ClientOrder order, ProductProperties product, Integer quantity, Double price) {
		super();
		id.setOrder(order);
		id.setProduct(product);
		this.quantity = quantity;
		this.price = price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
	@JsonIgnore
	public ClientOrder getOrder()
	{
		return id.getOrder();
	}
	
	public void setOrder(ClientOrder order)
	{
		id.setOrder(order);
	}
	
	public ProductProperties getProduct()
	{
		return id.getProduct();
	}
	
	public void setProduct(ProductProperties product)
	{
		id.setProduct(product);
	}
	
	public Double getSubTotal() {
		return price*quantity;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderItem other = (OrderItem) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
}
