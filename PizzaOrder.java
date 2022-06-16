import java.util.ArrayList;
import java.util.Scanner;
class Pizza{ // Pizza class to create each pizza object (name and price).
    private String pizza_name; /// Private access
    private float price;

    public String getPizza_name() { /// Getter function
        return pizza_name;
    }

    public float getPrice() {
        return price;
    }

    Pizza(String pizza_name, float price) {
        this.pizza_name = pizza_name;
        this.price = price;
    }

}

class Service{ // Service class to create object for each order (pizza_name, price and quantity).

    private int quantity;

    private String pizza_name;
    private float price;

    public int getQuantity() {
        return quantity;
    }

    public String getPizza_name() {
        return pizza_name;
    }

    public float getPrice() {
        return price;
    }

    Service(Pizza pizza, int quantity) { // Passing objects is different from extending objects.
        this.pizza_name = pizza.getPizza_name();
        this.price = pizza.getPrice();
        this.quantity = quantity;
    }
    public float computeCost() {
        float cost = this.price * this.quantity;
        return cost;
    }
}

public class PizzaOrder {
    public static void main(String[] args){
        System.out.println("Welcome to Dominos' Pizza. Please proceed with your order for delivery.");
        System.out.println("-----------------------------------------------------------------------");
        Scanner sc = new Scanner(System.in);
        System.out.println(" ");

        /// Create pizza objects
        ArrayList <Pizza> Pizzas = new ArrayList<>();
        String[] pizza_names = {"Very Veggie", "Cheesy burst", "Garden Veggie", "Trio Cheese"};
        float[] pizza_prices = {9.00f,11.00f,10.50f,12.70f};

        for (int i = 0; i < pizza_prices.length; i += 1){
            Pizza pizza = new Pizza(pizza_names[i], pizza_prices[i]);
            Pizzas.add(pizza);
        }

        /// Start order
        ArrayList <Service> Services = new ArrayList<>();

        while (true) {
            System.out.println("Please choose your pizza from the menu below.");
            int i = 1;
            for (Pizza pizza: Pizzas) {
                System.out.println("(" + i + ") " + pizza.getPizza_name() + ":  $" + pizza.getPrice());
                i += 1;
            }
            System.out.println(" ");
            System.out.println("Enter the pizza (number).");
            int pizza_number = sc.nextInt();
            System.out.println("Enter the quantity.");
            int quantity = sc.nextInt();
            Service order = new Service(Pizzas.get(pizza_number-1), quantity); /// New order
            Services.add(order); /// Storing each new order
            System.out.println(" ");
            System.out.println("Type c to order more or type e to checkout.");
            String choice = sc.next();
            if (choice.contains("c")) {
                continue;
            } else if (choice.contains("e")) {
                break;
            }
        }

        System.out.println("~~~~~~~~~~~ Checkout ~~~~~~~~~~~~~~~");
        System.out.println(" ");
        System.out.println("-------- Cost breakdown ------------");
        float total_cost = 0f;
        for (Service order: Services) {
            total_cost += order.computeCost();
            System.out.println(order.getPizza_name() + ": $" + order.getPrice() + " x " + order.getQuantity() + " = $" + order.computeCost());
        }
        System.out.println("------------------------------------");
        System.out.println("Total $ "  + total_cost + " .");
    }
}