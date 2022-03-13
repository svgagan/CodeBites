package javaCode.Graphs;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * Write a function, hasPath, that takes in an object representing the adjacency list of a directed acyclic graph (DAG) and two nodes (src, dst).
 * The function should return a boolean indicating whether or not there exists a directed path between the source and destination nodes.
 *
 * */

public class DirectedGraphPath {

    public static boolean hasPathUsingDFS(Graph<Character> graph, char src, char dst) {
        if (src == dst){
            return true;
        }
        for (Character current:graph.getAdjacencyVertices(src)) {
            if (hasPathUsingDFS(graph, current, dst)) {
                return true;
            }
        }
        return false;
    }

    public static boolean hasPathUsingBFS(Graph<Character> graph, char src, char dst) {
        Queue<Character> queue = new LinkedList<>();
        queue.add(src);

        while(!queue.isEmpty()) {
            char current = queue.poll();
            if (current == dst) {
                return true;
            }
            queue.addAll(graph.getAdjacencyVertices(current));
        }
        return false;
    }

    public static void main(String[] args) {

        Graph<Character> directedGraph = new Graph<>();

        directedGraph.addEdges('f', 'g', false);
        directedGraph.addEdges('f', 'i', false);
        directedGraph.addEdges('g', 'h', false);
        directedGraph.addEdges('i', 'g', false);
        directedGraph.addEdges('i', 'k', false);
        directedGraph.addEdges('j', 'i', false);
        System.out.println("Graph:\n" + directedGraph);

        System.out.println("hasPathUsingDFS for directedGraph: "+hasPathUsingDFS(directedGraph, 'f','k'));
        System.out.println("hasPathUsingBFS for directedGraph: "+hasPathUsingBFS(directedGraph, 'h','k'));
    }
}
