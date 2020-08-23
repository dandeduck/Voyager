package com.navapp.functional;

public interface ConditionalFunction {
    default void check(){
        if(condition())
            function();
    }

    boolean condition();
    void function();
}
