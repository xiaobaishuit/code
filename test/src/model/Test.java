package model;

/**
 * @author ssl
 * 
 */
public class Test {
	public static void main(String[] args) {
		CakeStore cakeStore = CakeStore.valueOf(1000);
		for (int i = 0; i < 3; i++) {
			new Thread(new CakeProducer(cakeStore)).start();
		}
		for (int i = 0; i < 1; i++) {
			new Thread(new CakeCustomer(cakeStore)).start();
		}
	}

}
