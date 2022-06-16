import java.util.Scanner;

import static java.lang.Math.round;

public class HealthyHearts {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("What is your age?");
        int age = sc.nextInt();
        int maxHeartRate = 220 - age;
        int lowerBound = round(0.5f * maxHeartRate);
        int upperBound = round(0.85f * maxHeartRate);
        System.out.println("Your maximum heart rate should be " + maxHeartRate + " beats per minute.");
        System.out.println("Your target HR Zone is " + lowerBound + " - " + upperBound+ " beats per minute.");
    }
}