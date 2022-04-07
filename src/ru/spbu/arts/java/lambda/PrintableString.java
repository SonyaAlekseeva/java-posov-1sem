package ru.spbu.arts.java.lambda;

public class PrintableString implements Printable {
    String str;

    public PrintableString(String str) {
        this.str = str;
    }

    @Override
    public void print() {
        System.out.println(str);
    }
}
