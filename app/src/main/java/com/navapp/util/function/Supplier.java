package com.navapp.util.function;

/**
 * Copied from java.util.function.Supplier, which requires API level 24 (JDK 8)
 */
@FunctionalInterface
public interface Supplier<T> {

    T get();
}
