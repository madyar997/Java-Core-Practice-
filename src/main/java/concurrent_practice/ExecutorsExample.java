package concurrent_practice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorsExample {
    public static void main(String[] args) {
        ExecutorService ex = Executors.newCachedThreadPool();
        ex.execute(new SimpleThread());
        ex.execute(new SimpleThread());
        ex.execute(new SimpleThread());
        ex.shutdown();
    }

}

class SimpleThread implements Runnable{
    public int count = 0;
    @Override
    public void run() {
        for (int i = 0; i < 1000000; i++) {
            count++;
        }
        System.out.println(count);
    }
}