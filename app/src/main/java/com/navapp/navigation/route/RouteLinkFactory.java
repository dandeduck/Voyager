package com.navapp.navigation.route;

import android.net.Uri;

import com.navapp.navigation.destination.Destination;

public class RouteLinkFactory {
    public static Uri create(Route route, boolean chooseDriving, boolean shouldSkipOverview) {
        RouteLinkBuilder linkBuilder = new RouteLinkBuilder()
                .origin(route)
                .destination(route)
                .waypoints(route);

        if (chooseDriving)
            linkBuilder = linkBuilder.onlyDriving();
        if (shouldSkipOverview)
            linkBuilder = linkBuilder.skipOverview();

        return linkBuilder.build();
    }
}
