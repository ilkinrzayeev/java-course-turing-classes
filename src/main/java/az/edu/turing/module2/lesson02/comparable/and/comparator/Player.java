package az.edu.turing.module2.lesson02.comparable.and.comparator;

public class Player implements Comparable<Player> {
    @Override
    public int compareTo(Player that) {
        return this.id - that.id;
    }

    public int id;
    public String name;
    public int age;
    public double score;
    public boolean isFemale;

    public Player(int id, String name, int age, double score, boolean isFemale) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.score = score;
        this.isFemale = isFemale;
    }

    @Override
    public String toString() {
        return "{id=%d, name='%s', age=%d, score=%s, isFemale=%s}".formatted(id, name, age, score, isFemale);
    }
}
