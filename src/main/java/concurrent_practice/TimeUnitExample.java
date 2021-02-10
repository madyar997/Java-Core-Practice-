package concurrent_practice;

import java.util.concurrent.*;

public class TimeUnitExample {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<Integer> count1 = executorService.submit(new TimeUnitThread());
        try {
            System.out.println(count1.isDone());
            System.out.println(count1.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}

class TimeUnitThread implements Callable<Integer>{

    @Override
    public Integer call() {
        int count = 0;
        for (int i = 0; i < 1000; i++) {
            count++;
            try {
                TimeUnit.MICROSECONDS.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return count;
    }
}