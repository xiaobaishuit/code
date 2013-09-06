package model;

/**
 * @author ssl
 * 
 */
public class LockTest {
	private Object lock = new Object();
	public static void main(String[] args) {
		new Thread(new Test2()).start();
		
	}
	
}


class Test2 implements Runnable{

	@Override
	public void run() {
		
	}
	
}