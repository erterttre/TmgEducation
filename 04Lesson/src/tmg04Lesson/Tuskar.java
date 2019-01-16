package tmg04Lesson;

public class Tuskar extends Hero {
    @Override
    public String getSpell() {
        return Spell.ICESHARD.toString();
    }

    @Override
    public String toString() {
        return "Tuskar{" +
                super.toString() +
                "}";
    }
}
