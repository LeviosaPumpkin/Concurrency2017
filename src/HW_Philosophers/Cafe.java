package HW_Philosophers;

import java.util.ArrayList;
import java.util.List;

public class Cafe {
	
	List<Fork> forks = new ArrayList<>();
	int totalEaten;
	final int NUMBER;

	public Cafe(int n) {
		NUMBER=n;
		for (int i = 0; i < NUMBER; i++) {
			forks.add(new Fork());
		}
	}
	public Thread newPhilosopher(int fork1, int fork2) {
		return new Thread(new Philosopher(forks.get(fork1), forks.get(fork2)),"Philosopher"+fork1);
	}
}
