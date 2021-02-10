package multithreadingPractice;

import javax.print.attribute.standard.RequestingUserName;

public class PriorityDemo {
    public static void main(String[] args) {
        Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
        Clicker hi = new Clicker();
        Clicker lo = new Clicker();
        hi.setPriority(Thread.NORM_PRIORITY + 2);
        lo.setPriority(Thread.NORM_PRIORITY - 2);
        hi.start();
        lo.start();
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted.");
        }
        lo.stopClick();
        hi.stopClick();
        try {
            hi.join();
            lo.join();
        } catch (InterruptedException e) {
            System.out.println("Interrupted Exception caught");
        }
        System.out.println("lo : "+ lo.count);
        System.out.println("hi : "+ hi.count);



    }
}

class Clicker extends Thread{
    private volatile boolean running = true;
    int count = 0;
    @Override
    public void run() {
        while (running){
            count++;
        }
    }
    public void stopClick(){
        running = false;
    }
}