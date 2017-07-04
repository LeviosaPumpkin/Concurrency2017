package Lab2;
import Lab1.Utils;
public class JoinExample {
	
	static class Task implements Runnable{
		@Override
		public void run() {
			System.out.println("start");
			Utils.pause(30000);
			System.out.println("finish");
		}
	}
	
	public static void main(String[] args) {
		Thread thread = new Thread(new Task());
		thread.start();		
		System.out.println("thread started");
		try {
				thread.join(50000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println("main end");
		Utils.pause(10000);
	}
}
