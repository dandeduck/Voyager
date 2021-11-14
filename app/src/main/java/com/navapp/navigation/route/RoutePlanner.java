package com.navapp.navigation.route;

import com.google.maps.DirectionsApi;
import com.google.maps.GeoApiContext;
import com.google.maps.PendingResult;
import com.google.maps.errors.ApiException;
import com.google.maps.model.DirectionsResult;
import com.google.maps.model.GeocodedWaypoint;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RoutePlanner {
    private final GeoApiContext context;
    private final DirectionsApi.RouteRestriction[] restrictions;

    public RoutePlanner(GeoApiContext context) {
        this(context, new ArrayList<>());
    }

    public RoutePlanner(GeoApiContext context, List<DirectionsApi.RouteRestriction> restrictions) {
        this.context = context;

        DirectionsApi.RouteRestriction[] tmp = new DirectionsApi.RouteRestriction[restrictions.size()];
        this.restrictions = restrictions.toArray(tmp);
    }

    public void requestOrderedRouteIds(String originId, List<String> waypointIds, String destinationId, PendingResult.Callback<List<String>> callback) {
        DirectionsApi.newRequest(context)
                .departureTimeNow()
                .originPlaceId(originId)
                .waypointsFromPlaceIds(toArray(waypointIds))
                .destinationPlaceId(destinationId)
                .avoid(restrictions)
                .optimizeWaypoints(true)
                .setCallback(new PendingResult.Callback<DirectionsResult>() {
                    @Override
                    public void onResult(DirectionsResult result) {
                        callback.onResult(extractWaypointIds(result.geocodedWaypoints));
                    }

                    @Override
                    public void onFailure(Throwable e) {
                        callback.onFailure(e);
                    }
                });
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
