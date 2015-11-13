package concurrent.liveness;

public class DeadLock {
	static class Friend {
		private String name;
		
		public Friend(String name) {
			this.name = name;
		}
		
		public String getName() {
			return this.name;
		}
		
		public synchronized void bow(Friend bower) {
			System.out.format("%s: %s has bowed to me!%n", this.name, bower.getName());
			bower.bowBack(this);
		}
		
		public synchronized void bowBack(Friend bower) {
			System.out.format("%s: %s has bowed back to me!%n", this.name, bower.getName());
		}
	}
	
	public static void main(String[] args) {
		Friend jack = new Friend("Jack");
		Friend tom = new Friend("Tom");
		
		new Thread(new Runnable() {

			@Override
			public void run() {
				jack.bow(tom);
			}
			
		}).start();;
		
		new Thread(new Runnable() {

			@Override
			public void run() {
				tom.bow(jack);
			}
			
		}).start();;
	}
}

/*饥饿和活锁 

饥饿和活锁并不如死锁一般普遍，但它仍然是每个并发程序设计者可能会遇到的问题。 

饥饿 

饥饿是指当一个线程不能正常的访问共享资源并且不能正常执行的情况。这通常在共享资源被
其他“贪心”的线程长期时发生。举个例子，假设一个对象提供了一个同步方法，这个方法通常
需要执行很长一段时间才返回。如果一个线程经常调用这个方法，那么其他需要同步的访问这
个对象的线程就经常会被阻塞。 

活锁 

一个线程通常会有会响应其他线程的活动。如果其他线程也会响应另一个线程的活动，那么就
有可能发生活锁。同死锁一样，发生活锁的线程无法继续执行。然而线程并没有阻塞——他们在
忙于响应对方无法恢复工作。这就相当于两个在走廊相遇的人：Alphonse向他自己的左边靠
想让Gaston过去，而Gaston向他的右边靠想让Alphonse过去。可见他们阻塞了对方。
Alphonse向他的右边靠，而Gaston向他的左边靠，他们还是阻塞了对方。 
 * 
 */
