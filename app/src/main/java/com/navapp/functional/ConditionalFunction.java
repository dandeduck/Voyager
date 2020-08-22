package com.navapp.functional;

import com.google.maps.errors.ApiException;

import java.io.IOException;

public interface ConditionalFunction {
    default void check() throws InterruptedException, ApiException, IOException {
        if(condition())
            function();
    }

    boolean condition() throws InterruptedException, ApiException, IOException;
    void function();
}
