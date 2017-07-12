package Lab5;

import java.util.LinkedList;
import java.util.Queue;

public class WorkerThread {
	
	Queue<Runnable> tasks = new LinkedList<>();
	
	public WorkerThread(){
		new Thread(this::process).start();//ссылка на метод
	}
	
	private void process(){
		while (true) {
			Runnable task=null;
			synchronized (tasks) {
				while (tasks.isEmpty()) {//делаем проверку листа, пока НЕ захватили в монопольное использование - very bad!!!
					try {
						tasks.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				task = tasks.poll();
			}
			task.run();
		}
	}
	public void submit(Runnable task){
		synchronized (tasks) {
			tasks.add(task);
			tasks.notify();
		}
	}
}
