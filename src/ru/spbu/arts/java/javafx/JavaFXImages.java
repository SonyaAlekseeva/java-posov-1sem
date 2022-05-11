package ru.spbu.arts.java.javafx;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class JavaFXImages extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("Работа с изображениями и цветом");
        Parent parent = initInterface();
        stage.setScene(new Scene(parent));
        stage.show();
    }

    private Parent initInterface() {
        WritableImage task1 = new WritableImage(100, 100);
        ImageView viewer1 = new ImageView(task1);
        PixelWriter pixelWriter1 = task1.getPixelWriter();
        for (int x = 0; x <= 99; x++)
            for (int y = 0; y <= 99; y++)
                pixelWriter1.setArgb(x, y, 0xFF77C4E4);

        WritableImage task2 = new WritableImage(256, 256);
        ImageView viewer2 = new ImageView(task2);
        PixelWriter pixelWriter2 = task2.getPixelWriter();
        for (int x = 0; x <= 255; x++)
            for (int y = 0; y <= 255; y++)
                pixelWriter2.setColor(x, y, Color.rgb(x, y, 123));

        WritableImage task3 = new WritableImage(360, 100);
        ImageView viewer3 = new ImageView(task3);
        PixelWriter pixelWriter3 = task3.getPixelWriter();
        for (int x = 0; x <= 359; x++)
            for (int y = 0; y <= 99; y++)
                pixelWriter3.setColor(x, y, Color.hsb(x, y * 0.01, 0.5));

        WritableImage task4 = new WritableImage(100, 100);
        ImageView viewer4 = new ImageView(task4);
        PixelWriter pixelWriter4 = task4.getPixelWriter();
        for (int x = 0; x <= 99; x++)
            for (int y = 0; y <= 99; y++)
                if (25 < x && x < 75 && 25 < y && y < 75) // тут надо 24 или 25 писать?
                    pixelWriter4.setColor(x, y, Color.BLACK);
                else
                    pixelWriter4.setColor(x, y, Color.WHITE);

        WritableImage task5 = new WritableImage(100, 100);
        ImageView viewer5 = new ImageView(task5);
        PixelWriter pixelWriter5 = task5.getPixelWriter();
        for (int x = 0; x <= 99; x++)
            for (int y = 0; y <= 99; y++)
                if (Math.sqrt((x - 49) * (x - 49) + (y - 49) * (y - 49)) < 50)
                    pixelWriter5.setColor(x, y, Color.BLACK);
                else
                    pixelWriter5.setColor(x, y, Color.WHITE);

        WritableImage task6 = new WritableImage(361, 101);
        ImageView viewer6 = new ImageView(task6);
        PixelWriter pixelWriter6 = task6.getPixelWriter();
        for (int x = 0; x <= 360; x++)
            for (int y = 0; y <= 100; y++)
                pixelWriter6.setColor(x, y, LCH.colorFromLCH(y, 123, x));

        WritableImage task7 = new WritableImage(371, 100);
        ImageView viewer7 = new ImageView(task7);
        PixelWriter pixelWriter7 = task7.getPixelWriter();
        for (int x = 0; x <= 370; x++) {
            int[] color = waveLengthToRgb(x+380);
            for (int y = 0; y <= 99; y++)
                pixelWriter7.setColor(x, y, Color.rgb(color[0], color[1], color[2]));
        }

        return new FlowPane(
                viewer1,
                viewer2,
                viewer3,
                viewer4,
                viewer5,
                viewer6,
                viewer7
        );
    }

    public int[] waveLengthToRgb (int wavelength){
        double attenuation,R, G, B;
        double gamma = 0.8;
        if (wavelength >= 380 & wavelength <= 440) {
            attenuation = 0.3 + 0.7 * (wavelength - 380) / (440 - 380);
            R = Math.pow(((-(wavelength - 440.0) / (440 - 380)) * attenuation), gamma);
            G = 0.0;
            B = Math.pow((attenuation), gamma);
        }
        else if (wavelength >= 440 & wavelength <= 490) {
            R = 0.0;
            G = Math.pow(((wavelength - 440.0) / (490 - 440)), gamma);
            B = 1.0;
        }
        else if (wavelength >= 490 & wavelength <= 510) {
            R = 0.0;
            G = 1.0;
            B = Math.pow((-(wavelength - 510.0) / (510 - 490)), gamma);
        }
        else if (wavelength >= 510 & wavelength <= 580) {
            R = Math.pow(((wavelength - 510.0) / (580 - 510)), gamma);
            G = 1.0;
            B = 0.0;
        }
        else if (wavelength >= 580 & wavelength <= 645) {
            R = 1.0;
            G = Math.pow((-(wavelength - 645.0) / (645 - 580)), gamma);
            B = 0.0;
        }
        else if (wavelength >= 645 & wavelength <= 750) {
            attenuation = 0.3 + 0.7 * (750 - wavelength) / (750 - 645);
            R = Math.pow(attenuation, gamma);
            G = 0.0;
            B = 0.0;
        }
        else {
            R = 0.0;
            G = 0.0;
            B = 0.0;
        }
        int nR = (int) Math.floor(R * 255);
        int nG = (int) Math.floor(G * 255);
        int nB = (int) Math.floor(B * 255);
        return new int[]{nR, nG, nB};
    }
}
