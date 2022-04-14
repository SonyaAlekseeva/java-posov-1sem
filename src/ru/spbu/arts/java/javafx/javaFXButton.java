package ru.spbu.arts.java.javafx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class javaFXButton extends Application {

    private final HBox panel0 = new HBox();
    private final Button button = new Button("Не нажимайте эту кнопку");
    private int i = 0;
    private final String[] angryText = {"Зачем вы нажали?", "Я же просила вас не нажимать!",
            "Вы совершаете ошибку вселенского масштаба!", "Остановитесь!!", "Я так больше не могу", "Ну все..."};

    @Override
    public void start(Stage stage) {
        stage.setTitle("Злая кнопка");
        Parent parent = initInterface();
        initInteraction();

        stage.setScene(new Scene(parent));
        stage.setHeight(500);
        stage.setWidth(600);
        stage.show();
    }

    private Parent initInterface() {
        panel0.getChildren().addAll(button);
        panel0.setAlignment(Pos.CENTER);
        return panel0;
    }

    private void initInteraction(){
        button.addEventHandler(ActionEvent.ACTION, event -> {
            if (i < angryText.length) {
                button.setText(angryText[i]);
                i++;
            }
            else {
                panel0.getChildren().removeAll(button);
                Image img = null;
                try {
                    img = new Image(new FileInputStream("src/img.jpg"));
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                ImageView cat = new ImageView(img);
                cat.setFitHeight(467);
                cat.setFitWidth(367);
                panel0.getChildren().add(cat);
            }
        });
    }
}
