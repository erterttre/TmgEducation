package Tmg05Lesson;


public class GenericPrinterImpl implements GenericPrinter{
    Printable print = new PrintableRealization("kokoko");
    @Override
    public void printIt(Printable toPrint) {
        System.out.println(print.printMe());
    }
}
