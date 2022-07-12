import java.util.*;

public class GraphDFS {

    private int numNodes;
    private List<List<Integer>> adjList;

    public GraphDFS(int numNodes, List<List<Integer>> adjList) {
        this.numNodes = numNodes;
        this.adjList = adjList;
    }

    public List<Integer> traverseDFS(int vertex, List<Integer> values, boolean[] seen) {
        values.add(vertex);
        seen[vertex] = true;

        List<Integer> connections = this.adjList.get(vertex);
        for (int i = 0; i < connections.size(); i++) {
            int connection = connections.get(i);
            if (!seen[connection]) {
                traverseDFS(connection, values, seen);
            }
        }
        return values;
    }

    public static void main(String[] args) {
        int numNodes = 9;
        List<List<Integer>> adjList = new ArrayList<>(numNodes);
        for (int i = 0; i < numNodes; i++) {
            adjList.add(new ArrayList<>());
        }
        adjList.get(0).add(1);
        adjList.get(0).add(3);

        adjList.get(1).add(0);

        adjList.get(2).add(3);
        adjList.get(2).add(8);

        adjList.get(3).add(0);
        adjList.get(3).add(4);
        adjList.get(3).add(5);
        adjList.get(3).add(2);

        adjList.get(4).add(3);
        adjList.get(4).add(6);

        adjList.get(5).add(3);

        adjList.get(6).add(4);
        adjList.get(6).add(7);

        adjList.get(7).add(6);

        adjList.get(8).add(2);

        GraphDFS graph = new GraphDFS(numNodes, adjList);

        List<Integer> values = new ArrayList<>();
        boolean[] seen = new boolean[numNodes];
        values = graph.traverseDFS(0, values, seen);

        for (int i = 0; i < values.size(); i++) {
            System.out.println("i = " + i + ", Node = " + values.get(i));
        }
    }
}