package com.navapp.navigation;

import android.content.Intent;

import com.navapp.navigation.data.Address;
import com.navapp.navigation.data.PhoneNumber;
import com.navapp.navigation.data.Rate;

public class Destination {
    private final Address address;
    private final Rate rate;
    private final PhoneNumber phoneNumber;
    private final String comment;
    private boolean isDelivered;

    public Destination(Address address, Rate rate) {
        this(address, rate, PhoneNumber.empty(), "");
    }

    public Destination(Address address, Rate rate, PhoneNumber phoneNumber) {
        this(address, rate, phoneNumber, "");
    }

    public Destination(Address address, Rate rate, PhoneNumber phoneNumber, String comment) {
        this.address = address;
        this.rate = rate;
        this.phoneNumber = phoneNumber;
        this.comment = comment;
        isDelivered = false;
    }
    public Address address() {
        return address;
    }

    public double rate() {
        return rate.value();
    }

    public Intent callIntent() {
        return phoneNumber.callIntent();
    }

    public String comment() {
        return comment;
    }

    public boolean isDelivered() {
        return isDelivered;
    }

    public void setDelivered() {
        isDelivered = true;
    }

    public void setUnDelivered() {
        isDelivered = false;
    }
}
