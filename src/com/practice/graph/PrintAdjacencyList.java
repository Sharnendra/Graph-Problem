package com.practice.graph;

import java.util.ArrayList;

//Print Adjacent List int a Graph
public class PrintAdjacencyList {

	// A utility function to add an edge in an
	// undirected graph
	static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
		if (!adj.get(u).contains(v)) {
			adj.get(u).add(v);
		}
		if (!adj.get(v).contains(u)) {
			adj.get(v).add(u);
		}
	}

	// A utility function to print the adjacency list
	// representation of graph
	static void printGraph(ArrayList<ArrayList<Integer>> adj) {
		for (int i = 0; i < adj.size(); i++) {
			System.out.print("The List of Vertices of vertex " + i + " -> ");
			for (int j = 0; j < adj.get(i).size(); j++) {
				System.out.print(adj.get(i).get(j) + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(5);

		for (int i = 0; i < 5; i++) {
			adj.add(new ArrayList<Integer>());
		}

		// Adding edges one by one
		addEdge(adj, 0, 1);
		addEdge(adj, 0, 4);
		addEdge(adj, 1, 2);
		addEdge(adj, 1, 3);
		addEdge(adj, 1, 4);
		addEdge(adj, 2, 3);
		addEdge(adj, 3, 4);

		printGraph(adj);
	}

}
