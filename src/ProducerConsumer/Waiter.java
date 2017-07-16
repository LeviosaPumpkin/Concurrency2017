package ProducerConsumer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

import Lab1.Utils;

class Waiter implements Runnable{
	private BlockingQueue<String> window;
	
	public Waiter(BlockingQueue<String> window){
		this.window=window;
	}
	
	@Override
	public void run() {
		while(true){
			try {
				String dish = window.take();
			} catch (Exception e) {
				// TODO: handle exception
			}
			System.out.println("serving");
			Utils.pause(2000+SuncQueueEx.random.nextInt(3000));

		}
	}
	
}