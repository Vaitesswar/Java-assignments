import java.util.Scanner;
class Calculator3{

    Calculator3(){}

    /// Method overloading
    public void add(float number1, float number2){
        float output = number1 + number2;
        System.out.println("The value is " + output);
    }

    public void add(float number1, float number2, float number3){
        float output = number1 + number2 + number3;
        System.out.println("The value is " + output);
    }

    public void subtract(float number1, float number2){
        float output = number1 + number2;
        System.out.println("The value is " + output);
    }

    public void subtract(float number1, float number2, float number3){
        float output = number1 - number2 - number3;
        System.out.println("The value is " + output);
    }

    public void multiply(float number1, float number2){
        float output = number1 * number2;
        System.out.println("The value is " + output);
    }

    public void multiply(float number1, float number2, float number3){
        float output = number1 * number2 * number3;
        System.out.println("The value is " + output);
    }

    public void divide(float number1, float number2){
        try {
            float output = number1 / number2;
            System.out.println("The value is " + output);
        } catch (ArithmeticException e){
            System.out.println(e.getMessage());
        }
    }

    public void divide(float number1, float number2, float number3){
        try {
            float output = (number1 / number2) / number3;
            System.out.println("The value is " + output);
        } catch (ArithmeticException e){
            System.out.println(e.getMessage());
        }
    }

}

class SciCalculator2 extends Calculator3 { /// Inheritance

    SciCalculator2(){}

    public void square(float x){
        float output = x*x;
        System.out.println(output);
    }

    public void cube(float x){
        float output = x*x*x;
        System.out.println(output);
    }

    public void squareRoot(float x){
        float output = (float)Math.pow(x,0.5);
        System.out.println(output);
    }

    public void cubeRoot(float x){
        float output = (float)Math.pow(x,0.5);
        System.out.println(output);
    }

}

public class ScientificCalculator {
    public static void main(String[] args){
        while (true) {
            System.out.println("Welcome to online calculator!");
            System.out.println("-----------------------------");
            System.out.println(" ");
            Scanner sc = new Scanner(System.in);
            System.out.println("-------- List of operations ----------");
            System.out.println("1) +,-,*,/");
            System.out.println("2) Square,Cube,SquareRoot,CubeRoot");
            System.out.println("Enter the number associated with class of operations you want to perform (1 or 2).");
            SciCalculator2 calculator = new SciCalculator2(); /// Inheritance
            int category = sc.nextInt();
            if (category == 1) {
                System.out.println("How many numbers does your operation involve (Enter 2 or 3)");
                int quantity = sc.nextInt();
                if (quantity == 2) {
                    System.out.println("Please enter the first number.");
                    float number1 = sc.nextFloat();
                    System.out.println("Please enter the second number.");
                    float number2 = sc.nextFloat();
                    System.out.println("Please enter a operator from this list (+,-,*,/).");
                    String operator = sc.next();
                    if (operator.contains("+")) {
                        calculator.add(number1, number2);
                    } else if (operator.contains("-")) {
                        calculator.subtract(number1, number2);
                    } else if (operator.contains("*")) {
                        calculator.multiply(number1, number2);
                    } else if (operator.contains("/")) {
                        calculator.divide(number1, number2);
                    } else {
                        System.out.println("Error. Please enter a valid argument.");
                    }
                } else if (quantity == 3) {
                    System.out.println("Please enter the first number.");
                    float number1 = sc.nextFloat();
                    System.out.println("Please enter the second number.");
                    float number2 = sc.nextFloat();
                    System.out.println("Please enter the third number.");
                    float number3 = sc.nextFloat();
                    System.out.println("Please enter a operator from this list (+,-,*,/).");
                    String operator = sc.next();
                    if (operator.contains("+")) {
                        calculator.add(number1, number2, number3);
                    } else if (operator.contains("-")) {
                        calculator.subtract(number1, number2, number3);
                    } else if (operator.contains("*")) {
                        calculator.multiply(number1, number2, number3);
                    } else if (operator.contains("/")) {
                        calculator.divide(number1, number2, number3);
                    } else {
                        System.out.println("Error. Please enter a valid argument.");
                    }
                }
            } else if (category == 2) {
                System.out.println("Please enter the number.");
                float number = sc.nextFloat();
                System.out.println("Type the operator from this list (Square,Cube,SquareRoot,CubeRoot).");
                String operator = sc.next();
                if (operator.contains("Square")) {
                    calculator.square(number);
                } else if (operator.contains("Cube")) {
                    calculator.cube(number);
                } else if (operator.contains("SquareRoot")) {
                    calculator.squareRoot(number);
                } else if (operator.contains("CubeRoot")) {
                    calculator.cubeRoot(number);
                } else {
                    System.out.println("Error. Please enter a valid argument.");
                }
            }
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