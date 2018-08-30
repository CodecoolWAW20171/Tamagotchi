package com.codecool.tamagotchi.model;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

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

    }

    public synchronized void feed() {
        this.Feeding.setValue(1.0);
    }

    public synchronized void decreaseFeeding() {
        this.Feeding.setValue(this.Feeding.getValue() - 0.01);
    }

    public synchronized void decreaseFun() { this.Fun.setValue(this.Fun.getValue() - 0.01); }

    public synchronized void haveFun() {
        if (this.Fun.getValue() < 0.8) {
            this.Fun.setValue(this.Fun.getValue() + 0.2);
        } else {
            this.Fun.setValue(1.0);
        }
    }

    public synchronized void getOlder() { this.Age.setValue(this.Age.getValue() + 1); }

    public DoubleProperty getFeeding() {
        return this.Feeding;
    }

    public DoubleProperty getFun() {
        return this.Fun;
    }

    public DoubleProperty getAge() {
        return this.Age;
    }


}
