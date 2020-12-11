package cashierProgram;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		ArrayList<Food> foodList = new ArrayList<>();
		ArrayList<Food> orderList = new ArrayList<>();
		
		int order, qty, orderPrice;
		double totalPrice = 0, tax, payment, pay;
		String orderNumber, orderItem, addMore;
		
		LocalDateTime date = LocalDateTime.now();
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("E, MMM dd yyyy HH:mm:ss");
		
		orderNumber = date.getYear() + "" + date.getMonthValue() + "" + 
					  date.getDayOfMonth() + "" + date.getHour() + "" +
					  date.getMinute() + "" + date.getSecond();
		
		System.out.println("=====================");
		System.out.println("   CASHIER PROGRAM   ");
		System.out.println("=====================");
		System.out.println("\n*** LIST OF FOODS ***\n");
		
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
		
		System.out.println("*** ORDER ***\n");
		do {
			System.out.print("Add Item  : ");
			order = input.nextInt();
			System.out.print("Quantity  : ");
			qty = input.nextInt();
			
			orderItem = foodList.get(order-1).getItem();
			orderPrice = foodList.get(order-1).getPrice();

			orderList.add(new Food(orderItem, orderPrice, qty));
			totalPrice += (orderPrice*qty);
			
			System.out.println(String.format("Price     : Rp %,d", orderPrice));
			System.out.println(String.format("Amount    : Rp %,d", (orderPrice*qty)));
			System.out.println(String.format("\nTotal     : Rp %,.0f", totalPrice));
			
			System.out.print("\nAdd More ? (y/n) ");
			addMore = input.next();
			System.out.println();
		} while (addMore.equals("y"));
		
		System.out.println("*** RECEIPT ***\n");
		
		System.out.println("Order No. : " + orderNumber);
		System.out.println("Date      : " + date.format(dateFormatter));
		System.out.println();
		
		for (Food food : orderList) {
			food.paymentReceipt();
		}
		
		tax = totalPrice * 0.1;
		payment = totalPrice * 1.1;
		
		System.out.println(String.format("Total     : Rp %,9.0f", totalPrice));
		System.out.println(String.format("Tax       : Rp %,9.0f", tax));
		System.out.println(String.format("Payment   : Rp %,9.0f", payment));
		
		System.out.print("\nPay       : ");
		pay = input.nextDouble();
		
		System.out.println(String.format("\nPay       : Rp %,9.0f", pay));
		System.out.println(String.format("Change    : Rp %,9.0f", (pay-payment)));
		
		System.out.println("\nThank You, Enjoy Your Meal!");
		
		input.close();
	}

}
