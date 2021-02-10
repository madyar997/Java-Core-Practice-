package concurrent_practice;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicExample {
    public static void main(String[] args) {
        MyThread2 nonAtomic = new MyThread2();
        AtomicThread atomic = new AtomicThread();
        Thread thread = new Thread(nonAtomic);
        Thread thread1 = new Thread(atomic);
        thread.start();
        thread1.start();

    }
}

class MyThread2 implements Runnable{
    public volatile int count = 0;
    public void run() {
        for (int i = 0; i < 1000; i++) {
            count++;
        }
        System.out.println(count);
    }
}

class AtomicThread implements Runnable{
    private static AtomicInteger count = new AtomicInteger(0);

    @Override
    public void run() {
        for (int i = 0; i < 1000000; i++) {
            count.getAndAdd(1);
        }
        System.out.println(count);
    }
}
