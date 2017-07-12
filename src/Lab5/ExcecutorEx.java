package Lab5;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import Lab1.Utils;

public class ExcecutorEx {
	
	public static void main(String[] args) {
		
		Executor service = Executors.newSingleThreadExecutor();
		
		service.execute(() -> {
			System.out.println("start" + Thread.currentThread());
			Utils.pause(2000);
			System.out.println("end");
		});
		
		service.execute(() -> {
			System.out.println("start" + Thread.currentThread());
			Utils.pause(2000);
			System.out.println("end");
		});
		
		service.execute(() -> {
			System.out.println("start" + Thread.currentThread());
			Utils.pause(2000);
			System.out.println("end");
		});
		
	}

}
