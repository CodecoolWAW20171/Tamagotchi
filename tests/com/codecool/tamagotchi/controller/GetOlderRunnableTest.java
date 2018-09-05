package com.codecool.tamagotchi.controller;

import com.codecool.tamagotchi.model.Tamagotchi;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GetOlderRunnableTest {

    Tamagotchi tamagotchi;
    GetOlderRunnable runnable;

    @Before
    public void initialize() {
        this.tamagotchi = new Tamagotchi();
        this.runnable = new GetOlderRunnable(this.tamagotchi);
    }

    @Test
    public void run() {
        Assert.assertEquals((Double) 0.0, tamagotchi.getAge().getValue());
        runnable.run();
        Assert.assertEquals((Double)1.0, tamagotchi.getAge().getValue());
    }
}