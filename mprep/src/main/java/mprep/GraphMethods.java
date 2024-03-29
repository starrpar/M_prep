package mprep;

import java.util.Set;
import java.util.Queue;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

public class GraphMethods {

    public class Node {

        public Node() {
            this.neighbors = new ArrayList<>();
        }

        public Node(int val) {
            this.value = val;
            // this.neighbors = new ArrayList<>();
        }

        int value;
        List<Node> neighbors;
    }

    public boolean DFS(GraphMethods.Node source,
            GraphMethods.Node destination, Set<GraphMethods.Node> graph) {
        if (source == destination) {
            return true;
        }
        return DFS_helper(source, destination, graph);
    }

    public boolean DFS_helper(GraphMethods.Node source,
            GraphMethods.Node dest, Set<GraphMethods.Node> s) {
        if (source != null && dest != null) {
            if (source.neighbors != null && source.neighbors.contains(dest)) {
                return true;
            } else {
                if (source.neighbors != null)
                    for (GraphMethods.Node n : source.neighbors) {
                        System.out.println(
                                "\nCalling recursively for source: " + n.value + ", (" + n + "), has neighbors: "
                                        + n.neighbors);
                        // return false;
                        return DFS_helper(n, dest, s);
                    }
            }
        }
        return false;
    }

    public boolean BFS(GraphMethods.Node source,
            GraphMethods.Node destination, Set<GraphMethods.Node> graph) {
        if (source == destination) {
            return true;
        }
        return BFS_helper(source, destination, graph);
    }

    public boolean BFS_helper(GraphMethods.Node source,
            GraphMethods.Node dest, Set<GraphMethods.Node> s) {
        Queue<GraphMethods.Node> queue = new LinkedList<>();

        if (source != null && dest != null) {
            if (source.neighbors != null && source.neighbors.contains(dest)) {
                return true;
            } else if (source.neighbors != null) {
                for (GraphMethods.Node n : source.neighbors) {
                    System.out.println("\nAdding: " + n);
                    queue.add(n);
                    return BFS_helper(n, dest, s);
                }
            }
        }
        return false;
    }
}