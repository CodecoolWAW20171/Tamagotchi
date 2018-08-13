package com.codecool.tamagotchi.controller;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    private static final String TITLE = "Tamagotchi";

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        MainMenuController mainMenuController = new MainMenuController(primaryStage);
        primaryStage.setTitle(TITLE);
        mainMenuController.initMainMenu();
        primaryStage.show();
    }
}
