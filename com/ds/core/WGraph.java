package com.ds.core;

// An undirected weighted graph implementation using Adjacency List representation

import java.util.*;
import java.util.Map.Entry;

public class WGraph	{
	// Inner class to represent a Vertex
	private class Vertex	{
		public String name;
		public Vertex parent;
		int key;
		
		// Required for DFS
		public boolean visited = false;

		Vertex(String name)	{
			this.name = name;
		}

		@Override
		public String toString()	{
			return this.name + " " + Integer.toString(key) + " " + this.parent;
		}
	}

	// Inner class to represent an Edge
	private class Edge implements Comparable<Edge>	{
		public String from;
		public String to;
		public int weight;

		Edge(String from, String to, int weight)	{
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		public int compareTo(Edge edge)	{
			return this.weight == edge.weight ? 0 : (this.weight < edge.weight ? -1 : 1);
		}

		@Override
		public String toString()	{
			StringBuilder builder = new StringBuilder();
			
			builder.append(this.from).append(" ---> ").append(this.to).append("(").append(Integer.toString(this.weight)).append(")");
			return builder.toString();
		}		
	}	

	Map<Vertex, HashMap<Vertex, Integer>> adjList;
	Map<String, Vertex> allVertices;
	List<Edge> allEdges;
	int vertices;
	int edges;
	
	public WGraph()	{
		adjList = new HashMap<Vertex, HashMap<Vertex, Integer>>();
		allVertices = new HashMap<String, Vertex>();
		allEdges = new ArrayList<Edge>();
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
			adjList.put(vt, new HashMap<Vertex, Integer>());
			vertices++;
		} else {
			vt = allVertices.get(to);
		}

		adjList.get(vf).put(vt, weight);
		adjList.get(vt).put(vf, weight);
	
		allEdges.add(new Edge(from, to, weight));
		allEdges.add(new Edge(to, from, weight));
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

		Iterator<Entry<String, Vertex>> itr = allVertices.entrySet().iterator();

		while (itr.hasNext())	{
			Entry<String, Vertex> pair = itr.next();
			System.out.print(pair.getKey() + "-->");

			HashMap<Vertex, Integer> list = adjList.get(pair.getValue());
			if (list.size() == 0)	{
				System.out.println("END");
				continue;
			}

			Iterator<Entry<Vertex, Integer>> itr1 = list.entrySet().iterator();
			while (itr1.hasNext())	{
				Map.Entry<Vertex, Integer> pair1 = itr1.next();
				Vertex v = pair1.getKey();
				System.out.print(v.name + "(" + pair1.getValue() + ")" + "-->");
			}

			System.out.print("END");
			System.out.println();
		}	
	}

	public void makeKruskalMST()	{
		ArrayList<Edge> mstForest = new ArrayList<Edge>();
		
		DisjointSet<Vertex> dsets = new DisjointSet<Vertex>();
		
		Iterator<Map.Entry<String, Vertex>> itr = allVertices.entrySet().iterator();
		while (itr.hasNext())	{
			Map.Entry<String, Vertex> entry = itr.next();
			dsets.makeSet(entry.getValue());
		}

		Collections.sort(this.allEdges);

		for (Edge edge : allEdges)	{
			Vertex u = allVertices.get(edge.from);
			Vertex v = allVertices.get(edge.to);
			if (dsets.findSet(u) != dsets.findSet(v))	{
				mstForest.add(edge);
				dsets.union(u, v);	
			}
		}

		System.out.println(mstForest);
	}

	public void makePrimMST(String root)	{
		if (!allVertices.containsKey(root))	{
			System.err.println("ROOT NOT PRESENT");
			return;
		}

		PriorityQueue<Vertex> queue = new PriorityQueue<Vertex>(allVertices.size(), new Comparator<Vertex>()	{
			public int compare(Vertex v1, Vertex v2)	{
				return v1.key == v2.key ? 0 : (v1.key < v2.key ? -1 : 1);
			}
		});

		ArrayList<Edge> primTree = new ArrayList<Edge>();
	
		Vertex r = null, u = null;

		Iterator<Entry<String, Vertex>> itr = allVertices.entrySet().iterator();
		while (itr.hasNext())	{
			Entry<String, Vertex> entry = itr.next();
			if (entry.getKey().equals(root))	{	
				r = (Vertex) entry.getValue();
				continue;
			}
			
			u = (Vertex) entry.getValue();
			u.key = Integer.MAX_VALUE;
			u.parent = null;
		}

		r.key = 0;	

		// Re-iterate to poplute the queue
		for (Vertex vertex : allVertices.values())	{
			queue.offer(vertex);
		}

		while (queue.size() != 0)	{	
			System.out.println("Queue Right Now:: " + queue);

			u = queue.poll();
			System.out.println("Curret Vertex:: " + u);
			HashMap<Vertex, Integer> list = adjList.get(u);

			System.out.println("Processing Adjacency List of " + u);
			for (Map.Entry<Vertex, Integer> entry : list.entrySet())	{
				Vertex v = (Vertex) entry.getKey();
				Integer w = (Integer) entry.getValue();
				System.out.println("Current Neibhour:: " + v);
				System.out.println("Key:: " + v.key + " Edge Weight:: " + w.toString());		
	
				if (queue.contains(v) && w.intValue() < v.key)	{
					System.out.println("Conditions true. Adding to primTree");
					v.parent = u;
					v.key = w;
					primTree.add(new Edge(u.name, v.name, w.intValue()));
				}
			}

			System.out.println();
		}

		System.out.println(primTree);
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
			
			HashMap<Vertex, Integer> list = adjList.get(root);
			Iterator<Map.Entry<Vertex, Integer>> itr = list.entrySet().iterator();
			
			while (itr.hasNext())	{
				Vertex v = itr.next().getKey();
				if (v.visited == false)	{
					search(v);
				}
			}
		}
}
