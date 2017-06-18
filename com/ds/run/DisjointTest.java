package com.ds.run;

import com.ds.core.DisjointSet;

public class DisjointTest {
	
	public static void main(String [] args)	{
		
		DisjointSet<Integer> dsets = new DisjointSet<Integer>();
		
		dsets.makeSet(30);
		dsets.makeSet(600);
		dsets.makeSet(20);
		dsets.makeSet(25);
		dsets.makeSet(90);
		dsets.makeSet(100);
		dsets.makeSet(1);

		dsets.viewAllSets();

		System.out.println(dsets.findSet(25));

		dsets.union(20, 25);
		dsets.viewAllSets();

		System.out.println();

		System.out.println(dsets.findSet(25));

		dsets.union(1, 100);
		dsets.viewAllSets();

		System.out.println();

		dsets.union(20, 100);
		dsets.viewAllSets();

		System.out.println(dsets.findSet(100));

		System.out.println();

		dsets.union(20, 90);
		dsets.viewAllSets();

		System.out.println();
	}	
}