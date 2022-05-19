package ru.spbu.arts.java.fractal;

import javafx.scene.paint.Color;

public interface Palette {

    // Преобразовывает число от 0 до 1 в цвет
    Color color(double c);

}
