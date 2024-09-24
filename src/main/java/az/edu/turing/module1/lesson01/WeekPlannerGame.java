package az.edu.turing.module1.lesson01;

import java.util.Scanner;

public class WeekPlannerGame {

    public static void main(String[] args) {
        String[][] schedule = new String[7][2];

        schedule[0][0] = "Sunday";
        schedule[0][1] = "do home work";
        schedule[1][0] = "Monday";
        schedule[1][1] = "go to courses; watch a film";
        schedule[2][0] = "Tuesday";
        schedule[2][1] = "gym; reading";
        schedule[3][0] = "Wednesday";
        schedule[3][1] = "go to courses; work on project";
        schedule[4][0] = "Thursday";
        schedule[4][1] = "gym; go shopping";
        schedule[5][0] = "Friday";
        schedule[5][1] = "work; hangout with friends";
        schedule[6][0] = "Saturday";
        schedule[6][1] = "relax; family time";

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Please, input the day of the week: ");
            String input = scanner.nextLine().trim().toLowerCase();

            if (input.equals("exit")) {
                System.out.println("Exiting the program...");
                break;
            }

            if (input.startsWith("change") || input.startsWith("reschedule")) {
                String[] parts = input.split(" ");
                if (parts.length == 2) {
                    String day = parts[1].toLowerCase();
                    int dayIndex = getDayIndex(day, schedule);
                    if (dayIndex != -1) {
                        System.out.print("Please, input new tasks for " + schedule[dayIndex][0] + ": ");
                        String newTasks = scanner.nextLine();
                        schedule[dayIndex][1] = newTasks;
                        System.out.println("Tasks for " + schedule[dayIndex][0] + " have been updated.");
                    } else {
                        System.out.println("Sorry, I don't understand you, please try again.");
                    }
                } else {
                    System.out.println("Invalid command format.");
                }
                continue;
            }

            int dayIndex = getDayIndex(input, schedule);
            if (dayIndex != -1) {
                System.out.println("Your tasks for " + schedule[dayIndex][0] + ": " + schedule[dayIndex][1]);
            } else {
                System.out.println("Sorry, I don't understand you, please try again.");
            }
        }
    }

    public static int getDayIndex(String day, String[][] schedule) {
        for (int i = 0; i < schedule.length; i++) {
            if (schedule[i][0].toLowerCase().equals(day)) {
                return i;
            }
        }
        return -1;
    }
}

