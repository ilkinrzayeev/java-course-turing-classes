package az.edu.turing.module2.lesson01;

import java.util.Random;
import java.util.Scanner;

public class ShipBattleGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        char[][] field = new char[5][5];

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                field[i][j] = '-';
            }
        }
        int targetRow = random.nextInt(5);
        int targetCol = random.nextInt(5);

        System.out.println("Everything is ready. Start getting ready!");
        while (true) {
            printField(field);
            int shotRow = getValidInput(scanner) - 1;
            int shotCol = getValidInput(scanner) - 1;

            if (shotRow == targetRow && shotCol == targetCol) {
                field[shotRow][shotCol] = 'x';
                printField(field);
                System.out.println("You win!");
                break;
            } else {
                field[shotRow][shotCol] = '*';
            }
        }

        scanner.close();
    }

    private static void printField(char[][] field) {
        System.out.println("  1 | 2 | 3 | 4 | 5 |");
        for (int i = 0; i < 5; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < 5; j++) {
                System.out.print("| " + field[i][j] + " ");
            }
            System.out.println("|");
        }
    }

    private static int getValidInput(Scanner scanner) {
        int input;
        while (true) {
            System.out.print("Enter the sequence number (1-5): ");
            if (scanner.hasNextInt()) {
                input = scanner.nextInt();
                if (input >= 1 && input <= 5) {
                    break;
                }
            } else {
                scanner.next();
            }
            System.out.println("Invalid entry. Please enter a number between 1 and 5.");
        }
        return input;
    }
}
