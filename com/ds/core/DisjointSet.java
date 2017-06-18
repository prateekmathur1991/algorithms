package com.ds.core;

// Disjoint Sets need to support 3 operations
// 1. MakeSet()
// 2. FindSet()
// 3. Union()

import java.util.*;

public class DisjointSet<T>	{
	Set<LinkedHashSet<T>> allSets;

	public DisjointSet()	{
		allSets = new HashSet<LinkedHashSet<T>>();
	}

	public void makeSet(T t)	{
		Iterator<LinkedHashSet<T>> itr = allSets.iterator();
		while (itr.hasNext())	{
			LinkedHashSet<T> set = itr.next();
			if (set.contains(t))	{
				return;
			}
		}

		LinkedHashSet<T> set = new LinkedHashSet<T>();
		set.add(t);

		allSets.add(set);
	}

	public T findSet(T t)	{		
		Iterator<LinkedHashSet<T>> itr = allSets.iterator();
		while (itr.hasNext())	{
			LinkedHashSet<T> set = itr.next();
			if (set.contains(t))	{
				return (T) set.iterator().next();
			}
		}

		return null;
	}

	public void union(T t1, T t2)	{
		LinkedHashSet<T> set1 = null, set2 = null;
		
		Iterator<LinkedHashSet<T>> itr = allSets.iterator();
		while (itr.hasNext())	{
			LinkedHashSet<T> set = itr.next();
			if (set.contains(t1))	{
				set1 = (LinkedHashSet<T>) set;
			} else if (set.contains(t2))	{
				set2 = (LinkedHashSet<T>) set;
			}
		}

		if (null != set1)	{
			LinkedHashSet<T> set = new LinkedHashSet<T>(set1);
			set.addAll(set2);

			allSets.add(set);

			allSets.remove(set1);
			if (null != set2)	{
				allSets.remove(set2);
			}
		}
	}

	public void viewAllSets()	{
		System.out.println(this.allSets);
	}
}
