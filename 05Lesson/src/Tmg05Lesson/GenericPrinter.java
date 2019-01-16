package Tmg05Lesson;

public interface GenericPrinter<T extends Printable> {
    void printIt(T toPrint);
}
