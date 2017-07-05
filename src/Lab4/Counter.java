package Lab4;

public class Counter {
	
	private int count;
	private Object lock = new Object();//это поле видно только экземпляру класса, никто не сможет захватить его
	
	public int getCount() {//можно сделать volatile, а можно синхронизировать по одному объекту
		synchronized(lock){
			return count;
		}
	}
	
	public void inc() {
		synchronized(lock){
			count++;
		}
	}

	public static void main(String[] args) {
		
	}
}
