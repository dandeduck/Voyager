package com.navapp.navigation.util.general;

import com.navapp.navigation.destination.Destination;
import com.navapp.navigation.destination.data.Location;
import com.navapp.navigation.util.math.LocationCluster;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ZipCodeClustering {
    private final Map<String, LocationCluster> zipCodes;

    public ZipCodeClustering() {
        zipCodes = new HashMap<>();
    }

    public List<LocationCluster> divideDestinationsIntoClusters(List<Destination> destinations) { //would have used Stream .map method here...
        List<Location> convertedList = new ArrayList<>();

        for (Destination dest : destinations)
            convertedList.add(dest.getLocation());

        return divideLocationsIntoClusters(convertedList);
    }

    public List<LocationCluster> divideLocationsIntoClusters(List<Location> locations) {
        for (Location location : locations) {
            String zipCode = location.getAddress().getPostalCode();

            if(zipCodes.containsKey(zipCode))
                zipCodes.get(zipCode).getLocations().add(location);
            else
                zipCodes.put(zipCode, new LocationCluster(location));
        }

        return extractClustersFromMap();
    }

    private List<LocationCluster> extractClustersFromMap() {
        List<LocationCluster> clusters = new ArrayList<>();

        for (String zipCode : zipCodes.keySet())
            clusters.add(zipCodes.remove(zipCode));

        return clusters;
    }
}
