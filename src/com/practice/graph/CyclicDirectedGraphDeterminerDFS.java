package com.practice.graph;

import java.util.ArrayList;
import java.util.List;

//To Determine whether the graph is Cyclic or not using Breadth First Search
public class CyclicDirectedGraphDeterminerDFS {

	// A utility function to add an edge in an
	// directed graph
	static void addEdge(List<ArrayList<Integer>> adj, int u, int v) {
		if (!adj.get(u).contains(v)) {
			adj.get(u).add(v);
		}
	}
	
	public static void main(String[] args) {
		List<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(5);

		for (int i = 0; i < 5; i++) {
			adj.add(new ArrayList<Integer>());
		}
		// Adding edges one by one
		addEdge(adj, 0, 1);
		addEdge(adj, 2, 3);
		addEdge(adj, 3, 4);
		//addEdge(adj, 4, 2);
	    System.out.println(DFS(adj, 5));
	}
	
	public static Boolean DFS(List<ArrayList<Integer>> adj,int V) {
		Boolean visited[]=new Boolean[V];
		Boolean reccursionStack[]=new Boolean[V];
		
		for(int i=0;i<V;i++) {
			if(visited[i]!=Boolean.TRUE) { 
				visited[i]=Boolean.TRUE;
				if(DFSUtil(adj, i, visited, reccursionStack)) {
					return Boolean.TRUE;
				}
			}
		}
		return Boolean.FALSE;
	}
	
	public static Boolean DFSUtil(List<ArrayList<Integer>> adj, int src, Boolean visited[], Boolean reccursionStack[]){
		visited[src]=Boolean.TRUE;
		reccursionStack[src]=Boolean.TRUE;
		
		for(int u:adj.get(src)) {
			if(visited[u]==Boolean.FALSE && DFSUtil(adj, u, visited, reccursionStack)) {
				return Boolean.TRUE;
			}
			else {
				return reccursionStack[u]==Boolean.TRUE;
			}
		}
		reccursionStack[src]=Boolean.FALSE;
		return Boolean.FALSE;
	}

}
