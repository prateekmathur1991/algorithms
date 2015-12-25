// Prateek Mathur

// Java program to test a weighted graph

public class WGTest	{
	public static void main(String [] args)	{
		WGraph wgraph = new WGraph();
		
		wgraph.addVertex("A");
		wgraph.addVertex("B");
		wgraph.addVertex("C");
		wgraph.addVertex("D");

		wgraph.addEdge("A", "B", 2);
		wgraph.addEdge("A", "C", 4);
		wgraph.addEdge("E", "G", 3);
		wgraph.addEdge("A", "G", 4);

		System.out.println(wgraph.hasEdge("A", "B"));
		System.out.println(wgraph.hasEdge("A", "C"));
		System.out.println(wgraph.hasEdge("A", "H"));
		System.out.println(wgraph.hasEdge("A", "G"));

		wgraph.printAdjList();

		System.out.println(wgraph.vertices + " " + wgraph.edges);
	}
}
