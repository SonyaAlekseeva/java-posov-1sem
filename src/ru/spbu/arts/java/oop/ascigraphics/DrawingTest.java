package ru.spbu.arts.java.oop.ascigraphics;

public class DrawingTest {
    public static void main (String[] args) {
        Drawing d1 = new Drawing(5,6, '.');
        d1.print();
        System.out.println("------------------------------");
        d1.setPoint(1,2,'*');
        d1.print();
        System.out.println("------------------------------");
        d1.drawVerticalLine(2,1, 4,'*');
        d1.print();
        System.out.println("------------------------------");
        d1.drawHorizontalLine(1,4, 1,'*');
        d1.print();
        System.out.println("------------------------------");
        d1.drawRectangle(0,0, 2, 3, '-');
        d1.print();
        System.out.println("------------------------------");
        Drawing d2 = new Drawing(7,9, '.');
        d2.drawCircle(1,3, 3, '*');
        d2.print();
        System.out.println("------------------------------");
        Drawing d3 = new Drawing(7,9, '.');
        d3.drawCircle(3,4, 2, '*');
        d3.print();
        System.out.println("------------------------------");
        Drawing d4 = new Drawing(7,9, '.');
        Drawing d5 = new Drawing(4,6, '!');
        d4.draw(1,2, d5);
        d4.print();
        System.out.println("------------------------------");
        Drawing d6 = new Drawing(21,11, ' ');
        d6.drawHorizontalLine(0,20, 0,'-');
        d6.drawHorizontalLine(0,20, 5,'-');
        d6.drawHorizontalLine(0,20, 10,'-');
        d6.drawVerticalLine(0,0, 10,'|');
        d6.drawVerticalLine(5,0, 10,'|');
        d6.drawVerticalLine(10,0, 10,'|');
        d6.drawVerticalLine(15,0, 10,'|');
        d6.drawVerticalLine(20,0, 10,'|');
        Drawing wind = new Drawing(2,2, '*');
        Drawing door = new Drawing(2,3, '*');
        d6.draw(2,2, wind);
        d6.draw(2,7, wind);
        d6.draw(7,2, wind);
        d6.draw(7,7, door);
        d6.draw(12,2, wind);
        d6.draw(12,7, wind);
        d6.draw(17,2, wind);
        d6.draw(17,7, wind);
        d6.print();
    }
}
