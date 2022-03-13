package javaCode.Graphs;

import java.util.*;

public class Graph<T> {

    // We use Hashmap to store the edges in the graph as an adjancency list.
    private Map<T, List<T>> adjVertices = new HashMap<>();

    // This function adds a new vertex to the graph
    public void addVertex(T vertex) {
        adjVertices.putIfAbsent(vertex, new ArrayList<T>());
    }

    // This function adds the edge between source to destination
    public void addEdges(T sourceVertex, T destinationVertex, boolean isItBiDirectional) {
        addVertex(sourceVertex);
        addVertex(destinationVertex);

        adjVertices.get(sourceVertex).add(destinationVertex);
        if(isItBiDirectional)
            adjVertices.get(destinationVertex).add(sourceVertex);
    }

    // Prints the adjancency list of each vertex.
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (T sourceNode : adjVertices.keySet()) {
            builder.append(sourceNode.toString()).append(": ");
            for (T destinationNode : adjVertices.get(sourceNode)) {
                builder.append(destinationNode.toString()).append(" ");
            }
            builder.append("\n");
        }
        return (builder.toString());
    }

    // Verifies if a source vertex has edge to destination vertex.
    public void hasAnyEdge(T sourceVertex, T destinationVertex) {
        if(adjVertices.get(sourceVertex).contains(destinationVertex)) {
            System.out.println(sourceVertex+" has edge to "+destinationVertex);
        } else {
            System.out.println(sourceVertex+" has no edge to "+destinationVertex);
        }
    }

    public List<T> getAdjacencyVertices(T vertex) {
        return adjVertices.get(vertex);
    }
}
