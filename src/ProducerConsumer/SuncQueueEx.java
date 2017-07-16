package ProducerConsumer;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

import Lab1.Utils;

public class SuncQueueEx {
	
	static Random random = new Random();
	
	public static void main(String[] args) {
		
		LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<>();
		
		Cook cook = new Cook(queue);
		Waiter waiter=new Waiter(queue);
		
		ExecutorService service = Executors.newCachedThreadPool();
		
		service.execute(cook);
		service.execute(waiter);
	}

}
