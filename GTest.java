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

		System.out.println(graph.hasEdge("A", "B"));
		System.out.println(graph.hasEdge("A", "C"));
		System.out.println(graph.hasEdge("A", "H"));
		System.out.println(graph.hasEdge("A", "G"));

		graph.printAdjList();
	}
}
