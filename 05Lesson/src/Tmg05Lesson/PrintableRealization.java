package Tmg05Lesson;

public class PrintableRealization implements Printable{
    private final String field;

    public PrintableRealization(String field) {
        this.field = field;
    }

    @Override
    public String printMe() {
        //System.out.println("Some text11 " + field);
        return "Some text " + field;
    }
}
