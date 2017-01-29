package newCalendar;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class UnitTestGregorian {

    private Gregorian gregorian;

    public UnitTestGregorian() {
        gregorian = new Gregorian();
    }

    @Test
    public void leap() {
        assertFalse(gregorian.isLeap(-1000));
        assertFalse(gregorian.isLeap(-802));
        assertTrue(gregorian.isLeap(-801));
        assertFalse(gregorian.isLeap(-800));
        assertFalse(gregorian.isLeap(-402));
        assertTrue(gregorian.isLeap(-401));
        assertFalse(gregorian.isLeap(-400));
        assertFalse(gregorian.isLeap(-201));
        assertFalse(gregorian.isLeap(-200));
        assertFalse(gregorian.isLeap(-199));
        assertFalse(gregorian.isLeap(-101));
        assertFalse(gregorian.isLeap(-100));
        assertFalse(gregorian.isLeap(-99));
        assertFalse(gregorian.isLeap(-18));
        assertTrue(gregorian.isLeap(-17));
        assertFalse(gregorian.isLeap(-16));
        assertFalse(gregorian.isLeap(-6));
        assertTrue(gregorian.isLeap(-5));
        assertFalse(gregorian.isLeap(-4));
        assertFalse(gregorian.isLeap(-2));
        assertTrue(gregorian.isLeap(-1));
        assertFalse(gregorian.isLeap(0));
        assertFalse(gregorian.isLeap(1));
        assertFalse(gregorian.isLeap(2));
        assertFalse(gregorian.isLeap(3));
        assertTrue(gregorian.isLeap(4));
        assertFalse(gregorian.isLeap(5));
        assertFalse(gregorian.isLeap(15));
        assertTrue(gregorian.isLeap(16));
        assertFalse(gregorian.isLeap(17));
        assertFalse(gregorian.isLeap(18));
        assertFalse(gregorian.isLeap(99));
        assertFalse(gregorian.isLeap(100));
        assertFalse(gregorian.isLeap(101));
        assertFalse(gregorian.isLeap(399));
        assertTrue(gregorian.isLeap(400));
        assertFalse(gregorian.isLeap(401));
        assertFalse(gregorian.isLeap(799));
        assertTrue(gregorian.isLeap(800));
        assertFalse(gregorian.isLeap(801));
        assertFalse(gregorian.isLeap(1000));
    }
}