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
        assertFalse(smartDoorLock.isLocked());
    }

    private void lock() {
        smartDoorLock.setPin(this.pin);
        smartDoorLock.lock();
    }

    @Test
    public void canLock() {
        lock();
        assertTrue(smartDoorLock.isLocked());
    }

    @Test
    public void cantLockIfPinNotSet() {
        assertThrows(IllegalStateException.class, () -> smartDoorLock.lock());
    }

    @Test
    public void setIllegalPin() {
        assertThrows(IllegalArgumentException.class, () -> smartDoorLock.setPin(ILLEGAL_PIN));
    }

    @Test
    public void setPinWhenLocked() {
        smartDoorLock.setPin(this.pin);
        smartDoorLock.lock();
        assertThrows(IllegalStateException.class, () -> smartDoorLock.setPin(this.pin));
    }

    @Test
    public void canUnlock() {
        lock();
        smartDoorLock.unlock(this.pin);
        assertFalse(smartDoorLock.isLocked());
    }

    @Test
    public void cantUnlockWithWrongPin() {
        lock();
        smartDoorLock.unlock(WRONG_PIN);
        assertTrue(smartDoorLock.isLocked());
    }

}
