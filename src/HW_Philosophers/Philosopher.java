package HW_Philosophers;

public class Philosopher implements Runnable{
	
	private final Fork fork1, fork2;
	
	public Philosopher(Fork f1, Fork f2){
		fork1=f1;
		fork2=f2;
	}
	
	@Override
	public void run() {
		while (true) {
			fork1.take();
			fork2.take();
			eat();
			fork1.put();
			fork2.put();
			think();
		}
	}
	private void eat() {
		
	}
	private void think() {
		
	}

}
