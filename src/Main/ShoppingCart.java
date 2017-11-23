package Main;

import java.util.ArrayList;

public class ShoppingCart implements CartOperations{
	
	private ArrayList<Product> product;
	private float invoiceAmount;
	private float taxPercentage;
	
	public ShoppingCart(){
		this.product = new ArrayList<Product>();
		this.invoiceAmount = 0.0f;
		getTaxPercentage(10);
	}

	public static void main(String[] args) throws ProductException{
		Product p1 = new Product("Ramayana Book", 6000, 1);
		Product p2 = new Product("Lifebuy",25,2);
		Product p3 = new Product("MiPhone", 7000, 1);
		Product p4 = new Product("Flower", 650, 2);
		Product p5 = new Product("Fogg", 250, 1);
		ShoppingCart spc = new ShoppingCart();
		spc.addToCart(p1);
		spc.addToCart(p2);
		spc.addToCart(p5);
		spc.addToCart(p3);
		System.out.println(spc.toString());
		System.out.println(spc.getInvoice());
		spc.removeFormCart(p2);
		System.out.println(spc.toString());
		System.out.println(spc.getInvoice());
	}

	public String toString(){
		String cart = "***Shopping Cart***\n";
		for(Product p: product){
			cart += "Product Name: "+p.getProductName()+" |Price: "+p.getProductPrice()+" |Quantity: "+p.getProductQuantity()+"\n";
		}
		return cart;
	}

	private void getTaxPercentage(int taxPercentage){
		this.taxPercentage = taxPercentage/100.0f;
	}

	@Override
	public float getInvoice() {
		return invoiceAmount;
	}

	@Override
	public void addToCart(Product p) {
		float netPrice = p.getProductPrice()*p.getProductQuantity()*(1+taxPercentage);
		invoiceAmount += netPrice;
		product.add(p);
	}

	@Override
	public void removeFormCart(Product p) throws ProductException{
		if(product.remove(p)){
			invoiceAmount -= p.getProductPrice()*p.getProductQuantity()*(1+taxPercentage);
		}else{
			throw new ProductException("Product not found");
		}
	}
}
