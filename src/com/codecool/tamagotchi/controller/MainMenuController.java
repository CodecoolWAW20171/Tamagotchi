package com.codecool.tamagotchi.controller;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class MainMenuController {

    public static final double WINDOW_WIDTH = 1200;
    public static final double WINDOW_HEIGHT = 800;
    public static final String MenuFXML = "../view/MainMenu.fxml";
    public static final String FILENAME = "@/saveFile.txt";
    private Stage primaryStage;

    @FXML
    private Button startNewGame;
    @FXML
    private Button startLoadedGame;

    private GameController gameController;

    public void setGameController(GameController gameController) {
        this.gameController = gameController;
    }

    public MainMenuController(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public MainMenuController() {
    }

    public void initMainMenu() {
        try {
            primaryStage.hide();

            FXMLLoader mainMenuLoader = new FXMLLoader(getClass().getResource(this.MenuFXML));
            Parent root = (AnchorPane) mainMenuLoader.load();

            primaryStage.setScene(new Scene(root, MainMenuController.WINDOW_WIDTH, MainMenuController.WINDOW_HEIGHT));
            primaryStage.show();

        } catch (IOException e) {
            e.printStackTrace();
            Platform.exit();
        }
    }


    @FXML
    private void startNewGame() {
        GameController gameController = new GameController();
        gameController.initializeGame();
    }

    @FXML
    private void continueSavedGame() {
        gameController.loadGame(FILENAME);
    }

}
