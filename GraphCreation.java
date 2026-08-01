import java.util.*;

public class GraphCreation {
    static class Graph {
        int vertices;
        List<List<Integer>> adjList; 

        // Constructor
        Graph(int vertices) {
            this.vertices = vertices;
            adjList = new ArrayList<>();

            for (int i = 0; i < vertices; i++) {
                adjList.add(new ArrayList<>());
            }
        }

        // Add edge (undirected by default)
        void addEdge(int src, int dest) {
            adjList.get(src).add(dest);
            adjList.get(dest).add(src); // comment this line if graph is directed
        }

        // Print adjacency list
        void printGraph() {
            System.out.println("Graph adjacency list:");
            for (int i = 0; i < vertices; i++) {
                System.out.print(i + " -> ");
                for (int node : adjList.get(i)) {
                    System.out.print(node + " ");
                }
                System.out.println();
            }
        }

        // BFS traversal non recursive using queue
        void bfs(int start) {
            boolean[] visited = new boolean[vertices];
            Queue<Integer> q = new LinkedList<>();
            visited[start] = true;
            q.add(start);

            System.out.println("BFS traversal:");
            while (!q.isEmpty()) {
                int node = q.poll();
                System.out.print(node + " ");

                for (int neighbor : adjList.get(node)) {
                    if (!visited[neighbor]) {
                        visited[neighbor] = true;
                        q.add(neighbor);
                    }
                }
            }
            System.out.println();
        }

        // DFS traversal (non-recursive using stack)
        void dfs(int start) {
            boolean[] visited = new boolean[vertices];
            Stack<Integer> s = new Stack<>();
            visited[start] = true;
            s.push(start);

            System.out.println("DFS traversal:");
            while (!s.isEmpty()) {
                int node = s.pop();
                System.out.print(node + " ");

                for (int neighbor : adjList.get(node)) {
                    if (!visited[neighbor]) {
                        visited[neighbor] = true;
                        s.push(neighbor);
                    }
                }
            }
            System.out.println();
        }
    }

    public static void main(String args[]) {
        Scanner sc= new Scanner(System.in);
        System.out.print("Enter no of vertice: ");
        int vertices= sc.nextInt();
        Graph graph = new Graph(vertices);
        System.out.print("Enter no of edges you want ");
        int e= sc.nextInt();
        for(int i=0; i<e; i++){
            System.out.print("Enter Source Value: ");
            int s= sc.nextInt();
            System.out.print("Enter Destination Value: ");
            int d= sc.nextInt();
            graph.addEdge(s,d); 
        }
        
        // Print adjacency list
        graph.printGraph();

        // Run traversals
        graph.bfs(0);
        graph.dfs(0);
        sc.close();
    }
 
}
