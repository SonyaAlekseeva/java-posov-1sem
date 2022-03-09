package ru.spbu.arts.java.oop.rational;

public class RationalTest {
    public static void main (String[] args) {
        Rational r1 = new Rational(1, 3);
        Rational r2 = new Rational(2, 8);
        Rational r3 = new Rational(2);
        Rational r4 = new Rational(1, 6);
        Rational r5 = new Rational(7, 4);
        Rational r6 = new Rational(5, -3);

        System.out.println(r1.toString());
        System.out.println(r2.toString());
        System.out.println(r3.toString());
        System.out.println(r4.toString());

        System.out.println(r1.toDouble());
        System.out.println(r2.toDouble());

        System.out.println(r1.add(r4));
        System.out.println(r2.add(r5));
        System.out.println(r3.sub(r2));
        System.out.println(r2.mul(r4));
        System.out.println(r4.div(r2));

        System.out.println(progressionDouble(1));
        System.out.println(progressionDouble(2));
        System.out.println(progressionDouble(3));
        System.out.println(progressionDouble(20));

        System.out.println(r5.getNumerator());
        System.out.println(r5.getDenominator());

    }

    // Изначально я написала функцию так. f(20) = 0.8302753773574207, что неправильно.
    // В этом случае s.n = 1.288.546.204, а должен быть равен 5.583.513.500
    // Почему так получилось? Потому что тип int хранит значения до 2.147.483.647, а при i = 20 числитель получается больше
    // Если заменить на long, то вроде бы работает правильно

    //public static double progressionRational(int n) {
    //    Rational s = new Rational(1, 1);
    //    for (int i = 2; i <= n; i++) {
    //        Rational e = new Rational(1, i);
    //        s.addInPlace(e);
    //    }
    //    return s.toDouble();
    //}

    public static double progressionDouble(int n){
        double s = 1;
        for (int i = 2; i <= n; i++)
            s += 1.0 / i;
        return s;
    }
}
