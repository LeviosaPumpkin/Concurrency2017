package HW_Philosophers_Sync;

public class Main {
	
	final static int NUMBER=5;
	
	public static void main(String[] args) {
		
		Cafe cafe=new Cafe(NUMBER);
		
		cafe.newPhilosopher(0,1,0).start();
		cafe.newPhilosopher(1,2,1).start();
		cafe.newPhilosopher(2,3,2).start();
		cafe.newPhilosopher(3,4,3).start();
		cafe.newPhilosopher(0,4,4).start();//4-0 - deadlock!
		
	}
}
