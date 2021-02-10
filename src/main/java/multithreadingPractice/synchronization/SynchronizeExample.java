package multithreadingPractice.synchronization;

import javax.accessibility.AccessibleAction;

public class SynchronizeExample {
    public static void main(String[] args) {
        Account account = new Account(200);
        OperatorDeposit opD = new OperatorDeposit(account);
        OperatorWithdraw opW = new OperatorWithdraw(account);
        opD.start();
        opW.start();
        try {
            opD.join();
            opW.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(account.getBalance());
    }
}

////syncronized method example

//class Account{
//    private int balance;
//
//    public Account(int balance) {
//        this.balance = balance;
//    }
//
//    public int getBalance() {
//        return balance;
//    }
//    public synchronized void deposit(int amount){
//        int x = balance + amount;
//        try {
//            Thread.sleep(15);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        balance = x;
//    }
//    public synchronized void withdraw(int amount){
//        int x = balance -  amount;
//        try {
//            Thread.sleep(20);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        balance = x;
//    }
//}

/// syncronized block example
//class Account {
//    private int balance;
//    private Object lock = new Object();
//
//    public Account(int balance) {
//        this.balance = balance;
//    }
//
//    public int getBalance() {
//        return balance;
//    }
//
//    public void deposit(int amount) {
//        synchronized (lock) {
//            int x = balance + amount;
//            try {
//                Thread.sleep(15);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            balance = x;
//        }
//    }
//
//    public void withdraw(int amount) {
//        synchronized (lock) {
//            int x = balance - amount;
//            try {
//                Thread.sleep(20);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            balance = x;
//        }
//
//    }
//}

//synchronized with block
class Account {
    private int balance;

    public Account(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    public void deposit(int amount) {
        synchronized (this) {
            int x = balance + amount;
            try {
                Thread.sleep(15);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            balance = x;
        }
    }

    public void withdraw(int amount) {
        synchronized (this) {
            int x = balance - amount;
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            balance = x;
        }

    }
}


class OperatorDeposit extends Thread {
    private Account account;

    public OperatorDeposit(Account account) {
        this.account = account;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            synchronized (account) {
                account.deposit(100);
                System.out.println(getName() + " " + account.getBalance());
                ;
            }

        }
    }
}

class OperatorWithdraw extends Thread {
    private Account account;

    public OperatorWithdraw(Account account) {
        this.account = account;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            synchronized (account) {
                account.withdraw(50);
                System.out.println(getName() + " " + account.getBalance());
                ;
            }
        }
    }
}