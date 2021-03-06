package ru.spbu.arts.java.fractal;

import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

//Хранит информацию о положении окна на математической плоскости
//Умеет создавать изображения на основе фрактала
public class Display {
    private double x0;
    private double y0;
    private double d;

    public Display(double x0, double y0, double d) {
        this.x0 = x0;
        this.y0 = y0;
        this.d = d;
    }

    // Рисует указанный фрактал на переданном изображении
    public void paint(WritableImage image, Fractal fractal) {
        double w = image.getWidth();
        double h = image.getHeight();
        PixelWriter pixelWriter = image.getPixelWriter();
        GrayscalePalette gray = new GrayscalePalette();
        HSBPalette hsb = new HSBPalette();

        for (int xPixel = 0; xPixel < w; xPixel++)
            for (int yPixel = 0; yPixel < h; yPixel++) {
                double x = x0 + d * xPixel;
                double y = y0 - d * yPixel;
                double f = fractal.paint(x, y);
                Color color = gray.color(f);
                //Color color = hsb.color(f);

                pixelWriter.setColor(xPixel, yPixel, color);
            }
    }
}