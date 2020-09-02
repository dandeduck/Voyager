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
        this(location, rate, phoneNumber, comment, false);
    }

    private Destination(Location location, Rate rate, PhoneNumber phoneNumber, String comment, boolean isDelivered) {
        this.location = location;
        this.rate = rate;
        this.phoneNumber = phoneNumber;
        this.comment = comment;
        this.isDelivered = isDelivered;
    }

    public Destination changeRate(Rate newRate) {
        return new Destination(location, newRate, phoneNumber, comment, isDelivered);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Destination)) return false;

        Destination that = (Destination) o;
        return isDelivered == that.isDelivered &&
                location.equals(that.location) &&
                rate.equals(that.rate) &&
                phoneNumber.equals(that.phoneNumber) &&
                comment.equals(that.comment);
    }

    public String getLocationId() {
        return location.getId();
    }

    public Location getLocation() {
        return location;
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
