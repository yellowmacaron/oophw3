package oophw2;

public class Stock {
	Location location;
	Product product;
	int quantity;
	public Stock(Location location,Product product,int quantity) {
		this.location=location;
		this.product=product;
		this.quantity=quantity;
	}
	public Location getLocation() {
		return location;
	}
	public Product getProduct() {
		return product;
	}

	public int getQuantity() {
		return quantity;
	}
}
