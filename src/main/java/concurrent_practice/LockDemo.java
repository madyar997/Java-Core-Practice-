package concurrent_practice;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockDemo implements Runnable{
    private static int count;
    private static Lock lock = new ReentrantLock();
    @Override
    public void run() {
        for (int i = 0; i < 1000000; i++) {
            lock.lock();
            count++;
            lock.unlock();
        }
        System.out.println(count);
    }

    public static void main(String[] args) {
        LockDemo lockDemo = new LockDemo();
        LockDemo lockDemo1 = new LockDemo();
        Thread thread = new Thread(lockDemo);
        Thread thread1 = new Thread(lockDemo);
        thread1.start();
        thread.start();
    }
}
