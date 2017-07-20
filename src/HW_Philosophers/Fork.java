package HW_Philosophers;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Fork {

	private final Lock lock=new ReentrantLock();
	
	public void take() {
		lock.lock();
	}
	public void put() {
		lock.unlock();
	}
}
