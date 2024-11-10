package oh;

import java.io.Serializable;

public class Textbook implements Serializable {
	
	// Data members
	private int sku;
	private String title;
	private double price;
	private int quantity;
	
	public Textbook(int sku, String title, double price, int quantity) {
		this.sku = sku;
		this.title = title;
		this.price = price;
		this.quantity = quantity;
	}

	// Setters and getters
	public int getSku() {
		return sku;
	}

	public void setSku(int sku) {
		this.sku = sku;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	// Methods
	public String toString() {
		return String.format("SKU: %d , Title: %s , Price: $%.2f , Quantity: %d", sku, title, price, quantity);
	}

}
