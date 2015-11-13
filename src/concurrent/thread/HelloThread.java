package concurrent.thread;

public class HelloThread extends Thread {

	@Override
	public void run() {
		System.out.println("Hello from a thread!\n");
	}
	
	public static void main(String[] args) {
		new HelloThread().start();
	}
}
