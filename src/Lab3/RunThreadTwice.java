package Lab3;

public class RunThreadTwice {
	
	public static void main(String[] args) {
		Thread t  = new Thread();
		t.start();
		System.out.println(t.getState());
		try {
			t.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println(t.getState());
		//t.start();
		//System.out.println(t.getState());
	}
}
