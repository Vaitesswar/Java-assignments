package com.flooringMastery;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;
import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.stereotype.Component;

@Component
public class DAO {
	private int maxOrderNumber;
	private LinkedList<Order> orderList = new LinkedList<Order>();
	
	public void readExistingOrders() throws IOException{
		//Creating a File object for directory
	    File directoryPath = new File("src/main/resources/SampleFileData/Orders/");
	    //List of all files and directories
	    File filesList[] = directoryPath.listFiles();
	    this.maxOrderNumber = 0;
		for (File file:filesList) {
			Scanner sc = new Scanner(file);
			sc.nextLine();
			while (sc.hasNextLine()) {
				String[] info = sc.nextLine().split(",");
				String[] fileInfo = file.getName().split("_");
				String Date = fileInfo[1].substring(0, 8);
				int OrderNumber = Integer.valueOf(info[0]);
				if (OrderNumber > this.maxOrderNumber) {
					this.maxOrderNumber = OrderNumber;
				}
				String CustomerName = info[1];
				String State = info[2];		
				BigDecimal TaxRate = new BigDecimal(info[3]).setScale(2);
				String ProductType = info[4];
				BigDecimal Area = new BigDecimal(info[5]).setScale(2);
				BigDecimal CostPerSquareFoot = new BigDecimal(info[6]).setScale(2);
				BigDecimal LaborCostPerSquareFoot = new BigDecimal(info[7]).setScale(2);
				BigDecimal MaterialCost = new BigDecimal(info[8]).setScale(2);
				BigDecimal LaborCost = new BigDecimal(info[9]).setScale(2);
				BigDecimal Tax = new BigDecimal(info[10]).setScale(2);
				BigDecimal Total = new BigDecimal(info[11]).setScale(2);
				Order order = new Order(Date,OrderNumber,CustomerName,State,TaxRate,
										ProductType,Area,CostPerSquareFoot,LaborCostPerSquareFoot,
										MaterialCost,LaborCost,Tax,Total);
				orderList.add(order);
			}
			sc.close();				
		}					
	}
	
	public void displayOrder(String date){
		boolean orderAvailable = false;
		for (Order order:orderList) {
			if (order.getDate().equals(date)){
				orderAvailable = true;
				System.out.println("Date: " + order.getDate());
				System.out.println("OrderNumber: " + order.getOrderNumber());
				System.out.println("CustomerName: " + order.getCustomerName());
				System.out.println("State: " + order.getState());
				System.out.println("TaxRate: " + order.getTaxRate());
				System.out.println("ProductType: " + order.getProductType());
				System.out.println("Area: " + order.getArea());
				System.out.println("CostPerSquareFoot: " + order.getCostPerSquareFoot());
				System.out.println("LaborCostPerSquareFoot: " + order.getLaborCostPerSquareFoot());
				System.out.println("MaterialCost: " + order.getMaterialCost());
				System.out.println("LaborCost: " + order.getLaborCost());
				System.out.println("Tax: " + order.getTax());
				System.out.println("LaborCost: " + order.getLaborCost());
				System.out.println("Total: " + order.getTotal());
				System.out.println(" ");
			}
		}
		if (!orderAvailable) {
			System.out.println("ERROR: No orders exist for that date.");
		}
	}
	
	public void displayOrder(int orderNumber,String date){
		for (Order order:orderList) {
			if (order.getDate().equals(date) && order.getOrderNumber() == orderNumber){
				System.out.println("Date: " + order.getDate());
				System.out.println("OrderNumber: " + order.getOrderNumber());
				System.out.println("CustomerName: " + order.getCustomerName());
				System.out.println("State: " + order.getState());
				System.out.println("TaxRate: " + order.getTaxRate());
				System.out.println("ProductType: " + order.getProductType());
				System.out.println("Area: " + order.getArea());
				System.out.println("CostPerSquareFoot: " + order.getCostPerSquareFoot());
				System.out.println("LaborCostPerSquareFoot: " + order.getLaborCostPerSquareFoot());
				System.out.println("MaterialCost: " + order.getMaterialCost());
				System.out.println("LaborCost: " + order.getLaborCost());
				System.out.println("Tax: " + order.getTax());
				System.out.println("LaborCost: " + order.getLaborCost());
				System.out.println("Total: " + order.getTotal());
				System.out.println(" ");
			}
		}
    }

	public void displayOrder(Order order) {
		System.out.println("Order summary");
		System.out.println("---------------------------------------");
		System.out.println("Date: " + order.getDate());
		System.out.println("OrderNumber: " + order.getOrderNumber());
		System.out.println("CustomerName: " + order.getCustomerName());
		System.out.println("State: " + order.getState());
		System.out.println("TaxRate: " + order.getTaxRate());
		System.out.println("ProductType: " + order.getProductType());
		System.out.println("Area: " + order.getArea());
		System.out.println("CostPerSquareFoot: " + order.getCostPerSquareFoot());
		System.out.println("LaborCostPerSquareFoot: " + order.getLaborCostPerSquareFoot());
		System.out.println("MaterialCost: " + order.getMaterialCost());
		System.out.println("LaborCost: " + order.getLaborCost());
		System.out.println("Tax: " + order.getTax());
		System.out.println("Total: " + order.getTotal());
	}
	
	public Order addOrderCreate(String date,String name,String state,BigDecimal TaxRate,
			String productType,BigDecimal Area,BigDecimal CostPerSquareFoot,BigDecimal LaborCostPerSquareFoot,
			BigDecimal MaterialCost,BigDecimal LaborCost,BigDecimal Tax,BigDecimal Total){
		this.maxOrderNumber += 1;
		Order order = new Order(date,this.maxOrderNumber,name,state,TaxRate,
				productType,Area,CostPerSquareFoot,LaborCostPerSquareFoot,
				MaterialCost,LaborCost,Tax,Total);
		return order;	
	}
	
	public void addOrderAdd(Order order){
    	orderList.add(order);
    }
	
	public boolean orderExists(int orderNumber,String date){
    	boolean isOrder = false;
    	for(Order order:orderList) {
    		if(order.getOrderNumber() == orderNumber && date.equals(order.getDate())) {
    			isOrder = true;
    			break;
    		}
    	}
    	return isOrder;
    }
	
	public Order editOrderCreate(int orderNumber,String date,String name,String state,String productType,String area) throws IOException{
		Order existOrder =  new Order();
		for(Order order:orderList) {
    		if(order.getOrderNumber() == orderNumber && date.equals(order.getDate())) {
    			existOrder = order;
    			break;
    		}
    	}
		BigDecimal Area = new BigDecimal(0).setScale(2,RoundingMode.HALF_UP);
		// Filling empty fields
		if (name.isEmpty()) {
			name = existOrder.getCustomerName();
		}
		if (state.isEmpty()) {
			state = existOrder.getState();
		}
		if (productType.isEmpty()) {
			productType = existOrder.getProductType();
		}
		if (area.isEmpty()) {
			Area = existOrder.getArea().setScale(2,RoundingMode.HALF_UP);
		} else{
			Area = new BigDecimal(area).setScale(2,RoundingMode.HALF_UP);
		}
		// Editing necessary fields
		if (!name.equals(existOrder.getCustomerName())) {
			existOrder.setCustomerName(name);
		}
		if (!state.equals(existOrder.getState()) 
			|| !productType.equals(existOrder.getProductType())
			|| Area.compareTo(existOrder.getArea()) != 0) {
			File directoryPath = new File("src/main/resources/SampleFileData/Data/Taxes.txt");
        	Scanner sc = new Scanner(directoryPath);
        	Map<String,String[]> stateMap = new HashMap<>();
        	while(sc.hasNextLine()) {
        		String[] stateInfo = sc.nextLine().split(",");
        		stateMap.put(stateInfo[0], Arrays.copyOfRange(stateInfo, 1, stateInfo.length));
        	}
        	sc.close();
        	File filePath = new File("src/main/resources/SampleFileData/Data/Products.txt");
        	Scanner sc1 = new Scanner(filePath);
        	Map<String,String[]> materialMap = new HashMap<>();
        	while(sc1.hasNextLine()) {
        		String[] stateInfo = sc1.nextLine().split(",");
        		materialMap.put(stateInfo[0], Arrays.copyOfRange(stateInfo, 1, stateInfo.length));
        	}
        	sc1.close();
        	BigDecimal TaxRate = new BigDecimal(stateMap.get(state)[1]).setScale(2,RoundingMode.HALF_UP);
        	BigDecimal CostPerSquareFoot = new BigDecimal(materialMap.get(productType)[0]).setScale(2,RoundingMode.HALF_UP);
        	BigDecimal LaborCostPerSquareFoot = new BigDecimal(materialMap.get(productType)[1]).setScale(2,RoundingMode.HALF_UP);
        	BigDecimal MaterialCost = Area.multiply(CostPerSquareFoot).setScale(2,RoundingMode.HALF_UP);
        	BigDecimal LaborCost = Area.multiply(LaborCostPerSquareFoot).setScale(2,RoundingMode.HALF_UP);
        	BigDecimal hundred = new BigDecimal(100).setScale(2,RoundingMode.HALF_UP);
        	BigDecimal Tax = (MaterialCost.add(LaborCost)).multiply(TaxRate.divide(hundred)).setScale(2,RoundingMode.HALF_UP);
        	BigDecimal Total = MaterialCost.add(LaborCost).add(Tax).setScale(2,RoundingMode.HALF_UP);
        	existOrder.setState(state);
        	existOrder.setTaxRate(TaxRate);
        	existOrder.setProductType(productType);
        	existOrder.setArea(Area);
        	existOrder.setCostPerSquareFoot(CostPerSquareFoot);
        	existOrder.setLaborCostPerSquareFoot(LaborCostPerSquareFoot);
        	existOrder.setMaterialCost(MaterialCost);
        	existOrder.setLaborCost(LaborCost);
        	existOrder.setTax(Tax);
        	existOrder.setTotal(Total);
		}
		return existOrder;
	}	

	public void editOrderAdd(Order existOrder){
		for(Order order:orderList) {
    		if(order.getOrderNumber() == existOrder.getOrderNumber() && existOrder.getDate().equals(order.getDate())) {
    			order = existOrder;
    			break;
    		}
    	}
	}
	
	public void removeOrder(int orderNumber,String date) {
		for (Order order:orderList) {
			if (order.getDate().equals(date) && order.getOrderNumber() == orderNumber){
				orderList.remove(order);
				break;
			}
		}
	}
	
	public void exportData() throws IOException {
		FileWriter fileStream = new FileWriter("src/main/resources/SampleFileData/Backup/DataExport.txt");
        BufferedWriter info = new BufferedWriter(fileStream);
        info.write("OrderNumber,CustomerName,State,TaxRate,"
        		+ "ProductType,Area,CostPerSquareFoot,LaborCostPerSquareFoot,"
        		+ "MaterialCost,LaborCost,Tax,Total,OrderDate");
        info.newLine();
        for (Order order:orderList){
            String output = order.getOrderNumber() + "," +
                    		order.getCustomerName() + "," +
                    		order.getState() + "," +
                    		order.getTaxRate() + "," +
                    		order.getProductType() + "," +
                    		order.getArea() + "," +
                    		order.getCostPerSquareFoot() + "," +
                    		order.getLaborCostPerSquareFoot() + "," +
                    		order.getMaterialCost() + "," +
                    		order.getLaborCost() + "," +
                    		order.getTax() + "," +
                    		order.getTotal() + "," +
                    		order.getDate();
            info.write(output);
            info.newLine();
        }
        info.close();
    }
}