// A Graph with vertices of type Project

// Need a Graph separately for this problem as my DGraph does
// not support vertices of type Project. Had I coded it usng generics, I wouldn't
// have wasted time in coding this ProjectGraph. :(

package ctci;

import java.util.*;

public class ProjectGraph	{
	private List<Project> nodes = new ArrayList<Project>();
	private Map<String, Project> map = new HashMap<String, Project>();
	
	public Project addNode(String name)	{
		if (!map.containsKey(name))	{
			Project project = new Project(name);
			nodes.add(project);
			map.put(name, project);
		}
 
		return map.get(name);
	}

	public void addEdge(String from, String to)	{
		Project start = addNode(from);
		Project end = addNode(to);

		start.addToAdjList(end);
	}

	public List<Project> getNodes()	{
		return nodes;
	}
}
