package tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SmartDoorLockTest {

    private static final int INITIAL_PIN = 1234;
    private static final int ILLEGAL_PIN = 12345;

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

    @Test
    public void canLock() {
        smartDoorLock.setPin(this.pin);
        smartDoorLock.lock();
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
}
