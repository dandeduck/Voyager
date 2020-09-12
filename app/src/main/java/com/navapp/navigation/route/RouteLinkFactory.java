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
        StringBuilder linkBuilder = new StringBuilder(NAVIGATION_LINK);

        originSection(linkBuilder, route);
        destinationSection(linkBuilder, route);
        waypointsSection(linkBuilder, route);

        linkBuilder.append(chooseDriving ? DRIVING_TRAVEL_MODE : "")
                .append(shouldSkipOverview ? SKIP_OVERVIEW : "");

        return Uri.parse(linkBuilder.toString());
    }

    private static void originSection(StringBuilder builder, Route route) {
        builder.append(ORIGIN)
                .append(route.getOrigin().getPlace().getAddress())
                .append(ORIGIN_PLACE_ID)
                .append(route.getOrigin().getPlaceId());
    }

    private static void destinationSection(StringBuilder builder, Route route) {
        builder.append(DESTINATION)
                .append(route.getDestination().getPlace().getAddress())
                .append(DESTINATION_PLACE_ID)
                .append(route.getDestination().getPlaceId());
    }

    private static void waypointsSection(StringBuilder builder, Route route) {
        builder.append(WAYPOINTS);

        for (Destination destination : route.getWaypoints())
            builder.append(destination.getPlace().getAddress())
                    .append(WAYPOINT_SEPARATOR);

        builder.deleteCharAt(builder.length()-1);
        builder.append(WAYPOINT_PLACE_ID);

        for (Destination destination : route.getWaypoints())
            builder.append(destination.getPlaceId())
                    .append(WAYPOINT_SEPARATOR);

        builder.delete(builder.length()-1, builder.length());
    }
}
