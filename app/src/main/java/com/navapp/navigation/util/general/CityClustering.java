package com.navapp.navigation.util.general;

import com.navapp.navigation.destination.Destination;
import com.navapp.navigation.destination.data.Location;
import com.navapp.navigation.util.android.AddressUtil;
import com.navapp.navigation.util.math.LocationCluster;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CityClustering {
    private final Map<String, LocationCluster> cities;

    public CityClustering() {
        cities = new HashMap<>();
    }

    public List<LocationCluster> divideDestinationsIntoClusters(List<Destination> destinations) { //would have used Stream .map method here...
        List<Location> convertedList = new ArrayList<>();

        for (Destination dest : destinations)
            convertedList.add(dest.getLocation());

        return divideLocationsIntoClusters(convertedList);
    }

    public List<LocationCluster> divideLocationsIntoClusters(List<Location> locations) {
        for (Location location : locations) {
            String city = AddressUtil.city(location.getAddress());

            if(cities.containsKey(city))
                cities.get(city).getLocations().add(location);
            else
                cities.put(city, new LocationCluster(location));
        }

        return extractClustersFromMap();
    }

    private List<LocationCluster> extractClustersFromMap() {
        List<LocationCluster> clusters = new ArrayList<>();

        for (String city : cities.keySet())
            clusters.add(cities.remove(city));

        return clusters;
    }
}
