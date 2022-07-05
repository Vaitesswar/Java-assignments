package com.example.demo;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Controller {
	
	@Autowired 
	ServiceImpl serviceImpl;
	
	Controller(){}

    public void read(String URL) throws IOException {
    	serviceImpl.read(URL);
    }

    public void print(){
    	serviceImpl.print();
    }

    public void calCoins(String amount,int item) throws NoItemInventoryException, InsufficientFundsException, IOException {
    	serviceImpl.calCoins(amount,item);
    }

    public void save() throws IOException {
    	serviceImpl.save();
    }

    public void update(int item){
    	serviceImpl.update(item);
    }

}
