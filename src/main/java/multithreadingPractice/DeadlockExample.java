package multithreadingPractice;

public class DeadlockExample {
    public static void main(String[] args) {
        Account account1 = new Account(200);
        Account account2 = new Account(300);

        Operator op1 = new Operator(account1, account2);
        Operator op2 = new Operator(account1, account2);

        op1.start();
        op2.start();
    }
}

class Account{
    private int balance;

    public Account(int balance) {
        this.balance = balance;
    }

    public int getBalance(){
        return balance;
    }

    public void deposit(int amount){
        balance = balance + amount;
    }

    public void withdraw(int amount){
        balance = balance - amount;
    }
}

class Operator extends Thread{
    private Account account1;
    private Account account2;

    Operator(Account account1, Account account2){
        this.account1 = account1;
        this.account2 = account2;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            operationDeposit(10);
        }
    }

    private void operationDeposit(int depositSum){
        synchronized (account1){
            System.out.println("Заблокирован первый счет.");
            synchronized (account2){
                System.out.println("Заблокирован второй счет.");
                account1.deposit(depositSum);
                account2.withdraw(depositSum);
            }
        }
    }
}

