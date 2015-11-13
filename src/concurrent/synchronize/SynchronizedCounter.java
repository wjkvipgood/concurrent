package concurrent.synchronize;

public class SynchronizedCounter {
	private int c = 0;
	
	/**
	 * 首先，相同对象上的同步方法的两次调用，它们要交替执行是不可能的。 
	 * 当一个线程正在执行对象的同步方法时，所有其他调用该对象同步方法
	 * 的线程会被阻塞（挂起执行）,直到第一个线程处理完该对象。
	 * 
	 * 其次，当一个同步方法退出时，它会自动跟该对象同步方法的任意后续
	 * 调用建立起一种happens-before关系。这确保对象状态的改变对所有
	 * 线程是可见的。
	 * 
	 * 注意构造方法不能是同步的——构造方法加synchronized关键字会报语
	 * 法错误。同步的构造方法没有意义，因为当这个对象被创建的时候，只
	 * 有创建对象的线程能访问它。
	 */
	public synchronized void increment() {
		c++;
	}
	
	public synchronized void decrement() {
		c--;
	}
}

/*
内部锁与同步 

同步机制的建立是基于其内部一个叫内部锁或者监视锁的实体。（在Java API规范
中通常被称为监视器。）内部锁在同步机制中起到两方面的作用：对一个对象的排他
性访问；建立一种happens-before关系，而这种关系正是可见性问题的关键所在。
 
每个对象都有一个与之关联的内部锁。通常当一个线程需要排他性的访问一个对象的
域时，首先需要请求该对象的内部锁，当访问结束时释放内部锁。在线程获得内部锁
到释放内部锁的这段时间里，我们说线程拥有这个内部锁。那么当一个线程拥有一个
内部锁时，其他线程将无法获得该内部锁。其他线程如果去尝试获得该内部锁，则会
被阻塞。 

当线程释放一个内部锁时，该操作和对该锁的后续请求间将建立happens-before关系。
*/