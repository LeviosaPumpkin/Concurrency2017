package Lab5;

import Lab1.Utils;

public class UseWorkerThread {
	
	public static void main(String[] args) {
		WorkerThread worker = new WorkerThread();
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
		
		worker.submit(() -> {
			System.out.println("start" + Thread.currentThread());
			Utils.pause(1000);
			System.out.println("end");
		});
	}

}
