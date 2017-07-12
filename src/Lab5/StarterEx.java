package Lab5;

import java.util.Arrays;
import java.util.List;

import Lab1.Utils;

public class StarterEx {
	
	static class Runner implements Runnable{
		Object pager;
		public Runner(Object pager) {
			this.pager=pager;
		}
		@Override
		public void run() {
			synchronized (pager) {
				try {
					pager.wait();
					
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
			System.out.println("Running "+this);
		}
	}
	
	public static void main(String[] args) {
		
		System.out.println("Start");
		
		Object starter = new Object();
		
		List<Runner> runners = Arrays.asList(new Runner(starter), new Runner(starter), new Runner(starter));
		
		for(Runner runner : runners){
			new Thread(runner).start();
		}
		
		Utils.pause(3000);
		
		System.out.println("end");
		
		synchronized (starter) {
			starter.notifyAll();
		}
	}

}
