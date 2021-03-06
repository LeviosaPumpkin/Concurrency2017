package HW_Philosophers;

import Lab1.Utils;

public class Philosopher implements Runnable{
	
	private final Fork fork1, fork2;
	private int num;
	
	public Philosopher(Fork f1, Fork f2, int num){
		fork1=f1;
		fork2=f2;
		this.num=num;
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
		System.out.println("Philosopher "+num+" is eating");
		Utils.pause(1000);
	}
	private void think() {
		System.out.println("Philosopher "+num+" is thinking");
		Utils.pause(2000);
	}

}
