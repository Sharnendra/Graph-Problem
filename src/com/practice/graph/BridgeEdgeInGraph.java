package com.practice.graph;

import java.util.ArrayList;
import java.util.List;

public class BridgeEdgeInGraph {
	
	private static int V = 5;   // No. of vertices
	  
    // Array  of lists for Adjacency List Representation
    static int time = 0;
    static final int NIL = -1;
    static List<ArrayList<Integer>> adj;

	// A utility function to add an edge in an
	// undirected graph
	static void addEdge(List<ArrayList<Integer>> adj, int u, int v) {
		if (!adj.get(u).contains(v)) {
			adj.get(u).add(v);
		}
		if (!adj.get(v).contains(u)) {
			adj.get(v).add(u);
		}
	}
	
	public static void main(String[] args) {
		adj = new ArrayList<ArrayList<Integer>>(5);

		for (int i = 0; i < 5; i++) {
			adj.add(new ArrayList<Integer>());
		}

		// Create graphs given in above diagrams
        System.out.println("Bridges in first graph ");
        addEdge(adj,1, 0);
        addEdge(adj,0, 2);
        addEdge(adj,2, 1);
        addEdge(adj,0, 3);
        addEdge(adj,3, 4);
        bridge();
        
        System.out.println();
        // Create graphs given in above diagrams
        System.out.println("Bridges in first graph ");
        adj = new ArrayList<ArrayList<Integer>>(V);
        for (int i = 0; i < V; i++) {
			adj.add(new ArrayList<Integer>());
		}
        addEdge(adj,0,1);
        addEdge(adj,1,2);
        addEdge(adj,2,3);
        addEdge(adj,3,4);
        bridge();
	}
	
	// A recursive function that finds and prints bridges
    // using DFS traversal
    // u --> The vertex to be visited next
    // visited[] --> keeps tract of visited vertices
    // disc[] --> Stores discovery times of visited vertices
    // parent[] --> Stores parent vertices in DFS tree
    static void bridgeUtil(int u, boolean visited[], int disc[],
                    int low[], int parent[])
    {
  
        // Mark the current node as visited
        visited[u] = true;
  
        // Initialize discovery time and low value
        disc[u] = low[u] = ++time;
  
        // Go through all vertices aadjacent to this
        for (int data : adj.get(u)) 
        {
            int v = data;  // v is current adjacent of u
  
            // If v is not visited yet, then make it a child
            // of u in DFS tree and recur for it.
            // If v is not visited yet, then recur for it
            if (!visited[v])
            {
                parent[v] = u;
                bridgeUtil(v, visited, disc, low, parent);
  
                // Check if the subtree rooted with v has a
                // connection to one of the ancestors of u
                low[u]  = Math.min(low[u], low[v]);
  
                // If the lowest vertex reachable from subtree
                // under v is below u in DFS tree, then u-v is
                // a bridge
                if (low[v] > disc[u])
                    System.out.println(u+" "+v);
            }
  
            // Update low value of u for parent function calls.
            else if (v != parent[u])
                low[u]  = Math.min(low[u], disc[v]);
        }
    }
  
  
    // DFS based function to find all bridges. It uses recursive
    // function bridgeUtil()
    static void bridge()
    {
        // Mark all the vertices as not visited
        boolean visited[] = new boolean[V];
        int disc[] = new int[V];
        int low[] = new int[V];
        int parent[] = new int[V];
  
  
        // Initialize parent and visited, and ap(articulation point)
        // arrays
        for (int i = 0; i < V; i++)
        {
            parent[i] = NIL;
        }
  
        // Call the recursive helper function to find Bridges
        // in DFS tree rooted with vertex 'i'
        for (int i = 0; i < V; i++)
            if (!visited[i])
                bridgeUtil(i, visited, disc, low, parent);
    }
}
