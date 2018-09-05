package com.codecool.tamagotchi.model;

import javafx.application.Platform;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Tamagotchi {
    private DoubleProperty Feeding = new SimpleDoubleProperty();
    private DoubleProperty Fun = new SimpleDoubleProperty();
    private DoubleProperty Age = new SimpleDoubleProperty();

    public Tamagotchi() {
        Feeding.setValue(1.0);
        Fun.setValue(1.0);
        Age.setValue(0);
    }

    public Tamagotchi(String filename) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            this.Feeding.setValue(Double.parseDouble(reader.readLine()));
            this.Fun.setValue(Double.parseDouble(reader.readLine()));
            this.Age.setValue(Double.parseDouble(reader.readLine()));
        }  catch (IOException e) {
            e.printStackTrace();
            Platform.exit();
        }
    }

    public synchronized void feed() {
        this.Feeding.setValue(1.0);
    }

    public synchronized void decreaseFeeding() {
        this.Feeding.setValue(this.Feeding.getValue() - 0.01);
        if (this.Feeding.getValue() <= 0.0) {
            Platform.exit();
        }
    }

    public synchronized void decreaseFun() {
        this.Fun.setValue(this.Fun.getValue() - 0.01);
        if (this.Feeding.getValue() <= 0.0) {
            Platform.exit();
        }
    }

    public synchronized void haveFun() {
        if (this.Fun.getValue() < 0.8) {
            this.Fun.setValue(this.Fun.getValue() + 0.2);
        } else {
            this.Fun.setValue(1.0);
        }
    }

    public synchronized void getOlder() {
        this.Age.setValue(this.Age.getValue() + 1);
    }

    public synchronized DoubleProperty getFeeding() {
        return this.Feeding;
    }

    public synchronized DoubleProperty getFun() {
        return this.Fun;
    }

    public synchronized DoubleProperty getAge() {
        return this.Age;
    }


}
