package com.ds.core;

//This data structure uses multiple stacks to hold 
//data into. Whenever the current stack gets full, it
//creates and allocates a new stack and saves data in it.

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

import com.ds.core.LinkedStack;

public class SetOfStacks<T>	{
	List<LinkedStack<T>> stacks;
	public int capacity;	// The capacity of each individual stack, after which a new stack is created
	
	{
		stacks = new ArrayList<LinkedStack<T>>();
	}
	
	public SetOfStacks()	{
		capacity = 10;
	}
	
	public SetOfStacks(int capacity)	{
		this.capacity = capacity;
	}
	
	public LinkedStack<T> getLastStack() {
		if (stacks.size() == 0) {
			return null;
		}
		return stacks.get(stacks.size() - 1);
	}
	
	public void push(T t)	{
		LinkedStack<T> last = getLastStack();
		if (null != last && !last.isFull())	{
			last.push(t);
		} else {
			LinkedStack<T> stack = new LinkedStack<T>(capacity);
			stack.push(t);
			stacks.add(stack);
		}
	}
	
	public T pop() throws EmptyStackException	{
		LinkedStack<T> last = getLastStack();
		if (null == last)	{
			throw new EmptyStackException();
		}
		
		T t = last.pop();
		if (last.isEmpty())	{
			stacks.remove(stacks.size() - 1);
		}
		
		return t;
	}
	
	public T peek() throws EmptyStackException	{
		LinkedStack<T> last = getLastStack();
		if (null == last)	{
			throw new EmptyStackException();
		}
		
		return last.peek();
	}
	
	public int noOfStacks()	{
		return stacks.size();
	}
}
