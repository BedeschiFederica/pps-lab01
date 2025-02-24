package tdd;

public class SmartDoorLockImpl implements SmartDoorLock {

    private boolean locked = false;
    private int pin;

    @Override
    public void setPin(final int pin) {
        this.pin = pin;
    }

    @Override
    public void unlock(final int pin) {

    }

    @Override
    public void lock() {
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
