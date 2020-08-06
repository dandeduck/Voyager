package com.navapp.util;

import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * Copied from java.util.Optional, which requires API level 24 (JDK 8)
 */
public class Optional<T> {

    private static final Optional<?> EMPTY = new Optional<>();
    private final T value;

    private Optional() {
        this.value = null;
    }

    public static <T> Optional<T> empty() {
        return (Optional<T>) EMPTY;
    }

    private Optional(T value) {
        this.value = Objects.requireNonNull(value);
    }

    public static <T> Optional<T> of(T value) {
        return new Optional(value);
    }

    public static <T> Optional<T> ofNullable(T value) {
        return value == null ? empty() : of(value);
    }

    public T get() {
        if (this.value == null) {
            throw new NoSuchElementException("No value present");
        } else {
            return this.value;
        }
    }

    public boolean isPresent() {
        return this.value != null;
    }

    public boolean isEmpty() {
        return this.value == null;
    }
}
