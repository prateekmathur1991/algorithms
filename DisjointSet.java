// Prateek Mathur

// A Disjoint-Set Data Structure Implementation in Java

// Disjoint Sets need to support 3 operations
// 1. MakeSet()
// 2. FindSet()
// 3. Union()

import java.util.*;

public class DisjointSet<T>	{
	Map<T, LinkedHashSet<T>> allSets;

	DisjointSet()	{
		allSets = new HashMap<T, LinkedHashSet<T>>();
	}

	public void makeSet(T t)	{
		if (allSets.containsKey(t))	{
			return;
		}

		LinkedHashSet<T> set = new LinkedHashSet<T>();
		set.add(t);

		allSets.put(t, set);
	}

	public T findSet(T t)	{		
		if (!allSets.containsKey(t))	{
			return null;
		}

		return allSets.get(t).iterator().next();
	}

	public void union(T t1, T t2)	{
		if (!allSets.containsKey(t1) || !allSets.containsKey(t2))	{
			return;
		}

		LinkedHashSet<T> set1 = allSets.get(t1);
		LinkedHashSet<T> set2 = allSets.get(t2);

		set1.addAll(set2);
		set2.clear();

		allSets.put(t1, set1);
		allSets.remove(t2);
	}

	public void viewAllSets()	{
		Iterator itr = allSets.entrySet().iterator();
		
		while (itr.hasNext())	{
			Map.Entry entry = (Map.Entry) itr.next();
			LinkedHashSet set = (LinkedHashSet) entry.getValue();

			System.out.println(Arrays.toString(set.toArray()));
		}
	}
}
