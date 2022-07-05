package com.example.demo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.LinkedList;

import org.springframework.stereotype.Component;

@Component
public class DAO{
	
    private final LinkedList<Item> itemList = new LinkedList<Item>();
    
    DAO(){}

    public void addItem(String properties){
        String[] splitProp = properties.split("::");
        BigDecimal amt = new BigDecimal(splitProp[1]);
        amt = amt.setScale(2, RoundingMode.HALF_UP);
        Item item = new Item(splitProp[0],amt,Integer.parseInt(splitProp[2])); //DTO accessed via DAO from Service.
        itemList.add(item);
    }

    public Item getItem(int item){
        return itemList.get(item - 1);
    }

    public LinkedList<Item> getAll(){
        return itemList;
    }

    public void printAll(){
        System.out.println("The list of available items, their unit prices and the available quantity are as follows.");
        int ind = 1;
        for (Item item : itemList) {
            System.out.println(ind + ") " + item.getName()
                    + ", $" + item.getCost()
                    + ", " + item.getQuantity());
            ind += 1;
        }
    }

    public void saveAll() throws IOException {
        FileWriter fileStream = new FileWriter("src/main/Resources/items.txt");
        BufferedWriter info = new BufferedWriter(fileStream);
        for (Item item:itemList){
            String output = item.getName() + "::" +
                    item.getCost() + "::" +
                    item.getQuantity();
            info.write(output);
            info.newLine();
        }
        info.close();
    }

    public void updateItem(int item){
        int quantity = itemList.get(item-1).getQuantity();
        itemList.get(item-1).setQuantity(quantity-1);
    }

}
