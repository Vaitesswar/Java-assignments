class Laptop{
    int price;
    String company;

    public void playsMusic() {
        System.out.println("Laptop is playing music.");
    }

    public void getConfig() {
        System.out.println("This brand of this laptop is " + this.company);
    }
}

public class TestOOPs1 {

    public static void main(String[] args){
        Laptop laptop = new Laptop(); //create laptop object
        laptop.price = 5000;
        laptop.company = "Lenovo";
        laptop.getConfig();
    }
}
