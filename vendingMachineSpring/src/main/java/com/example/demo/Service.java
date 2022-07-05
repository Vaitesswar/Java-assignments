package com.example.demo;

public interface Service {
	
	void insufficientFunds() throws
    	InsufficientFundsException;

	void noItemInventory() throws
    	NoItemInventoryException;

}
