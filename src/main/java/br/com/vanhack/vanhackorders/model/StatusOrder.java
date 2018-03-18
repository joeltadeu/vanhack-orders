package br.com.vanhack.vanhackorders.model;

public enum StatusOrder {

	ANALYSIS("Under Analysis"), CONFIRMED("Confirmed"), DELIVERED("Delivered"), CANCELED("Canceled");

	private String description;

	StatusOrder(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
}
