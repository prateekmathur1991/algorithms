package ctci;

public class AnimalShelter {
	private LinkedQueue<Dog> dogs = new LinkedQueue<>(100);
	private LinkedQueue<Cat> cats = new LinkedQueue<>(100);
	
	public void enqueue(Animal animal)	{
		if (animal instanceof Dog)	{
			Dog dog = (Dog) animal;
			dogs.add(dog);
			
		} else if (animal instanceof Cat)	{
			Cat cat = (Cat) animal;
			cats.add(cat);
		}
	}
	
	public Dog dequeueDog()	{
		if (!dogs.isEmpty())	{
			return dogs.remove();
		} else {
			return null;
		}
	}
	
	public Cat dequeueCat()	{
		if (!cats.isEmpty())	{
			return cats.remove();
		} else {
			return null;
		}
	}
	
	public Animal dequeueAny()	{
		if (dogs.size() == 0)	{
			Cat cat = (Cat) cats.remove();
			return cat;
		} else if (cats.size() == 0)	{
			Dog dog = (Dog) dogs.remove();
			return dog;
		}
		
		Cat cat = (Cat) cats.remove();
		Dog dog = (Dog) dogs.remove();
		
		if (cat.isOlderThan(dog))	{
			return cat;
		} else {
			return dog;
		}
	}
	
	public static void main(String[] args) {
		AnimalShelter shelter = new AnimalShelter();
		
		shelter.enqueue(new Dog("Blackey", System.currentTimeMillis()));
		shelter.enqueue(new Cat("Timmy", System.currentTimeMillis()));
		shelter.enqueue(new Cat("Shiny", System.currentTimeMillis()));
		// shelter.enqueue(new Dog("Tommy", System.currentTimeMillis()));
		shelter.enqueue(new Dog("Sunny", System.currentTimeMillis()));
		shelter.enqueue(new Cat("Catty", System.currentTimeMillis()));
		shelter.enqueue(new Cat("Laddy", System.currentTimeMillis()));
		shelter.enqueue(new Dog("Shady", System.currentTimeMillis()));
		
		System.out.println(shelter.dequeueDog().name);
		System.out.println(shelter.dequeueCat().name);
		
		Animal animal = shelter.dequeueAny();
		if (animal instanceof Cat)	{
			Cat cat = (Cat) animal;
			System.out.println("Got cat:: " + cat.name);
		} else if (animal instanceof Dog)	{
			Dog dog = (Dog) animal;
			System.out.println("Got dog:: " + dog.name);
		}
		
		shelter.enqueue(new Cat("NewCat", System.currentTimeMillis()));
		shelter.enqueue(new Dog("NewDog", System.currentTimeMillis()));
		
		animal = shelter.dequeueAny();
		if (animal instanceof Cat)	{
			Cat cat = (Cat) animal;
			System.out.println("Got cat:: " + cat.name);
		} else if (animal instanceof Dog)	{
			Dog dog = (Dog) animal;
			System.out.println("Got dog:: " + dog.name);
		}
	}
}
