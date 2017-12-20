import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class testThread implements Runnable {
	volatile int i=0;
	
	//public synchronized void run() {
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("hello");
		synchronized(this) {
		i++;
//		for(i=0;i<5;i++) {
//			System.out.println(i);
//		}
		}
	}
	
	public int getCount() {
		return i;
	}
}

class testLock implements Runnable {
	int i;
	Lock lock = new ReentrantLock();
	
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("hello lock " + Thread.currentThread().getName());
		boolean f = false;
		try {
			f = lock.tryLock(10, TimeUnit.MILLISECONDS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(f) {
		try {
			//i++;
			for(;i<5;i++) {
				System.out.println(i + " - " + Thread.currentThread().getName());
				Thread.sleep(100);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			lock.unlock();
			System.out.println("unlock lock " + Thread.currentThread().getName());
		}	
		}
		System.out.println("finish");
	}
	
	public void setCount() {
		i++;
	}
	
	public int getCount() {
		return i;
	}
}
	
	
public class testThreadMain {	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		/*testThread r = new testThread();
		Thread t1 = new Thread(r);
		t1.start();		
		Thread t2 = new Thread(r);
		t2.start();		
		t1.join();
		t2.join();		
		System.out.println("i= " + r.getCount());
		*/
		testLock r1 = new testLock();
		Thread t3 = new Thread(r1,  "T3");
		t3.start();		
		Thread t4 = new Thread(r1, "T4");
		t4.start();
		t3.join();
		t4.join();
		//r1.setCount();
		System.out.println("main i= " + r1.getCount());
		
		
		
		
		/*Thread t1 = new Thread(new Runnable() {
			public void run() {
				x++;
				System.out.println("hello1 " + x);
			}
		});
		t1.start();
		Thread t2 = new Thread(new Runnable() {
			public void run() {
				System.out.println("hello2 " + x);
			}
		});		
		t2.start(); */
	}
}
