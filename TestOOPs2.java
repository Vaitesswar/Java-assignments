class Laptop1{
    int price; // empty variables created within class.
    String company;
    Laptop1(int price, String company ) { // Constructor
        System.out.println("Hello");
        this.price = price; // Supplied as an input variable.
        this.company = company;

    }
    public void playsMusic() {
        System.out.println("Laptop is playing music.");
    }

    public void getConfig() {
        System.out.println("This brand of this laptop is " + this.company);
    }
}
public class TestOOPs2 {
    public static void main(String[] args) {

        Laptop1 laptop = new Laptop1(5000,"Dell"); //create laptop object
        Laptop1 laptop1 = new Laptop1(7000, "Macbook");
        laptop.getConfig();
        laptop1.getConfig();

    }
}
