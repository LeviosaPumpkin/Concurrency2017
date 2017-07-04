package Lab1;

public class Exampl4 {
	public static void main(String[] args) {
		new Thread(() -> {
			int count =0;
		while(true){
			System.out.println(count++);
			Utils.pause(1000);
		}
		},"Counter").start();;
	}
}
