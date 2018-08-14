package com.codecool.tamagotchi.view;

import javafx.application.Platform;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class View {

    public void showTamagotchi(ImageView imageView) {
        try {
            Image image = new Image("tamagotchi.png");
            imageView.setImage(image);
            imageView.setCache(true);
        } catch (Exception e) {
            e.printStackTrace();
            Platform.exit();
        }
    }


}
