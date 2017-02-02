package newCalendar;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class UnitTestGregorian {
    private Gregorian gregorian;

    @Before
    public void initTest() {
        gregorian = new Gregorian();
    }

    @Test
    public void leapTest() {
        assertFalse(gregorian.isLeap(-1000));
        assertFalse(gregorian.isLeap(-802));
        assertFalse(gregorian.isLeap(-901));
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
        assertTrue(gregorian.isLeap(1992));
        assertTrue(gregorian.isLeap(1996));
        assertTrue(gregorian.isLeap(2004));
        assertTrue(gregorian.isLeap(2000));
        assertTrue(gregorian.isLeap(2400));
        assertTrue(gregorian.isLeap(2800));
        assertFalse(gregorian.isLeap(1800));
        assertFalse(gregorian.isLeap(1900));
        assertFalse(gregorian.isLeap(2100));
        assertFalse(gregorian.isLeap(2200));
        assertFalse(gregorian.isLeap(2300));
        assertFalse(gregorian.isLeap(1990));
        assertFalse(gregorian.isLeap(1991));
        assertTrue(gregorian.isLeap(1992));
        assertFalse(gregorian.isLeap(1993));
        assertFalse(gregorian.isLeap(1994));
        assertFalse(gregorian.isLeap(1995));
        assertTrue(gregorian.isLeap(1996));
        assertFalse(gregorian.isLeap(1997));
        assertFalse(gregorian.isLeap(1998));
        assertFalse(gregorian.isLeap(1999));
        assertTrue(gregorian.isLeap(2000));
        assertFalse(gregorian.isLeap(2001));
        assertFalse(gregorian.isLeap(2002));
        assertFalse(gregorian.isLeap(2003));
        assertTrue(gregorian.isLeap(2004));
        assertFalse(gregorian.isLeap(2005));
        assertFalse(gregorian.isLeap(2006));
        assertFalse(gregorian.isLeap(2007));
        assertTrue(gregorian.isLeap(2008));
        assertFalse(gregorian.isLeap(2009));
        assertFalse(gregorian.isLeap(2010));
        assertFalse(gregorian.isLeap(2011));
        assertTrue(gregorian.isLeap(2012));
        assertFalse(gregorian.isLeap(2013));
        assertFalse(gregorian.isLeap(2014));
        assertFalse(gregorian.isLeap(2015));
        assertTrue(gregorian.isLeap(2016));
        assertFalse(gregorian.isLeap(2017));
        assertFalse(gregorian.isLeap(2018));
        assertFalse(gregorian.isLeap(2019));
        assertTrue(gregorian.isLeap(2020));
        assertFalse(gregorian.isLeap(2021));
        assertFalse(gregorian.isLeap(2022));
        assertFalse(gregorian.isLeap(2023));
        assertTrue(gregorian.isLeap(2024));
        assertFalse(gregorian.isLeap(2025));
        assertFalse(gregorian.isLeap(2026));
        assertFalse(gregorian.isLeap(2027));
        assertTrue(gregorian.isLeap(2028));
        assertFalse(gregorian.isLeap(2029));
    }

    @Test
    public void to_jdTest() {
        assertEquals(gregorian.to_jd(2016, 2, 4), 2457423);
        assertEquals(gregorian.to_jd(0, 0, 0), 1721028);
        assertEquals(gregorian.to_jd(1, 1, 1), 1721426);
        assertEquals(gregorian.to_jd(-2, 1, 1), 1720330);
        assertEquals(gregorian.to_jd(-1, -1, -1), 1720632);
        assertEquals(gregorian.to_jd(-17, -1, -1), 1714788);
        assertEquals(gregorian.to_jd(-17, 1, 1), 1714851);
        assertEquals(gregorian.to_jd(-17, 2, 28), 1714909);
        assertEquals(gregorian.to_jd(-17, 2, 29), 1714910);
        assertEquals(gregorian.to_jd(-17, 3, 1), 1714911);
        assertEquals(gregorian.to_jd(-16, 2, 28), 1715274);
        assertEquals(gregorian.to_jd(-16, 2, 29), 1715275);
        assertEquals(gregorian.to_jd(-16, 3, 1), 1715275);
        assertEquals(gregorian.to_jd(16, 3, 1), 1726964);
        assertEquals(gregorian.to_jd(16, 2, 29), 1726963);
        assertEquals(gregorian.to_jd(16, 2, 28), 1726962);
        assertEquals(gregorian.to_jd(15, 3, 1), 1726598);
        assertEquals(gregorian.to_jd(15, 2, 29), 1726598);
        assertEquals(gregorian.to_jd(15, 2, 28), 1726597);
        assertEquals(gregorian.to_jd(20000, 2, 28), 9025968);
        assertEquals(gregorian.to_jd(2000, 12, 31), 2451910);
        assertEquals(gregorian.to_jd(2001, 1, 1), 2451911);
        assertEquals(gregorian.to_jd(2001, 11, 30), 2452244);
        assertEquals(gregorian.to_jd(2001, 12, 1), 2452245);
        assertEquals(gregorian.to_jd(800, 12, 1), 2013589);
        assertEquals(gregorian.to_jd(800, 7, 11), 2013446);
        assertEquals(gregorian.to_jd(800, 3, 5), 2013318);
        assertEquals(gregorian.to_jd(801, 12, 1), 2013954);
        assertEquals(gregorian.to_jd(801, 7, 11), 2013811);
        assertEquals(gregorian.to_jd(801, 3, 5), 2013683);
    }
}