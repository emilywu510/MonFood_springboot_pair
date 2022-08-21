package com.monfood.boot.orderdetail;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ORDER_DETAIL")

public class OrderDetailVO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "PRODUCT_ID")
	private Integer productId;
	
	@Id
	@Column(name = "ORDER_ID")
	private Integer orderId;
	
	@Column(name = "AMOUNT")
	private Integer amount;
	
	@Column(name = "ORDERED_PRICE")
	private Integer orderedPrice;
	
	public OrderDetailVO() {
	}
	
	public OrderDetailVO(Integer productId, Integer orderId, Integer amount, Integer orderedPrice) {
		this.productId = productId;
		this.orderId = orderId;
		this.amount = amount;
		this.orderedPrice = orderedPrice;
	}
	
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public Integer getOrderedPrice() {
		return orderedPrice;
	}
	public void setOrderedPrice(Integer orderedPrice) {
		this.orderedPrice = orderedPrice;
	}

	@Override
	public int hashCode() {
		return Objects.hash(orderId, productId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderDetailVO other = (OrderDetailVO) obj;
		return Objects.equals(orderId, other.orderId) && Objects.equals(productId, other.productId);
	}

	
}