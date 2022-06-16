import java.util.Scanner;

public class IfElseExam {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter your marks.");
        int marks = sc.nextInt();

        if (marks >= 90 && marks <= 100) {
            System.out.println("Your grade is A.");
        } else if (marks >= 80 && marks < 90) {
            System.out.println("Your grade is B.");
        } else if (marks >= 70 && marks < 80) {
            System.out.println("Your grade is C.");
        } else {
            System.out.println("Your grade is Fail.");
        }
    }
}
