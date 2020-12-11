package cashierProgram;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Food food = new Food();
		
		int orderNumber;
		String addMore;

		LocalDateTime date = LocalDateTime.now();
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("E, MMM dd yyyy HH:mm:ss");
		
		orderNumber = (int) Math.round(Math.random() * 1000);
		
		System.out.println("=====================");
		System.out.println("   CASHIER PROGRAM   ");
		System.out.println("=====================");
		System.out.println("\n*** LIST OF FOODS ***\n");
		food.listOfFoods();

		System.out.println("*** ORDER ***\n");
		do {
			food.inputOrder();
			
			System.out.print("\nAdd More ? (y/n) ");
			addMore = input.next();
			System.out.println();
		} while (addMore.equals("y") || addMore.equals("Y"));
		
		System.out.println("*** RECEIPT ***\n");
		System.out.println("Order No. : " + orderNumber);
		System.out.println("Date      : " + date.format(dateFormatter));
		System.out.println();
		food.paymentReceipt();
		System.out.println("\nThank You. Enjoy Your Meal!");
		
		input.close();
	}

}
