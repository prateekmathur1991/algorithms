package core;
// Prateek Mathur

// Java program to test a weighted graph

public class WGTest	{
	public static void main(String [] args)	{
		WGraph wgraph = new WGraph();
		
		wgraph.addVertex("A");
		wgraph.addVertex("B");
		wgraph.addVertex("C");
		wgraph.addVertex("D");
		wgraph.addVertex("E");
		wgraph.addVertex("F");
		wgraph.addVertex("G");
		wgraph.addVertex("H");
		wgraph.addVertex("I");

		wgraph.addEdge("A", "B", 4);
		wgraph.addEdge("A", "H", 8);
		wgraph.addEdge("B", "C", 8);
		wgraph.addEdge("C", "D", 7);
		wgraph.addEdge("D", "E", 9);
		wgraph.addEdge("E", "F", 10);
		wgraph.addEdge("F", "G", 2);
		wgraph.addEdge("G", "H", 1);
		wgraph.addEdge("H", "I", 7);
		wgraph.addEdge("I", "C", 2);
		wgraph.addEdge("C", "F", 4);
		wgraph.addEdge("D", "F", 14);

		/* System.out.println(wgraph.hasEdge("A", "B"));
		System.out.println(wgraph.hasEdge("A", "C"));
		System.out.println(wgraph.hasEdge("A", "H"));
		System.out.println(wgraph.hasEdge("A", "G"));

		wgraph.printAdjList();

		System.out.println(wgraph.vertices + " " + wgraph.edges);

		wgraph.makeKruskalMST(); */

		wgraph.makePrimMST("A");
	}
}
