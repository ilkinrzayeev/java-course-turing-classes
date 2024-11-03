package az.edu.turing.module2.lesson02.comparable.and.comparator;

import java.util.Arrays;
import java.util.List;

public class SolutionApp {

    public static void main(String[] args) {
        Player[] players =
                {
                        new Player(1, "Ilkin", 19, 500, false),
                        new Player(2, "Hikmat", 15, 400, true),
                        new Player(3, "Ali", 20, 300, false),
                        new Player(4, "Murad", 18, 200, true),
                        new Player(5, "Ruslan", 17, 100, false),
                };
        List<Player> list = Arrays.asList(players);

        list.sort(new Checker());

        for (Player player : players) {
            System.out.println(player);
        }

    }
}
