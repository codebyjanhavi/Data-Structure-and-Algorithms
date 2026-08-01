/*Time Complexity:O(ElogV)
  Space Complexity:
 */

import java.util.*;
class Edge{
    int to,weight;
    Edge(int t, int w){
        to= t;
        weight=w;
    }
}

public class Primspq {
    public static void main(String[] args) {
        int V=5;
        List<List<Edge>>graph= new ArrayList<>();
        for(int i=0; i<V; i++){
            graph.add(new ArrayList<>());
        }
        addEdge(graph,0,1,2);
        addEdge(graph,0,3,6);
        addEdge(graph,1,2,3);
        addEdge(graph,1,3,8);
        addEdge(graph,1,4,5);
        addEdge(graph,2,4,7);
        addEdge(graph,3,4,9);
        primsMST(graph,V);
}
    
static void addEdge(List<List<Edge>>graph,int u, int v, int w){
    graph.get(u).add(new Edge(v,w));
    graph.get(v).add(new Edge(u,w));
}
static void primsMST (List<List<Edge>> graph, int V){
    boolean visited[]= new boolean[V];
    PriorityQueue<Edge> pq= new PriorityQueue<>((a,b) -> a.weight-b.weight);
    visited[0]= true;
    pq.addAll(graph.get(0));
    int totalWeight=0;
    System.out.println("Edges in MST:");
    while(!pq.isEmpty()){
        Edge e= pq.poll();
        if(visited[e.to])
            continue;
        visited[e.to]=true;
        totalWeight += e.weight;
        System.out.println("-"+e.to+":"+e.weight);
        for(Edge next:graph.get(e.to)){
            if(!visited[next.to]){
                pq.add(next);
            }
        } 
    }
    
    System.out.println("Total weight ="+ totalWeight);

   }
}

    
