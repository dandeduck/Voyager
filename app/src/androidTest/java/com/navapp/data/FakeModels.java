package com.navapp.data;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.Random;

public class FakeModels {

    private static final int MAX_STRING_LENGTH = 40;
    private static final double MAX_DOUBLE_SIZE = 1e6;

    private final AppDatabase database;
    private final Random random;

    public FakeModels(AppDatabase database) {
        this.database = database;
        random = new Random();
    }

    public AddressModel makeFakeAddress() {
        AddressModel address = new AddressModel(
                generateAlphanumericString(),
                random.nextDouble() * MAX_DOUBLE_SIZE,
                random.nextDouble() * MAX_DOUBLE_SIZE
        );

        long[] ids = database.addressDao().insert(address);
        address.setId(ids[0]);

        return address;
    }

    public RateModel makeFakeRate() {
        RateModel rate = new RateModel(
                generateAlphanumericString(),
                random.nextDouble()
        );

        long[] ids = database.rateDao().insert(rate);
        rate.setId(ids[0]);

        return rate;
    }

    private String generateAlphanumericString() {
        return RandomStringUtils.randomAlphanumeric(MAX_STRING_LENGTH);
    }
}
