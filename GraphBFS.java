import java.util.*;

public class GraphBFS {
    
    private int numNodes;
    private List<List<Integer>> adjList;

    public GraphBFS(int numNodes, List<List<Integer>> adjList) {
        this.numNodes = numNodes;
        this.adjList = adjList;
    }

    public List<Integer> traverseBFS() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        
        List<Integer> values = new ArrayList<>();
        boolean[] seen = new boolean[this.numNodes];

        while (queue.size() > 0) {
            int vertex = queue.remove();
            values.add(vertex);
            seen[vertex] = true;
            List<Integer> connections = this.adjList.get(vertex);

            for (int i = 0; i < connections.size(); i++) {
                int connection = connections.get(i);
                if (!seen[connection]) {
                    queue.add(connection);
                }
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

        GraphBFS graph = new GraphBFS(numNodes, adjList);

        List<Integer> bfsList = graph.traverseBFS();

        for (int i = 0; i < bfsList.size(); i++) {
            System.out.println("i: " + i + ", Node value = " + bfsList.get(i));
        }
    }
}
