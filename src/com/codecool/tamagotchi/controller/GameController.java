package com.codecool.tamagotchi.controller;

import com.codecool.tamagotchi.model.Tamagotchi;
import com.codecool.tamagotchi.view.View;
import javafx.application.Platform;
import javafx.beans.property.Property;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;

public class GameController {

    public static final String GameFXML = "../view/Game.fxml";
    Tamagotchi tamagotchi;
    Stage primaryStage;


    public GameController(Stage primaryStage, Tamagotchi tamagotchi) {
        this.primaryStage = primaryStage;
        this.tamagotchi = tamagotchi;
    }

    @FXML
    public void initializeGame() {
        try {
            this.primaryStage.hide();

            FXMLLoader GameLoader = new FXMLLoader(getClass().getResource(this.GameFXML));
            GameLoader.setController(this);
            Parent root = GameLoader.load();
            ImageView tamagotchiPicture = (ImageView) root.lookup("#tamagotchiPicture");

            View view = new View();
            view.showTamagotchi(tamagotchiPicture);
            view.setUpBindings(tamagotchi, root);

            this.primaryStage.setScene(new Scene(root, MainMenuController.WINDOW_WIDTH, MainMenuController.WINDOW_HEIGHT));
            this.primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
            Platform.exit();
        }
    }

    public void loadGame(String filename) {

    }

    public void saveGame() {

    }
}
