package oophw2;

public class OrderDetail {
	int orderQuantity;
	double productPrice;
	Product product;
	Order order;
	public OrderDetail(Product product, int orderQuantity,Order order) {
		this.product=product;
		this.orderQuantity=orderQuantity;
		this.order=order;
	}
	public int getOrderQuantity() {
		return orderQuantity;
	}

	public Product getProduct() {
		return product;
	}

	public Order getOrder() {
		return order;
	}

}
