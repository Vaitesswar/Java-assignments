package com.flooringMastery;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Controller {
	
	@Autowired 
	Service service;
	
	Controller(){}

    public void displayOrder(String date){
    	service.displayOrder(date);
    }
    
    public void displayOrder(int orderNumber,String date){
    	service.displayOrder(orderNumber,date);
    }
    
    public void displayOrder(Order order){
    	service.displayOrder(order);
    }
    
    public void readExistingOrders() throws IOException{
    	service.readExistingOrders();
    }
    
    public void displayProduct() throws IOException{
    	service.displayProduct();
    }
    
    public boolean addOrderCheck(String date,String name,String state,String productType,String area) throws IOException{
    	return service.addOrderCheck(date,name,state,productType,area);
    }
    
    public Order addOrderCreate(String date,String name,String state,String productType,String area) throws IOException{
    	return service.addOrderCreate(date,name,state,productType,area);
    }
    
    public void addOrderAdd(Order order){
    	service.addOrderAdd(order);
    }
    
    public boolean orderExists(int orderNumber,String date) {
    	return service.orderExists(orderNumber,date);
    }
    
    public Order editOrderCreate(int orderNumber,String date,String name,String state,String productType,String area) throws IOException{
    	return service.editOrderCreate(orderNumber,date,name,state,productType,area);
    }
    
    public void editOrderAdd(Order order){
    	service.editOrderAdd(order);
    }
    
    public void removeOrder(int orderNumber,String date) {
    	service.removeOrder(orderNumber,date);
    }
    
    public void exportData() throws IOException {
    	service.exportData();
    }

}
