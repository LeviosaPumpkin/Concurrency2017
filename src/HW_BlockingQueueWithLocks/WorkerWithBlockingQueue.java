package HW_BlockingQueueWithLocks;

public class WorkerWithBlockingQueue {
	
	private BlockingQueue<Runnable> tasks = new BlockingQueue<>(10);
	private Thread thread;
	static final private Runnable POISONPILL = () -> {};
	volatile private boolean running;
	//private final int capacity;
	
	public WorkerWithBlockingQueue(int capacity){
		synchronized (POISONPILL) {
			tasks = new BlockingQueue<>(capacity);
			thread = new Thread(this::process);
			thread.start();//ссылка на метод
			running =true;
		}
		
	}
	
	public void shutdown() {
		submit(POISONPILL);
}
	
	private void process(){
		while (true) {
			Runnable task = tasks.take();
			if (task==POISONPILL) {
				break;
			}
			if (task==null){
				task=POISONPILL;
				break;
			}
			task.run();
		}
	}
	public boolean submit(Runnable task){
		if (!running) {
			return false;
		}
		if (task == POISONPILL) {
			running=false;
		}
		tasks.put(task);
		return true;
	}

}
