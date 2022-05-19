package ru.spbu.arts.java.fractal;

import javafx.scene.paint.Color;

public class GrayscalePalette implements Palette {

    @Override
    public Color color(double c) {
        if (((c * 10) % 10) % 2 == 0)
            return Color.gray(1-c);
        return Color.gray(c);
    }
}
