package mycollection;

import java.io.File;
import java.io.IOException;
import java.util.*;

class ExpirySearch {
    private ArrayList<String> cardHolderNamesArray;
    private ArrayList<Integer> daysToExpiryArray;

    public ExpirySearch(ArrayList<String> cardHolderNamesArray, ArrayList<Integer> daysToExpiryArray) {
        this.cardHolderNamesArray = cardHolderNamesArray;
        this.daysToExpiryArray = daysToExpiryArray;
    }

    public ArrayList<String> getCardHolderNamesArray() {
        return cardHolderNamesArray;
    }

    public void setCardHolderNamesArray(ArrayList<String> cardHolderNamesArray) {
        this.cardHolderNamesArray = cardHolderNamesArray;
    }

    public ArrayList<Integer> getDaysToExpiryArray() {
        return daysToExpiryArray;
    }

    public void setDaysToExpiryArray(ArrayList<Integer> daysToExpiryArray) {
        this.daysToExpiryArray = daysToExpiryArray;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExpirySearch that = (ExpirySearch) o;
        return Objects.equals(cardHolderNamesArray, that.cardHolderNamesArray) && Objects.equals(daysToExpiryArray, that.daysToExpiryArray);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardHolderNamesArray, daysToExpiryArray);
    }

    @Override
    public String toString() {
        return "ExpirySearch{" +
                "cardHolderNamesArray=" + cardHolderNamesArray +
                ", daysToExpiryArray=" + daysToExpiryArray +
                '}';
    }

    public int checkExpiry(String queryName){
        int ind = 0;
        for (String cardHolderName:this.cardHolderNamesArray){
            if (queryName.equals(cardHolderName)){
                break;
            }
            ind += 1;
        }
        try {
            queryName.equals(this.cardHolderNamesArray.get(ind));
            return this.daysToExpiryArray.get(ind);
        } catch (IndexOutOfBoundsException i){
            return -1;
        }

    }
}

class AddCardHolder{

    private LinkedList<String> cardHolderNamesList;
    private LinkedList<Integer> daysToExpiryList;

    public AddCardHolder(LinkedList<String> cardHolderNamesList, LinkedList<Integer> daysToExpiryList) {
        this.cardHolderNamesList = cardHolderNamesList;
        this.daysToExpiryList = daysToExpiryList;
    }

    public LinkedList<String> getCardHolderNamesList() {
        return cardHolderNamesList;
    }

    public void setCardHolderNamesList(LinkedList<String> cardHolderNamesList) {
        this.cardHolderNamesList = cardHolderNamesList;
    }

    public LinkedList<Integer> getDaysToExpiryList() {
        return daysToExpiryList;
    }

    public void setDaysToExpiryList(LinkedList<Integer> daysToExpiryList) {
        this.daysToExpiryList = daysToExpiryList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddCardHolder that = (AddCardHolder) o;
        return Objects.equals(cardHolderNamesList, that.cardHolderNamesList) && Objects.equals(daysToExpiryList, that.daysToExpiryList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardHolderNamesList, daysToExpiryList);
    }

    @Override
    public String toString() {
        return "AddCustomer{" +
                "cardHolderNamesList=" + cardHolderNamesList +
                ", daysToExpiryList=" + daysToExpiryList +
                '}';
    }

    public void addCardHolder(String cardHolderName, int daysToExpiry, ExpirySearch expirySearch){
        this.cardHolderNamesList.add(cardHolderName);
        this.daysToExpiryList.add(daysToExpiry);

        // Updating name and days to expire for LinkedList
        ArrayList<String> cardHolderNamesArray = expirySearch.getCardHolderNamesArray();
        ArrayList<Integer> daysToExpiryArray = expirySearch.getDaysToExpiryArray();

        // Updating name and days to expire for ArrayList
        cardHolderNamesArray.add(cardHolderName);
        daysToExpiryArray.add(daysToExpiry);
        expirySearch.setCardHolderNamesArray(cardHolderNamesArray);
        expirySearch.setDaysToExpiryArray(daysToExpiryArray);

        System.out.println("New card holder added successfully.");
    }
}

class UpdateExpiryDays{

    UpdateExpiryDays(){}

    public void updateExpiryDays(ExpirySearch expirySearch, AddCardHolder addCardHolder){
        for (int i = 0; i < expirySearch.getDaysToExpiryArray().size(); i += 1){
            int days = expirySearch.getDaysToExpiryArray().get(i);
            days -= 1;
            expirySearch.getDaysToExpiryArray().set(i, days);
            addCardHolder.getDaysToExpiryList().set(i, days);
        }
    }
}

public class BankApp {
    //Cards expiry search (check if card is expired)
    //Cards upgrade functionality (add new customer)
    //New card creation
    public static void main(String[] args) throws IOException {
        File file = new File("src/mycollection/names.txt");
        Scanner sc = new Scanner(file);
        Random random = new Random(); // Random number of days to expiry
        ArrayList<String> cardHolderNamesArray = new ArrayList<String>();
        ArrayList<Integer> daysToExpiryArray = new ArrayList<Integer>();
        LinkedList<String> cardHolderNamesLinked = new LinkedList<String>();
        LinkedList<Integer> daysToExpiryLinked = new LinkedList<Integer>();
        while (sc.hasNextLine()){
            String cardHolderName = sc.next();
            cardHolderNamesArray.add(cardHolderName);
            cardHolderNamesLinked.add(cardHolderName);
            int daysToExpiry = random.nextInt(730) + 1; // Expiration within 2 years
            daysToExpiryArray.add(daysToExpiry);
            daysToExpiryLinked.add(daysToExpiry);
        }

        /// Creating bank application objects
        ExpirySearch expirySearch = new ExpirySearch(cardHolderNamesArray,daysToExpiryArray);
        AddCardHolder addCardHolder = new AddCardHolder(cardHolderNamesLinked,daysToExpiryLinked);
        UpdateExpiryDays updateExpiryDays = new UpdateExpiryDays();
        Scanner scBank = new Scanner(System.in);
        //System.out.println(expirySearch.getDaysToExpiryArray());
        while (true) {
            System.out.println("------ Welcome to ABC Bank Server ------");
            System.out.println(" ");
            System.out.println("1) Check card expiry date");
            System.out.println("2) Add new user");
            System.out.println("3) Update expiry days");
            System.out.println(" ");
            System.out.println("Please choose a task (Enter 1,2 or 3).");
            int number = scBank.nextInt();
            if (number == 1) {
                System.out.println("Please enter card holder's name.");
                String queryName = scBank.next();
                int daysToExpiry = expirySearch.checkExpiry(queryName);
                if (daysToExpiry != -1) {
                    System.out.println("Days to expiry: " + daysToExpiry);
                } else {
                    System.out.println("User does not exist.");
                }
            } else if (number == 2) {
                System.out.println("Please enter card holder's name.");
                String addName = scBank.next();
                System.out.println("Please enter the days to card expiry.");
                int daysToExpiry = scBank.nextInt();
                addCardHolder.addCardHolder(addName, daysToExpiry, expirySearch);
            } else if (number == 3) {
                updateExpiryDays.updateExpiryDays(expirySearch, addCardHolder);
            }
            System.out.println(" ");
            System.out.println("Type c to perform more tasks or type e to exit.");
            String choice = scBank.next();
            if (choice.contains("c")) {
                continue;
            } else if (choice.contains("e")) {
                break;
            }
        }
        //System.out.println(expirySearch.getCardHolderNamesArray());
        //System.out.println(expirySearch.getDaysToExpiryArray());
        //System.out.println(addCardHolder.getCardHolderNamesList());
        //System.out.println(addCardHolder.getDaysToExpiryList());
    }

}
