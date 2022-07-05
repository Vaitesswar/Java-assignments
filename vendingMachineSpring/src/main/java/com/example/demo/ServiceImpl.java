package com.example.demo;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServiceImpl implements Service{
	
	@Autowired 
	DAO dao;

    ServiceImpl(){}

    public void read(String URL) throws IOException {
        File file = new File(URL);
        Scanner sc = new Scanner(file);
        while (sc.hasNextLine()) {
            String properties = sc.nextLine();
            dao.addItem(properties);
        }
        sc.close();
    }

    public void print(){
    	dao.printAll();
    }

    public void save() throws IOException {
    	dao.saveAll();
    }

    public void update(int item){
    	dao.updateItem(item);
    }

    public void insufficientFunds() throws
            InsufficientFundsException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void noItemInventory() throws
            NoItemInventoryException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    public void calCoins(String amt, int item) throws
            InsufficientFundsException, NoItemInventoryException, IOException {
        BigDecimal amount = new BigDecimal(amt);
        amount = amount.setScale(2, RoundingMode.HALF_UP);
        if (dao.getItem(item).getQuantity()  == 0){
        	dao.saveAll();
            throw new NoItemInventoryException(
                    "The user tries to purchase an item that has zero inventory");
        } else if (amount.compareTo(dao.getItem(item).getCost()) < 0) {
            System.out.print("Amount inserted: $" + amount);
            System.out.println(" ");
            throw new InsufficientFundsException(
                    "Insufficient funds!");
        }

        BigDecimal balance = amount.subtract(dao.getItem(item).getCost());
        balance = balance.setScale(2, RoundingMode.HALF_UP);
        System.out.println("------Balance Summary-------");
        System.out.println("Balance: $" + balance);

        List<Coins> coins = new LinkedList<>(Arrays.asList(Coins.QUARTERS,Coins.DIMES,Coins.NICKELS, Coins.PENNIES));

        for (Coins coin : coins) {
            int total = 0;
            while (balance.compareTo(coin.amount) >= 0) {
                balance = balance.subtract(coin.amount);
                total += 1;
            }
            coin.quantity = total;
        }
        // Lambda Expression
        coins.stream().forEach(coin -> System.out.println(coin.name + ": " + coin.quantity));
    }
}
