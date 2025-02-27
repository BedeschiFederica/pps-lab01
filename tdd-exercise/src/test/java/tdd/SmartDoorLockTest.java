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
    public void setPinWhenLocked() {
        this.smartDoorLock.setPin(this.pin);
        this.smartDoorLock.lock();
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

    @Test
    public void canBlock() {
        lock();
        for (int i = 0; i < this.smartDoorLock.getMaxAttempts(); i++) {
            this.smartDoorLock.unlock(WRONG_PIN);
        }
        assertTrue(this.smartDoorLock.isBlocked());
    }

}
