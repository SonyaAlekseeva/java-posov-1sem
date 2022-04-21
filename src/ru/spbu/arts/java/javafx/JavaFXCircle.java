package ru.spbu.arts.java.javafx;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import static javafx.geometry.Pos.CENTER;

public class JavaFXCircle extends Application {

    private final Slider slider = new Slider(0, 200, 100);
    private final ColorPicker colorPicker1 = new ColorPicker();
    private final ColorPicker colorPicker2 = new ColorPicker();
    private final Circle circle = new Circle(100);
    Pane panelRight = new Pane();
    BackgroundFill background_fill = new BackgroundFill(Color.PINK, CornerRadii.EMPTY, Insets.EMPTY);
    Background background = new Background(background_fill);

    @Override
    public void start(Stage stage) {
        stage.setTitle("Программа с кругом и grid pane");

        Parent parent = initInterface();
        initInteraction();

        stage.setScene(new Scene(parent));
        stage.setHeight(600);
        stage.setWidth(900);

        stage.show();
    }

    private void initInteraction() {
        circle.radiusProperty().bind(slider.valueProperty());

        panelRight.widthProperty().addListener(observable -> circle.setCenterX(panelRight.getWidth() / 2));
        panelRight.heightProperty().addListener(observable -> circle.setCenterY(panelRight.getHeight() / 2));

        circle.fillProperty().bind(colorPicker1.valueProperty());

        //colorPicker2.valueProperty().addListener(observable -> System.out.println(colorPicker2.valueProperty()));

        colorPicker2.valueProperty().addListener((observable, oldColor, newColor) ->
                setBackgroundColor(panelRight, colorPicker2.getValue())
        );

    }

    private Parent initInterface() {
        GridPane panel0 = new GridPane();

        Pane panel1 = new Pane();
        Pane panel2 = new Pane();
        Pane panel3 = new Pane();
        Pane panel4 = new Pane();
        Pane panel5 = new Pane();
        Pane panel6 = new Pane();

        panelRight.setBackground(background);

        panel1.setStyle("-fx-background-color: #EFEFEF");
        panel3.setStyle("-fx-background-color: #EFEFEF");
        panel5.setStyle("-fx-background-color: #EFEFEF");
        panel0.setStyle("-fx-background-color: #EBEBEB");

        panelRight.setMinHeight(400);
        panelRight.setMinWidth(400);

        panel0.add(panel1, 0, 0);
        panel0.add(panel2, 0, 1);
        panel0.add(panel3, 0, 2);
        panel0.add(panel4, 0, 3);
        panel0.add(panel5, 0, 4);
        panel0.add(panel6, 0, 5);
        panel0.add(panelRight, 1, 0, 1, 6);

        ColumnConstraints c1 = new ColumnConstraints(200, 300, Double.MAX_VALUE);
        c1.setHgrow(Priority.ALWAYS);
        ColumnConstraints c2 = new ColumnConstraints(400, 600, Double.MAX_VALUE);
        c2.setHgrow(Priority.ALWAYS);

        panel0.getColumnConstraints().addAll(c1, c2);

        RowConstraints r1 = new RowConstraints(67, 100, Double.MAX_VALUE);
        r1.setVgrow(Priority.ALWAYS);
        RowConstraints r2 = new RowConstraints(67, 100, Double.MAX_VALUE);
        r2.setVgrow(Priority.ALWAYS);
        RowConstraints r3 = new RowConstraints(67, 100, Double.MAX_VALUE);
        r3.setVgrow(Priority.ALWAYS);
        RowConstraints r4 = new RowConstraints(67, 100, Double.MAX_VALUE);
        r4.setVgrow(Priority.ALWAYS);
        RowConstraints r5 = new RowConstraints(67, 100, Double.MAX_VALUE);
        r5.setVgrow(Priority.ALWAYS);
        RowConstraints r6 = new RowConstraints(67, 100, Double.MAX_VALUE);
        r6.setVgrow(Priority.ALWAYS);

        panel0.getRowConstraints().addAll(r1, r2, r3, r4, r5, r6);

        Label radius = new Label("Радиус круга");
        panel0.add(radius, 0, 0);
        panel0.add(slider, 0, 1);
        radius.setAlignment(CENTER);

        Label circlecolor = new Label("Цвет круга");
        panel0.add(circlecolor, 0, 2);
        circlecolor.setAlignment(CENTER);
        Label panecolor = new Label("Цвет фона");
        panel0.add(panecolor, 0, 4);
        panecolor.setAlignment(CENTER);

        colorPicker1.setValue(Color.WHITE);

        panel0.add(colorPicker1, 0, 3);
        panel0.add(colorPicker2, 0, 5);
        panelRight.getChildren().add(circle);

        circle.setStyle("-fx-background-color: white");

        colorPicker2.setValue(Color.PINK);

        return panel0;
    }

    private String rgb(Color value) {
        return "#" + (changeType(value.getRed()) + changeType(value.getGreen()) + changeType(value.getBlue()) + changeType(value.getOpacity()))
                .toUpperCase();
    }

    private String changeType(double val) {
        String in = Integer.toHexString((int) Math.round(val * 255));
        return in.length() == 1 ? "0" + in : in;
    }

    private void setBackgroundColor(Pane previewPane, Color backgroundColor) {
        previewPane.setStyle("-fx-background-color: " + rgb(backgroundColor) + ";");
    }
}
