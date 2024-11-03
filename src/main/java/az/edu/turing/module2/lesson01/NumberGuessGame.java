package az.edu.turing.module2.lesson01;

import java.util.Random;
import java.util.Scanner;

public class NumberGuessGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your name: ");

        String name = scanner.nextLine();
        Random random = new Random();

        int randomNumber = random.nextInt(101);
        System.out.println("Let the game begin!");
        int[] guesses = new int[100];
        int count = 0;

        while (true) {
            System.out.print("Enter a number: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Please enter a number!");
                scanner.next();
            }
            int userNumber = scanner.nextInt();
            guesses[count] = userNumber;
            count++;

            if (userNumber < randomNumber) {
                System.out.println("Your number is too small. Please, try again.");
            } else if (userNumber > randomNumber) {
                System.out.println("Your number is too big. Please, try again.");
            } else {
                System.out.println("Congratulations, " + name + "!");
                break;
            }
        }

        System.out.print("Your numbers: ");
        for (int i = 0; i < count; i++) {
            System.out.print(guesses[i] + " ");
        }
    }
}



