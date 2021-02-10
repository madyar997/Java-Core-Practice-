package multithreadingPractice;

public class GetStateDemo implements Runnable {
    public static void main(String[] args) {
        Thread th1 = new Thread(new GetStateDemo());
        th1.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Thread.State state = th1.getState();
        System.out.println(th1.getName() + " " + state);
    }

    @Override
    public void run() {
        Thread.State state = Thread.currentThread().getState();
        System.out.println(Thread.currentThread().getName() + " " + state);
    }
}
