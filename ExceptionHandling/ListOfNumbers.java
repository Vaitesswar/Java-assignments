package ExceptionHandling;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ListOfNumbers {

    public static void main(String[] args) throws IOException { // Throwing IOException
        File file = new File("Resources/myfile.txt");
        Scanner sc = new Scanner(file);
        int[] arr = new int[1];
        ArrayList<Integer> arrLs = new ArrayList<>(); // Built-in dynamic array
        int count = 0;
        while (sc.hasNextLine()){
            count += 1;
            if (count > arr.length) { // Dynamic array assignment
                int[] newArr = new int[arr.length+1];
                for (int i = 0; i < arr.length; i += 1){ // Can multiply by 2 for better dynamic resizing
                    newArr[i] = arr[i];
                }
                arr = newArr;
            }
            int input = sc.nextInt();
            arr[count-1] = input;
            arrLs.add(input);
        }
        System.out.println(Arrays.toString(arr)); // Dynamically resized array
        System.out.println(arrLs); // ArrayList - similar to linked list in python.
    }
}
