import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        String[] names = {"Rock","Paper","Scissors"};
        while (true) {
            System.out.println("----------Rock Paper Scissors------------");
            System.out.println("How many rounds do you want want to play? (Enter a number between 1 and 10)");
            int rounds = sc.nextInt();
            if (rounds > 10 || rounds < 1) {
                System.out.println("ERROR");
                break;
            }
            int tie = 0;
            int player_win = 0;
            int computer_win = 0;
            for (int i = 1; i <= rounds; i += 1) {
                System.out.println("Player's turn (Type 1 for Rock, 2 for Paper and 3 for Scissors)");
                int player = sc.nextInt();
                System.out.println("-------Computer's turn-------");
                System.out.println(" ");
                int computer = rand.nextInt(3) + 1;
                System.out.println("Computer chose " + names[computer - 1]);
                if (player == computer) { // Rock - Rock, Paper - Paper, Scissors - Scissors
                    tie += 1;
                    System.out.println("It is a tie.");
                } else if (player == 1 && computer == 3) { // Rock - Scissors
                    player_win += 1;
                    System.out.println("Player wins.");
                } else if (player == 1 && computer == 2) { // Rock - Paper
                    computer_win += 1;
                    System.out.println("Computer wins.");
                } else if (player == 3 && computer == 1) { // Scissors - Rock
                    computer_win += 1;
                    System.out.println("Computer wins.");
                } else if (player == 3 && computer == 2) { // Scissors - Paper
                    player_win += 1;
                    System.out.println("Player wins.");
                } else if (player == 2 && computer == 3) { // Paper - Scissors
                    computer_win += 1;
                    System.out.println("Computer wins.");
                } else if (player == 2 && computer == 1) { // Paper - Rock
                    player_win += 1;
                    System.out.println("Player wins.");
                }
                System.out.println(" ");
            }

            System.out.println("-------Game Summary-------");
            System.out.println("Total ties: " + tie);
            System.out.println("Total player wins: " + player_win);
            System.out.println("Total computer wins: " + computer_win);
            System.out.println("--------------------------");
            if (player_win > computer_win) {
                System.out.println("Outcome: Player wins.");
            } else if (computer_win > player_win) {
                System.out.println("Outcome: Computer wins.");
            } else {
                System.out.println("Outcome: The game is a tie.");
            }
            System.out.println("--------------------------");
            System.out.println(" ");
            System.out.println("Do you want to play again? (Enter y or n)");
            String choice = sc.next();
            if (choice.contains("y")){
                continue;
            } else if (choice.contains("n")){
                System.out.println("Thanks for playing!");
                break;
            }
        }
    }
}