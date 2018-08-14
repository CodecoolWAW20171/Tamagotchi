package com.codecool.tamagotchi.controller;

import com.codecool.tamagotchi.model.Tamagotchi;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class GameController {

    public static final String GameFXML = "../view/Game.fxml";
    Tamagotchi tamagotchi;
    Stage primaryStage;

    public GameController() {
    }

    public GameController(Stage primaryStage, Tamagotchi tamagotchi) {
        this.primaryStage = primaryStage;
        this.tamagotchi = tamagotchi;
    }

    public void initializeGame() {
        this.primaryStage.hide();

        FXMLLoader GameLoader = new FXMLLoader(getClass().getResource(this.GameFXML));
        Parent root = GameLoader.load();

        this.primaryStage.setScene(new Scene(root, MainMenuController.WINDOW_WIDTH, MainMenuController.WINDOW_HEIGHT));
        this.primaryStage.show();
    }

    public void loadGame(String filename) {

    }
}
