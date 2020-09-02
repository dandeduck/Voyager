package com.navapp.navigation.route;

import android.net.Uri;

public class RouteLinkFactory {
    private static final String NAVIGATION_LINK =  "https://www.google.com/maps/dir/?api=1";
    private static final String ORIGIN = "&origin=";
    private static final String ORIGIN_PLACE_ID = "&origin_place_id=";
    private static final String DESTINATION = "&destination=";
    private static final String DESTINATION_PLACE_ID = "&destination_place_id=";
    private static final String WAYPOINTS = "&waypoints=";
    private static final String WAYPOINT_PLACE_ID = "&waypoint_place_ids=";
    private static final String WAYPOINT_SEPARATOR = "|";

    private static final String DRIVING_TRAVEL_MODE = "&travelmode=driving";
    private static final String SKIP_OVERVIEW = "dir_action=navigate";

    public static Uri create(Route route, boolean chooseDriving, boolean shouldSkipOverview) {
        String unEncodedUri = new StringBuilder()
                .append(NAVIGATION_LINK)
                .append()
                .toString();



        return Uri.parse(unEncodedUri);
    }

    private String originSection(Route route) {
        return new StringBuilder()
                .append(ORIGIN)
                .append(route.getOrigin())
    }
}
