package com.flooringMastery;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Service {
	
	@Autowired 
	DAO DAO;
	
	public void displayOrder(String date) {
		DAO.displayOrder(date);
	}
	
	public void displayOrder(int orderNumber,String date){
    	DAO.displayOrder(orderNumber,date);
    }

	public void displayOrder(Order order){
    	DAO.displayOrder(order);
    }
	
	public void readExistingOrders() throws IOException{
		DAO.readExistingOrders();
	}
	
    public void displayProduct() throws IOException{
    	File directoryPath = new File("src/main/resources/SampleFileData/Data/Products.txt");
    	Scanner sc = new Scanner(directoryPath);
    	while(sc.hasNextLine()) {
    		System.out.println(sc.nextLine());
    	}
    	sc.close();
    }
    
    public boolean addOrderCheck(String date,String name,String state,String productType,String area)throws IOException{
    	boolean orderCheck = true;
    	if (Float.valueOf(area) < 100) {
    		System.out.println("ERROR: Area is less than 100 ft.");
    		orderCheck = false;
        }
        File directoryPath = new File("src/main/resources/SampleFileData/Data/Taxes.txt");
        Scanner sc = new Scanner(directoryPath);
        Map<String,String[]> stateMap = new HashMap<>();
        while(sc.hasNextLine()) {
        	String[] stateInfo = sc.nextLine().split(",");
        	stateMap.put(stateInfo[0], Arrays.copyOfRange(stateInfo, 1, stateInfo.length));
        }
        sc.close();
        boolean isState = false;
        for (String stateAbb:stateMap.keySet()) {
        	if (stateAbb.equals(state)) {
        		isState = true;
        	}
        	}
        if (!isState) {
        	System.out.println("ERROR: State is not available.");
        	orderCheck = false;
        }
        return orderCheck;
    }
    
    public Order addOrderCreate(String date,String name,String state,String productType,String area)throws IOException{	
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
        BigDecimal Area = new BigDecimal(area).setScale(2,RoundingMode.HALF_UP);
        BigDecimal CostPerSquareFoot = new BigDecimal(materialMap.get(productType)[0]).setScale(2,RoundingMode.HALF_UP);
        BigDecimal LaborCostPerSquareFoot = new BigDecimal(materialMap.get(productType)[1]).setScale(2,RoundingMode.HALF_UP);
        BigDecimal MaterialCost = Area.multiply(CostPerSquareFoot).setScale(2,RoundingMode.HALF_UP);
        BigDecimal LaborCost = Area.multiply(LaborCostPerSquareFoot).setScale(2,RoundingMode.HALF_UP);
        BigDecimal hundred = new BigDecimal(100).setScale(2,RoundingMode.HALF_UP);
        BigDecimal Tax = (MaterialCost.add(LaborCost)).multiply(TaxRate.divide(hundred)).setScale(2,RoundingMode.HALF_UP);
        BigDecimal Total = MaterialCost.add(LaborCost).add(Tax).setScale(2,RoundingMode.HALF_UP);
        Order order = DAO.addOrderCreate(date,name,state,TaxRate,productType,Area,
        				CostPerSquareFoot,LaborCostPerSquareFoot,
        				MaterialCost,LaborCost,Tax,Total);
    	return order;    	
    }
    
    public void addOrderAdd(Order order){
    	DAO.addOrderAdd(order);
    }
    
    public boolean orderExists(int orderNumber,String date) {
    	return DAO.orderExists(orderNumber,date);
    }

    public Order editOrderCreate(int orderNumber,String date,String name,String state,String productType,String area) throws IOException{
    	return DAO.editOrderCreate(orderNumber,date,name,state,productType,area);
    }
    
    public void editOrderAdd(Order order){
    	DAO.editOrderAdd(order);
    }

    public void removeOrder(int orderNumber,String date) {
    	DAO.removeOrder(orderNumber,date);
    }
    
    public void exportData() throws IOException {
    	DAO.exportData();
    }
}

