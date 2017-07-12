package HW_Philosophers;

public class Main {
	
	final static int NUMBER=5;
	
	public static void main(String[] args) {
		
		Cafe cafe=new Cafe(NUMBER);
		
		cafe.newPhilosopher(0,1).start();
		cafe.newPhilosopher(1,2).start();
		cafe.newPhilosopher(2,3).start();
		cafe.newPhilosopher(3,4).start();
		cafe.newPhilosopher(0,4).start();//4-0 - deadlock!
		
	}
}
