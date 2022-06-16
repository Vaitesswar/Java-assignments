import java.util.Scanner;

public class TestIfElseMore {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("What is your age?");
        int age = sc.nextInt();
        System.out.println("Are you single? (Type Yes or No)");
        String single = sc.next();
        System.out.println("Are you wearing shoes? (Type Yes or No)");
        String shoe = sc.next();

        if (age > 21) {
            if (single.equals("Yes")) {
                if (shoe.equals("Yes")) {
                    System.out.println("You are allowed in party :)");
                } else {
                    System.out.println("You are not allowed in party :(");
                }
            } else {
                System.out.println("You are not allowed in party :(");
            }
        } else {
            System.out.println("You are not allowed in party :(");
        }
    }
}