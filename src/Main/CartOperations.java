package Main;

public interface CartOperations {
	public float getInvoice();
	
	public void addToCart(Product p);
	
	public void removeFormCart(Product p) throws ProductException;
}
