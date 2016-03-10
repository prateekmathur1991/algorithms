package ctci;

public class LinkedQueueTest	{
	public static void main(String [] args)	{
		LinkedQueue<Integer> queue = new LinkedQueue<>();
		queue.add(10);
		queue.add(15);
		queue.add(45);
		queue.add(67);
		queue.add(758);
		queue.add(79);
		queue.add(243);
		queue.add(-824);
		queue.add(011);
		queue.add(011);
		
		// System.out.println(queue.size());
		
		// System.out.println(queue.isEmpty());
		// System.out.println(queue.isFull());
		
		while (!queue.isEmpty())	{
			System.out.println(queue.remove());
		}
			
		// System.out.println(queue.remove());
	}
	
}
