package ctci;

public class Cat implements Animal {
	
	public long order;
	public String name;
	
	public Cat(String name, long order)	{
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
