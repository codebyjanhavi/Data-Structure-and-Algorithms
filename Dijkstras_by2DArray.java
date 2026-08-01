

import java.util.*;
public class Dijkstras_by2DArray {
    static final int V=6
;
    int minDistance(int dist[],boolean visited[])
    {
        int min= Integer.MAX_VALUE,minIndex=-1;
        for(int v=0; v<V;v++){
            if(!visited[v]&& dist[v]<=min){
                min= dist[V];
                minIndex= v;
            }
        }
    return minIndex;
    }

void printSolution(int dist[]){
    System.out.println("Vertex \t Distance from source");
    for(int i= 0; i<V; i++){
    System.out.println(i+ "\t\t"+dist[i]);
    }
}

void dijkstra(int graph[][],int src){
    int dist[]= new int[V];
    boolean visited[]= new boolean[V];
    Arrays.fill(dist,Integer.MAX_VALUE);
    Arrays.fill(visited,false);
    dist[src]=0;

    for(int i=0; i<V-1; i++){
        int u= minDistance(dist,visited);
        visited[u]=true;

        for(int v=0;v<V;v++){
            if(!visited[v] && graph[u][v]!=0 && dist[u]!=Integer.MAX_VALUE && dist[u]+graph[u][v]<dist[v]){
                dist[v]=dist[u]+graph[u][v];
            }
        }
    }
    printSolution(dist);
}
public static void main (String args[]){
    int graph[][]={
        {0,2,4,0,0,0},
        {0,0,1,7,0,0},
        {0,0,0,0,3,0},
        {0,0,0,0,0,1},
        {0,0,0,2,0,5},
        {0,0,0,0,0,0}
    };
    Dijkstras_by2DArray d= new Dijkstras_by2DArray();
    d.dijkstra(graph,0);
}
}

