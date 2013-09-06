package queueModel;

import java.util.concurrent.LinkedBlockingQueue;

/**
* 测试类
*
* @author Administrator
*
*/
public class Tester {

    public static void main(String[] args) throws InterruptedException {
        // 队列
        LinkedBlockingQueue<Cake> queue = new LinkedBlockingQueue<Cake>(1000);
        // 生产者
        Producer producer = new Producer(queue);
        // 消费者
        Consumer consumer = new Consumer(queue);

        for (int i = 0; i < 2; i++) {
            new Thread(producer).start();
        }


        for (int i = 0; i < 4; i++) {
            new Thread(consumer).start();
        }
    }
}    