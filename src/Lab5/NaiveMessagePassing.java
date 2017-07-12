package Lab5;

import javax.rmi.CORBA.Util;

import Lab1.Utils;

public class NaiveMessagePassing {
	
	volatile static boolean ready=false;
	
	static class Task implements Runnable{
		@Override
		public void run() {
			while (!ready) {//вот тут все ядро занято бесконечной проверкой в цикле
					
			}				
			System.out.println("got it");
			
		}
	}
	
	public static void main(String[] args) {
		
		System.out.println("start");
		new Thread(new Task()).start();
		Utils.pause(3000);
		ready=true;//проблема в visibility
	}

}
