package multithreadingPractice;

public class ThreadGropuUncaughtExceptionDemo {
    public static void main(String[] args) {
        NewThreadGroup g = new NewThreadGroup("one");
        Thread t1 = new ThreadD(g,"1");
        Thread t2 = new ThreadD(g,"2");
        Thread t3 = new ThreadD(g,"3");
        t3.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println(t + "throws exception: " + e);
            }
        });
        t1.start();
        t2.start();
        t3.start();
    }
}

class NewThreadGroup extends ThreadGroup{

    public NewThreadGroup(String name) {
        super(name);
    }

    public NewThreadGroup(ThreadGroup parent, String name) {
        super(parent, name);
    }
    public void uncaughtException(Thread t, Throwable e){
        System.out.println(t + " has unhandled exception: " + e);
    }
}
class ThreadD extends Thread{
    public ThreadD(ThreadGroup group, String name) {
        super(group, name);
    }

    @Override
    public void run() {
        throw new RuntimeException("Oy, exception!!!  ");
    }
}