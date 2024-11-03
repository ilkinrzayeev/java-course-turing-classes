package az.edu.turing.module2.lesson02.comparable.and.comparator;

import java.util.Comparator;

public class Checker implements Comparator<Player> {
    @Override

    public int compare(Player player1, Player player2) {
// 1. isFemale true olanlar evvel gelir
        if (player1.isFemale != player2.isFemale) {
            return player1.isFemale ? 1 : -1;
        }
// 2. Eger score equals deyilse Desc olaraq siralansin
        if (player1.score != player2.score) {
            return Double.compare(player2.score, player1.score);
        }
// 3. Eger name differentdise Desc
        if (!player1.name.equals(player2.name)) {
            return player2.name.compareTo(player1.name);
        }
// 4. Eger age equals deyilse ASC
        if (player1.age != player2.age) {
            return Integer.compare(player1.age, player2.age);
        }
// 5. En sonda id ASC
        return Integer.compare(player1.id, player2.id);
    }
}
