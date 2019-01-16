package tmg04Lesson;

public class Unit {
    private int health;
    private int mana;

    public Unit() {
    }

    public Unit(int health, int mana) {
        this.health = health;
        this.mana = mana;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    @Override
    public String toString() {
        return "{" +
                "health=" + health +
                ", mana=" + mana +
                '}';
    }
}
