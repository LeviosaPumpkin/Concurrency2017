package Lab6;

import java.util.LinkedList;
import java.util.Queue;

public class WorkerThreadWithShutdown {
	
	Queue<Task> tasks = new LinkedList<>();
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
			Task task=null;
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
	public void submit(Task task){
		synchronized (tasks) {
			tasks.add(task);
			tasks.notify();
		}
	}
}
