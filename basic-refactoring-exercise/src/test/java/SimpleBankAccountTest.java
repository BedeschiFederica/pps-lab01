import example.model.AccountHolder;
import example.model.BankAccount;
import example.model.SimpleBankAccount;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * The test suite for testing the SimpleBankAccount implementation
 */
class SimpleBankAccountTest {

    private static final int INITIAL_BALANCE = 0;
    private static final int DEPOSIT_AMOUNT = 100;
    private static final int WITHDRAW_AMOUNT = 70;
    private static final int WITHDRAW_ILLEGAL_AMOUNT = 200;

    private AccountHolder accountHolder;
    private BankAccount bankAccount;

    @BeforeEach
    void beforeEach(){
        this.accountHolder = new AccountHolder("Mario", "Rossi");
        this.bankAccount = new SimpleBankAccount(this.accountHolder, INITIAL_BALANCE);
    }

    @Test
    void testDifferentIdsForDifferentAccounts() {
        final AccountHolder anotherAccountHolder = new AccountHolder("Maria", "Bianchi");
        assertNotEquals(this.accountHolder.getId(), anotherAccountHolder.getId());
    }

    @Test
    void testInitialBalance() {
        assertEquals(INITIAL_BALANCE, this.bankAccount.getBalance());
    }

    private void deposit() {
        this.bankAccount.deposit(this.accountHolder.getId(), DEPOSIT_AMOUNT);
    }

    @Test
    void testDeposit() {
        deposit();
        assertEquals(DEPOSIT_AMOUNT, this.bankAccount.getBalance());
    }

    private void wrongDeposit() {
        this.bankAccount.deposit(this.accountHolder.getId() + 1, DEPOSIT_AMOUNT);
    }

    @Test
    void testWrongDeposit() {
        deposit();
        assertThrows(IllegalArgumentException.class, this::wrongDeposit);
    }

    @Test
    void testCorrectBalanceAfterWrongDeposit() {
        deposit();
        try {
            wrongDeposit();
        } catch (IllegalArgumentException e) {
        }
        assertEquals(DEPOSIT_AMOUNT, this.bankAccount.getBalance());
    }

    @Test
    void testWithdraw() {
        deposit();
        this.bankAccount.withdraw(this.accountHolder.getId(), WITHDRAW_AMOUNT);
        assertEquals(DEPOSIT_AMOUNT - WITHDRAW_AMOUNT - SimpleBankAccount.WITHDRAW_FEE,
                this.bankAccount.getBalance());
    }

    private void withdrawWithWrongId() {
        this.bankAccount.withdraw(this.accountHolder.getId() + 1, WITHDRAW_AMOUNT);
    }

    @Test
    void testWithdrawWithWrongId() {
        deposit();
        assertThrows(IllegalArgumentException.class, this::withdrawWithWrongId);
    }

    @Test
    void testWithdrawWithIllegalAmount() {
        deposit();
        assertThrows(IllegalStateException.class,
                () -> this.bankAccount.withdraw(this.accountHolder.getId(), WITHDRAW_ILLEGAL_AMOUNT));
    }

    @Test
    void testCorrectBalanceAfterWithdrawWithWrongId() {
        deposit();
        try {
            withdrawWithWrongId();
        } catch (IllegalArgumentException e) {
        }
        assertEquals(DEPOSIT_AMOUNT, this.bankAccount.getBalance());
    }

    @Test
    void testWithdrawSameAmountOfBalance() {
        deposit();
        assertThrows(IllegalStateException.class,
                () -> this.bankAccount.withdraw(this.accountHolder.getId(), DEPOSIT_AMOUNT));
    }

}
