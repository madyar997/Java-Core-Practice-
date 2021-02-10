package concurrent_practice;

import java.util.Random;
import java.util.concurrent.PriorityBlockingQueue;

public class Syncronized_collections {
    public static void main(String[] args) {
        QueueTask pbQueue = new QueueTask();
        for (int i = 0; i < 10; i++) {
            pbQueue.setTask(new Task(i));
        }
        Manager manager1 = new Manager(pbQueue, "John");
        Manager manager2 = new Manager(pbQueue, "Paul");

        Thread th1 = new Thread(manager1);
        Thread th2 = new Thread(manager2);
        th1.start();
        th2.start();
        try{
            th1.join();
            th2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

class Task implements Comparable<Task>{
    private int taskNumber;

    public Task(int taskNumber) {
        this.taskNumber = taskNumber;
    }

    public int getTaskNumber() {
        return taskNumber;
    }

    public void setTaskNumber(int taskNumber) {
        this.taskNumber = taskNumber;
    }

    @Override
    public int compareTo(Task o) {
        Random random = new Random();
        int comp = random.nextInt(2000);
        if(comp % 2 == 0){
            return 1;
        }
        else if (comp % 3 == 0){
            return -1;
        }
        return 0;
    }
}

class QueueTask{
    private PriorityBlockingQueue<Task> queue = new PriorityBlockingQueue<Task>();
    public Task getTask(){
        return queue.poll();
    }
    public void setTask(Task task){
        queue.add(task);
    }
    public PriorityBlockingQueue<Task> getQueue(){
        return queue;
    }
}

class Manager implements Runnable{
    public QueueTask pbQ;
    private String name;

    public Manager(QueueTask pbQ, String name) {
        this.pbQ = pbQ;
        this.name = name;
    }

    @Override
    public void run() {
        Task task;
        while((task = pbQ.getTask()) != null){
            System.out.println(name + " get task number " + task.getTaskNumber());
        }
    }
}