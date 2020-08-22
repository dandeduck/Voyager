package com.navapp.functional;

public interface DependentFunction {
    default void check() {
        if(condition())
            function();
    }

    boolean condition();
    void function();
}
