package queueModel;

import java.util.concurrent.BlockingQueue;

/**
* �����߶��У�������ȡ�ö����е�uuid��ӡ��
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
    			System.out.println(Thread.currentThread() + " ���˱�ǩ��Ϊ" + cake.getCakeId()+"�ĵ���");
    		} catch (InterruptedException e) {
    			System.out.println(e.getMessage());
    		}
    	}

    }
}       
