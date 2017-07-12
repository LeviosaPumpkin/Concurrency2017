package Lab5;

import Lab1.Utils;

public class UseWorker {
	
	public static void main(String[] args) {
		SimpleWorker w = new SimpleWorker();
		w.process(() -> {
			System.out.println("hello");
		});
		
		w.process(() -> {
			System.out.println("hello");
		});
		
		w.process(() -> {
			System.out.println("hello");
		});
		
		w.process(() -> {
			System.out.println("hello");
		});//тут создается каждый раз новый поток, что очень дорого
		
		Utils.pause(3000);
	}

}
