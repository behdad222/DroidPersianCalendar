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
        assertEquals(gregorian.to_jd(2015, 1, 1), 2457024);
        assertEquals(gregorian.to_jd(2015, 2, 1), 2457055);
        assertEquals(gregorian.to_jd(2015, 3, 1), 2457083);
        assertEquals(gregorian.to_jd(2015, 4, 1), 2457114);
        assertEquals(gregorian.to_jd(2015, 5, 1), 2457144);
        assertEquals(gregorian.to_jd(2015, 6, 1), 2457175);
        assertEquals(gregorian.to_jd(2015, 7, 1), 2457205);
        assertEquals(gregorian.to_jd(2015, 8, 1), 2457236);
        assertEquals(gregorian.to_jd(2015, 9, 1), 2457267);
        assertEquals(gregorian.to_jd(2015, 10, 1), 2457297);
        assertEquals(gregorian.to_jd(2015, 11, 1), 2457328);
        assertEquals(gregorian.to_jd(2015, 12, 1), 2457358);
        assertEquals(gregorian.to_jd(2016, 1, 1), 2457389);
        assertEquals(gregorian.to_jd(2016, 2, 1), 2457420);
        assertEquals(gregorian.to_jd(2016, 3, 1), 2457449);
        assertEquals(gregorian.to_jd(2016, 4, 1), 2457480);
        assertEquals(gregorian.to_jd(2016, 5, 1), 2457510);
        assertEquals(gregorian.to_jd(2016, 6, 1), 2457541);
        assertEquals(gregorian.to_jd(2016, 7, 1), 2457571);
        assertEquals(gregorian.to_jd(2016, 8, 1), 2457602);
        assertEquals(gregorian.to_jd(2016, 9, 1), 2457633);
        assertEquals(gregorian.to_jd(2016, 10, 1), 2457663);
        assertEquals(gregorian.to_jd(2016, 11, 1), 2457694);
        assertEquals(gregorian.to_jd(2016, 12, 1), 2457724);
        assertEquals(gregorian.to_jd(2017, 1, 1), 2457755);
        assertEquals(gregorian.to_jd(2017, 2, 1), 2457786);
        assertEquals(gregorian.to_jd(2017, 3, 1), 2457814);
        assertEquals(gregorian.to_jd(2017, 4, 1), 2457845);
        assertEquals(gregorian.to_jd(2017, 5, 1), 2457875);
        assertEquals(gregorian.to_jd(2017, 6, 1), 2457906);
        assertEquals(gregorian.to_jd(2017, 7, 1), 2457936);
        assertEquals(gregorian.to_jd(2017, 8, 1), 2457967);
        assertEquals(gregorian.to_jd(2017, 9, 1), 2457998);
        assertEquals(gregorian.to_jd(2017, 10, 1), 2458028);
        assertEquals(gregorian.to_jd(2017, 11, 1), 2458059);
        assertEquals(gregorian.to_jd(2017, 12, 1), 2458089);
    }

    @Test
    public void jd_toTest() {
        assertEquals(gregorian.jd_to(2013683).getDate(), "801/3/5");
        assertEquals(gregorian.jd_to(2013811).getDate(), "801/7/11");
        assertEquals(gregorian.jd_to(2013954).getDate(), "801/12/1");
        assertEquals(gregorian.jd_to(2013318).getDate(), "800/3/5");
        assertEquals(gregorian.jd_to(2013446).getDate(), "800/7/11");
        assertEquals(gregorian.jd_to(2013589).getDate(), "800/12/1");
        assertEquals(gregorian.jd_to(1000).getDate(), "-4710/8/20");
        assertEquals(gregorian.jd_to(-1000).getDate(), "-4715/2/27");
        assertEquals(gregorian.jd_to(2457423).getDate(), "2016/2/4");
        assertEquals(gregorian.jd_to(1721028).getDate(), "-1/11/29");
        assertEquals(gregorian.jd_to(1721426).getDate(), "1/1/1");
        assertEquals(gregorian.jd_to(1720330).getDate(), "-2/1/1");
        assertEquals(gregorian.jd_to(1720632).getDate(), "-2/10/30");
        assertEquals(gregorian.jd_to(1714788).getDate(), "-18/10/30");
        assertEquals(gregorian.jd_to(1714851).getDate(), "-17/1/1");
        assertEquals(gregorian.jd_to(1714909).getDate(), "-17/2/28");
        assertEquals(gregorian.jd_to(1714910).getDate(), "-17/2/29");
        assertEquals(gregorian.jd_to(1714911).getDate(), "-17/3/1");
        assertEquals(gregorian.jd_to(1715274).getDate(), "-16/2/28");
        assertEquals(gregorian.jd_to(1715275).getDate(), "-16/3/1");
        assertEquals(gregorian.jd_to(1726964).getDate(), "16/3/1");
        assertEquals(gregorian.jd_to(1726963).getDate(), "16/2/29");
        assertEquals(gregorian.jd_to(1726962).getDate(), "16/2/28");
        assertEquals(gregorian.jd_to(1726598).getDate(), "15/3/1");
        assertEquals(gregorian.jd_to(1726597).getDate(), "15/2/28");
        assertEquals(gregorian.jd_to(9025968).getDate(), "20000/2/28");
        assertEquals(gregorian.jd_to(2451910).getDate(), "2000/12/31");
        assertEquals(gregorian.jd_to(2451911).getDate(), "2001/1/1");
        assertEquals(gregorian.jd_to(2452244).getDate(), "2001/11/30");
        assertEquals(gregorian.jd_to(2452245).getDate(), "2001/12/1");
        assertEquals(gregorian.jd_to(2013589).getDate(), "800/12/1");
        assertEquals(gregorian.jd_to(2013446).getDate(), "800/7/11");
        assertEquals(gregorian.jd_to(2013318).getDate(), "800/3/5");
        assertEquals(gregorian.jd_to(2013954).getDate(), "801/12/1");
        assertEquals(gregorian.jd_to(2013811).getDate(), "801/7/11");
        assertEquals(gregorian.jd_to(2013683).getDate(), "801/3/5");
        assertEquals(gregorian.jd_to(2457024).getDate(), "2015/1/1");
        assertEquals(gregorian.jd_to(2457055).getDate(), "2015/2/1");
        assertEquals(gregorian.jd_to(2457083).getDate(), "2015/3/1");
        assertEquals(gregorian.jd_to(2457114).getDate(), "2015/4/1");
        assertEquals(gregorian.jd_to(2457144).getDate(), "2015/5/1");
        assertEquals(gregorian.jd_to(2457175).getDate(), "2015/6/1");
        assertEquals(gregorian.jd_to(2457205).getDate(), "2015/7/1");
        assertEquals(gregorian.jd_to(2457236).getDate(), "2015/8/1");
        assertEquals(gregorian.jd_to(2457267).getDate(), "2015/9/1");
        assertEquals(gregorian.jd_to(2457297).getDate(), "2015/10/1");
        assertEquals(gregorian.jd_to(2457328).getDate(), "2015/11/1");
        assertEquals(gregorian.jd_to(2457358).getDate(), "2015/12/1");
        assertEquals(gregorian.jd_to(2457389).getDate(), "2016/1/1");
        assertEquals(gregorian.jd_to(2457420).getDate(), "2016/2/1");
        assertEquals(gregorian.jd_to(2457449).getDate(), "2016/3/1");
        assertEquals(gregorian.jd_to(2457480).getDate(), "2016/4/1");
        assertEquals(gregorian.jd_to(2457510).getDate(), "2016/5/1");
        assertEquals(gregorian.jd_to(2457541).getDate(), "2016/6/1");
        assertEquals(gregorian.jd_to(2457571).getDate(), "2016/7/1");
        assertEquals(gregorian.jd_to(2457602).getDate(), "2016/8/1");
        assertEquals(gregorian.jd_to(2457633).getDate(), "2016/9/1");
        assertEquals(gregorian.jd_to(2457663).getDate(), "2016/10/1");
        assertEquals(gregorian.jd_to(2457694).getDate(), "2016/11/1");
        assertEquals(gregorian.jd_to(2457724).getDate(), "2016/12/1");
        assertEquals(gregorian.jd_to(2457755).getDate(), "2017/1/1");
        assertEquals(gregorian.jd_to(2457786).getDate(), "2017/2/1");
        assertEquals(gregorian.jd_to(2457814).getDate(), "2017/3/1");
        assertEquals(gregorian.jd_to(2457845).getDate(), "2017/4/1");
        assertEquals(gregorian.jd_to(2457875).getDate(), "2017/5/1");
        assertEquals(gregorian.jd_to(2457906).getDate(), "2017/6/1");
        assertEquals(gregorian.jd_to(2457936).getDate(), "2017/7/1");
        assertEquals(gregorian.jd_to(2457967).getDate(), "2017/8/1");
        assertEquals(gregorian.jd_to(2457998).getDate(), "2017/9/1");
        assertEquals(gregorian.jd_to(2458028).getDate(), "2017/10/1");
        assertEquals(gregorian.jd_to(2458059).getDate(), "2017/11/1");
        assertEquals(gregorian.jd_to(2458089).getDate(), "2017/12/1");
        assertEquals(gregorian.jd_to(0).getDate(), "-4713/11/23");
        assertEquals(gregorian.jd_to(-1).getDate(), "-4713/11/22");
        assertEquals(gregorian.jd_to(-2).getDate(), "-4713/11/21");
        assertEquals(gregorian.jd_to(-22).getDate(), "-4713/11/1");
        assertEquals(gregorian.jd_to(-23).getDate(), "-4713/10/31");
        assertEquals(gregorian.jd_to(-24).getDate(), "-4713/10/30");
        assertEquals(gregorian.jd_to(-100).getDate(), "-4713/8/15");
        assertEquals(gregorian.jd_to(-23131).getDate(), "-4776/7/27");
    }

}