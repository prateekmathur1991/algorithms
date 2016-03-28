package core;
// Prateek Mathur

// A directed graph implementation using Adjacency List representation

import java.util.*;
import java.util.Map.Entry;

public class DGraph	{
	// Inner class to represent a Vertex
	class Vertex	{
		public String name;
		
		// Required for BFS and DFS
		public String color;
		public int distance;
		public Vertex parent;

		// Required for DFS
		public int discoveryTime;
		public int finishTime;
		public boolean visited = false;

		Vertex(String name)	{
			this.name = name;
		}

		@Override
		public String toString() {
			return this.name;
		}
	}

	Map<Vertex, HashSet<Vertex>> adjList;
	Map<String, Vertex> allVertices;
	int vertices;
	int edges;

	// Global variable for depth-first search
	private int time;

	// LinkedList of Vertices, for topological sort
	java.util.LinkedList<Vertex> verticesList;
	
	DGraph()	{
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
		edges++;
	}

	public boolean hasEdge(String from, String to)	{
		if (!allVertices.containsKey(from) || !allVertices.containsKey(to))	{
			return false;
		}

		return adjList.get(allVertices.get(from)).contains(allVertices.get(to));
	}

	public void printAdjList()	{
		if (allVertices.size() == 0)	{
			System.err.println("NO VERTICES");
			return;
		}

		Iterator<Entry<String, Vertex>> itr = allVertices.entrySet().iterator();

		while (itr.hasNext())	{
			Entry<String, Vertex> pair = itr.next();
			System.out.print(pair.getKey() + "-->");
			
			HashSet<Vertex> list = adjList.get(pair.getValue());
			if (list.size() == 0)	{
				System.out.println("END");
				continue;
			}	

			Iterator<Vertex> itr1 = list.iterator();
			while (itr1.hasNext())	{
				Vertex v = itr1.next();
				System.out.print(v.name + "-->");
			}
			System.out.print("END");
			System.out.println();
		}	
	}

	public void printBFS(String r)	{
		if (!hasVertex(r))	{
			System.err.println("ROOT NOT PRESENT IN TREE");
			return;
		}
		
		java.util.LinkedList<Vertex> queue = new java.util.LinkedList<Vertex>();
		Vertex root = null, u= null;
		
		Iterator<Entry<String, Vertex>> itr = allVertices.entrySet().iterator();
		while (itr.hasNext())	{
			Entry<String, Vertex> entry = itr.next();
			if (entry.getKey().equals(r)) {
				root = entry.getValue();
				continue;
			}

			u = entry.getValue();
			u.color = "w";
			u.distance = Integer.MAX_VALUE;
			u.parent = null;
		}

		root.color = "g";
		root.distance = 0;
		root.parent = null;

		queue.add(root);

		while (queue.size() != 0)	{
			System.out.println("Queue right now:: " + Arrays.toString(queue.toArray(new Vertex[0])));
			u = queue.poll();
			HashSet<Vertex> list = adjList.get(u);

			System.out.println("Getting and coloring Neighbours");
			Iterator<Vertex> itr1 = list.iterator();
			while (itr1.hasNext())	{
				Vertex v = itr1.next();
				if ("w".equals(v.color))	{
					System.out.println("Got white neighbour " + v.name);
					v.color = "g";
					v.distance = u.distance + 1;
					v.parent = u;
					System.out.println("Processed neighbour. Name:: " + v.name + " Distance:: " + v.distance + " Parent:: " + u.name);
					queue.add(v);
				}
			}

			u.color = "b";
			System.out.println();
		}	
	}

	public void printShortestPath(String source, String vertex)	{
		if (!hasVertex(source) || !hasVertex(vertex))	{
			System.err.println("Source or vertex not present in graph");
			return;
		}

		this.printBFS(source);

		Vertex v = allVertices.get(vertex);
		
		if (source.equals(vertex))	{
			System.out.print(source + " ");
		} else if (v.parent == null)	{
			System.err.println("No path from source to vertex");
		} else {
			printShortestPath(source, v.parent.name);
			System.out.print(v.name + " ");
		}
	}
	
	public void printDFS()	{
		DFS(false);
	}

	private void DFS(boolean topo)	{
		if (topo) {
			verticesList = new java.util.LinkedList<Vertex>();
		}

		Iterator<Entry<String, Vertex>> itr = allVertices.entrySet().iterator();
		while (itr.hasNext())	{
			Entry<String, Vertex> entry = itr.next();
			Vertex u = (Vertex) entry.getValue();
			u.color = "w";
			u.parent = null;
			u.discoveryTime = 0;
			u.finishTime = 0;
		}

		this.time = 0;
		
		itr = allVertices.entrySet().iterator();
		while (itr.hasNext())	{
			Entry<String, Vertex> entry = itr.next();
			Vertex u = (Vertex) entry.getValue();
			System.out.println("About to visit:: " + u.name);
			dfsVisit(u, topo);
		}
	}

	private void dfsVisit(Vertex u, boolean topo)	{
		time++;
		u.discoveryTime = time;
		u.color = "g";

		HashSet<Vertex> list = adjList.get(u);
		Iterator<Vertex> itr = list.iterator();
		System.out.println("Visiting adjacency list for " + u.name);

		while (itr.hasNext())	{
			Vertex v = itr.next();
			if (v.color.equals("w"))	{
				System.out.println("White node found. About to visit recursively " + v.name);
				v.parent = u;
				dfsVisit(v, topo);
			}
		}

		u.color = "b";
		time++;
		u.finishTime = time;

		System.out.println("Visit complete for " + u.name + " First Visit Time:: " + u.discoveryTime + " Last Visit Time:: " + u.finishTime);
	
		if (topo) {
			verticesList.addFirst(u);
		}
	}

	public void topologicalSort()	{
		DFS(true);
		System.out.println(Arrays.toString(verticesList.toArray(new Vertex[0])));
	}
	
	// This method is a simplified version of DFS, and I
		// find it easier to implement and use
		public void dfs(String root)	{	
			if (hasVertex(root)) {
				throw new RuntimeException("Root not present in graph");
			}
			
			Vertex v = allVertices.get(root);
			search(v);
		}
		
		private void search(Vertex root)	{
			if (null == root)	{
				return;
			}
			
			System.out.print(root + " ");
			root.visited = true;
			
			HashSet<Vertex> list = adjList.get(root);
			Iterator<Vertex> itr = list.iterator();
			
			while (itr.hasNext())	{
				Vertex v = itr.next();
				if (v.visited == false)	{
					search(v);
				}
			}
				
		}
}
