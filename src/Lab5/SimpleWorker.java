package Lab5;

public class SimpleWorker {
	public void process(Runnable task) {
		new Thread(task).start();	
	}
}
