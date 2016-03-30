// Required for Build Order Problem (CTCI 4.7)

package ctci;

import java.util.*;

public class Project	{
	public enum State {BLANK, PARTIAL, COMPLETE};
	private String name;
	private State state = State.BLANK;
	private List<Project> adjList = new ArrayList<Project>();
	private Map<String, Project> map = new HashMap<String, Project>();

	public Project(String name)	{
		this.name = name;
	}

	public void addToAdjList(Project project)	{
		if (!map.containsKey(project.getName()))	{
			adjList.add(project);
			map.put(project.getName(), project);
		}
	}

	public State getState()	{
		return this.state;
	}

	public void setState(State state)	{
		this.state = state;
	}

	public List<Project> getAdjList()	{
		return adjList;
	}

	public String getName()	{
		return name;
	}

	@Override
	public String toString()	{
		return this.name;
	}
}
