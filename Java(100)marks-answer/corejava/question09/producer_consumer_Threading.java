package corejava.question09;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

//using MULTITHREADING with Synchronization

class Producer implements Runnable{
	
	
	private Queue<Integer> queue;
	private int maxSize;
	private Random random;
	
	public Producer(Queue<Integer> queue, int maxSize) {
		this.queue = queue;
		this.maxSize = maxSize;
		this.random = new Random();
	}
	
	
	

	@Override
	public void run() {
		
		while (true) {
			synchronized (queue) {
			    while(queue.size()>=maxSize) {
			    	try {
						queue.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					
					}
			    }
			    int number=random.nextInt(100);
			    queue.add(number);
			    System.out.println("Produced : " +number);
			    queue.notifyAll();
			}
		}
	}
	
}



class Consumer implements Runnable{
	
	private Queue<Integer> queue;

	public Consumer(Queue<Integer> queue) {
		this.queue = queue;
	}



	@Override
	public void run() {
		while(true) {
			synchronized (queue) {
				while(queue.isEmpty()) {
					try {
						queue.wait();
					} catch (InterruptedException e) {
                             e.printStackTrace();
					}
				}
				int number=queue.peek();
				System.out.println("Consumer : " + number);
				queue.notifyAll();
			}
		}
		
	}
	
}

public class producer_consumer_Threading {
	
	public static void main(String[] args) {
		Queue<Integer> queue=new LinkedList<>();
		int maxSize=5;
		
		Producer producer=new Producer(queue, maxSize);
		Consumer consumer =new Consumer(queue);
		
		Thread producerThread=new Thread(producer);
		Thread consumerThread=new Thread(consumer);
		
		producerThread.start();
		consumerThread.start();
		
	}
	
	
	
}


