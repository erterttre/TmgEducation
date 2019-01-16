package tmg04Lesson;

public class Crep extends Unit {
    @Override
    public String toString() {
        return"Crep{" +
                super.toString() +
                "}";
    }

    public Crep(int health, int mana) {
        super(health, mana);
    }
}
