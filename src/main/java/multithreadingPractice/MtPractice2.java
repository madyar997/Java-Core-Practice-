package multithreadingPractice;

public class MtPractice2 {
    public static void main(String[] args) {
        MyThread ob1 = new MyThread("one");
        MyThread ob2 = new MyThread("two");
        MyThread ob3 = new MyThread("three");
        for (int i = 0; i < 3; i++) {
            System.out.println("Thread" + ob1.name + ob1.t.isAlive());
        }
    }
}

class MyThread implements Runnable {
String name;
Thread t;

    public MyThread(String name) {
        this.name = name;
        t = new Thread(this, name);
        System.out.println("New Thread "+ t);
        t.start();
    }

    @Override
    public void run() {
        try {
            for (int i = 5; i > 0; i--) {
                System.out.println(name + ": " + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println(name + " interrupted.");
        }
        System.out.println(name + " exiting");
    }
}
