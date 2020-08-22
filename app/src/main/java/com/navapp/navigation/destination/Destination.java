package com.navapp.navigation.destination;

import com.navapp.navigation.destination.data.Location;
import com.navapp.navigation.destination.data.PhoneNumber;
import com.navapp.navigation.destination.data.Rate;

public class Destination {
    private final Location location;
    private final Rate rate;
    private final PhoneNumber phoneNumber;
    private final String comment;
    private boolean isDelivered;

    public Destination(Location location) {
        this(location, Rate.empty());
    }

    public Destination(Location location, Rate rate) {
        this(location, rate, PhoneNumber.empty());
    }

    public Destination(Location location, Rate rate, PhoneNumber phoneNumber) {
        this(location, rate, phoneNumber, "");
    }

    public Destination(Location location, Rate rate, PhoneNumber phoneNumber, String comment) {
        this.location = location;
        this.rate = rate;
        this.phoneNumber = phoneNumber;
        this.comment = comment;
        isDelivered = false;
    }

    public Destination changeLocation(String newLocationId) {
        return changeLocation(new Location(newLocationId));
    }

    public Destination changeLocation(Location newLocation) {
        return new Destination(newLocation, rate, phoneNumber, comment);
    }

    public Destination changeRate(Rate newRate) {
        return new Destination(location, newRate, phoneNumber, comment);
    }

    public String getLocationId() {
        return location.getId();
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
