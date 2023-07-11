package com.prototype.webproject.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.prototype.webproject.entities.enums.ClientOrderStatus;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Orders_Table")
public class ClientOrder implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	
	@JsonFormat(shape = JsonFormat.Shape.STRING , pattern = "yyyy-MM-dd 'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant moment;
	
	private Integer orderStatus;
	
	@ManyToOne
	@JoinColumn(name = "client_id")
	private UserProperties client; 
	
	
	@OneToMany(mappedBy = "id.order")
	private Set<OrderItem> items = new HashSet<>();
	
	@JsonIgnore
	@OneToOne(mappedBy="order",cascade = CascadeType.ALL)
	private PaymentProperties payment;
	
	public ClientOrder() {
		
	}

	public ClientOrder(Long id, Instant moment, UserProperties client,ClientOrderStatus orderStatus) {
		super();
		this.id = id;
		this.moment = moment;
		this.client = client;
		setOrderStatus(orderStatus);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getMoment() {
		return moment;
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
	}

	public UserProperties getClient() {
		return client;
	}

	public void setClient(UserProperties client) {
		this.client = client;
	}
	
	public ClientOrderStatus getOrderStatus() {
		return ClientOrderStatus.valueOf(orderStatus);
	}
	

	public PaymentProperties getPayment() {
		return payment;
	}

	public void setPayment(PaymentProperties payment) {
		this.payment = payment;
	}

	public void setOrderStatus(ClientOrderStatus orderStatus) {
		if (orderStatus != null){	
			this.orderStatus = orderStatus.getCode();
		}
		}

	public Set<OrderItem> getItems()
	{
		return items;
	}
	
	public Double getTotal()
	{
		double sum = 0.0;
		for(OrderItem x:items)
		{
			sum +=x.getSubTotal();
		}
		return sum;
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
		ClientOrder other = (ClientOrder) obj;
		return Objects.equals(id, other.id);
	}
	
	
}
