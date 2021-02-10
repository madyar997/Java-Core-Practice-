package multithreadingPractice;

public class VolotileDemo {
    public static void main(String[] args) throws InterruptedException {
        Clicker1 clicker1 = new Clicker1();
        clicker1.start();
        Thread.sleep(50);
        clicker1.stopClick();
        clicker1.join();

        System.out.println("Последний оператора метода main ()");
    }
}

class Clicker1 extends Thread {
    private int click = 0;
    private volatile boolean running = true;
    Clicker1 (){
    }

    @Override
    public void run() {
        while(running){
            click++;
        }
    }
    public void stopClick(){
        running = false;
    }
}