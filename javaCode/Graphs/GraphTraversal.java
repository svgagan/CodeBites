package javaCode.Graphs;

import java.util.*;

public class GraphTraversal {

    public static Set<Integer> depthFirstGraphTraversal(Graph<Integer> graph, int root) {
        Set<Integer> visitedVertex = new LinkedHashSet<>();
        Stack<Integer> depthStack = new Stack<>();
        depthStack.push(root);
        while(!depthStack.isEmpty()) {
            int currentVertex = depthStack.pop();
            if (!visitedVertex.contains(currentVertex)) {
                visitedVertex.add(currentVertex);
                graph.getAdjacencyVertices(currentVertex).forEach(depthStack::push);
            }
        }
        return visitedVertex;
    }

    public static Set<Integer> breadthFirstGraphTraversal(Graph<Integer> graph, int root) {
        Set<Integer> visitedVertex = new LinkedHashSet<>();
        Queue<Integer> breadthQueue = new LinkedList<>();
        breadthQueue.add(root);
        visitedVertex.add(root);
        while(!breadthQueue.isEmpty()) {
            int currentVertex = breadthQueue.poll();
            graph.getAdjacencyVertices(currentVertex).forEach(node -> {
                    if(!visitedVertex.contains(node)){
                        visitedVertex.add(node);
                        breadthQueue.add(node);
                    }
            });
        }
        return visitedVertex;
    }

    public static void main(String[] args){
        Graph<Integer> graph = new Graph<Integer>();

        graph.addEdges(0, 1, true);
        graph.addEdges(0, 4, true);
        graph.addEdges(1, 2, true);
        graph.addEdges(1, 3, true);
        graph.addEdges(1, 4, true);
        graph.addEdges(2, 3, true);
        graph.addEdges(3, 4, true);

        System.out.println("Graph:\n" + graph.toString());
        graph.hasAnyEdge(2, 4);

        System.out.println("depthFirstGraphTraversal: "+depthFirstGraphTraversal(graph, 0));
        System.out.println("breadthFirstGraphTraversal: "+breadthFirstGraphTraversal(graph, 0));
    }
}
