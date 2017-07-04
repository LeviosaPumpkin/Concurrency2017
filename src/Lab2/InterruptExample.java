package Lab2;

import Lab1.Utils;

public class InterruptExample {
	
	static class Task implements Runnable{
		@Override
		public void run() {
			long count = 0;
			while (true) {
				count++;
				if (Thread.interrupted()) {
					System.out.println(count);
					
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Thread thread = new Thread(new Task());
		thread.start();
		while (true) {
			Utils.pause(1000);
			thread.interrupt();
		}
	}
}
