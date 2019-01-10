public class Mirana extends Hero {
    @Override
    protected String getSpell() {
        spell = Spell.SacredArrow.toString();
        return spell;
    }
}
