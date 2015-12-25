// Prateek Mathur

// An undirected weighted graph implementation using Adjacency List representation

import java.util.*;

public class WGraph	{
	// Inner class to represent a Vertex
	class Vertex	{
		public String name;

		Vertex(String name)	{
			this.name = name;
		}

		@Override
		public String toString()	{
			return this.name;
		}
	}

	Map<Vertex, TreeMap<Integer, Vertex>> adjList;
	Map<String, Vertex> allVertices;
	int vertices;
	int edges;
	
	WGraph()	{
		adjList = new HashMap<Vertex, TreeMap<Integer, Vertex>>();
		allVertices = new HashMap<String, Vertex>();
		vertices = 0;
		edges = 0;
	}
	
	public void addVertex(String name)	{
		Vertex v;
		if ((v = allVertices.get(name)) == null) {
			v = new Vertex(name);
			allVertices.put(name, v);
			adjList.put(v, new TreeMap<Integer, Vertex>());
			vertices++;
		}
	}

	public boolean hasVertex(String name)	{
		return allVertices.containsKey(name);
	}

	public void addEdge(String from, String to, int weight)	{
		if (hasEdge(from, to)) {
			return;
		}

		Vertex vf = null, vt = null;

		if (!allVertices.containsKey(from))	{
			vf = new Vertex(from);
			allVertices.put(from, vf);
			adjList.put(vf, new TreeMap<Integer, Vertex>());
			vertices++;
		} else {
			vf = allVertices.get(from);
		}
	
		if (!allVertices.containsKey(to))	{
			vt = new Vertex(to);
			allVertices.put(to, vt);
			adjList.put(vt, new TreeMap<Integer, Vertex>());
			vertices++;
		} else {
			vt = allVertices.get(to);
		}

		adjList.get(vf).put(weight, vt);
		adjList.get(vt).put(weight, vf);
		edges++;
	}

	public boolean hasEdge(String from, String to)	{
		if (!allVertices.containsKey(from) || !allVertices.containsKey(to))	{
			return false;
		}

		return adjList.get(allVertices.get(from)).containsValue(allVertices.get(to));
	}

	public void printAdjList()	{
		System.out.println(this.adjList);
		if (allVertices.size() == 0)	{
			System.err.println("NO VERTICES");
			return;
		}

		Iterator itr = allVertices.entrySet().iterator();

		while (itr.hasNext())	{
			Map.Entry pair = (Map.Entry) itr.next();
			System.out.print(pair.getKey() + "-->");

			TreeMap<Integer, Vertex> list = adjList.get(pair.getValue());
			if (list.size() == 0)	{
				System.out.println("END");
				continue;
			}
			Iterator itr1 = list.entrySet().iterator();
			while (itr1.hasNext())	{
				Map.Entry pair1 = (Map.Entry) itr1.next();
				Vertex v = (Vertex) pair1.getValue();
				System.out.print(v.name + "(" + pair1.getKey() + ")" + "-->");
			}

			System.out.print("END");
			System.out.println();
		}	
	}
}
