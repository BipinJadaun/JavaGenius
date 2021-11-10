package corejava.concurrency;

import org.apache.commons.lang3.RandomUtils;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumerUsingLockAndCondition {
    private static Queue<Integer> goods = new LinkedList<>();
    private static Lock lock = new ReentrantLock();
    private static Condition added = lock.newCondition();
    private static Condition removed = lock.newCondition();
    private static final int MAX_QUEUE_SIZE = 10;

    public static void main(String[] args) {
        Thread consumer = new Thread(new Consumer(goods, lock, added, removed));
        Thread producer = new Thread(new Producer(goods, lock, added, removed, MAX_QUEUE_SIZE));

        consumer.start();
        producer.start();
    }

}

class Producer implements Runnable {

    private Queue<Integer> goods ;
    private Lock lock ;
    private Condition added;
    private Condition removed;
    private int maxQueueSize;

    public Producer(Queue<Integer> goods, Lock lock, Condition added, Condition removed, int maxQueueSize) {
        this.goods = goods;
        this.lock = lock;
        this.added = added;
        this.removed = removed;
        this.maxQueueSize = maxQueueSize;
    }

    @Override
    public void run() {
        lock.lock();

        try {
            while(goods.size() == maxQueueSize)
                removed.await();
            int producedGood = RandomUtils.nextInt();
            System.out.println("Produced Good: " + producedGood);
            goods.add(producedGood);
            added.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}

class Consumer implements Runnable {

    private Queue<Integer> goods ;
    private Lock lock ;
    private Condition added;
    private Condition removed;

    public Consumer(Queue<Integer> goods, Lock lock, Condition added, Condition removed) {
        this.goods = goods;
        this.lock = lock;
        this.added = added;
        this.removed = removed;
    }

    @Override
    public void run() {
        lock.lock();
        try{
            while(goods.size() == 0)
                added.await();

            int consumedGood = goods.poll();
            System.out.println("Consumed Good: "+ consumedGood);
            removed.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
