package com.practice.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

//To Determine whether the graph is Cyclic or not using Breadth First Search
public class CyclicGraphDeterminerBFS {

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
		System.out.println(BFS(adj, 0, 5));
	}

	// Perform BFS on the graph starting from vertex `src` and
	// return true if a cycle is found in the graph
	public static boolean BFS(List<ArrayList<Integer>> graph, int src, int N) {
		// to keep track of whether a vertex is discovered or not
		boolean[] discovered = new boolean[N];

		// mark the source vertex as discovered
		discovered[src] = true;

		// create a queue for doing BFS and
		// enqueue source vertex
		Queue<Node> queue = new ArrayDeque<>();
		queue.add(new Node(src, -1));

		// loop till queue is empty
		while (!queue.isEmpty()) {
			// dequeue front node and print it
			Node node = queue.poll();

			// do for every edge `v —> u`
			for (int u : graph.get(node.value)) {
				if (!discovered[u]) {
					// mark it as discovered
					discovered[u] = true;

					// construct the queue node containing info
					// about vertex and enqueue it
					queue.add(new Node(u, node.value));
				}

				// `u` is discovered, and `u` is not a parent
				else if (u != node.parent) {
					// we found a cross-edge, i.e., the cycle is found
					return true;
				}
			}
		}

		// no cross-edges were found in the graph
		return false;
	}
}

//Node to store vertex and its parent info in BFS
class Node {
	int value, parent;

	Node(int value, int parent) {
		this.value = value;
		this.parent = parent;
	}
}
