package queueModel;

import java.util.UUID;
import java.util.concurrent.BlockingQueue;

/**
 * �������࣬�����ǲ�����uuid���ڶ�����
 * 
 * @author Administrator
 * 
 */
public class Producer implements Runnable {
	private BlockingQueue<Cake> queue;

	public Producer(BlockingQueue<Cake> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		while (true) {
			String cakeId = UUID.randomUUID().toString();
			Cake cake = Cake.valueOf(cakeId);
			try {
				queue.put(cake);
				System.out.println(Thread.currentThread() + " �����˱�ǩ��Ϊ" + cakeId
						+ "�ĵ���");
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}
