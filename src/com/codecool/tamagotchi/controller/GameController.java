package com.codecool.tamagotchi.controller;

import com.codecool.tamagotchi.Utility;
import com.codecool.tamagotchi.model.Tamagotchi;
import com.codecool.tamagotchi.view.View;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class GameController {
    private Tamagotchi tamagotchi;
    private Stage primaryStage;


    public GameController(Stage primaryStage, Tamagotchi tamagotchi) {
        this.primaryStage = primaryStage;
        this.tamagotchi = tamagotchi;
    }

    @FXML
    public void initializeGame() {
        try {
            this.primaryStage.hide();

            FXMLLoader GameLoader = new FXMLLoader(getClass().getResource(Utility.GameFXML));
            GameLoader.setController(this);
            Parent root = GameLoader.load();
            ImageView tamagotchiPicture = (ImageView) root.lookup("#tamagotchiPicture");

            View view = new View();
            view.showTamagotchi(tamagotchiPicture);
            view.setUpBindings(this.tamagotchi, root);

            ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);
            executor.scheduleAtFixedRate(new GenerateNeedsRunnable(this.tamagotchi), 0, 2, TimeUnit.SECONDS);
            executor.scheduleAtFixedRate(new GetOlderRunnable(this.tamagotchi), 1, 1, TimeUnit.SECONDS);

            this.primaryStage.setScene(new Scene(root, Utility.WINDOW_WIDTH, Utility.WINDOW_HEIGHT));
            this.primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
            Platform.exit();
        }
    }

    public void feed() {
        this.tamagotchi.feed();
    }

    public void haveFun() {
        this.tamagotchi.haveFun();
    }

    public void saveGame() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(Utility.saveFile));
            writer.write(tamagotchi.getFeeding().getValue().toString());
            writer.newLine();
            writer.write(tamagotchi.getFun().getValue().toString());
            writer.newLine();
            writer.write(tamagotchi.getAge().getValue().toString());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
            Platform.exit();
        }
    }
}
