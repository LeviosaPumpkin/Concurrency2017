package Lab6;

import Lab1.Utils;

public class UseWorkerWithPoisonPill {
	static class Task implements Runnable{
		private int num;

		public Task(int num){
			this.num=num;
		}
		
		@Override
		public void run() {
			System.out.println("start " + num);
			Utils.pause(2000);
			System.out.println("stop "+ num);
			
		}
	}
	public static void main(String[] args) {
		WorkerThreadWithPoisonPill worker = new WorkerThreadWithPoisonPill();
		worker.submit(new Task(1));
		worker.submit(new Task(2));
		worker.submit(new Task(3));
		worker.submit(new Task(4));
		
		worker.shutdown();
	}
}
