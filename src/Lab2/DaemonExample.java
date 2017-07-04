package Lab2;

import Lab1.Utils;

public class DaemonExample {
	
	static class Counter implements Runnable{
		@Override
		public void run() {
			int count=0;
			while (true) {
				Utils.pause(1000);
				System.out.println(++count);
			}
		}
	}

	public static void main(String[] args) {
		Thread thread = new Thread(new Counter());
		thread.setDaemon(true);
		thread.start();
		System.out.println("start");
		try {
			thread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Utils.pause(5000);
		System.out.println("stop");
	}
}
