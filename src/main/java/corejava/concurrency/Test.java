package corejava.concurrency;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Test implements Runnable{
    Lock lock = new ReentrantLock();

    public void run(){
        System.out.println("inside run");
        lock.lock();
        System.out.println("fist locked");
        lock.lock();
        System.out.println("2nd locked");
        lock.unlock();
        System.out.println("unlocked");
        lock.unlock();
        System.out.println("unlocked");
    }

    public static void main(String[] args) {
        Thread t = new Thread(new Test());
        t.start();

    }
}
