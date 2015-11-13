package concurrent.thread;

public class HelloRunnable implements Runnable {

	@Override
	public void run() {
		System.out.println("Hello from a thread!\n");
	}
	
	public static void main(String[] args) {
		new Thread(new HelloRunnable()).start();
	}

}
