public class Lion extends Hero {
    @Override
    protected String getSpell() {
        spell = Spell.FireBall.toString();
        return spell;
    }
}
