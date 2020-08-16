package com.navapp.navigation.factories;

import com.navapp.navigation.destination.data.Location;

public interface LocationFactory {
    Location create(String address);
}
