// Prateek Mathur

// An undirected weighted graph implementation using Adjacency List representation

import java.util.*;

public class WGraph	{
	// Inner class to represent a Vertex
	private class Vertex	{
		public String name;
		public Vertex parent;
		int key;

		Vertex(String name)	{
			this.name = name;
		}

		@Override
		public String toString()	{
			return this.name + " " + Integer.toString(key) + " " + this.parent;
		}

		public boolean equals(Vertex vertex)	{
			return this.name.equalsIgnoreCase(vertex.name);
		}
	}

	private class Edge implements Comparable<Edge>	{
		public String from;
		public String to;
		public int weight;

		Edge(String from, String to, int weight)	{
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge edge)	{
			return this.weight == edge.weight ? 0 : (this.weight < edge.weight ? -1 : 1);
		}

		@Override
		public String toString()	{
			StringBuilder builder = new StringBuilder();
			
			builder.append(this.from).append(" ---> ").append(this.to).append("(").append(Integer.toString(this.weight)).append(")");
			return builder.toString();
		}

		public boolean equals(Edge edge)	{
			return this.weight == edge.weight;
		}		
	}	

	Map<Vertex, HashMap<Vertex, Integer>> adjList;
	Map<String, Vertex> allVertices;
	List<Edge> allEdges;
	int vertices;
	int edges;
	
	WGraph()	{
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
	
		/* Edge edge1 = new Edge(from, to, weight);
		Edge edge2 = new Edge(to, from, weight); */

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

	public void makeKruskalMST()	{
		ArrayList<Edge> mstForest = new ArrayList<Edge>();
		
		DisjointSet<Vertex> dsets = new DisjointSet<Vertex>();
		
		Iterator itr = allVertices.entrySet().iterator();
		while (itr.hasNext())	{
			Map.Entry entry = (Map.Entry) itr.next();
			dsets.makeSet((Vertex) entry.getValue());
		}

		Collections.sort(this.allEdges);

		// System.out.println(allEdges);
		// dsets.viewAllSets();
		
		for (Edge edge : allEdges)	{
			// System.out.println("Current Edge:: " + edge);
			// System.out.println("MST Forest currently:: " + mstForest);
			// System.out.print("Set of vertices currently:: ");
			// dsets.viewAllSets();

			Vertex u = allVertices.get(edge.from);
			Vertex v = allVertices.get(edge.to);
			if (dsets.findSet(u) != dsets.findSet(v))	{
				// System.out.println("Different sets. Adding to MST Forest");
				mstForest.add(edge);
				// System.out.println("Performing union");
				dsets.union(u, v);	
			}

			// System.out.println();
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

		Iterator itr = allVertices.entrySet().iterator();
		while (itr.hasNext())	{
			Map.Entry entry = (Map.Entry) itr.next();
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
			u = (Vertex) queue.poll();
			System.out.println("Curret Vertex:: " + u);
			HashMap<Vertex, Integer> list = adjList.get(u);

			System.out.println("Processing Adjacency List of " + u);
			for (Map.Entry entry : list.entrySet())	{
				Vertex v = (Vertex) entry.getKey();
				Integer w = (Integer) entry.getValue();
				System.out.println("Current Neibhour:: " + v + " Weight:: " + w.toString());		
	
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
}
