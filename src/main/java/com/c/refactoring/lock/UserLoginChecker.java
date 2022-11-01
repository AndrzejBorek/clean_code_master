package com.c.refactoring.lock;

import java.util.Date;
import java.util.List;

public class UserLoginChecker {

    private int MAX_LOCK_PERIOD_IN_MS = 60 * 60 * 1000;

    /**
     * {@inheritDoc}.
     */
    public Lock isUserAllowedToLogin(boolean isFirstScreen, User userTryingToLogin, List existingLocks) {

        if (existingLocks.size() == 0 || existingLocks.get(0) == null)
            return createWriteLock();

        Object[] existingLock = (Object[]) existingLocks.get(0);
        String userIdWithLock = (String) existingLock[0];
        Date lockTimestamp = (Date) existingLock[1];

        if (userIdWithLock == null) {
            return createWriteLock();
        }

        //if userID is present, the Lock time stamp will also be present

        if (userIdWithLock.equalsIgnoreCase(userTryingToLogin.getUserId())) {
            return createWriteLock();
        }

        long timeElapsedSinceLock = new Date().getTime() - lockTimestamp.getTime();
        if (timeElapsedSinceLock > MAX_LOCK_PERIOD_IN_MS && isFirstScreen) {
            return createWriteLock();
        }

        return createReadLock(userIdWithLock);

    }

    private static Lock createReadLock(String userIdWithLock) {
        String messageShownToUser = Constants.LOCK_TEXT.replaceAll("@@USER@@", userIdWithLock);
        Lock lock = new Lock();
        lock.setRead(true);
        //Only read access is permitted to other user
        lock.setLockReason(messageShownToUser);
        return lock;
    }

    private static Lock createWriteLock() {
        Lock lock = new Lock();
        lock.setRead(false);
        return lock;
    }
}