package tdd;

public class SmartDoorLockImpl implements SmartDoorLock {

    private boolean locked = false;
    private int pin;
    private boolean isPinSet  = false;

    @Override
    public void setPin(final int pin) {
        this.pin = pin;
        isPinSet = true;
    }

    @Override
    public void unlock(final int pin) {

    }

    @Override
    public void lock() {
        if (!isPinSet) {
            throw new IllegalStateException("Pin is not set.");
        }
        this.locked = true;
    }

    @Override
    public boolean isLocked() {
        return this.locked;
    }

    @Override
    public boolean isBlocked() {
        return false;
    }

    @Override
    public int getMaxAttempts() {
        return 0;
    }

    @Override
    public int getFailedAttempts() {
        return 0;
    }

    @Override
    public void reset() {

    }
}
