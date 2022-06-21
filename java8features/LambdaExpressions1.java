package java8features;

import java.util.Arrays;
import java.util.List;

public class LambdaExpressions1 {
    public static void main(String[] args) {
        // Finding even numbers in list
        List<Integer> myNum = Arrays.asList(2, 3, 4, 5, 7, 8, 9);
        System.out.println("Finding even numbers in list");
        myNum.stream().filter((i) -> {
            return i % 2 == 0;
        }).forEach(i -> System.out.print(i + " "));

        // Finding square of numbers
        System.out.println(" ");
        System.out.println("Finding square of numbers in list");
        myNum.stream().map((i) -> {return i*i;}).forEach((i) -> System.out.print(i + " "));

        // Finding odd numbers in list
        System.out.println(" ");
        System.out.println("Finding odd numbers in list");
        myNum.stream().filter((i) -> {return i % 2 == 1;}).forEach(i -> System.out.print(i + " "));
    }
}
