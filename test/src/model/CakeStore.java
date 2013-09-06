package model;

import java.util.concurrent.locks.Lock;

/**
 * ���ǵ���store
 * 
 * @author ssl
 * 
 */
public class CakeStore {
	/** �������� */
	private int number = 0;
	/** ��������� */
	private int capacity = 0;

	private Object lock = new Object();

	/** ���쵰�� */
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

	/** �Ե��� */
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
	 * ���췽��
	 * 
	 * @return
	 */
	public static CakeStore valueOf(int capacity) {
		CakeStore cakeStore = new CakeStore();
		cakeStore.setCapacity(capacity);
		return cakeStore;
	}

}
