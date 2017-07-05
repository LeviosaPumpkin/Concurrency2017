package Lab4;

import Lab1.Utils;

public class SyncMultyThreaded {
	
	synchronized void change(){
			for (int i = 0; i < 100; i++) {
			System.out.println(Thread.currentThread().getName()+" "+i);
			Utils.pause(1000);
		}
	}
	
	public static void main(String[] args) {
		
		Sync sync = new Sync();
		
		new Thread(() -> {
			sync.change();
		}).start();
		new Thread(() -> {
			sync.change();
		}).start();
		new Thread(() -> {
			sync.change();
		}).start();
		new Thread(() -> {
			sync.change();
		}).start();
		
		sync.change();
	}
}
