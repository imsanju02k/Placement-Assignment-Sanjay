package corejava.question05;



interface Shape {
	
	double calculateArea();
	double caluclatePerimeter();
}

class Circle implements Shape{
	
	
	private double radius;
	
	
	public Circle(double radius) {
		this.radius=radius;
	}

	@Override
	public double calculateArea() {
		return Math.PI*radius*radius;
	}

	@Override
	public double caluclatePerimeter() {
		return 2*Math.PI*radius;
	}
	
}

public class InterfaceClass {

	public static void main(String[] args) {
		Shape circle=new Circle(15);
		System.out.println("Circle Area : " + circle.calculateArea());
		System.out.println("Circle Perimeter : " + circle.caluclatePerimeter());
		
	}

}
