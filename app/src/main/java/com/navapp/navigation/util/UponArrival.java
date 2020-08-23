package com.navapp.navigation.util;

import com.navapp.functional.ConditionalFunction;

public abstract class UponArrival implements ConditionalFunction {
    private final double minDistance;

    protected UponArrival(long minDistance) {
        this.minDistance = minDistance;
    }

    @Override
    public boolean condition() {
        return distance() <= minDistance;
    }

    protected abstract double distance();
}
