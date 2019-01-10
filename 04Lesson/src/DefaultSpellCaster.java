public class DefaultSpellCaster  implements Caster {
    public static void castSpel(Lion l,Mirana m,Tuskar t) {
        Lion c = new Lion();
        System.out.println(l.toString().split("@")[0]+" Casting spell "+c.getSpell());
        Mirana d = new Mirana();
        System.out.println(m.toString().split("@")[0]+" Casting spell "+d.getSpell());
        Tuskar r = new Tuskar();
        System.out.println(t.toString().split("@")[0]+" Casting spell "+r.getSpell());
    }
}
