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

    private String feedingBarSelector = "#feedingBar";
    private String funBarSelector = "#funBar";
    private String ageFieldSelector = "#ageField";

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
        ProgressBar feedingBar = (ProgressBar) root.lookup(feedingBarSelector);
        ProgressBar funBar = (ProgressBar) root.lookup(funBarSelector);
        TextField ageField = (TextField) root.lookup(ageFieldSelector);

        feedingBar.progressProperty().bindBidirectional(tamagotchi.getFeeding());
        funBar.progressProperty().bindBidirectional(tamagotchi.getFun());
        ageField.textProperty().bindBidirectional(tamagotchi.getAge(), new NumberStringConverter());
    }
}
