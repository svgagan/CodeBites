package javaCode.Graphs;

public class PrintGraph {

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
    }
}
