package Lab1;

public class Example2 {
	
	static class Task implements Runnable{
		public void run(){
			System.out.println("Hello");
		}
	}
	
	public static void main(String[] args){
		Task task = new Task();
		Thread t = new Thread(task);
		t.start();
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("Hello2");
			}
		}).start();
	}
}
