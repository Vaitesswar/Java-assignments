import java.util.Scanner;
class Calculator{

    float number1;
    float number2;
    String operator;


    Calculator(float number1, float number2, String operator){
        this.number1 = number1;
        this.number2 = number2;
        this.operator = operator;
    }

    public void add(){
        float output = this.number1 + this.number2;
        System.out.println("The value is " + output);
    }

    public void subtract(){
        float output = this.number1 - this.number2;
        System.out.println("The value is " + output);
    }

    public void multiply(){
        float output = this.number1 * this.number2;
        System.out.println("The value is " + output);
    }

    public void divide(){
        try {
            float output = this.number1 / this.number2;
            System.out.println("The value is " + output);
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }
    }

    public void compute(){
        if (this.operator.contains("+")) {
            add();
        } else if (this.operator.contains("-")) {
            subtract();
        } else if (this.operator.contains("*")) {
            multiply();
        }  else if (this.operator.contains("/")) {
            divide();
        } else {
            System.out.println("Error. Please enter a valid argument.");
        }
    }
}
public class CalculatorOOP {
    public static void main(String[] args){
        while (true) {
            System.out.println("Welcome to online calculator!");
            System.out.println("-----------------------------");
            System.out.println(" ");
            Scanner sc = new Scanner(System.in);
            System.out.println("Please enter the first number.");
            float number1 = sc.nextFloat();
            System.out.println("Please enter a operator from this list (+,-,*,/).");
            String operator = sc.next();
            System.out.println("Please enter the second number.");
            float number2 = sc.nextFloat();
            Calculator calculator = new Calculator(number1,number2, operator);
            calculator.compute();
            System.out.println("Type 'c' to continue or 'b' to 'break.");
            String step = sc.next();
            if (step.contains("c")){
                continue;
            } else if (step.contains("b")){
                break;
            }
        }
    }
}
