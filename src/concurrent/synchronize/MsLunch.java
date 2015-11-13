package concurrent.synchronize;

public class MsLunch {
	private long c1 = 0;
	private long c2 = 0;
	
	// 这里我们创建了两个“锁”对象
	private Object lock1 = new Object();
	private Object lock2 = new Object();
	
	public void inc1() {
		synchronized(lock1) {
			c1++;
		}
	}
	
	public void inc2() {
		synchronized(lock2) {
			c2++;
		}
	}
}
