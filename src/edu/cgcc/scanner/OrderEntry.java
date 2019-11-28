package edu.cgcc.scanner;
import java.util.Scanner;
import java.lang.reflect.*;

public class OrderEntry {
	private static Scanner scanner;
	
	/**
	 * Request information for a give object
	 * @param o
	 * @return
	 */
	public static boolean newOrder(Object o) {
		scanner = new Scanner(System.in);
		boolean created = false;
		Field[] fields = o.getClass().getDeclaredFields();
		System.out.println("Creating new Order:");
		for(Field field : fields) {
			System.out.println("Enter value for " + field.getName() + ": ");
			String entry = scanner.nextLine();
			try {				
				System.out.println(field.getType().toString());
				if(field.getType().toString().toLowerCase().contains("string"))
					field.set(o, entry.trim());
				
				else if(field.getType().toString().toLowerCase().contains("int"))
					field.set(o, Integer.parseInt(entry.trim()));
				
				else if(field.getType().toString().toLowerCase().contains("boolean"))
					field.set(o, Boolean.parseBoolean(entry.trim()));
				
				else if(field.getType().toString().toLowerCase().contains("char"))
					field.set(o, entry.charAt(0));
				
				else if(field.getType().toString().contains("double"))
					field.set(o, Double.parseDouble(entry.trim()));
				
				else if(field.getType().toString().toLowerCase().contains("float"))
					field.set(o, Float.parseFloat(entry.trim()));
				
				else if(field.getType().toString().toLowerCase().contains("long"))
					field.set(o, Long.parseLong(entry.trim()));
				
				else if(field.getType().toString().toLowerCase().contains("short"))
					field.set(o, Short.parseShort(entry.trim()));
				
				else if(field.getType().toString().toLowerCase().contains("byte"))
					field.set(o, Byte.parseByte(entry.trim()));
				
				else
					throw new Exception("Unable to set " + field.getName());
				
			}
			catch(Exception e) {
				System.err.println(e.getMessage());
			}
		}
		
		scanner.close();
		return created;
	}
	
	/**
	 * A method to select whether to create a new order or find an existing order.
	 * @return option 1 to create new order, 2 to search existing order
	 * or -1 if the option wasn't understood.
	 */
	public static int selectOption() {
		scanner = new Scanner(System.in);
		System.out.println("Available Options:\n1 = Enter New Order\n2 = Find Existing Order");
		System.out.println("Please select an option(1 or 2):");
		while(scanner.hasNextLine()) {
			try {
				int entry = Integer.parseInt(scanner.nextLine());
				switch(entry) {
					case 1: 
						return 1;
					case 2:
						return 2;
					default:
						throw new Exception("The value was not between 1 or 2.");
				}
			}
			catch(NumberFormatException e) {
				System.err.println("You must enter a valid number. Try again:");
			}
			catch(Exception e) {
				System.err.println(e.getMessage());
			}
		}
		scanner.close();
		return -1;
	}
}
