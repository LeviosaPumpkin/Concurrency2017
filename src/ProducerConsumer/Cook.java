package ProducerConsumer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

import Lab1.Utils;

class Cook implements Runnable{
	
	private int numOfDish;
	
	private BlockingQueue<String> window;

	public Cook(BlockingQueue<String> window){
		this.window=window;		
		numOfDish=0;
	}
	@Override
	public void run() {
		while(true){
			System.out.println("start cook "+numOfDish);
			Utils.pause(2000+SuncQueueEx.random.nextInt(3000));
			System.out.println("ready "+numOfDish);
			try {
				window.put("dish "+numOfDish);
				++numOfDish;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
}