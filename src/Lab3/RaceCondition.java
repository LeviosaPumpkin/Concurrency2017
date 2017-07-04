package Lab3;

import Lab1.Utils;

public class RaceCondition {
	
	static int count;
	
	static class Task implements Runnable{
		@Override
		public void run() {
			while (true) {
				Utils.pause(3000);
				inc();

			}		
		}

		synchronized private void inc() {
			count++;
			System.out.println(count);
		}
	}

	public static void main(String[] args) {
		Task target = new Task();
		Thread t1 =  new Thread(target);
		Thread t2 =  new Thread(target);
		t1.start();
		t2.start();
	}
}
