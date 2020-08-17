package com.navapp.navigation.route;

import com.google.maps.DirectionsApi;
import com.google.maps.GeoApiContext;
import com.google.maps.errors.ApiException;
import com.google.maps.model.GeocodedWaypoint;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RoutePlanner {
    private final GeoApiContext context;

    public RoutePlanner(GeoApiContext context) {
        this.context = context;
    }

    public List<String> orderedRouteIds(String originId, List<String> waypointIds, String destinationId) throws InterruptedException, ApiException, IOException {
        GeocodedWaypoint[] orderedWaypoints = DirectionsApi.newRequest(context)
                .originPlaceId(originId)
                .waypointsFromPlaceIds(toArray(waypointIds))
                .destinationPlaceId(destinationId)
                .optimizeWaypoints(true)
                .await().geocodedWaypoints;

        return extractWaypointIds(orderedWaypoints);
    }

    private String[] toArray(List<String> list) {
        String[] array = new String[list.size()];
        list.toArray(array);

        return array;
    }

    private List<String> extractWaypointIds(GeocodedWaypoint[] waypoints) {
        List<String> ids = new ArrayList<>();

        for (GeocodedWaypoint waypoint: waypoints)
            ids.add(waypoint.placeId);

        return ids;
    }
}
