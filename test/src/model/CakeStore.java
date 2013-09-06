package model;

import java.util.concurrent.locks.Lock;

/**
 * 这是蛋糕store
 * 
 * @author ssl
 * 
 */
public class CakeStore {
	/** 蛋糕数量 */
	private int number = 0;
	/** 蛋糕店容量 */
	private int capacity = 0;

	private Object lock = new Object();

	/** 制造蛋糕 */
	public void makeCake() {
		synchronized (lock) {
			while (number == capacity) {
				try {
					lock.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			number++;
			lock.notify();
		}
	}

	/** 吃蛋糕 */
	public void eatCake() {
		synchronized (lock) {
			while (number == 0) {
				try {
					lock.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			number--;
			lock.notify();
		}
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	// Getter and Setter ...

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	// Static Method's ...

	/**
	 * 构造方法
	 * 
	 * @return
	 */
	public static CakeStore valueOf(int capacity) {
		CakeStore cakeStore = new CakeStore();
		cakeStore.setCapacity(capacity);
		return cakeStore;
	}

}
