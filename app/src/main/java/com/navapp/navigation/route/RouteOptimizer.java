package com.navapp.navigation.route;

import com.navapp.navigation.destination.Destination;
import com.navapp.navigation.destination.data.Address;

import java.util.Collection;
import java.util.Deque;

public interface RouteOptimizer {
    Deque<Destination> optimizeRoute(Address start, Collection<Destination> destinations, Address end);
}
