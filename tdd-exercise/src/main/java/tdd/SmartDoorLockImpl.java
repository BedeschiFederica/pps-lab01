package tdd;

public class SmartDoorLockImpl implements SmartDoorLock {

    private static final int MIN_PIN = 0;
    private static final int MAX_PIN = 9999;
    private static final int MAX_ATTEMPTS = 3;

    private boolean blocked = false;
    private boolean locked = false;
    private int pin;
    private boolean isPinSet  = false;
    private int failedAttempts = 0;


    private void checkPin(final int pin) {
        if (pin < MIN_PIN || pin > MAX_PIN) {
            throw new IllegalArgumentException("Pin must have 4 digits.");
        }
    }

    private void checkState() {
        if (this.locked) {
            throw new IllegalStateException("Can't set pin when locked.");
        }
    }

    @Override
    public void setPin(final int pin) {
        checkPin(pin);
        checkState();
        this.pin = pin;
        isPinSet = true;
    }

    private void blockIfNecessary() {
        if (this.failedAttempts == MAX_ATTEMPTS) {
            this.blocked = true;
        }
    }

    @Override
    public void unlock(final int pin) {
        if (pin == this.pin) {
            this.locked = false;
        } else {
            this.failedAttempts++;
            blockIfNecessary();
        }
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
        return this.blocked;
    }

    @Override
    public int getMaxAttempts() {
        return MAX_ATTEMPTS;
    }

    @Override
    public int getFailedAttempts() {
        return this.failedAttempts;
    }

    @Override
    public void reset() {

    }
}
