package HW_BlockingQueueWithLocks;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BlockingQueue<T> {
	
	final Lock lock = new ReentrantLock();
	final Condition notFull = lock.newCondition();
	final Condition notEmpty = lock.newCondition();
	final int capacity;

	private Queue<T> tasks = new LinkedList<>();
	
	public BlockingQueue(int capacity){
		this.capacity=capacity;
	}
	
	public void put(T item) {
		lock.lock();
		try {
			while(capacity == tasks.size())
				notFull.await();
			tasks.add(item);
			notEmpty.signal();
		} catch(InterruptedException e){
			e.printStackTrace();
		} finally {
			lock.unlock();
		}	
	}
	
	public T take() {
		lock.lock();
		try{
			while(tasks.size()==0)
				notEmpty.await();
			T task = tasks.poll();
			notFull.signal();
			return task;
		} catch(InterruptedException e){
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
		return null;	
	}
	

}
