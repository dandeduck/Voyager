package com.navapp.navigation.util;

import com.navapp.functional.ConditionalFunction;

public abstract class UponArrival implements ConditionalFunction {
    @Override
    public boolean condition() {
        return false;
    }
}
