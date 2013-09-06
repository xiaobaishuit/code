package queueModel;

import java.util.concurrent.BlockingQueue;

/**
* 消费者队列，任务是取得队列中的uuid打印下
*
* @author Administrator
*
*/
public class Consumer implements Runnable {
    private BlockingQueue<Cake> queue;

    public Consumer(BlockingQueue<Cake> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
    	while(true){
    		try {
    			Cake cake = queue.take();
    			System.out.println(Thread.currentThread() + " 吃了标签号为" + cake.getCakeId()+"的蛋糕");
    		} catch (InterruptedException e) {
    			System.out.println(e.getMessage());
    		}
    	}

    }
}       
