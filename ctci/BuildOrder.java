// Our approach uses a topological sort of the project graph

// We uses a State enum inside the Project to keep track of the DFS visit of a Project.
// If the DFS visit of a project indicates a state of PARTIAL, this simply means that 
// this project was visited earlier, and indicates a cycle in the graph.

package ctci;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class BuildOrder {

	public static void main(String[] args) {
		ProjectGraph projectGraph = new ProjectGraph();
		String[] projects = {"a", "b", "c", "d", "e", "f"};
		String[][] dependencies = {
				{"d", "a"},
				{"b", "f"},
				{"d", "b"},
				{"a", "f"},
				{"c", "d"},
				};
		
		for (String project : projects) {
			projectGraph.addNode(project);
		}
		
		for (String[] dependency : dependencies) {
			String first = dependency[0];
			String second = dependency[1];
			projectGraph.addEdge(first, second);
		}
		
		Stack<Project> buildOrder = orderProjects(projectGraph.getNodes());
		System.out.println(Arrays.toString(getBuildOrderArray(buildOrder)));
	}
	
	public static Stack<Project> orderProjects(List<Project> projects) {
		Stack<Project> stack = new Stack<Project>();
		for (Project project : projects) {
			if (project.getState() == Project.State.BLANK) {
				if (!doDFS(project, stack)) {
					return null;
				}
			}
		}
		
		return stack;
	}
	
	public static boolean doDFS(Project project, Stack<Project> stack) {
		if (project.getState() == Project.State.PARTIAL) {
			// This is by far the simplest way to detect cycles in a graph
			return false;
		}
		
		if (project.getState() == Project.State.BLANK) {
			project.setState(Project.State.PARTIAL);
			List<ctci.Project> children = project.getAdjList();
			for (Project child : children) {
				if (!doDFS(child, stack)) {
					return false;
				}
			}
			
			project.setState(Project.State.COMPLETE);
			stack.push(project);
		}
		return true;
	}
	
	public static String[] getBuildOrderArray(Stack<Project> projects)	{
		String[] buildOrder = new String[projects.size()];
		for (int i = 0; i < buildOrder.length; i++) {
			buildOrder[i] = projects.pop().getName();
		}
		return buildOrder;

	}

}
