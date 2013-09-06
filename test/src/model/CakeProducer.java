package model;

/**
 * 蛋糕生产者
 * 
 * @author ssl
 * 
 */
public class CakeProducer implements Runnable {
	private CakeStore cakeStore;

	public CakeProducer(CakeStore cakeStore) {
		this.cakeStore = cakeStore;
	}

	@Override
	public void run() {
		while (true) {
			/*
			 * try { Thread.sleep(1000); } catch (InterruptedException e) {
			 * e.printStackTrace(); }
			 */
			cakeStore.makeCake();
			System.out.println(Thread.currentThread() + "生产了cake");
		}

	}

}
