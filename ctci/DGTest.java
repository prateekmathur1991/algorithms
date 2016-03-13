package ctci;
// Prateek Mathur

// Java program to test a graph

public class DGTest	{
	public static void main(String [] args)	{
		DGraph graph = new DGraph();
		
		graph.addVertex("0");
		graph.addVertex("1");
		graph.addVertex("2");
		graph.addVertex("3");
		graph.addVertex("4");
		graph.addVertex("5");

		graph.addEdge("0", "1");
		graph.addEdge("0", "4");
		graph.addEdge("0", "5");
		graph.addEdge("1", "4");
		graph.addEdge("1", "3");
		graph.addEdge("2", "1");
		graph.addEdge("3", "2");
		graph.addEdge("3", "4");

		/* System.out.println(graph.hasEdge("A", "B"));
		System.out.println(graph.hasEdge("A", "C"));
		System.out.println(graph.hasEdge("A", "H"));
		System.out.println(graph.hasEdge("A", "G"));

		System.out.println(graph.vertices + " " + graph.edges);

		graph.printAdjList();
		graph.printBFS("r");
		graph.printShortestPath("r", "x");

		graph.printDFS();

		graph.topologicalSort(); */
		
		System.out.println(graph.hasRoute("0", "3"));
	}
}
