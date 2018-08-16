package com.codecool.tamagotchi.view;

import com.codecool.tamagotchi.model.Tamagotchi;
import javafx.application.Platform;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ObservableValue;
import javafx.scene.Parent;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.converter.NumberStringConverter;


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


    public void setUpBindings(Tamagotchi tamagotchi, Parent root) {
        ProgressBar feedingBar = (ProgressBar) root.lookup("#feedingBar");
        ProgressBar funBar = (ProgressBar) root.lookup("#funBar");
        TextField ageField = (TextField) root.lookup("#ageField");

        ObservableValue<Integer> observableFeeding = new SimpleIntegerProperty(tamagotchi.getFeeding()).asObject();
        feedingBar.progressProperty().bindBidirectional((Property) observableFeeding);

        ObservableValue<Integer> observableFun = new SimpleIntegerProperty(tamagotchi.getFun()).asObject();
        funBar.progressProperty().bindBidirectional((Property) observableFun);

        ObservableValue<Integer> observableAge = new SimpleIntegerProperty(tamagotchi.getAge()).asObject();
        ageField.textProperty().bindBidirectional((Property) observableAge, new NumberStringConverter());
    }
}
