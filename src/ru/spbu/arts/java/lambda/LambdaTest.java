package ru.spbu.arts.java.lambda;
import ru.spbu.arts.java.oop.ascigraphics.Drawing;

public class LambdaTest {
    public static void main(String[] args) {

        Drawing draw = new Drawing(5, 7, '*');
        draw.print();

        PrintableLetter pl = new PrintableLetter("x", 10);
        pl.print(); //печатает букву x 10 раз

        PrintableString ps = new PrintableString("asdf");
        ps.print(); //печатает asdf

        Printable anon = new Printable() {
            @Override
            public void print() {
                System.out.println("I'm an anonymous class");
            }
        };

        Printable lambda = () -> System.out.println("I'm a lambda expression");

        Printable[] array = {draw, pl, ps, anon, lambda};
        for (Printable x : array)
            x.print();
    }
}
