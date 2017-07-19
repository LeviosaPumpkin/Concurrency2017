package HW_Philosophers_Sync;

import Lab1.Utils;

public class Philosopher implements Runnable{
	
	private final Object fork1, fork2;
	private int num;
	
	public Philosopher(Object f1, Object f2, int num){
		fork1=f1;
		fork2=f2;
		this.num=num;
	}
	
	@Override
	public void run() {
		while (true) {
            synchronized (fork1) {
                synchronized (fork2) {
                    eat();
                }
            }
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
