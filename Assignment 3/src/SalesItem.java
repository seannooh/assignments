
public class SalesItem {
	
	// data members
	private String name;
	private double price;
	private int quantity;
	
	// constructor
	public SalesItem(String n, double p, int q) {
		name = n;
		price = p;
		quantity = q;
	}

	// setters and getters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
	
	// tostring
	public String toString() {
		return name + ", $" + price + ", " + quantity + " items";
	}
}
