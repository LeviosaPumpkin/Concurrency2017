package Lab8;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

import Lab1.Utils;

public class SemaphoreFairEx {
	
	private static final class Runner implements Runnable {
		Semaphore sem;
		public Runner(Semaphore s){
			sem=s;
		}
		@Override
		public void run() {
			int number=count;
			System.out.println("waiting for sinal");
			sem.acquireUninterruptibly();
			System.out.println(number + " got sinal");
			while(true){
				System.out.println(count++);
				Utils.pause(1000);
			}
		}
	}

	static volatile int count=0;
	
	public static void main(String[] args) {
		Semaphore sem = new Semaphore(0);
		
		List<Runner> runners = Arrays.asList(new Runner(sem), new Runner(sem), new Runner(sem), new Runner(sem), new Runner(sem));
		
		ExecutorService service = Executors.newCachedThreadPool();
		
		for (Runner runner : runners) {
			Utils.pause(200);
			service.execute(runner);
		}
		
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
