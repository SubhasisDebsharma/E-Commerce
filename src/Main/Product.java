package Main;

public class Product {
	private String product;
	private int price, quantity;
	
	public Product(String product, int price, int quantity){
		this.product = product;
		this.price = price;
		this.quantity = quantity;
	}

	String getProductName(){
		return product;
	}

	int getProductPrice(){
		return price;
	}

	int getProductQuantity(){
		return quantity;
	}
}
