import java.util.Random;
import java.util.Scanner;
import static java.lang.Math.round;

public class DogGenetics {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("What is your dog's name?");
        String name = sc.next();
        System.out.println("Well then, I have this highly reliable report on " + name + "'s prestigious background right here.");
        System.out.println(" ");
        System.out.println(name + " is:");
        System.out.println(" ");
        Random rand = new Random();
        float[] numbers = new float[5];
        int total = 0;
        for (int i = 0; i < numbers.length; i += 1){
            int randNum = rand.nextInt(100);
            numbers[i] = randNum;
            total += randNum;
        }
        int rem = 100;
        int[] percentages = new int[5];
        for (int i = 0; i < numbers.length; i += 1){
            int intVal = round((numbers[i]/total)*100);
            percentages[i] = intVal;
            rem -= intVal;
        }
        percentages[4] -= rem; // Confining the range between 100

        String[] breeds = {"St. Bernard", "Chihuahua", "Dramatic RedNosed Asian Pug", "Common Cur", "King Doberman"};
        for (int i = 0; i < percentages.length; i += 1){
            System.out.println(percentages[i] + "% " + breeds[i]);
        }
        System.out.println(" ");
        System.out.println("Wow, that's QUITE the dog!");
    }
}