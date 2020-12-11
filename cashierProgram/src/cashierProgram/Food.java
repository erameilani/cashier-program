package cashierProgram;

public class Food implements Interface {
	
	private String item;
	private int price, qty;
	
	public Food() {
	}

	public Food(String item, int price) {
		super();
		this.item = item;
		this.price = price;
	}
	
	public Food(String item, int price, int qty) {
		super();
		this.item = item;
		this.price = price;
		this.qty = qty;
	}

	public String getItem() {
		return item;
	}

	public int getPrice() {
		return price;
	}

	public int getQty() {
		return qty;
	}

	@Override
	public void paymentReceipt() {
		String strPrice = String.format("Rp %,d", getPrice());
		String strAmount = String.format("Rp %,d", (getQty() * getPrice()));
		
		System.out.println(getItem());
		System.out.println(getQty() + " * " + strPrice + " = " + strAmount);
		System.out.println();
	}

}
