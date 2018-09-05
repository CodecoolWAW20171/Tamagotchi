package com.codecool.tamagotchi.controller;

import com.codecool.tamagotchi.model.Tamagotchi;

public class GetOlderRunnable implements Runnable {

    private Tamagotchi tamagotchi;

    public GetOlderRunnable(Tamagotchi tamagotchi) {
        this.tamagotchi = tamagotchi;
    }

    public synchronized void run() {
        this.tamagotchi.getOlder();
    }

}
