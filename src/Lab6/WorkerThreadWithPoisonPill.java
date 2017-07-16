package Lab6;

import java.util.LinkedList;
import java.util.Queue;

public class WorkerThreadWithPoisonPill {
	
	Queue<Runnable> tasks = new LinkedList<>();
	private Thread thread;
	static final private Runnable POISONPILL = () -> {};
	volatile private boolean running;
	
	public WorkerThreadWithPoisonPill(){
		synchronized (tasks) {
			thread = new Thread(this::process);
			thread.start();//ссылка на метод
			running =true;
		}
		
	}
	
	public void shutdown() {
		
		synchronized (tasks) {
			submit(POISONPILL);
		}
		
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
						break;
					}
				}
				task = tasks.poll();
			}
			if (task==POISONPILL) {
				break;
			}
			task.run();
		}
	}
	public boolean submit(Runnable task){
		synchronized (tasks) {
			if (!running) {
				return false;
			}
			if (task == POISONPILL) {
				running=false;
			}
			tasks.add(task);
			tasks.notify();
		}
		return true;
	}
	
}
