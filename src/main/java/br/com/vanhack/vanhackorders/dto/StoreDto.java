package br.com.vanhack.vanhackorders.dto;

import java.io.Serializable;

public class StoreDto implements Serializable {

	private static final long serialVersionUID = 5447820993359955379L;

	private Long id;

	private Long cousineId;

	private String name;

	private String address;

	public StoreDto() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public Long getCousineId() {
		return cousineId;
	}

	public void setCousineId(Long cousineId) {
		this.cousineId = cousineId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
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
		StoreDto other = (StoreDto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
