package Lab6;

import Lab1.Utils;

public class UseWorkerThreadWithShutdown {
	
	public static void main(String[] args) {
		
		WorkerThreadWithShutdown worker = new WorkerThreadWithShutdown();
		worker.submit(new Task());
		worker.submit(new Task());
		Utils.pause(5000);
		worker.shutdown();
		worker.submit(new Task());
		
	}

}
