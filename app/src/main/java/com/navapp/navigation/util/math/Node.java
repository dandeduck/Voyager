package com.navapp.navigation.util.math;

import java.util.List;

public class Node {
    private final MathDestination self;
    private final List<Node> children;

    public Node(MathDestination self, List<Node> children) {
        this.self = self;
        this.children = children;
    }

    public double calcCost() {
        double cost = 0;

        for (Node node : children) {
            cost += self.cost(node.self);
        }

        return cost;
    }

    public List<Node> getChildren() {
        return children;
    }
}
