package edu.cgcc.scanner;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int option = OrderEntry.selectOption();
		
		//1 = new order
		if(option == 1) {
			Order o = new Order();
			OrderEntry.newOrder(o);
			System.out.println("Customer Number: " + o.customerNumber + "\nOrder Number: " + o.number + "\nAddress: " + o.address);
		}
		//2 = search existing order
		else if(option == 2) {
			System.out.println(1);
		}
		//final error message
		else {
			System.err.println("Option selected was not understood.");
		}
	}

}
