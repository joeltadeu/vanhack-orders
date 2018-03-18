package br.com.vanhack.vanhackorders.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class OrderDto implements Serializable {

	private static final long serialVersionUID = -4791575769477398832L;

	private Long id;

	private LocalDateTime date;

	private Long customerId;

	private String deliveryAddress;

	private String contact;

	private Long storeId;

	private List<OrderItemDto> orderItems;

	private String status;

	private LocalDateTime lastUpdate;

	public OrderDto() {
		
	}
	
	public Long getId() {
		return id;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public String getDeliveryAddress() {
		return deliveryAddress;
	}

	public String getContact() {
		return contact;
	}

	public Long getStoreId() {
		return storeId;
	}

	public List<OrderItemDto> getOrderItems() {
		return orderItems;
	}

	public BigDecimal getTotal() {
		return getOrderItems().stream().map(OrderItemDto::getTotal).reduce(BigDecimal::add).orElse(BigDecimal.ZERO);
	}

	public String getStatus() {
		return status;
	}

	public LocalDateTime getLastUpdate() {
		return lastUpdate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderDto other = (OrderDto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public void setStoreId(Long storeId) {
		this.storeId = storeId;
	}

	public void setOrderItems(List<OrderItemDto> orderItems) {
		this.orderItems = orderItems;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setLastUpdate(LocalDateTime lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
}
