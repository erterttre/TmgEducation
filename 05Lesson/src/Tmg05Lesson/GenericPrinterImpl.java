package Tmg05Lesson;

public class GenericPrinterImpl implements GenericPrinter<Printable>{
    @Override
    public void printIt(Printable toPrint) {
        System.out.println(toPrint.printMe());
    }
}
