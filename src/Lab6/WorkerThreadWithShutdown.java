package Lab6;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

import Lab1.Utils;

public class WorkerThreadWithShutdown {
	
	Queue<Runnable> tasks = new LinkedList<>();
	private Thread thread;
	
	public WorkerThreadWithShutdown(){
		thread = new Thread(this::process);
		thread.start();//ссылка на метод
	}
	
	public void shutdown() {
		
		thread.interrupt();
		
	}
	
	private void process(){
		OUTER: while (true) {
			Runnable task=null;
			synchronized (tasks) {
				while (tasks.isEmpty()) {//делаем проверку листа, пока НЕ захватили в монопольное использование - very bad!!!
					try {
						tasks.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
						break OUTER;
					}
				}
				task = tasks.poll();
			}
			task.run();
		}
		for (Runnable runnable : tasks) {
			runnable.run();
		}
	}
	public void submit(Runnable task){
		synchronized (tasks) {
			tasks.add(task);
			tasks.notify();
		}
	}
}
