package Lab4;

import Lab1.Utils;

public class EvilCounterUsage {
	
	public static void main(String[] args) {
		
		Counter c = new Counter();//создали плохой поток, используя публичную ссылку на наш объект
		new Thread(() -> {
			synchronized (c) {
				while (true) {
					
				}
				
			}
		}).start();
		Utils.pause(1000);
		System.out.println("start good thread");
		
		new Thread(() -> {
			while (true) {
				c.inc();
				Utils.pause(1000);
				
			}
		}).start();
		
		new Thread(() -> {
				while (true) {
					System.out.println(c.getCount());
					Utils.pause(1000);
				}
			}).start();	
	}
}
