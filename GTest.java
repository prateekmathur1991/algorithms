// Prateek Mathur

// Java program to test a graph

public class GTest	{
	public static void main(String [] args)	{
		Graph graph = new Graph();
		
		graph.addVertex("A");
		graph.addVertex("B");
		graph.addVertex("C");

		graph.addEdge("A", "B");
		graph.addEdge("A", "C");
		graph.addEdge("E", "G");
	}
}
