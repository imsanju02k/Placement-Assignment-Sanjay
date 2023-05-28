package corejava.question02;




class parent{
	public parent() {
		System.out.println("IM A PARENT CLASS CONSTRUCTOR...");
	}
	
}
class child extends parent{
	public child() {
		//super();//explicitly invoke the parent class constructor
		System.out.println("IM A CHILD CLASS CONSTRUCTOR...");
	}
}


public class ConstructorProgram {

	public static void main(String[] args) {
		
		child cld=new child();
        System.out.println("child class invoked SUCCESSFULLY....");
		

	}

}
