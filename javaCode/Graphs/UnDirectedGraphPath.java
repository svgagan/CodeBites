package javaCode.Graphs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * Write a function, undirected_path, that takes in a list of edges for an undirected graph and two nodes (node_A, node_B).
 * The function should return a boolean indicating whether or not there exists a path between node_A and node_B.
 *
 * */
public class UnDirectedGraphPath {

    public static void main(String[] args) {

        Graph<Character> unDirectedGraph = new Graph<>();

        unDirectedGraph.addEdges('i', 'j', true);
        unDirectedGraph.addEdges('k', 'i', true);
        unDirectedGraph.addEdges('m', 'k', true);
        unDirectedGraph.addEdges('k', 'l', true);
        unDirectedGraph.addEdges('o', 'n', true);
        System.out.println("Graph:\n" + unDirectedGraph);

        System.out.println("hasPathUsingDFS for unDirectedGraph: "+hasPathUsingDFS(unDirectedGraph, 'j','m',new HashSet()));
        System.out.println("hasPathUsingBFS for unDirectedGraph: "+hasPathUsingBFS(unDirectedGraph, 'j','n', new HashSet()));
    }

    private static boolean hasPathUsingDFS(Graph<Character> unDirectedGraph, char src, char dst, HashSet<Character> visited) {

        if (src == dst)
            return true;

        // To handle cycle within undirected graphs.
        if (visited.contains(src))
            return false;

        visited.add(src);

        for (Character node: unDirectedGraph.getAdjacencyVertices(src)) {
            if(hasPathUsingDFS(unDirectedGraph, node, dst, visited)) {
                return true;
            }
        }
        return false;
    }

    private static boolean hasPathUsingBFS(Graph<Character> unDirectedGraph, char src, char dst, HashSet<Character> visited) {
        Queue<Character> queue = new LinkedList<>();
        queue.add(src);

        while(!queue.isEmpty()) {
            Character current = queue.poll();

            if (current == dst)
                return true;

            visited.add(current);
            for (Character node: unDirectedGraph.getAdjacencyVertices(current)) {
                if (!visited.contains(node)) {
                    queue.add(node);
                }
            }
        }

        return false;
    }
}
