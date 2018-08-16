package com.codecool.tamagotchi.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Tamagotchi {
    private IntegerProperty Feeding = new SimpleIntegerProperty();
    private IntegerProperty Fun = new SimpleIntegerProperty();
    private IntegerProperty Age = new SimpleIntegerProperty();

    public Tamagotchi() {
        Feeding.setValue(100);
        Fun.setValue(100);
        Age.setValue(0);
    }

    public Tamagotchi(String filename) {

    }

    public synchronized void feed() {
        this.Feeding.setValue(100);
    }

    public synchronized void decreaseFeeding() {
        this.Feeding.setValue(this.Feeding.getValue() - 1);
    }

    public synchronized void decreaseFun() { this.Fun.setValue(this.Fun.getValue() - 1); }

    public synchronized void haveFun() {
        if (this.Fun.getValue() < 80) {
            this.Fun.setValue(this.Fun.getValue() + 20);
        } else {
            this.Fun.setValue(100);
        }
    }

    public synchronized void getOlder() { this.Age.setValue(this.Age.getValue() - 1); }

    public IntegerProperty getFeeding() {
        return this.Feeding;
    }

    public IntegerProperty getFun() {
        return this.Fun;
    }

    public IntegerProperty getAge() {
        return this.Age;
    }


}
