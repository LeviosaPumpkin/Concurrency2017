package Lab5;

import Lab1.Utils;

public class WaitNotifyEx {
	 
	static class Task implements Runnable{
		
		private Object pager;

		public Task(Object pager) {
			this.pager=pager;
		}
		
		@Override
		public void run() {
			synchronized (pager) {
				try{
					pager.wait();
				}catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(this);
			}
		}
	}
	
	public static void main(String[] args) {
		System.out.println("start");
		Object p = new Object();
		new Thread(new Task(p)).start();
		Utils.pause(10000);
		synchronized (p) {
			p.notify();
		}
	}

}
