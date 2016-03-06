// Prateek Mathur

// A Fixed Multi Stack, which uses a single array to implement 
// 3 stacks

package ctci;

public class MultiStack	{
	public int [] values;
	public int [] sizes;
	public int noOfStacks = 3;
	public int stackCapacity;

	public MultiStack(int stackCapacity)	{
		this.stackCapacity = stackCapacity;
		this.values = new int[stackCapacity * noOfStacks];
		this.sizes = new int[noOfStacks];
	}

	public void push(int stackNum, int element) throws Exception	{
		if (isFull(stackNum))	{
			throw new Exception("Stack " + stackNum + " is full");
		}
	
		sizes[stackNum]++;
		values[indexOfTop(stackNum)] = element;
	}
	
	public int pop(int stackNum) throws Exception	{
		if (isEmpty(stackNum))	{
			throw new Exception("Stack " + stackNum + " is empty");
		}

		int indexTop = indexOfTop(stackNum);
		int value = values[indexTop];
		values[indexTop] = 0;
		sizes[stackNum]--;
		
		return value;
	}

	public int peek(int stackNum) throws Exception	{
		if (isEmpty(stackNum))	{
			throw new Exception("Stack " + stackNum + " is empty");
		}
		
		int value = values[indexOfTop(stackNum)];
		
		return value;
	}

	public boolean isFull(int stackNum)	{
		return sizes[stackNum] == stackCapacity;
	}

	public boolean isEmpty(int stackNum)	{
		return sizes[stackNum] == 0;
	}

	public int indexOfTop(int stackNum)	{
		int offset = stackNum * stackCapacity;
		int size = sizes[stackNum];
		return offset + size - 1;
	}
}
