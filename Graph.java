// Prateek Mathur

// An undirected graph implementation using Adjacency List representation
// TODO
// Following methods need to be added-
// hasEdge()
// printAdjList()
// printBFS()
// printDFS()
// topoligialSort()

import java.util.*;

public class Graph	{
	// Inner class to represent a Vertex
	class Vertex	{
		public String name;

		Vertex(String name)	{
			this.name = name;
		}
	}

	Map<Vertex, HashSet<Vertex>> adjList;
	Map<String, Vertex> allVertices;
	int vertices;
	int edges;
	
	Graph()	{
		adjList = new HashMap<Vertex, HashSet<Vertex>>();
		allVertices = new HashMap<String, Vertex>();
		vertices = 0;
		edges = 0;
	}
	
	public void addVertex(String name)	{
		Vertex v;
		if ((v = allVertices.get(name)) == null) {
			v = new Vertex(name);
			allVertices.put(name, v);
			adjList.put(v, new HashSet<Vertex>());
		}
	}

	public boolean hasVertex(String name)	{
		return allVertices.containsKey(name);
	}

	public void addEdge(String from, String to)	{
		Vertex vf = null, vt = null;

		if (!allVertices.containsKey(from))	{
			vf = new Vertex(from);
			allVertices.put(from, vf);
			adjList.put(vf, new HashSet<Vertex>());
		} else {
			vf = allVertices.get(from);
		}
	
		if (!allVertices.containsKey(to))	{	
			vt = new Vertex(to);
			allVertices.put(to, vt);
			adjList.put(vt, new HashSet<Vertex>());
		} else {
			vt = allVertices.get(to);
		}

		
		adjList.get(vf).add(vt);
		adjList.get(vt).add(vf);
	}
}
