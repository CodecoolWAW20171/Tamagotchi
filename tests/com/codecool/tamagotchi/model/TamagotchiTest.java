package com.codecool.tamagotchi.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TamagotchiTest {

    Tamagotchi tamagotchi;

    @Before
    public void initialize() {
        this.tamagotchi = new Tamagotchi();
    }

    @Test
    public void feed() {
        tamagotchi.feed();
        Assert.assertEquals((Double) 1.0, tamagotchi.getFeeding().getValue());
    }

    @Test
    public void decreaseFeeding() {
        tamagotchi.feed();
        tamagotchi.decreaseFeeding();
        Assert.assertEquals((Double) 0.99, tamagotchi.getFeeding().getValue());
    }

    @Test
    public void decreaseFun() {
        Assert.assertEquals((Double) 1.0, tamagotchi.getFun().getValue());
        tamagotchi.decreaseFun();
        Assert.assertEquals((Double) 0.99, tamagotchi.getFun().getValue());
    }

    @Test
    public void haveFun() {
        tamagotchi.haveFun();
        Assert.assertEquals((Double) 1.0, tamagotchi.getFun().getValue());
    }

    @Test
    public void getOlder() {
        Assert.assertEquals((Double) 0.0, tamagotchi.getAge().getValue());
        tamagotchi.getOlder();
        Assert.assertEquals((Double) 1.0, tamagotchi.getAge().getValue());
    }
}