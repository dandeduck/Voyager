package com.navapp.navigation.util.geofence;

import java.util.Observable;

public class HasArrived extends Observable {
    private final static HasArrived instance = new HasArrived();

    public static HasArrived getInstance() {
        return instance;
    }

    private HasArrived() {
    }

    public void update(boolean hasArrived) {
        synchronized (this) {
            if(hasArrived) {
                setChanged();
                notifyObservers(hasArrived);
            }
        }
    }
}
