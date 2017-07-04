package Lab3;

import Lab1.Utils;

public class HW_Race_Condition_Pauses {

static int count;
	
	static class Task implements Runnable{
		@Override
		public void run() {
			while (true) {
				Utils.pause(3000);
				inc();

			}		
		}

		 private void inc() {
				int tmp=count;
				System.out.println("LOAD");
				Utils.pause(1000);
				tmp=tmp+1;
				System.out.println("INC");
				Utils.pause(1000);
				count=tmp;
				System.out.println("STORE");
				Utils.pause(1000);
				System.out.println(count);
		}
	}

	public static void main(String[] args) {
		Task target = new Task();
		Thread t1 =  new Thread(target);
		Thread t2 =  new Thread(target);
		t1.start();
		t2.start();
	}
}
