package com.nvapp.navigation.util.geofencing;

import com.navapp.navigation.util.geofencing.HasArrived;

import org.junit.Test;

import java.util.Observer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class HasArrivedTest {
    @Test
    public void observeHasArrived_whenChangedToTrue_ObserverIsTriggered() {
        Observer checker = (observable, o) -> {
            assertEquals(true, o);
            ((HasArrived) observable).update(false); //can just pass the instance, but I thought that this will be more true to form to the expected use... But whatever I am not married to it.
            throw new IllegalStateException(); //I assume there is a more elegant way of doing this
        };
        HasArrived hasArrived = HasArrived.getInstance();
        hasArrived.addObserver(checker);

        try {
            hasArrived.update(true);
            fail();
        } catch (Exception ignored){}
    }
}
