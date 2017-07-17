package Lab6;

import Lab1.Utils;

public class UseWorkerThreadWithShutdown {
	
	public static void main(String[] args) {
		WorkerThreadWithShutdown worker = new WorkerThreadWithShutdown();
		worker.submit(() -> {
			System.out.println("start" + Thread.currentThread());
			Utils.pause(1000);
			System.out.println("end");
		});
		
		worker.submit(() -> {
			System.out.println("start" + Thread.currentThread());
			Utils.pause(1000);
			System.out.println("end");
		});
		Utils.pause(5000);
		worker.shutdown();
		worker.submit(() -> {
			System.out.println("start" + Thread.currentThread());
			Utils.pause(1000);
			System.out.println("end");
		});
		
	}

}
