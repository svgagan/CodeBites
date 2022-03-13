package javaCode.Graphs;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * Write a function, connected_components_count, that takes in the adjacency list of an undirected graph.
 * The function should return the number of connected components within the graph.
 *
 *
 * */
public class ConnectedComponents {

    private static int connected_components_count(Graph<Integer> graph) {
        int count = 0;
        Set<Integer> visited = new HashSet<>();
        for (Integer vertex :graph.getAllVertex()) {
            if (exploreGraphForVertex(vertex, graph, visited))
                count ++;
        }
        return count;
    }

    private static boolean exploreGraphForVertex(Integer vertex, Graph<Integer> graph, Set<Integer> visited) {
        if (visited.contains(vertex))
            return false;

        visited.add(vertex);

        for (int neighbor :graph.getAdjacencyVertices(vertex)) {
            exploreGraphForVertex(neighbor, graph, visited);
        }
        return true;
    }

    public static void main(String[] args) {
        Graph<Integer> unDirectedGraph = new Graph<>();

        unDirectedGraph.addEdges(0, 8, true);
        unDirectedGraph.addEdges(0, 1, true);
        unDirectedGraph.addEdges(0, 5, true);
        unDirectedGraph.addEdges(5, 8, true);
        unDirectedGraph.addEdges(2, 3, true);
        unDirectedGraph.addEdges(3, 4, true);
        unDirectedGraph.addEdges(4, 2, true);

        System.out.println("Graph:\n" + unDirectedGraph);
        int totalConnectedComponents = connected_components_count(unDirectedGraph);
        System.out.println("totalConnectedComponents: "+totalConnectedComponents);

    }
}
