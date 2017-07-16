package ProducerConsumer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

import Lab1.Utils;

class Cook implements Runnable{
	
	private BlockingQueue<String> window;

	public Cook(BlockingQueue<String> window){
		this.window=window;			
	}
	@Override
	public void run() {
		while(true){
			System.out.println("start cook");
			Utils.pause(1000+SuncQueueEx.random.nextInt(3000));
			System.out.println("ready");
			try {
				window.put("dish");
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
}