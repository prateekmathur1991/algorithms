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
	}

	Map<Vertex, HashMap<Vertex, Integer>> adjList;
	Map<String, Vertex> allVertices;
	int vertices;
	int edges;
	
	WGraph()	{
		adjList = new HashMap<Vertex, HashMap<Vertex, Integer>>();
		allVertices = new HashMap<String, Vertex>();
		vertices = 0;
		edges = 0;
	}
	
	public void addVertex(String name)	{
		Vertex v;
		if ((v = allVertices.get(name)) == null) {
			v = new Vertex(name);
			allVertices.put(name, v);
			adjList.put(v, new HashMap<Vertex, Integer>());
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
			adjList.put(vf, new HashMap<Vertex, Integer>());
			vertices++;
		} else {
			vf = allVertices.get(from);
		}
	
		if (!allVertices.containsKey(to))	{
			vt = new Vertex(to);
			allVertices.put(to, vt);
			adjList.put(vt, new HashMap<Vertex, Integer>());
			vertices++;
		} else {
			vt = allVertices.get(to);
		}

		adjList.get(vf).put(vt, weight);
		adjList.get(vt).put(vf, weight);
		edges++;
	}

	public boolean hasEdge(String from, String to)	{
		if (!allVertices.containsKey(from) || !allVertices.containsKey(to))	{
			return false;
		}

		return adjList.get(allVertices.get(from)).containsKey(allVertices.get(to));
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

			HashMap<Vertex, Integer> list = adjList.get(pair.getValue());
			if (list.size() == 0)	{
				System.out.println("END");
				continue;
			}
			Iterator itr1 = list.entrySet().iterator();
			while (itr1.hasNext())	{
				Map.Entry pair1 = (Map.Entry) itr1.next();
				Vertex v = (Vertex) pair1.getKey();
				System.out.print(v.name + "(" + pair1.getValue() + ")" + "-->");
			}

			System.out.print("END");
			System.out.println();
		}	
	}
}
