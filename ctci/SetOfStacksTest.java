package ctci;

public class SetOfStacksTest {

	public static void main(String[] args) {
		SetOfStacks<Integer> set = new SetOfStacks<Integer>(5);
		
		set.push(10);
		set.push(20);
		set.push(21);
		set.push(14);
		set.push(23);
		
		set.push(56);
		set.push(45);
		set.push(34);
		
		System.out.println(set.noOfStacks());
		
		// System.out.println(set.peek());
		System.out.println(set.pop());
		
		// System.out.println(set.peek());
		System.out.println(set.pop());
		
		System.out.println(set.pop());
		
		System.out.println(set.pop());
		
		System.out.println(set.noOfStacks());
	}

}
