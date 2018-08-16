package com.codecool.tamagotchi.model;

import javafx.collections.FXCollections;

public class Tamagotchi {
    private int Feeding;
    private int Fun;
    private int Age;

    public Tamagotchi() {
        Feeding = 100;
        Fun = 100;
        Age = 0;
    }

    public Tamagotchi(String filename) {

    }

    public synchronized void feed() {
        this.Feeding = 100;
    }

    public synchronized void decreaseFeeding() { this.Feeding -= 1;
    }

    public synchronized void decreaseFun() { this.Fun -= 1;}

    public synchronized void haveFun() {
        if (this.Fun < 80) {
            this.Fun += 20;
        } else {
            this.Fun = 100;
        }
    }

    public synchronized void getOlder() {
        this.Age += 1;
    }

    public int getFeeding() {
        return this.Feeding;
    }

    public int getFun() {
        return this.Fun;
    }

    public int getAge() {
        return this.Age;
    }


}
