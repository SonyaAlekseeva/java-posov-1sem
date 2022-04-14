package ru.spbu.arts.java.javafx;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class JavaFXInterface extends Application {

    private final TextArea panel11 = new TextArea();
    private final TextField panel121 = new TextField();
    private final Button panel122 = new Button("Отправить");
    private final ObservableList<String> contacts = FXCollections.observableArrayList();

    @Override
    public void start(Stage stage) {
        stage.setTitle("Мессенджер на JavaFX");

        Parent parent = initInterface();
        initInteraction();

        contacts.add("Мамочка");
        contacts.add("Аня");
        contacts.add("Любимый");
        contacts.add("Не брать!!!");

        stage.setScene(new Scene(parent));
        stage.setHeight(500);
        stage.setWidth(600);
        stage.show();
    }

    private Parent initInterface() {
        HBox panel0 = new HBox();

        VBox panel1 = new VBox();
        VBox panel2 = new VBox();

        HBox panel12 = new HBox();
        Label panel21 = new Label("Контакты");
        ListView<String> panel22 = new ListView<>(contacts);

        panel11.setStyle("-fx-border-color: #CDCDCD;");
        panel12.setStyle("-fx-border-color: #CDCDCD;");
        panel21.setStyle("-fx-background-color: #CDCDCD;");
        panel22.setStyle("-fx-border-color: #CDCDCD;");
        panel121.setStyle("-fx-border-color: #CDCDCD;");
        panel122.setStyle("-fx-border-color: #CDCDCD; -fx-background-color: #77C4E4");

        panel0.getChildren().addAll(panel1, panel2);
        panel1.getChildren().addAll(panel11, panel12);
        panel2.getChildren().addAll(panel21, panel22);
        panel12.getChildren().addAll(panel121, panel122);

        HBox.setHgrow(panel1, Priority.ALWAYS);
        HBox.setHgrow(panel21, Priority.ALWAYS);
        HBox.setHgrow(panel11, Priority.ALWAYS);
        HBox.setHgrow(panel121, Priority.ALWAYS);

        VBox.setVgrow(panel11, Priority.ALWAYS);
        VBox.setVgrow(panel22, Priority.ALWAYS);

        panel21.setAlignment(Pos.CENTER);
        panel11.setDisable(true);

        panel21.setPrefHeight(30);
        panel12.setPrefHeight(30);
        panel21.setPrefWidth(200);
        panel22.setPrefWidth(200);
        panel122.setPrefWidth(80);

        return panel0;
    }

    private void initInteraction() {
        panel122.addEventHandler(ActionEvent.ACTION, event -> {
            panel11.setText(panel11.getText() + panel121.getText() + "\n");
            panel121.clear();
        });
    }
}
