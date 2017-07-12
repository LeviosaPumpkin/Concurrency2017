package Lab5;

import Lab1.Utils;

public class WaitNotifyProblems {
	
	public static void main(String[] args) {
		
		System.out.println("start");
		
		Object pager = new Object();
		
		new Thread(() -> {
			synchronized (pager) {
				try {
					pager.wait();
				} catch (Exception e) {
					
				}
			}
			System.out.println("end");
		}).start();
		
		Utils.pause(2000);
		
		synchronized (pager) {
			pager.notify();
			while(true){
				
			}
		}
		
	}
	
}
