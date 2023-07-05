package com.prototype.webproject.entities.PK;

import java.io.Serializable;
import java.util.Objects;

import com.prototype.webproject.entities.ClientOrder;
import com.prototype.webproject.entities.ProductProperties;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class OrderItemPk implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name = "order_id")
	private ClientOrder order;
	
	@ManyToOne
	@JoinColumn(name = "product_id")
	private ProductProperties product;
	
	
	public ClientOrder getOrder() {
		return order;
	}
	public ProductProperties getProduct() {
		return product;
	}
	public void setOrder(ClientOrder order) {
		this.order = order;
	}
	public void setProduct(ProductProperties product) {
		this.product = product;
	}
	@Override
	public int hashCode() {
		return Objects.hash(order, product);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderItemPk other = (OrderItemPk) obj;
		return Objects.equals(order, other.order) && Objects.equals(product, other.product);
	}
	
	
}
