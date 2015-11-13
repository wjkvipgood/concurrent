package concurrent.thread;

public class SleepMessages {
	public static void main(String[] args) throws InterruptedException {
		String[] importantInfo = {
			"Mares eat oats",
			"Does eat oats",
			"Little lambs eat ivy",
			"A kid will eat ivy too"
		};
		
		for(int i=0; i<importantInfo.length; i++) {
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				//return;
				// 抛出更有意义
				throw new InterruptedException();
			}
			System.out.println(importantInfo[i]);
		}
	}
}
