package queueModel;

import java.util.UUID;
import java.util.concurrent.BlockingQueue;

/**
 * 生产者类，任务是产生个uuid放在队列中
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
				System.out.println(Thread.currentThread() + " 生产了标签号为" + cakeId
						+ "的蛋糕");
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
