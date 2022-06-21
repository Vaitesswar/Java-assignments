enum MyDays {
    SUNDAY, MONDAY, TUESDAY;
}

enum CoffeeSize {
    SMALL (100, 200),
    MEDIUM (200, 300),
    LARGE (300, 500);
    public final int quantity;
    private final int mass;

     CoffeeSize(int quantity, int mass){
         this.quantity = quantity;
         this.mass = mass;
     }

}

class StarBucksCoffee{

    int price;
    String name;
    //String coffee_size;
    CoffeeSize size;
}

public class TestEnum {

    public static void main(String[] args){
        MyDays day = MyDays.TUESDAY;
        System.out.println(day);
        StarBucksCoffee pumpkinLatte = new StarBucksCoffee();
        pumpkinLatte.price =20;
        pumpkinLatte.name ="Pumpkin Latte";
        pumpkinLatte.size = CoffeeSize.LARGE;

        System.out.println(pumpkinLatte.size.quantity);

    }

}
