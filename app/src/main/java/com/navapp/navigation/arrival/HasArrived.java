package com.navapp.navigation.arrival;

import java.util.Observable;

public class HasArrived extends Observable {
    private static final HasArrived instance = new HasArrived();

    public static HasArrived getInstance() {
        return instance;
    }

    private HasArrived() {
    }

    public void update() {
        synchronized (this) {
            setChanged();
            notifyObservers(null);
        }
    }
}
