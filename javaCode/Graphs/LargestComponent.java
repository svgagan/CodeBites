package javaCode.Graphs;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * Write a function, largest_component, that takes in the adjacency list of an undirected graph.
 * The function should return the size of the largest connected component in the graph.
 *
 * */
public class LargestComponent {

    private static int largest_component(Graph<Integer> graph) {
        Set<Integer> visited = new HashSet<>();
        int componentSize = 0;
        for (int current : graph.getAllVertex()) {
            int size = countTheIslandSize(current, graph, visited);
            if (componentSize < size)
                componentSize = size;
        }
        return componentSize;
    }

    private static int countTheIslandSize(int current, Graph<Integer> graph, Set<Integer> visited) {
        if (visited.contains(current))
            return 0;

        visited.add(current);
        int size = 1;
        for (int neighbor:graph.getAdjacencyVertices(current)) {
            size += countTheIslandSize(neighbor, graph, visited);
        }

        return size;
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
        int largestComponent = largest_component(unDirectedGraph);
        System.out.println("largestComponent: "+largestComponent);

    }
}
