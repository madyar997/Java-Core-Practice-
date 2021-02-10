package multithreadingPractice;

public class ThreadGroupDemo {
    public static void main(String[] args) {
    ThreadGroup threadGroupA = new ThreadGroup("Group A");
    ThreadGroup threadGroupB = new ThreadGroup("Group B");
    NewThread ob1 = new NewThread("one", threadGroupA);
    NewThread ob2 = new NewThread("two", threadGroupA);
    NewThread ob3 = new NewThread("three", threadGroupB);
    NewThread ob4 = new NewThread("four", threadGroupB);
        try {
            Thread.sleep(2500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        threadGroupA.interrupt();
    }
}
class NewThread extends Thread {

    public NewThread(String name, ThreadGroup threadGroupA) {
        super(threadGroupA, name);
        System.out.println("New Thread "+ this);
        start();
    }

    @Override
    public void run() {
        try {
            for (int i = 5; i > 0; i--) {
                System.out.println(getName() + ": " + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println(getName() + " interrupted.");
        }
        System.out.println(getName() + " exiting");
    }
}
