package com.practice.graph;

import java.util.ArrayList;
import java.util.List;

//To Determine whether the graph is Cyclic or not using Depth First Search
public class CyclicGraphDeterminerDFS {

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
		List<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(5);

		for (int i = 0; i < 5; i++) {
			adj.add(new ArrayList<Integer>());
		}

		// Adding edges one by one
		addEdge(adj, 0, 1);
		addEdge(adj, 0, 4);
		addEdge(adj, 1, 2);
		addEdge(adj, 1, 3);
		// addEdge(adj, 1, 4);
		addEdge(adj, 2, 3);
		// addEdge(adj, 3, 4);
		// addEdge(adj, 4, 0);
		boolean[] discovered = new boolean[5];
		System.out.println(DFS(adj, 0, discovered, -1));
	}

	// Perform BFS on the graph starting from vertex `src` and
	// return true if a cycle is found in the graph
	public static boolean DFS(List<ArrayList<Integer>> graph, int src, boolean[] discovered, int parent) {
		// to keep track of whether a vertex is discovered or not
		// mark the source vertex as discovered
		discovered[src] = true;

		// do for every edge `v —> u`
		for (int u : graph.get(src)) {
			// if `u` is not discovered
			if (!discovered[u]) {
				return DFS(graph, u, discovered, src);
			}

			// `u` is discovered, and `u` is not a parent
			else if (u != parent) {
				// we found a cross-edge, i.e., the cycle is found
				return true;
			}
		}

		// no cross-edges were found in the graph
		return false;
	}
}
