package ru.spbu.arts.java.fractal;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class FractalViewer extends Application {

    public final static int W = 600;
    public final static int H = 500;

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Просмотр фигур");

        Pane root = initInterface();
        primaryStage.setScene(new Scene(root));

        primaryStage.show();
    }

    private Pane initInterface() {
        WritableImage img = new WritableImage(W, H);
        Display display = new Display(-2, 2, 4 / 600.0);
        Fractal f = new FractalMandelbrot();
        display.paint(img, f);
        ImageView imageView = new ImageView(img);

        VBox panel = new VBox();
        Pane panel1 = new Pane(imageView);
        HBox panel2 = new HBox();

        Button button1 = new Button("Left");
        VBox button2 = new VBox();
        Button button21 = new Button("Up");
        Button button22 = new Button("Down");
        Button button3 = new Button("Right");
        Button button4 = new Button("Scale up");
        Button button5 = new Button("Scale down");
        Button button6 = new Button("Export");

        GridPane panel0 = new GridPane();

        panel0.add(button1, 0, 1);
        panel0.add(button21, 1, 0);
        panel0.add(button22, 1, 2);
        panel0.add(button3, 2, 1);
        panel0.add(button4, 3, 1);
        panel0.add(button5, 4, 1);
        panel0.add(button6, 5, 1);

        ColumnConstraints c1 = new ColumnConstraints(30, 50, Double.MAX_VALUE);
        ColumnConstraints c2 = new ColumnConstraints(30, 50, Double.MAX_VALUE);
        ColumnConstraints c3 = new ColumnConstraints(30, 150, Double.MAX_VALUE);
        ColumnConstraints c4 = new ColumnConstraints(30, 100, Double.MAX_VALUE);
        ColumnConstraints c5 = new ColumnConstraints(30, 150, Double.MAX_VALUE);
        ColumnConstraints c6 = new ColumnConstraints(30, 50, Double.MAX_VALUE);

        panel0.getColumnConstraints().addAll(c1, c2, c3, c4, c5, c6);

        panel.getChildren().addAll(panel1, panel2);
        panel2.getChildren().addAll(panel0);
        panel2.setStyle("-fx-background-color: #202020");
        VBox.setVgrow(panel1, Priority.ALWAYS);
        HBox.setHgrow(panel1, Priority.ALWAYS);
        HBox.setHgrow(panel2, Priority.ALWAYS);
        panel2.setPrefHeight(90);

        return panel;
    }
}
