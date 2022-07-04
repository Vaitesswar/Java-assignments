package org.example;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

// Enum - Coins
enum Coins{
    QUARTERS (new BigDecimal(0.25).setScale(2, RoundingMode.HALF_UP), "Quarters", 0),
    DIMES (new BigDecimal(0.10).setScale(2, RoundingMode.HALF_UP), "Dimes", 0),
    NICKELS (new BigDecimal(0.05).setScale(2, RoundingMode.HALF_UP), "Nickels", 0),
    PENNIES (new BigDecimal(0.01).setScale(2, RoundingMode.HALF_UP), "Pennies", 0);

    final BigDecimal amount;
    final String name;
    int quantity;

    Coins(BigDecimal amount, String name, int quantity){
        this.amount = amount;
        this.name = name;
        this.quantity = quantity;
    }
}

// Model - Data Transfer Object
class Item{

    private String name;
    private BigDecimal cost;
    private int quantity;

    public Item(String name, BigDecimal cost, int quantity) {
        this.name = name;
        this.cost = cost;
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Double.compare(item.cost.doubleValue(), cost.doubleValue()) == 0 && quantity == item.quantity && Objects.equals(name, item.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, cost, quantity);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "item{" +
                "name='" + name + '\'' +
                ", cost=" + cost +
                ", quantity=" + quantity +
                '}';
    }
}

// Data Access Object (DTO must be accessed via DAO for CRUD operations to be performed).
class DAO{

    private static final LinkedList<Item> itemList = new LinkedList<Item>();

    public static void addItem(String properties){
        String[] splitProp = properties.split("::");
        BigDecimal amt = new BigDecimal(splitProp[1]);
        amt = amt.setScale(2, RoundingMode.HALF_UP);
        Item item = new Item(splitProp[0],amt,Integer.parseInt(splitProp[2])); //DTO accessed via DAO from Service.
        itemList.add(item);
    }

    public static Item getItem(int item){
        return itemList.get(item - 1);
    }

    public static LinkedList<Item> getAll(){
        return itemList;
    }

    public static void printAll(){
        System.out.println("The list of available items, their unit prices and the available quantity are as follows.");
        int ind = 1;
        for (Item item : itemList) {
            System.out.println(ind + ") " + item.getName()
                    + ", $" + item.getCost()
                    + ", " + item.getQuantity());
            ind += 1;
        }
    }

    public static void saveAll() throws IOException {
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

    public static void updateItem(int item){
        int quantity = itemList.get(item-1).getQuantity();
        itemList.get(item-1).setQuantity(quantity-1);
    }

}

// Service - Business Logic (Exceptions & Interface)
class InsufficientFundsException extends Exception {

    public InsufficientFundsException(String message) {
        super(message);
    }

    public InsufficientFundsException(String message, Throwable cause) {
        super(message, cause);
    }

}
class NoItemInventoryException extends Exception {

    public NoItemInventoryException(String message) {
        super(message);
    }

    public NoItemInventoryException(String message, Throwable cause) {
        super(message, cause);
    }

}
interface Service{
    void insufficientFunds() throws
            InsufficientFundsException;

    void noItemInventory() throws
            NoItemInventoryException;
}

// Service - Business Logic (Implementation)
class ServiceImpl implements Service{

    ServiceImpl(){}

    public static void read(String URL) throws IOException {
        File file = new File(URL);
        Scanner sc = new Scanner(file);
        while (sc.hasNextLine()) {
            String properties = sc.nextLine();
            DAO.addItem(properties);
        }
    }

    public static void print(){
        DAO.printAll();
    }

    public static void save() throws IOException {
        DAO.saveAll();
    }

    public static void update(int item){
        DAO.updateItem(item);
    }

    public void insufficientFunds() throws
            InsufficientFundsException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void noItemInventory() throws
            NoItemInventoryException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    public static void calCoins(String amt, int item) throws
            InsufficientFundsException, NoItemInventoryException, IOException {
        BigDecimal amount = new BigDecimal(amt);
        amount = amount.setScale(2, RoundingMode.HALF_UP);
        if (DAO.getItem(item).getQuantity()  == 0){
            DAO.saveAll();
            throw new NoItemInventoryException(
                    "The user tries to purchase an item that has zero inventory");
        } else if (amount.compareTo(DAO.getItem(item).getCost()) < 0) {
            DAO.saveAll();
            System.out.print("Amount inserted: $" + amount);
            System.out.println(" ");
            throw new InsufficientFundsException(
                    "Insufficient funds!");
        }

        BigDecimal balance = amount.subtract(DAO.getItem(item).getCost());
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

// Controller
class Controller{

    Controller(){}

    public static void read(String URL) throws IOException {
        ServiceImpl.read(URL);
    }

    public static void print(){
        ServiceImpl.print();
    }

    public static void calCoins(String amount,int item) throws NoItemInventoryException, InsufficientFundsException, IOException {
        ServiceImpl.calCoins(amount,item);
    }

    public static void save() throws IOException {
        ServiceImpl.save();
    }

    public static void update(int item){
        ServiceImpl.update(item);
    }

}

// View - User Interface
public class AppTest {
    @Test
    public void simpleTest1() throws IOException, NoItemInventoryException, InsufficientFundsException {
        Controller.read("src/test/items.txt");
        String amount = "1.50";
        int item = 5;
        Controller.update(item);
        LinkedList<Item> itemList = DAO.getAll();
        int[] realArr = {7,0,1,3,3};
        int[] testArr = new int[realArr.length];
        for (int j = 0; j < realArr.length; j += 1){
            testArr[j] = itemList.get(j).getQuantity();
        }
        assertArrayEquals(realArr,testArr);
    }

    @Test
    public void simpleTest2() throws IOException, NoItemInventoryException, InsufficientFundsException {
        Controller.read("src/test/items.txt");
        Scanner sc = new Scanner(System.in).useDelimiter("\n");
        String amount = "1.50";
        int item = 3;
        Controller.update(item);
        LinkedList<Item> itemList = DAO.getAll();
        int[] realArr = {7,0,0,3,4};
        int[] testArr = new int[realArr.length];
        for (int j = 0; j < realArr.length; j += 1){
            testArr[j] = itemList.get(j).getQuantity();
        }
        assertArrayEquals(realArr,testArr);
    }
}

