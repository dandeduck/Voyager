package com.navapp.navigation.util.math;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NodeUtil {
    public static Node createAllDestinationNode(MathDestination start, List<MathDestination> destinations, MathDestination end) {
        List<Node> children = new ArrayList<>();
        List<MathDestination> tmp = new ArrayList<>();
        Collections.copy(tmp, destinations);

        for (int i = 0; i < tmp.size(); ++i) {
            children.add(createAllDestinationNode(tmp.remove(i), tmp, end));
        }

        return new Node(start, children);
    }
}
