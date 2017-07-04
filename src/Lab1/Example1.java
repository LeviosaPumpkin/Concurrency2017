package Lab1;

public class Example1 {
	public static void main(String[] args)
	{
		Thread cT =  Thread.currentThread();
		System.out.println(cT.getName());
		System.out.println(cT.getThreadGroup().getName());
		
		Thread thread = new Thread(()->{
			System.out.println("Hello");
			System.out.println(Thread.currentThread().getThreadGroup().getName());
			try {
				Thread.sleep(100000);			
			} catch (Exception e) {
			}
			System.out.println("finish");
		});
		thread.start();
		System.out.println("main");
	}

}
