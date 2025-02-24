package tdd;

public class SmartDoorLockImpl implements SmartDoorLock {

    private static final int MIN_PIN = 0;
    private static final int MAX_PIN = 9999;

    private boolean locked = false;
    private int pin;
    private boolean isPinSet  = false;

    private void checkPin(final int pin) {
        if (pin < MIN_PIN || pin > MAX_PIN) {
            throw new IllegalArgumentException("Pin must have 4 digits.");
        }
    }

    @Override
    public void setPin(final int pin) {
        checkPin(pin);
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
