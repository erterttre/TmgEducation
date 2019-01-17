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
       pounaColection(list);
        //list.stream().forEach(Main::onStrem);
    }

    /*public static void onStrem (Printable p ){
        System.out.println(p);
    }
    */

    public static  <T extends Collection<Printable>> void pounaColection (T t){
        for (Printable nextElem:t){
            GenericPrinter genericPrinter = new GenericPrinterImpl();
            genericPrinter.printIt(nextElem);
        }
    }
}
