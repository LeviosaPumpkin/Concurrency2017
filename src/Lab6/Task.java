package Lab6;

import Lab1.Utils;

public class Task implements Runnable{
	@Override
	public void run() {
		System.out.println("start" + Thread.currentThread());
		Utils.pause(1000);
		System.out.println("end");
	}
	
	
}
