package Lab8;

import java.util.concurrent.Semaphore;

import Lab1.Utils;

public class SemaphoreEx {
	
	public static void main(String[] args) {
		Semaphore sem = new Semaphore(0);
		
		Runnable runner = () -> {
			System.out.println("waiting for sinal");
			sem.acquireUninterruptibly();
			System.out.println("got sinal");
			int count=0;
			while(true){
				System.out.println(count++);
				Utils.pause(1000);
			}
		};
		
		new Thread(runner).start();
		
		Utils.pause(500);
		System.out.println("ready");
		Utils.pause(1000);
		System.out.println("steady");
		Utils.pause(1000);
		System.out.println("go");
		Utils.pause(1000);
		
		sem.release();
		
	}

}
