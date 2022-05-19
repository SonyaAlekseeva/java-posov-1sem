package ru.spbu.arts.java.fractal;

import javafx.scene.paint.Color;

public class HSBPalette implements Palette{

    @Override
    public Color color(double c) {
        return Color.hsb(c * 10 * 360 % 360, 1, 1);
    }
}
