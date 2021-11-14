package com.navapp.navigation.route;

import android.net.Uri;
import com.navapp.navigation.destination.Destination;
import com.navapp.navigation.destination.data.Place;

import java.util.List;

public class RouteLinkBuilder {
    private static final String NAVIGATION_LINK =  "https://www.google.com/maps/dir/?api=1";
    private static final String ORIGIN = "&origin=";
    private static final String ORIGIN_PLACE_ID = "&origin_place_id=";
    private static final String DESTINATION = "&destination=";
    private static final String DESTINATION_PLACE_ID = "&destination_place_id=";
    private static final String WAYPOINTS = "&waypoints=";
    private static final String WAYPOINT_PLACE_ID = "&waypoint_place_ids=";
    private static final char WAYPOINT_SEPARATOR = '|';

    private static final String DRIVING_TRAVEL_MODE = "&travelmode=driving";
    private static final String SKIP_OVERVIEW = "&dir_action=navigate";

    private final StringBuilder linkBuilder;

    public RouteLinkBuilder() {
        linkBuilder = new StringBuilder(NAVIGATION_LINK);
    }

    public RouteLinkBuilder origin(Route route) {
        return origin(route.getOrigin().getPlace().getAddress(), route.getOrigin().getPlaceId());
    }

    public RouteLinkBuilder origin(String address, String placeId) {
        linkBuilder.append(ORIGIN)
                .append(address)
                .append(ORIGIN_PLACE_ID)
                .append(placeId);

        return this;
    }

    public RouteLinkBuilder destination(Route route) {
        return destination(route.getDestination().getPlace().getAddress(), route.getDestination().getPlaceId());
    }

    public RouteLinkBuilder destination(String address, String placeId) {
        linkBuilder.append(DESTINATION)
                .append(address)
                .append(DESTINATION_PLACE_ID)
                .append(placeId);

        return this;
    }

    public RouteLinkBuilder waypoints(Route route) {
        return waypoints(route.getWaypoints());
    }

    public RouteLinkBuilder waypoints(List<Destination> waypoints) {
        linkBuilder.append(WAYPOINTS);

        for (Destination destination : waypoints)
            linkBuilder.append(destination.getPlace().getAddress())
                    .append(WAYPOINT_SEPARATOR);

        linkBuilder.deleteCharAt(linkBuilder.length()-1);
        linkBuilder.append(WAYPOINT_PLACE_ID);

        for (Destination destination : waypoints)
            linkBuilder.append(destination.getPlaceId())
                    .append(WAYPOINT_SEPARATOR);

        linkBuilder.deleteCharAt(linkBuilder.length()-1);

        return this;
    }

    public RouteLinkBuilder onlyDriving() {
        linkBuilder.append(DRIVING_TRAVEL_MODE);

        return this;
    }

    public RouteLinkBuilder skipOverview() {
        linkBuilder.append(SKIP_OVERVIEW);

        return this;
    }

    public Uri build() {
        return Uri.parse(linkBuilder.toString());
    }
}
