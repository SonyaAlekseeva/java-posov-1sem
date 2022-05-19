package ru.spbu.arts.java.fractal;

import javafx.scene.paint.Color;

public class FractalMandelbrot implements Fractal {
    @Override
    public double paint(double x, double y) {

        int max = 100, r = 10000;
        double k = 0, xk = 0, yk = 0;

        while (k < 100 && r * r >= xk * xk + yk * yk) {
            double a = ((xk * xk) - (yk * yk)) + x;
            double b = 2 * xk * yk + y;
            xk = a;
            yk = b;
            k ++;
        }

        if (k == max)
            return 1;
        return k / max;
    }
}
