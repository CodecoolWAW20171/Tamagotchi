package com.codecool.tamagotchi.controller;

import com.codecool.tamagotchi.Utility;
import com.codecool.tamagotchi.model.Tamagotchi;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class MainMenuController {
    private Stage primaryStage;

    @FXML
    private Button startNewGame;
    @FXML
    private Button startLoadedGame;


    public MainMenuController(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }


    public void initMainMenu() {
        try {
            this.primaryStage.hide();

            FXMLLoader mainMenuLoader = new FXMLLoader(getClass().getResource(Utility.MenuFXML));
            mainMenuLoader.setController(this);
            Parent root = mainMenuLoader.load();

            this.primaryStage.setScene(new Scene(root, Utility.WINDOW_WIDTH, Utility.WINDOW_HEIGHT));
            this.primaryStage.show();

        } catch (IOException e) {
            e.printStackTrace();
            Platform.exit();
        }
    }


    @FXML
    private void startNewGame() {
        Tamagotchi tamagotchi = new Tamagotchi();
        GameController gameController = new GameController(this.primaryStage, tamagotchi);
        gameController.initializeGame();
    }

    @FXML
    private void continueSavedGame() {
        Tamagotchi tamagotchi = new Tamagotchi(Utility.saveFile);
        GameController gameController = new GameController(this.primaryStage, tamagotchi);
        gameController.initializeGame();
    }

}
