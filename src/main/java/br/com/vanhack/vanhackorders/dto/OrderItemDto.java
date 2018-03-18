package br.com.vanhack.vanhackorders.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class OrderItemDto implements Serializable {

	private static final long serialVersionUID = 1111542963674713589L;

	private Long id;

	private Long orderId;

	private Long productId;

	private ProductDto product;

	private Integer quantity;

	private BigDecimal price;

	public OrderItemDto() {
		
	}
	
	public Long getId() {
		return id;
	}

	public Long getOrderId() {
		return orderId;
	}

	public Long getProductId() {
		return productId;
	}

	public ProductDto getProduct() {
		return product;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public BigDecimal getTotal() {
		return this.price.multiply(new BigDecimal(this.quantity));
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public void setProduct(ProductDto product) {
		this.product = product;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
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
		OrderItemDto other = (OrderItemDto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
