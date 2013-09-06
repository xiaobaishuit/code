package queueModel;

import java.util.concurrent.LinkedBlockingQueue;

/**
* ������
*
* @author Administrator
*
*/
public class Tester {

    public static void main(String[] args) throws InterruptedException {
        // ����
        LinkedBlockingQueue<Cake> queue = new LinkedBlockingQueue<Cake>(1000);
        // ������
        Producer producer = new Producer(queue);
        // ������
        Consumer consumer = new Consumer(queue);

        for (int i = 0; i < 2; i++) {
            new Thread(producer).start();
        }


        for (int i = 0; i < 4; i++) {
            new Thread(consumer).start();
        }
    }
}    