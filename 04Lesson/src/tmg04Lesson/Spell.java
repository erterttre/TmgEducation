package tmg04Lesson;

public enum Spell {
    FIREBALL(20),
    ICESHARD(10),
    SACREDARROW(100);

    private int demage;

    public int getDemage() {
        return demage;
    }

    Spell(int demage) {
        this.demage = demage;
    }
}
