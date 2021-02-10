package multithreadingPractice;

public class MtPractice {
    public static void main(String[] args) {
        Thread talk = new Thread(new Talk());
        talk.start();
        try {
            talk.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Walk walk = new Walk();
        walk.start();


    }
}
class Talk implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Talking ...");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Talking finished");

    }
}

class Walk extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Walking ...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Walking finished");
    }
}

class DaemonThread extends Thread{
    @Override
    public void run() {
        int i =0;
        while(i < 100000){
            System.out.println("Daemon thread is working");
            i++;
        };

    }
}
