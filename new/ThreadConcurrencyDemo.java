/**
 * ThreadConcurrencyDemo.java
 * Demonstrates:
 * 1. Creating Threads using Thread class and Runnable interface
 * 2. Thread states and lifecycle (start, sleep, join)
 * 3. Thread Synchronization to prevent race conditions
 * 4. Inter-thread Cooperation using wait() and notify()
 */

// Shared Bank Account demonstrating Thread Synchronization and Cooperation
class BankAccount {
    private int balance = 1000;

    public synchronized int getBalance() {
        return balance;
    }

    // Synchronized deposit method with notify()
    public synchronized void deposit(String user, int amount) {
        System.out.println(user + " is depositing: $" + amount);
        balance += amount;
        System.out.println(user + " completed deposit. Updated Balance: $" + balance);
        // Notify waiting threads that funds are available
        notify();
    }

    // Synchronized withdraw method with wait() for thread cooperation
    public synchronized void withdraw(String user, int amount) {
        System.out.println(user + " wants to withdraw: $" + amount);
        while (balance < amount) {
            System.out.println("Insufficient balance ($" + balance + "). " + user + " is WAITING for deposit...");
            try {
                wait(); // Release lock and wait for deposit notification
            } catch (InterruptedException e) {
                System.err.println("Thread interrupted: " + e.getMessage());
            }
        }
        balance -= amount;
        System.out.println(user + " successfully withdrew: $" + amount + ". Remaining Balance: $" + balance);
    }
}

// 1. Task created using Runnable interface
class DepositTask implements Runnable {
    private BankAccount account;
    private String name;
    private int amount;

    public DepositTask(BankAccount account, String name, int amount) {
        this.account = account;
        this.name = name;
        this.amount = amount;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000); // Simulate processing time
            account.deposit(name, amount);
        } catch (InterruptedException e) {
            System.err.println(name + " interrupted.");
        }
    }
}

// 2. Thread created by extending Thread class
class WithdrawThread extends Thread {
    private BankAccount account;
    private String name;
    private int amount;

    public WithdrawThread(BankAccount account, String name, int amount) {
        this.account = account;
        this.name = name;
        this.amount = amount;
    }

    @Override
    public void run() {
        account.withdraw(name, amount);
    }
}

public class ThreadConcurrencyDemo {
    public static void main(String[] args) {
        System.out.println("=================================================");
        System.out.println("   CO4: Thread Concurrency & Synchronization     ");
        System.out.println("=================================================");

        BankAccount sharedAccount = new BankAccount();
        System.out.println("Initial Account Balance: $" + sharedAccount.getBalance());

        // Create threads
        WithdrawThread withdrawer1 = new WithdrawThread(sharedAccount, "Alice (WithdrawThread)", 1500);
        Thread depositor1 = new Thread(new DepositTask(sharedAccount, "Bob (DepositRunnable)", 800));

        // Display Thread States
        System.out.println("\n--- Thread States Before Starting ---");
        System.out.println("Alice Thread State: " + withdrawer1.getState());
        System.out.println("Bob Thread State  : " + depositor1.getState());

        System.out.println("\n--- Starting Concurrent Operations ---");
        withdrawer1.start(); // Alice attempts to withdraw 1500 (has only 1000 -> will wait)
        depositor1.start();  // Bob will deposit 800 after 1s -> wakes Alice up

        try {
            // Wait for both threads to finish execution
            withdrawer1.join();
            depositor1.join();
        } catch (InterruptedException e) {
            System.err.println("Main thread interrupted: " + e.getMessage());
        }

        System.out.println("\n--- Thread States After Completion ---");
        System.out.println("Alice Thread State: " + withdrawer1.getState());
        System.out.println("Bob Thread State  : " + depositor1.getState());
        System.out.println("Final Account Balance: $" + sharedAccount.getBalance());
        System.out.println("=================================================");
    }
}
