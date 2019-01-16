package tmg04Lesson;

public class Main {
    public static void main(String[] args) {
        Tuskar tuskar = new Tuskar();
        Caster result = new DefaultSpellCaster();
        Crep crep = new Crep(100, 100);
        System.out.println(crep);
        result.castSpel(tuskar, crep);
        System.out.println(crep);
    }

    public void castSpel(Caster caster, Hero hero, Crep creep) {
         caster.castSpel(hero, creep);
    }
}
