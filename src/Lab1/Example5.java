package Lab1;

public class Example5 {
	static class Task implements Runnable{
		private String name;
		public Task(String name){
			this.name=name;
		}
		public void run(){
			Thread.currentThread().setName(name);
			int count =0;
			while(true){
				System.out.println(count++);
				Utils.pause(1000);
			}
		}
	}
	
	public static void main(String[] args) {
		new Thread(new Task("Counter")).start();
		new Thread(new Task("Counter2")).start();		
	}
}
