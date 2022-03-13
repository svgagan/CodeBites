package javaCode.Graphs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 *
 * Write a function, shortest_path, that takes in a list of edges for an undirected graph and two nodes (node_A, node_B).
 * The function should return the length of the shortest path between A and B.
 * Consider the length as the number of edges in the path, not the number of nodes. If there is no path between A and B, then return -1.
 *
 * */
class Node {
    int data;
    char vertex;

    Node(int data, char vertex){
        this.data = data;
        this.vertex = vertex;
    }
}

public class ShortestPath {

    public static void main(String[] args) {
        Graph<Character> unDirectedGraph = new Graph<>();
        unDirectedGraph.addEdges('W', 'X', true);
        unDirectedGraph.addEdges('X', 'Y', true);
        unDirectedGraph.addEdges('Z', 'Y', true);
        unDirectedGraph.addEdges('Z', 'V', true);
        unDirectedGraph.addEdges('W', 'V', true);
        System.out.println("Graph:\n" + unDirectedGraph);

        System.out.println("shortest_path: "+shortest_path(unDirectedGraph, 'W', 'Z'));
    }

    private static int shortest_path(Graph<Character> unDirectedGraph, char src, char dst) {
        Set<Character> visited = new HashSet<>();
        visited.add(src);

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0, src));

        while(!queue.isEmpty()) {
            Node current  = queue.poll();

            if (current.vertex == dst) {
                return current.data;
            }

            for (Character neighbor:unDirectedGraph.getAdjacencyVertices(current.vertex)) {
                if(!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(new Node(current.data + 1, neighbor));
                }
            }
        }

        return -1;
    }
}


