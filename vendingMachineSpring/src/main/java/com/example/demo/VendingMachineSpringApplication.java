package com.example.demo;

import java.io.IOException;
import java.util.Scanner;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class VendingMachineSpringApplication {

	public static void main(String[] args) throws IOException, NoItemInventoryException, InsufficientFundsException {
        // Scan for annotations and get controller bean
		AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext();
		appContext.scan("com.example.demo");
		appContext.refresh();
		Controller controller = appContext.getBean("controller", Controller.class); // bean name should be in lower case.
		// Load the items from vending machine
        controller.read("src/main/resources/items.txt");
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("-----Welcome to vending machine-----");
            System.out.println(" ");
            controller.print();
            System.out.println(" ");
            System.out.println("To proceed with order, type c. To exit the process, type e.");
            String choice = sc.next();
            if (choice.equals("e")) {
                break;
            }
            System.out.println(" ");
            System.out.println("Please enter the amount to be put into the vending machine. (Example: 2.70)");
            String amount = sc.next();
            System.out.println("Please choose an item (Enter the item number)");
            int item = sc.nextInt();
            controller.calCoins(amount,item);
            controller.update(item);
            controller.save();
            break;
        }
        sc.close();
        appContext.close();
	}
}
