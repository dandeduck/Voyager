package com.nvapp.navigation.arrival;

import com.navapp.navigation.arrival.HasArrived;

import org.junit.Test;

import java.util.Observer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class HasArrivedTest {
    @Test
    public void observeHasArrived_whenUpdated_ObserverIsTriggered() {
        Observer checker = (observable, o) -> {
            throw new IllegalStateException();
        };
        HasArrived hasArrived = HasArrived.getInstance();
        hasArrived.addObserver(checker);

        try {
            hasArrived.update();
            fail();
        } catch (Exception ignored){}
    }
}
