package tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SmartDoorLockTest {

    private static final int INITIAL_PIN = 1234;
    private static final int ILLEGAL_PIN = 12345;
    private static final int WRONG_PIN = 1111;

    private SmartDoorLock smartDoorLock;
    private int pin = INITIAL_PIN;

    @BeforeEach
    public void beforeEach() {
        this.smartDoorLock = new SmartDoorLockImpl();
    }

    @Test
    public void isInitiallyUnlocked() {
        assertFalse(this.smartDoorLock.isLocked());
    }

    private void lock() {
        this.smartDoorLock.setPin(this.pin);
        this.smartDoorLock.lock();
    }

    @Test
    public void canLock() {
        lock();
        assertTrue(this.smartDoorLock.isLocked());
    }

    @Test
    public void cantLockIfPinNotSet() {
        assertThrows(IllegalStateException.class, () -> this.smartDoorLock.lock());
    }

    @Test
    public void setIllegalPin() {
        assertThrows(IllegalArgumentException.class, () -> this.smartDoorLock.setPin(ILLEGAL_PIN));
    }

    @Test
    public void cantSetPinWhenLocked() {
        lock();
        assertThrows(IllegalStateException.class, () -> this.smartDoorLock.setPin(this.pin));
    }

    @Test
    public void canUnlock() {
        lock();
        this.smartDoorLock.unlock(this.pin);
        assertFalse(this.smartDoorLock.isLocked());
    }

    @Test
    public void cantUnlockWithWrongPin() {
        lock();
        this.smartDoorLock.unlock(WRONG_PIN);
        assertTrue(this.smartDoorLock.isLocked());
    }

    private void block() {
        for (int i = 0; i < this.smartDoorLock.getMaxAttempts(); i++) {
            this.smartDoorLock.unlock(WRONG_PIN);
        }
    }

    @Test
    public void isBlockedAfterMaxFailedAttempts() {
        lock();
        block();
        assertTrue(this.smartDoorLock.isBlocked());
    }

    @Test
    public void getNumberOfFailedAttempts() {
        lock();
        for (int i = 0; i < this.smartDoorLock.getMaxAttempts() - 1; i++) {
            this.smartDoorLock.unlock(WRONG_PIN);
        }
        assertEquals(this.smartDoorLock.getMaxAttempts() - 1, this.smartDoorLock.getFailedAttempts());
    }

    @Test
    public void canReset() {
        lock();
        block();
        this.smartDoorLock.reset();
        assertAll(
                () -> {
                    assertFalse(this.smartDoorLock.isLocked());
                    assertFalse(this.smartDoorLock.isBlocked());
                    assertEquals(0, this.smartDoorLock.getFailedAttempts());
                }
        );
    }

}
