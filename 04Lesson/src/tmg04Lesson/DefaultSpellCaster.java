package tmg04Lesson;

public class DefaultSpellCaster implements Caster {
    @Override
    public void castSpel(Hero hero,Crep crep) {
        crep.setHealth(crep.getHealth() - Spell.ICESHARD.getDemage());
        System.out.println(hero.toString() + " Casting spell " + hero.getSpell()+" demage "+crep.toString());
    }
}
