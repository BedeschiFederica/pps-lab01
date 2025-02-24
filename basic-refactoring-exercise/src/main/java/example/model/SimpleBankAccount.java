package example.model;

/**
 * This class represent a particular instance of a BankAccount.
 * In particular, a Simple Bank Account allows always the deposit
 * while the withdrawal is allowed only if the balance greater or equal the withdrawal amount
 */
public class SimpleBankAccount implements BankAccount {

    private double balance;
    private final AccountHolder holder;

    public SimpleBankAccount(final AccountHolder holder, final double balance) {
        this.holder = holder;
        this.balance = balance;
    }
    @Override
    public AccountHolder getHolder(){
        return this.holder;
    }

    @Override
    public double getBalance() {
        return this.balance;
    }

    private void checkUser(final int id) {
        if (this.holder.getId() != id) {
            throw new IllegalArgumentException("User ID does not match.");
        }
    }

    @Override
    public void deposit(final int userID, final double amount) {
        checkUser(userID);
        this.balance += amount;
    }

    private boolean isWithdrawAllowed(final double amount) {
        return this.balance >= amount;
    }

    @Override
    public void withdraw(final int userID, final double amount) {
        checkUser(userID);
        if (isWithdrawAllowed(amount)) {
            this.balance -= amount;
        } else {
            throw new IllegalStateException("Not enough money to withdraw.");
        }
    }
}
