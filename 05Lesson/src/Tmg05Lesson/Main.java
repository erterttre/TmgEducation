package Tmg05Lesson;

import java.util.*;

public class Main {

    public static void main(String[] args){
        Printable item = new PrintableRealization("Item");
        Printable item2 = new PrintableRealization("Item2");
        Collection<Printable> list = new ArrayList<>() {};
        list.add(item);
        list.add(item2);
        Map<Printable,Printable> map = new HashMap<>();
        Collection<Printable> set =new HashSet<>();
        Main n = new Main();
        n.pounaColection(list);
        //GenericPrinter genericPrinter = new GenericPrinterImpl();
        //((GenericPrinterImpl) genericPrinter).print.printMe();
        //list.stream().forEach(Main::onStrem);
    }

   // public static void onStrem (Printable p ){
    //    System.out.println(p);
    //}

    public <T extends Collection<Printable>> void pounaColection (T t){
        Iterator<Printable> printableIterator = t.iterator();
        while (printableIterator.hasNext()){
            Printable nextElem = printableIterator.next();
            t.stream().forEach(strem ->nextElem.printMe());
            System.out.println(nextElem.printMe());
        }
    }
}
