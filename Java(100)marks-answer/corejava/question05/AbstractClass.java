package corejava.question05;

abstract class Animal {
	protected String name;

	public Animal(String name) {
		this.name = name;
	}

	public abstract void sound();

	public void eat() {
		System.out.println(name + " is eating.");
	}
}

class Dog extends Animal{

	public Dog(String name) {
		super(name);
	}

	@Override
	public void sound() {
		System.out.println(name + " says: Woof!");
		
	}
	
}

public class AbstractClass {
	public static void main(String[] args) {
		Animal dog=new Dog("Tommy");
		dog.eat();
		dog.sound();

	}

}
