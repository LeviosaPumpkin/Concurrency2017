package ProducerConsumer;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SuncQueueEx {
	
	static Random random = new Random();
	
	public static void main(String[] args) {
		
		ArrayBlockingQueue<String> window = new ArrayBlockingQueue<String>(10);
		
		Cook cook = new Cook(window);
		Waiter waiter=new Waiter(window);
		
		ExecutorService service = Executors.newCachedThreadPool();
		
		service.execute(cook);
		service.execute(waiter);
	}

}
