package mprep;

import java.util.Set;
import java.util.Queue;
import java.util.Stack;
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

        List<GraphMethods.Node> visited = new LinkedList<>(); // could also use ID(Node.value)
        if (source == destination) {
            return true;
        }
        return DFS_helper(source, destination, graph, visited);
    }

    public boolean DFS_helper(GraphMethods.Node source,
            GraphMethods.Node dest, Set<GraphMethods.Node> s,
            List<GraphMethods.Node> visited) {
        Stack<GraphMethods.Node> stack = new Stack<>();
        if (source != null && dest != null) {
            if (source.neighbors != null && source.neighbors.contains(dest)) {
                return true;
            } else {
                visited.add(source);
                if (source.neighbors != null) {
                    for (GraphMethods.Node n : source.neighbors) {
                        // System.out.println(
                        // "\nCalling recursively for source: " + n.value + ", (" + n + "), has
                        // neighbors: "
                        // + n.neighbors);
                        stack.add(n);
                    }
                    // System.out.println("stack size: " + stack.size());
                    while (!stack.isEmpty()) {
                        // System.out.println("stack size: " + stack.size() + " peek..." +
                        // stack.peek());
                        GraphMethods.Node tmpNode = stack.pop();
                        if (!visited.contains(tmpNode)) {
                            if (tmpNode.neighbors.contains(dest)) {
                                // System.out.println("\nCan see destination from here, source node: " +
                                // tmpNode.value
                                // + " has neighbors: " + tmpNode.neighbors);
                            }
                            return DFS_helper(tmpNode, dest, s, visited);
                        } else {
                            // System.out.println("already visited node: " + tmpNode.value);
                            continue;
                        }
                    }
                }
            }
        }
        return false;
    }

    public boolean BFS(GraphMethods.Node source,
            GraphMethods.Node destination, Set<GraphMethods.Node> graph) {

        List<GraphMethods.Node> visited = new LinkedList<>(); // could also use ID(Node.value)
        if (source == destination) {
            return true;
        }
        return BFS_helper(source, destination, graph, visited);
    }

    public boolean BFS_helper(GraphMethods.Node source,
            GraphMethods.Node dest, Set<GraphMethods.Node> s,
            List<GraphMethods.Node> visited) {
        Queue<GraphMethods.Node> queue = new LinkedList<>();

        queue.add(source);

        if (source != null && dest != null) {
            if (source.neighbors != null && source.neighbors.contains(dest)) {
                return true;
            } else if (source.neighbors != null) {
                visited.add(source);
                for (GraphMethods.Node n : source.neighbors) {
                    // System.out.println("\nSource is (" + source.value + "): " + source + ",
                    // adding (" + n.value
                    // + "): " + n);
                    queue.add(n);
                }
                // System.out.println("queue size: " + queue.size());
                while (!queue.isEmpty()) {
                    GraphMethods.Node tmpNode = queue.remove();
                    // System.out.println("queue size: " + queue.size());
                    if (!visited.contains(tmpNode)) {
                        if (tmpNode.neighbors.contains(dest)) {
                            // System.out.println("\nCan see destination from here, source node: " +
                            // tmpNode.value
                            // + " has neighbors: " + tmpNode.neighbors);
                        }
                        return BFS_helper(tmpNode, dest, s, visited);
                    } else {
                        // System.out.println("already visited node: " + tmpNode.value);
                        continue;
                    }
                }
            }
        }
        return false;
    }
}