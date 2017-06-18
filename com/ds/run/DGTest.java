package com.ds.run;

import com.ds.core.DirectedGraph;

// Java program to test a graph

public class DGTest	{
	public static void main(String [] args)	{
		DirectedGraph graph = new DirectedGraph();
		
		graph.addVertex("r");
		graph.addVertex("s");
		graph.addVertex("t");
		graph.addVertex("u");
		graph.addVertex("v");
		graph.addVertex("w");
		graph.addVertex("x");
		graph.addVertex("y");

		graph.addEdge("r", "v");
		graph.addEdge("r", "s");
		graph.addEdge("s", "w");
		graph.addEdge("w", "t");
		graph.addEdge("w", "x");
		graph.addEdge("t", "u");
		graph.addEdge("t", "x");
		graph.addEdge("u", "x");
		graph.addEdge("u", "y");
		graph.addEdge("x", "y");

		/* System.out.println(graph.hasEdge("A", "B"));
		System.out.println(graph.hasEdge("A", "C"));
		System.out.println(graph.hasEdge("A", "H"));
		System.out.println(graph.hasEdge("A", "G"));

		System.out.println(graph.vertices + " " + graph.edges);

		graph.printAdjList();
		graph.printBFS("r");
		graph.printShortestPath("r", "x");

		graph.printDFS(); */

		graph.topologicalSort();
	}
}
