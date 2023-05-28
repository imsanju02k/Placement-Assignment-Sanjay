package corejava.quesion01;



/*1. Write a Java program that uses POLYMORPHISM by defining an interface called Shape
with methods to calculate the area and PERIMETER of a shape. Then create classes
that implement the Shape interface for different types of shapes, such as CIRCLES and
TRIANGLES.*/

public class MainClass {

	public static void main(String[] args) {

       Shape circle=new Circle(5);
       System.out.println("Circle Area: " + circle.calculateArea());
       System.out.println("Circle Perimeter: " + circle.caluclatePerimeter());

       Shape triangle = new Triangle(3, 4, 5);
       System.out.println("Triangle Area: " + triangle.calculateArea());
       System.out.println("Triangle Perimeter: " + triangle.caluclatePerimeter());
       

	}

}
