// Prateek Mathur

// Java program to test disjoint sets

public class DisjointTest	{	
	public static void main(String [] args)	{
		DisjointSet<Integer> dsets = new DisjointSet<Integer>();
		
		dsets.makeSet(30);
		dsets.makeSet(30);
		dsets.makeSet(600);
		dsets.makeSet(20);
		dsets.makeSet(25);

		dsets.viewAllSets();

		dsets.union(20, 25);

		dsets.viewAllSets();

		/* System.out.println(dsets.findSet(25));
		System.out.println(dsets.findSet(50));
		System.out.println(dsets.findSet(90)); */
	}	
}
