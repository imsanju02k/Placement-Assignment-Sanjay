package corejava.question08;

class EvenThread extends Thread{
	
	public void run() {
		for(int i=2;i<=10;i+=2) {
			System.out.println("Even Thread : " +i);
		}
	}
}

class OddThread extends Thread{
	public void run() {
		for(int i=1;i<=9;i+=2) {
			System.out.println("Odd thread : "+i);
		}
	}
}

public class Threads {
	
	public static void main(String[] args) {
		
		Thread evenThread=new EvenThread();
		Thread oddThread=new OddThread();
         
		evenThread.start();
		oddThread.start();
	}
	
	
	
}


