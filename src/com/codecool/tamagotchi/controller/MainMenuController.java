package com.codecool.tamagotchi.controller;

import com.codecool.snake.Game;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MainMenuController {

    public static final double MENU_WIDTH = 1000;
    public static final double MENU_HEIGHT = 700;
    public static final String MenuFXML = "../view/fxml/main_menu.fxml";
    public static final String filename;

    @FXML private Button startNewGame;
    @FXML private Button startLoadedGame;

    private GameController gameController;

    public void setMainController(GameController gameController) {
        this.gameController = gameController;
    }

    @FXML
    private void initialize() {
    }

    @FXML
    private void startNewGame() {
        gameController.initializeGame();
    }

    @FXML
    private void startLoadedGame() {
        gameController.loadGame(filename);
    }
}
