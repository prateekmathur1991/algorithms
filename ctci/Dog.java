package ctci;

public class Dog implements Animal {
	
	public long order;
	public String name;
	
	public Dog(String name, long order)	{
		this.name = name;
		this.order = order;
	}
	
	@Override
	public long getOrder() {
		return this.order;
	}

	@Override
	public boolean isOlderThan(Animal animal) {
		return this.getOrder() < animal.getOrder();
	}

}
