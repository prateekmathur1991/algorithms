// Prateek Mathur

// An undirected graph implementation using Adjacency List representation
// TODO
// Following methods need to be added-
// printBFS()
// printDFS()
// topoligialSort()

import java.util.*;

public class Graph	{
	// Inner class to represent a Vertex
	class Vertex	{
		public String name;
		
		// Required for BFS and DFS
		public String color;
		public int distance;
		public Vertex parent;

		Vertex(String name)	{
			this.name = name;
			/* this.color = "w";
			this.distance = 0;
			this.parent = null; */
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
			vertices++;
		}
	}

	public boolean hasVertex(String name)	{
		return allVertices.containsKey(name);
	}

	public void addEdge(String from, String to)	{
		if (hasEdge(from, to)) {
			return;
		}

		Vertex vf = null, vt = null;

		if (!allVertices.containsKey(from))	{
			vf = new Vertex(from);
			allVertices.put(from, vf);
			adjList.put(vf, new HashSet<Vertex>());
			vertices++;
		} else {
			vf = allVertices.get(from);
		}
	
		if (!allVertices.containsKey(to))	{	
			vt = new Vertex(to);
			allVertices.put(to, vt);
			adjList.put(vt, new HashSet<Vertex>());
			vertices++;
		} else {
			vt = allVertices.get(to);
		}

		
		adjList.get(vf).add(vt);
		adjList.get(vt).add(vf);
		edges++;
	}

	public boolean hasEdge(String from, String to)	{
		if (!allVertices.containsKey(from) || !allVertices.containsKey(to))	{
			return false;
		}

		Vertex vf = allVertices.get(from);
		Vertex vt = allVertices.get(to);

		return adjList.get(allVertices.get(from)).contains(allVertices.get(to));
	}

	public void printAdjList()	{
		if (allVertices.size() == 0)	{
			System.err.println("NO VERTICES");
			return;
		}

		Iterator itr = allVertices.entrySet().iterator();

		while (itr.hasNext())	{
			Map.Entry pair = (Map.Entry) itr.next();
			System.out.print(pair.getKey() + "-->");
			
			HashSet<Vertex> list = adjList.get(pair.getValue());
			if (list.size() == 0)	{
				System.out.println("END");
				continue;
			}	

			Iterator itr1 = list.iterator();
			while (itr1.hasNext())	{
				Vertex v = (Vertex) itr1.next();
				System.out.print(v.name + "-->");
			}
			System.out.print("END");
			System.out.println();
		}	
	}

	public void printBFS(String r)	{
		List<Vertex> queue = new LinkedList<Vertex>();
		Vertex root = null;
		
		Iterator itr = allVertices.entrySet().iterator();
		while (itr.hasNext())	{
			Map.Entry entry = (Map.Entry) itr.next();
			if (entry.getKey().equals(r)) {
				root = entry.getValue();
				continue;
			}

			Vertex u = entry.getValue();
			u.color = "w";
			u.distance = Integer.MAX_VALUE;
			u.parent = null;
		}

		root.color = "g";
		root.distance = 0;
		root.parent = null;

		while (queue.size() != 0)	{
			u = queue.getFirst();
		}	
	}
}
