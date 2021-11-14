package com.nvapp.navigation.arrival;

import com.navapp.navigation.arrival.HasArrived;

import org.junit.Test;

import java.util.Observer;

import static org.junit.Assert.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class HasArrivedTest {
    @Test
    public void observeHasArrived_whenUpdated_ObserverIsTriggered() {
        Observer checker = mock(Observer.class);
        HasArrived hasArrived = HasArrived.getInstance();
        hasArrived.addObserver(checker);

        hasArrived.update();
        verify(checker, times(1)).update(any(), any());
    }
}
