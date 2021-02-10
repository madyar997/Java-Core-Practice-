package multithreadingPractice.synchronization;

public class StaticSyncronizationExample {
    public static void main(String[] args) {
        new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    try {
                        StaticSynch.a();
                        Thread.sleep(20);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();

        for (int i = 0; i < 5; i++) {
            try {
                StaticSynch.b();
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}

class StaticSynch{
    public static synchronized void a() throws InterruptedException {
        System.out.println("Line #1 in the method a");
        Thread.sleep(1000);
        System.out.println("Line #2 in the method a");
    }

    public static synchronized void b() throws InterruptedException {
        System.out.println("Line #1 in the method b");
        Thread.sleep(1000);
        System.out.println("Line #2 in the method b");
    }
}