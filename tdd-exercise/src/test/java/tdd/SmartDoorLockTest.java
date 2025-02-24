package tdd;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SmartDoorLockTest {

    @Test
    public void isInitiallyUnlocked() {
        SmartDoorLock smartDoorLock = new SmartDoorLockImpl();
        assertFalse(smartDoorLock.isLocked());
    }

    @Test
    public void canLock() {
        SmartDoorLock smartDoorLock = new SmartDoorLockImpl();
        smartDoorLock.setPin(1234);
        smartDoorLock.lock();
        assertTrue(smartDoorLock.isLocked());
    }
}
