package Tmg05Lesson;

public class PrintableRealization implements Printable{
    private final String field;

    public PrintableRealization(String field) {
        this.field = field;
    }

    @Override
    public String printMe() {
        return "Some text " + field;
    }
}
