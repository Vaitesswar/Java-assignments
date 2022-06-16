import java.util.Scanner;

public class TestIfElse {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in); // Object is only created here. Nothing is assigned.
        System.out.println("Enter your age :)");
        int age = sc.nextInt(); // Capture the next integer that is being entered by using the scanner.

        if (age<20) {
            System.out.println("Not married.");
        } else {
            System.out.println("Married.");
        }
    }

}
