package edu.cgcc.scanner;

public class Main {
	//an array that contains objects		
	private static java.util.ArrayList<Object> objects = new java.util.ArrayList<Object>(); 
	public static void main(String[] args) {
				
		//get the the user input
		while(true) {
			int option = OrderEntry.selectOption();
			processOption(option);
		}
	}
	
	public static void processOption(int option) {
		/**
		 * Example 1 driver program using an if..else if..else
		 */
		//perform logic determining the option chosen by user
		//-1 = end program
		if(option == -1)
			System.exit(0);
		//1 = make new object
		else if(option == 1) {
			Order o = new Order();
			OrderEntry.newObject(o);
			objects.add(o);
			//print the object information
		}
		//2 = print existing orders
		else if(option == 2) {
			System.out.println("=====BEGIN REPORT=====");
			for(Object o : objects) {
				if(o != null) {
					OrderEntry.printObject(o);
					System.out.println();
					System.out.println();
				}
			}
			System.out.println("=====END REPORT=====");
		}
		//final error message
		else {
			System.err.println("Option selected was not understood.");
		}

		/**
		 * Example 2 driver program using a case statement
		 */
//		switch(option) {
//			//1 = new order
//			case 1: 
//				Order o = new Order();
//				OrderEntry.newObject(o);
//				//print the object information
//				OrderEntry.printObject(o);
//			//2 = print existing orders
//			case 2:
//				System.out.println(1);
//			default:
//				System.err.println("Option selected was not understood.");
//		}
	}
}
