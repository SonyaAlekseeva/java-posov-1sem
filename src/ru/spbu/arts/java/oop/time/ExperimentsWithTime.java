package ru.spbu.arts.java.oop.time;

public class ExperimentsWithTime {
    public static void main(String[] args) {
        Time t1 = new Time(9, 10);
        Time t2 = new Time(9, 50);
        Time t3 = new Time(22, 37);

        System.out.println(t1.show());
        System.out.println(t2.show());
        System.out.println(t3.show());

        System.out.println(t1.isMorning());
        System.out.println(t1.isDay());
        System.out.println(t1.isEvening());
        System.out.println(t1.isNight());
        System.out.println(t3.isNight());

        System.out.println(t1.sayHello());
        System.out.println(t2.sayHello());
        System.out.println(t3.sayHello());

        System.out.println(t1.add(20));
        System.out.println(t2.add(20));
        System.out.println(t3.add(20));
        System.out.println(t1.add(120));
        System.out.println(t3.add(120));
    }
}
