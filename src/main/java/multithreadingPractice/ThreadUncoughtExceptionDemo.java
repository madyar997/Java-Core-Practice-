package multithreadingPractice;

import jdk.swing.interop.SwingInterOpUtils;

public class ThreadUncoughtExceptionDemo {
    public static void main(String[] args) {
        Thread t = new Thread(new NewSimpleThread());
        t.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println(t + " throws exception "+ e);
            }
        });
        t.start();
    }
}
class NewSimpleThread implements Runnable{

    @Override
    public void run() {
        throw new RuntimeException("It is a great exception.");
    }
}