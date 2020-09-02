package com.navapp.navigation.route;

import android.net.Uri;

import com.navapp.navigation.destination.Destination;

public class RouteLinkFactory {
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

    public static Uri create(Route route, boolean chooseDriving, boolean shouldSkipOverview) {
        String unEncodedUri = new StringBuilder()
                .append(NAVIGATION_LINK)
                .append(originSection(route))
                .append(destinationSection(route))
                .append(waypointsSection(route))
                .append(chooseDriving ? DRIVING_TRAVEL_MODE : "")
                .append(shouldSkipOverview ? SKIP_OVERVIEW : "")
                .toString();

        return Uri.parse(unEncodedUri);
    }

    private static String originSection(Route route) {
        return new StringBuilder()
                .append(ORIGIN)
                .append(route.getOrigin().getLocation().getAddress())
                .append(ORIGIN_PLACE_ID)
                .append(route.getOrigin().getLocationId())
                .toString();
    }

    private static String destinationSection(Route route) {
        return new StringBuilder()
                .append(DESTINATION)
                .append(route.getDestination().getLocation().getAddress())
                .append(DESTINATION_PLACE_ID)
                .append(route.getDestination().getLocationId())
                .toString();
    }

    private static String waypointsSection(Route route) {
        StringBuilder builder = new StringBuilder();
        builder.append(WAYPOINTS);

        for (Destination destination : route.getWaypoints())
            builder.append(destination.getLocation().getAddress())
                    .append(WAYPOINT_SEPARATOR);

        builder.deleteCharAt(builder.length()-1);
        builder.append(WAYPOINT_PLACE_ID);

        for (Destination destination : route.getWaypoints())
            builder.append(destination.getLocationId())
                    .append(WAYPOINT_SEPARATOR);

        return builder.substring(0, builder.length() - 1);
    }
}
