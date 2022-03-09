package ru.spbu.arts.java.oop.rational;

public class Rational {
    private int n;
    private int d = 1;

    private static final Rational ZERO = new Rational(0);
    private static final Rational ONE = new Rational(1);

    Rational (int n, int d) {
        if (d > 0) {
            int c = gcd(n, d);
            this.n = n / c;
            this.d = d / c;
        }
        else
            System.out.println("Ошибка! Введите знаменатель больше 0");
    }

    Rational (int n) {
        this.n = n;
    }

    public static int gcd(int n1, int n2) {
        if (n2 == 0)
            return n1;
        return gcd(n2, n1 % n2);
    }

    public String toString() {
        if (n == 0 || d == 1)
            return Integer.toString(n);
        return n + "/" + d;
    }

    public double toDouble() {
        return (double) n / d;
    }

    public Rational add(Rational x) {
        int a = n * x.d + d * x.n;
        int b = d * x.d;
        return new Rational(a, b);
    }

    //public Rational addInPlace(Rational x) {
    //    n = n * x.d + d * x.n;
    //    d = d * x.d;
    //    int c = gcd(n, d);
    //    n = n / c;
    //    d = d / c;
    //    return this;
    //}

    public Rational sub(Rational x) {
        int a = n * x.d - d * x.n;
        int b = d * x.d;
        return new Rational(a, b);
    }

    //public Rational subInPlace(Rational x) {
    //    n = n * x.d - d * x.n;
    //    d = d * x.d;
    //    int c = gcd(n, d);
    //    n = n / c;
    //    d = d / c;
    //    return this;
    //}

    public Rational mul(Rational x) {
        int a = n * x.n;
        int b = d * x.d;
        return new Rational(a, b);
    }

    //public Rational mulInPlace(Rational x) {
    //    n = n * x.n;
    //    d = d * x.d;
    //    int c = gcd(n, d);
    //    n = n / c;
    //    d = d / c;
    //    return this;
    //}

    public Rational div(Rational x) {
        int a = n * x.d;
        int b = d * x.n;
        return new Rational(a, b);
    }

    //public Rational divInPlace(Rational x) {
    //    n = n * x.d;
    //    d = d * x.n;
    //    int c = gcd(n, d);
    //    n = n / c;
    //    d = d / c;
    //    return this;
    //}

    // Статические функции
    //public static Rational add(Rational r1, Rational r2) {
    //    int a = r1.n * r2.d + r1.d * r2.n;
    //    int b = r1.d * r2.d;
    //    return new Rational(a, b);
    //}

    //public static Rational sub(Rational r1, Rational r2) {
    //    int a = r1.n * r2.d - r1.d * r2.n;
    //    int b = r1.d * r2.d;
    //    return new Rational(a, b);
    //}

    //public static Rational mul(Rational r1, Rational r2) {
    //    int a = r1.n * r2.n;
    //    int b = r1.d * r2.d;
    //    return new Rational(a, b);
    //}

    //public static Rational div(Rational r1, Rational r2) {
    //    int a = r1.n * r2.d;
    //    int b = r1.d * r2.n;
    //    return new Rational(a, b);
    //}

    public int getNumerator() {
        return n;
    }

    public int getDenominator() {
        return d;
    }

}
