package com.codecool.tamagotchi.controller;

import com.codecool.tamagotchi.model.Tamagotchi;

public class GenerateNeedsRunnable implements Runnable {

    private Tamagotchi tamagotchi;

    public GenerateNeedsRunnable(Tamagotchi tamagotchi) {
        this.tamagotchi = tamagotchi;
    }

    public void run() {
        this.tamagotchi.decreaseFeeding();
        this.tamagotchi.decreaseFun();
    }

}
