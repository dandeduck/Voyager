package com.navapp.navigation.destination;

import com.navapp.navigation.destination.data.Address;
import com.navapp.navigation.destination.data.PhoneNumber;
import com.navapp.navigation.destination.data.Rate;

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
    public Address getAddress() {
        return address;
    }

    public Rate getRate() {
        return rate;
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }

    public String getComment() {
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
