package com.codecool.tamagotchi.controller;

import com.codecool.tamagotchi.model.Tamagotchi;

public class getOlderRunnable implements Runnable {

    private Tamagotchi tamagotchi;

    public getOlderRunnable(Tamagotchi tamagotchi) {
        this.tamagotchi = tamagotchi;
    }

    public void run() {
        this.tamagotchi.getOlder();
    }

}
