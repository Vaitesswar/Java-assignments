package com.flooringMastery;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootTest
class FlooringMasteryApplicationTests {
	
	@Test
	public void orderNumberAutoUpdated() throws IOException{
		// Scan for annotations and get controller bean
		AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext();
		appContext.scan("com.flooringMastery");
		appContext.refresh();
		Controller controller = appContext.getBean("controller", Controller.class); // bean name should be in lower case.
		// Load the existing orders
		controller.readExistingOrders();
		String date = "07012013";
		String name = "Vaitesswar";
		String state = "TX";
		String productType = "Tile";
		String area = "100";
		Order order = controller.addOrderCreate(date,name,state,productType,area);
        assertEquals(order.getOrderNumber(),4);
        appContext.close();
    }
	
	@Test
	public void areaLessThan100() throws IOException{
		// Scan for annotations and get controller bean
		AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext();
		appContext.scan("com.flooringMastery");
		appContext.refresh();
		Controller controller = appContext.getBean("controller", Controller.class); // bean name should be in lower case.
		// Load the existing orders
		controller.readExistingOrders();
		String date = "07012013";
		String name = "Vaitesswar";
		String state = "TX";
		String productType = "Tile";
		String area = "90";
		boolean check = controller.addOrderCheck(date,name,state,productType,area);
        assertEquals(check,false);
        appContext.close();
    }
	
	@Test
	public void areaMoreThan100() throws IOException{
		// Scan for annotations and get controller bean
		AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext();
		appContext.scan("com.flooringMastery");
		appContext.refresh();
		Controller controller = appContext.getBean("controller", Controller.class); // bean name should be in lower case.
		// Load the existing orders
		controller.readExistingOrders();
		String date = "07012013";
		String name = "Vaitesswar";
		String state = "TX";
		String productType = "Tile";
		String area = "150";
		boolean check = controller.addOrderCheck(date,name,state,productType,area);
        assertEquals(check,true);
        appContext.close();
    }
	
	@Test
	public void orderEdited() throws IOException{
		// Scan for annotations and get controller bean
		AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext();
		appContext.scan("com.flooringMastery");
		appContext.refresh();
		Controller controller = appContext.getBean("controller", Controller.class); // bean name should be in lower case.
		// Load the existing orders
		controller.readExistingOrders();
		String date = "06012013";
		int orderNumber = 1;
		String name = "Vaitesswar";
		String state = "TX";
		String productType = "Tile";
		String area = "150";
		Order order = controller.editOrderCreate(orderNumber,date,name,state,productType,area);
        assertEquals(order.getArea(),new BigDecimal("150").setScale(2,RoundingMode.HALF_UP));
        appContext.close();
    }
}
