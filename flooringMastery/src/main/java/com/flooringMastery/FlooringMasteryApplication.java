package com.flooringMastery;

import java.io.IOException;
import java.util.Scanner;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class FlooringMasteryApplication {

	public static void main(String[] args) throws IOException {
		
		// Scan for annotations and get controller bean
		AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext();
		appContext.scan("com.flooringMastery");
		appContext.refresh();
		Controller controller = appContext.getBean("controller", Controller.class); // bean name should be in lower case.
		// Load the existing orders
		controller.readExistingOrders();
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("---------------------------------------");
		    System.out.println("<<Flooring Program>>");
		    System.out.println("1. Display Order");
		    System.out.println("2. Add an Order");
		    System.out.println("3. Edit an Order");
		    System.out.println("4. Remove an Order");
		    System.out.println("5. Export All Data");
		    System.out.println("6. Quit");
		    System.out.println("---------------------------------------");
		    System.out.println("Enter the number associated with the desired operation.");
		    int choice = sc.nextInt();
		    if (choice == 1) {	  
		    	System.out.println("What is the date of the order you are requesting (e.g. MMDDYYYY)?");
		    	String date = sc.next();
		    	System.out.println("---------------------------------------");
		    	controller.displayOrder(date);
		    	System.out.println("---------------------------------------");
		    } else if (choice == 2) {
		    	System.out.println("Please key in the following details to add a new order.");
		    	System.out.println("---------------------------------------");
		    	System.out.println("Order Date - MMDDYYYY (must be in the future):");
		    	String date = sc.next();
		    	System.out.println("Customer Name (allowed to contain [a-z][0-9] as well as periods and comma characters)");
		    	sc.nextLine();
		    	String name = sc.nextLine();
		    	System.out.println("State (e.g. TX for TEXAS):");
		    	String state = sc.next();
		    	System.out.println("Please choose a product to choose from the table below.");
		    	System.out.println("---------------------------------------");
		    	controller.displayProduct();
		    	System.out.println("Product Type:");
		    	String productType = sc.next();
		    	System.out.println("Area (Minimum order size is 100 sq ft):");
		    	String area = sc.next();
		    	boolean checkValid = controller.addOrderCheck(date,name,state,productType,area);
		    	if (checkValid) {
		    		Order order = controller.addOrderCreate(date,name,state,productType,area);
		    		controller.displayOrder(order);
		    		System.out.println("Are the order details correct? (Enter y/n)");
					String choice1 = sc.next();
					if (choice1.equals("y")){
						controller.addOrderAdd(order);
					}
		    	}		    	
		    } else if (choice == 3) {
		    	System.out.println("Please key in the following details to edit an existing order.");
		    	System.out.println("---------------------------------------");
		    	System.out.println("Order Number:");
		    	int orderNumber = sc.nextInt();
		    	System.out.println("Order Date - MMDDYYYY:");
		    	String date = sc.next();
		    	if (!controller.orderExists(orderNumber,date)) {
		    		System.out.println("There is no existing order for the given order date and number.");
		    	} else{
		    		System.out.println("Please key in the following details to edit the existing order.");
			    	System.out.println("---------------------------------------");
			    	System.out.println("Customer Name (allowed to contain [a-z][0-9] as well as periods and comma characters)");
			    	sc.nextLine();
			    	String name = sc.nextLine();
			    	System.out.println("State (e.g. TX for TEXAS):");
			    	String state = sc.nextLine();
			    	System.out.println("Please choose a product to choose from the table below.");
			    	System.out.println("---------------------------------------");
			    	controller.displayProduct();
			    	System.out.println("Product Type:");
			    	String productType = sc.nextLine();
			    	System.out.println("Area (Minimum order size is 100 sq ft):");
			    	String area = sc.nextLine();
			    	boolean checkValid = controller.addOrderCheck(date,name,state,productType,area);
			    	if (checkValid) {
			    		Order order = controller.editOrderCreate(orderNumber,date,name,state,productType,area);
			    		controller.displayOrder(order);
			    		System.out.println("---------------------------------------");
			    		System.out.println("Are the order details correct? (Enter y/n)");
			    		String choice1 = sc.next();
			    		if (choice1.equals("y")){
			    			controller.editOrderAdd(order);
			    		}
					}
		    	}
		    } else if (choice == 4) {
		    	System.out.println("What is the date of the order you are requesting (e.g. MMDDYYYY)?");
		    	String date = sc.next();
		    	System.out.println("What is the order number?");
		    	int orderNumber = sc.nextInt();
		    	if (!controller.orderExists(orderNumber,date)) {
		    		System.out.println("There is no existing order for the given order date and number.");
		    	} else {
		    		System.out.println("---------------------------------------");
		    		controller.displayOrder(orderNumber,date);
		    		System.out.println("---------------------------------------");
		    		System.out.println("Are you sure that you want to delete the order? (y/n)");
		    		String choice1 = sc.next();
		    		if (choice1.equals("y")) {
		    			controller.removeOrder(orderNumber,date);
		    		}
		    	}
		    } else if (choice == 5) {
		    	controller.exportData();
		    } else if (choice == 6) {
		    	break;
		    } else {
		    	System.out.println("ERROR: Operation number not valid.");
		    }
		}
		sc.close();
		appContext.close();
	}
}
