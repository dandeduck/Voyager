package com.navapp.navigation.route;

import com.navapp.navigation.destination.Destination;
import com.navapp.navigation.destination.data.Address;

import java.util.Collection;
import java.util.Deque;
import java.util.Queue;

public interface RouteOptimizer {
    Queue<Destination> orderRoute(Address start, Route route);
}
