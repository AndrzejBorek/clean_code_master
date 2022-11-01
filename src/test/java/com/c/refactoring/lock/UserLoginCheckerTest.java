package com.c.refactoring.lock;

import java.util.Arrays;
import java.util.Date;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserLoginCheckerTest {
    UserLoginChecker userLoginChecker = new UserLoginChecker();
    private final String TEST_USER_ID_1 = "TEST_USER_ID_1";
    private final String TEST_USER_ID_2 = "TEST_USER_ID_2";
    private static final boolean IS_FIRST_SCREEN_TRUE = true;
    private static final boolean IS_FIRST_SCREEN_FALSE = false;

    private final int ID = 10;

    @Test
    public void testisUserAllowedToLogin_DifferentUserTriesImmediatelyAfter() {
        //given
        Object[] access = new Object[]{TEST_USER_ID_1, new Date()};
        //when
        Lock lock = userLoginChecker.isUserAllowedToLogin( IS_FIRST_SCREEN_TRUE, new User(
                TEST_USER_ID_2), Arrays.asList(new Object[][]{access}));
        //then
        assertAll(
                () -> assertTrue(lock.isReadAccess()),
                () -> assertNotNull(lock.getLockReason())
        );
    }

    @Test
    public void testisUserAllowedToLogin_SameUserReturnsToFirstScreen() {
        //given
        Object[] access = new Object[]{TEST_USER_ID_1, new Date()};
        //when
        Lock lock = userLoginChecker.isUserAllowedToLogin( IS_FIRST_SCREEN_TRUE, new User(
                TEST_USER_ID_1), Arrays.asList(new Object[][]{access}));
        //then
        assertAll(
                () -> assertFalse(lock.isReadAccess()),
                () -> assertNull(lock.getLockReason())
        );
    }

    @Test
    public void testisUserAllowedToLogin_SameUserReturnsToSecondScreen() {
        //given
        Object[] access = new Object[]{TEST_USER_ID_1, new Date()};
        //when
        Lock lock = userLoginChecker.isUserAllowedToLogin( IS_FIRST_SCREEN_FALSE, new User(
                TEST_USER_ID_1), Arrays.asList(new Object[][]{access}));
        //then
        assertAll(
                () -> assertFalse(lock.isReadAccess()),
                () -> assertNull(lock.getLockReason())
        );
    }

    @Test
    public void testisUserAllowedToLogin_User2TriesToLoginToFirstScreen3hoursAfterUser1() {
        //given
        Object[] access = new Object[]{TEST_USER_ID_1, threeHoursBefore()};
        //when
        Lock lock = userLoginChecker.isUserAllowedToLogin( IS_FIRST_SCREEN_TRUE, new User(
                TEST_USER_ID_2), Arrays.asList(new Object[][]{access}));
        //then
        assertAll(
                () -> assertFalse(lock.isReadAccess()),
                () -> assertNull(lock.getLockReason()));
    }

    @Test
    public void testisUserAllowedToLogin_User2TriesToLoginToSecondScreen3hoursAfterUser1() {
        //given
        Object[] access = new Object[]{TEST_USER_ID_1, threeHoursBefore()};
        //when
        Lock lock = userLoginChecker.isUserAllowedToLogin(IS_FIRST_SCREEN_FALSE, new User(
                TEST_USER_ID_2), Arrays.asList(new Object[][]{access}));
        //then
        assertAll(
                () -> assertTrue(lock.isReadAccess()),
                () -> assertNotNull(lock.getLockReason())
        );
    }

    public Date threeHoursBefore() {
        Date now = new Date();
        return new Date(now.getTime() - 3 * 60 * 60 * 1000);
    }

}
