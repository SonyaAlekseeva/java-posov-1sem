package ru.spbu.arts.java.lambda;

public class PrintableLetter implements Printable {
    private final String letter;
    private final int number;

    public PrintableLetter(String letter, int number) {
        this.letter = letter;
        this.number = number;
    }

    @Override
    public void print() {
        System.out.println(letter.repeat(number));
    }
}
