package multithreadingPractice;

public class SetDefaultUncaughtExceptionHandlerDemo {
    public static void main(String[] args) {
        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println(t + " (default handler) throws exception: " + e);
            }
        });
        Thread thr1 = new Thread(new MyThread1());
        Thread thr2 = new Thread(new MyThread1());
        thr2.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println(t + " throws exception " + e);
            }
        });
        thr1.start();
        thr2.start();
    }
}

class MyThread1 implements Runnable{

    @Override
    public void run() {
        throw new RuntimeException();

    }
}