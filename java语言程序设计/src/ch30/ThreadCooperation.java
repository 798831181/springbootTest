package ch30;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadCooperation {
    private static Account account = new Account();

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.execute(new DepositTask());
        executorService.execute(new WithdrawTask());
        executorService.shutdown();
    }
    /**
     * 存款任务
     */
    public static class DepositTask implements Runnable{

        @Override
        public void run() {
            try {
                while (true){
                    account.deposit((int)((Math.random() * 10) + 1));
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                    e.printStackTrace();
            }
        }
    }
    /**
     * 取款任务
     */
    public static class WithdrawTask implements Runnable{

        @Override
        public void run() {
            while (true){
                account.withdraw((int)(Math.random() * 10) + 1);

            }

        }
    }
    public static class Account{
        private static Lock lock = new ReentrantLock();
        private static Condition condition = lock.newCondition();
        private int balance = 0;

        public int getBalance() {
            return balance;
        }
        public void withdraw(int amount){
            lock.lock();
            try {
                while (balance < amount) {
                    System.out.println("Wait for a deposit");
                    condition.await();
                }
                balance -= amount;
                System.out.println("\t\t\twithdraw " + amount + "\t\t" + getBalance());
            }
            catch (InterruptedException e) {
                e.printStackTrace();
                }
            finally {
                lock.unlock();
            }
        }
        public void deposit(int amount){
            lock.lock();
            try {
                balance += amount;
                System.out.println("Deposit " + amount +"\t\t\t" + getBalance());
                condition.signalAll();
            }finally {
                lock.unlock();
            }

        }
    }
}
