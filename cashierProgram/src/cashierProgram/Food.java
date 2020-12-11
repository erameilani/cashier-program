package cashierProgram;

import java.util.ArrayList;
import java.util.Scanner;

public class Food implements Interface {
	
	private String item, orderItem;
	private int price, quantity, order, qty, orderPrice;
	private double totalPrice, tax, payment, pay;
	
	Scanner input = new Scanner(System.in);
	ArrayList<Food> foodList = new ArrayList<>();
	ArrayList<Food> orderList = new ArrayList<>();
	
	public Food() {
	}

	public Food(String item, int price) {
		super();
		this.item = item;
		this.price = price;
	}
	
	public Food(String item, int price, int quantity) {
		super();
		this.item = item;
		this.price = price;
		this.quantity = quantity;
	}

	public String getItem() {
		return item;
	}

	public int getPrice() {
		return price;
	}

	public int getQuantity() {
		return quantity;
	}
	
	public void listOfFoods() {
		foodList.add(new Food("Package A (Rice + Fried Chicken + Water)", 20000));
		foodList.add(new Food("Package B (Rice + Fried Chicken)", 18000));
		foodList.add(new Food("Fried Chicken", 15000));
		foodList.add(new Food("Rice", 5000));
		foodList.add(new Food("Juice", 10000));
		
		for (int i = 0; i < foodList.size(); i++) {
			System.out.println("Item " + (i+1));
			System.out.println("Food Name : " + foodList.get(i).getItem());
			System.out.println(String.format("Price     : Rp %,d", foodList.get(i).getPrice()));
			System.out.println();
		}
	}
	
	public void listOfOrders() {
		String strPrice = String.format("Rp %,d", getPrice());
		String strAmount = String.format("Rp %,d", (getQuantity()*getPrice()));
		
		System.out.println(getItem());
		System.out.println(getQuantity() + " * " + strPrice + " = " + strAmount);
		System.out.println();
	}
	
	public void inputOrder() {
		System.out.print("Add Item  : ");
		order = input.nextInt();
		System.out.print("Quantity  : ");
		qty = input.nextInt();
		
		if(order <= foodList.size()) {
			orderItem = foodList.get(order-1).getItem();
			orderPrice = foodList.get(order-1).getPrice();

			orderList.add(new Food(orderItem, orderPrice, qty));
			totalPrice += (orderPrice*qty);
			
			System.out.println(String.format("Price     : Rp %,d", orderPrice));
			System.out.println(String.format("Amount    : Rp %,d", (orderPrice*qty)));
			System.out.println(String.format("\nTotal     : Rp %,.0f", totalPrice));
		} else {
			System.out.println("\nInvalid Item");
		}
	}
	
	@Override
	public void paymentReceipt() {
		for (Food orderFood : orderList) {
			orderFood.listOfOrders();
		}
		
		tax = totalPrice*0.1;
		payment = totalPrice*1.1;
		
		System.out.println(String.format("Total     : Rp %,9.0f", totalPrice));
		System.out.println(String.format("Tax       : Rp %,9.0f", tax));
		System.out.println(String.format("Payment   : Rp %,9.0f", payment));
		
		do {
			System.out.print("\nPay       : ");
			pay = input.nextDouble();
			
			if(pay < payment) System.out.println("Invalid Payment. Try Again");
		} while (pay < payment);
		
		System.out.println(String.format("\nPay       : Rp %,9.0f", pay));
		System.out.println(String.format("Change    : Rp %,9.0f", (pay-payment)));
	}
	
}
