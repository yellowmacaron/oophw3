package oophw2;

import java.util.Date;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// Location
		Location locationA = new Location(011, "Warehouse A", "Adelaide");
		Location locationB = new Location(012, "Warehouse B", "Port Adelaide");
		Location locationC = new Location(013, "Warehouse C", "Noarlunga");

		// Product
		Product product1 = new Product();
		product1.name = "Black Coffee";
		product1.productID = "BlCf";
		product1.brand = "Trung Nguyen";
		product1.price = 7;

		Product product2 = new Product();
		product2.name = "White Coffee";
		product2.productID = "WhCf";
		product2.brand = "Kopitam";
		product2.price = 10;

		Product product3 = new Product();
		product3.name = "Brown Coffee";
		product3.productID = "BrCf";
		product3.brand = "Victorian";
		product3.price = 6;

		/// Stock in warehouse;

		// Black coffee stock;
		Stock stockBlCf11 = new Stock(locationA, product1, 30);
		Stock stockBlCf12 = new Stock(locationB, product1, 100);
		Stock stockBlCf13 = new Stock(locationC, product1, 200);
		Stock[] stockBlCfArray = { stockBlCf11, stockBlCf12, stockBlCf13 };
		product1.totalQuantity = calculateTotalStock(stockBlCfArray);

		// White coffee stock;
		Stock stockWhCf11 = new Stock(locationA, product2, 200);
		Stock stockWhCf12 = new Stock(locationB, product2, 100);
		Stock stockWhCf13 = new Stock(locationC, product2, 200);
		Stock[] stockWhCfArray = { stockWhCf11, stockWhCf12, stockWhCf13 };
		product2.totalQuantity = calculateTotalStock(stockWhCfArray);

		// Brown coffee stock;
		Stock stockBrCf11 = new Stock(locationA, product2, 100);
		Stock stockBrCf13 = new Stock(locationC, product2, 200);
		Stock[] stockBrCfArray = { stockBrCf11, stockBrCf13 };
		product3.totalQuantity = calculateTotalStock(stockBrCfArray);

		// Customer 1
		Customer customer1 = new Customer();
		customer1.name = "Customer 1";

		Account accCus1 = new Account();
		accCus1.accountId = "iamcustomer1";
		accCus1.password = "cantremember";
		accCus1.customer = customer1;
		accCus1.isActive = false;

		// Order 1
		Order order1 = new Order();
		order1.orderID = 001;
		order1.date = "12/04/2023";
		order1.customer = customer1;
		order1.isOnlineOrdered = true;

		// Order 1 detail
		OrderDetail order1Detail1 = new OrderDetail(product1, 6, order1);
		order1Detail1.productPrice = calculatePrice(order1Detail1, product1);

		OrderDetail order1Detail2 = new OrderDetail(product2, 15, order1);
		order1Detail2.productPrice = calculatePrice(order1Detail2, product2);

		OrderDetail order1Detail3 = new OrderDetail(product3, 10, order1);
		order1Detail3.productPrice = calculatePrice(order1Detail3, product2);

		OrderDetail[] order1DetailArr = { order1Detail1, order1Detail2, order1Detail3 };
		order1.totalPrice = calculateTotalPrice(order1DetailArr);

		// Order 2
		Order order2 = new Order();
		order2.orderID = 002;
		order2.date = "12/04/2023";
		order2.customer = customer1;

		// Order 2 detail
		OrderDetail order2Detail1 = new OrderDetail(product2, 8, order2);
		order2Detail1.productPrice = calculatePrice(order2Detail1, product2);
		OrderDetail[] order2DetailArr = { order2Detail1 };
		order2.totalPrice = calculateTotalPrice(order2DetailArr);

		// Customer 2
		Customer customer2 = new Customer();
		customer2.name = "Customer 2";

		// Customer 2's account
		Account accCus2 = new Account();
		accCus2.accountId = "thisis2";
		accCus2.password = "hereismypassword";
		accCus2.customer = customer2;
		accCus2.isActive = false;

		// Order 3
		Order order3 = new Order();
		order3.orderID = 003;
		order3.date = "12/04/2023";
		order3.customer = customer2;

		// Order 3 detail
		OrderDetail order3Detail1 = new OrderDetail(product1, 3, order3);
		order3Detail1.productPrice = calculatePrice(order3Detail1, product1);

		OrderDetail order3Detail2 = new OrderDetail(product2, 6, order3);
		order3Detail2.productPrice = calculatePrice(order3Detail2, product2);

		OrderDetail[] order3DetailArr = { order3Detail1, order3Detail2 };

		order3.totalPrice = calculateTotalPrice(order3DetailArr);

		// Order 4
		Order order4 = new Order();
		order4.orderID = 004;
		order4.date = "12/04/2023";
		order4.customer = customer2;
		order4.isOnlineOrdered = true;

		// Order 4 detail
		OrderDetail order4Detail1 = new OrderDetail(product3, 3, order4);
		order4Detail1.productPrice = calculatePrice(order4Detail1, product3);
		OrderDetail[] order4DetailArr = { order4Detail1 };
		order4.totalPrice = calculateTotalPrice(order4DetailArr);

		Order[] orderArr = { order1, order2, order3, order4 };
		Customer[] customerArr = { customer1, customer2 };
		Product[] productArr = { product1, product2, product3 };
		OrderDetail[] orderDetailArr = { order1Detail1, order1Detail2, order1Detail3, order2Detail1, order3Detail1,
				order3Detail2, order4Detail1 };
		Account[] accountArr = { accCus1, accCus2 };

		// Log in
		Scanner scanner = new Scanner(System.in);
		System.out.println("Account ID: ");
		String accountID = scanner.next();
		System.out.println("Password: ");
		String password = scanner.next();

		for (Account account : accountArr) {
			if (account.accountId.equals(accountID) && account.password.equals(password)) {
				Customer customer = account.customer;
				// for (Customer customer : customerArr) {
				account.lastLoginDay=new Date();
				System.out.println("Customer: " + customer.name);
				Order[] orderSource = getOrders(customer, orderArr);
				System.out.println("Last login time: " + account.lastLoginDay);
				System.out.println("----------------");
				for (Order order : orderSource) {
					if (order.isOnlineOrdered) {
						System.out.println("Online ordered: ");
						
					} else {
						System.out.println("Instore ordered: ");
					}
					System.out.println("Order ID: " + order.orderID);
					System.out.println("Date ordered: " + order.date); //
					OrderDetail[] orderDetailSource = getOrderDetails(order, orderDetailArr);

					for (OrderDetail detail : orderDetailSource) {
						System.out.println("Product: " + detail.product.name);
						System.out.println("Brand: " + detail.product.brand);
						System.out.println("Quantity: " + detail.orderQuantity + " kg");
						System.out.println("Price: $" + detail.productPrice);

					}

					System.out.println("Total: $" + order.totalPrice);
					System.out.println("------------------");
				}

			}
			
		}
	}
	// }}

	public static double calculatePrice(OrderDetail productDetail, Product product) {
		double price = product.price * productDetail.orderQuantity;
		return price;
	}

	public static Order[] getOrders(Customer customer, Order[] ordersSource) {
		int arrSize = 0;
		for (Order order : ordersSource) {
			if (order.customer.name.equals(customer.name)) {
				arrSize++;
			}
		}
		Order[] orders = new Order[arrSize];
		int index = 0;
		for (Order order : ordersSource) {
			if (order.customer.name.equals(customer.name)) {
				orders[index] = order;
				index++;
			}
		}
		return orders;

	}

	public static OrderDetail[] getOrderDetails(Order order, OrderDetail[] orderDetailSource) {
		int arrSize = 0;
		for (OrderDetail detail : orderDetailSource) {
			if (detail.order.orderID == order.orderID) {
				arrSize++;
			}
		}
		OrderDetail[] details = new OrderDetail[arrSize];
		int index = 0;
		for (OrderDetail detail : orderDetailSource) {
			if (detail.order.orderID == order.orderID) {
				details[index] = detail;
				index++;

			}
		}
		return details;
	}

	public static double calculateTotalPrice(OrderDetail[] orderDetailArr) {
		int totalPrice = 0;
		for (OrderDetail productDetail : orderDetailArr) {
			totalPrice += productDetail.productPrice;

		}
		return totalPrice;
	}

	public static int calculateTotalStock(Stock[] stockArr) {
		int totalStock = 0;
		for (Stock stock : stockArr) {
			totalStock += stock.quantity;
		}
		return totalStock;
	}

}
