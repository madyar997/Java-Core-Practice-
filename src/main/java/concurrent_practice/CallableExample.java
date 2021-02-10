package concurrent_practice;

import java.util.concurrent.*;

public class CallableExample {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        Future<Integer> s = executor.submit(new CallableThread());
        Future<Integer> s1 = executor.submit(new CallableThread());
        try {
            System.out.println("А я уже здесь");
            System.out.println(s.isDone());
            System.out.println(s.get());
            System.out.println(s1.get());
            System.out.println(s1.isDone());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}
class CallableThread implements Callable<Integer>{
    public  int count = 0;
    @Override
    public Integer call() throws Exception {
        for (int i = 0; i < 1000000; i++) {
            count++;
        }
        try{
            Thread.sleep(10000);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
        return count;
    }
}