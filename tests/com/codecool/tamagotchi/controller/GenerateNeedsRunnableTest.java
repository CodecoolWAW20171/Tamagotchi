package com.codecool.tamagotchi.controller;

import com.codecool.tamagotchi.model.Tamagotchi;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GenerateNeedsRunnableTest {

    Tamagotchi tamagotchi;
    GenerateNeedsRunnable runnable;

    @Before
    public void initialize() {
        this.tamagotchi = new Tamagotchi();
        this.runnable = new GenerateNeedsRunnable(this.tamagotchi);
    }

    @Test
    public void run() {
        Assert.assertEquals((Double)1.0, tamagotchi.getFeeding().getValue());
        Assert.assertEquals((Double) 1.0, tamagotchi.getFun().getValue());
        runnable.run();
        Assert.assertEquals((Double)0.99, tamagotchi.getFeeding().getValue());
        Assert.assertEquals((Double)0.99,tamagotchi.getFun().getValue());

    }
}