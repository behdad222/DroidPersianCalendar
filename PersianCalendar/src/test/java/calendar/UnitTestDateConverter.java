package calendar;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class UnitTestDateConverter {

    @Test
    public void to_jdTest() {
        assertEquals(DateConverter.civilToJdn(new CivilDate(2016, 2, 4)), 2457423);
//        assertEquals(DateConverter.civilToJdn(new CivilDate(0, 0, 0)), 1721028);
//        assertEquals(DateConverter.civilToJdn(new CivilDate(1, 1, 1)), 1721426);
//        assertEquals(DateConverter.civilToJdn(new CivilDate(-2, 1, 1)), 1720330);
//        assertEquals(DateConverter.civilToJdn(new CivilDate(-1, -1, -1)), 1720632);
//        assertEquals(DateConverter.civilToJdn(new CivilDate(-17, -1, -1)), 1714788);
//        assertEquals(DateConverter.civilToJdn(new CivilDate(-17, 1, 1)), 1714851);
//        assertEquals(DateConverter.civilToJdn(new CivilDate(-17, 2, 28)), 1714909);
//        assertEquals(DateConverter.civilToJdn(new CivilDate(-17, 2, 29)), 1714910);
//        assertEquals(DateConverter.civilToJdn(new CivilDate(-17, 3, 1)), 1714911);
//        assertEquals(DateConverter.civilToJdn(new CivilDate(-16, 2, 28)), 1715274);
//        assertEquals(DateConverter.civilToJdn(new CivilDate(-16, 2, 29)), 1715275);
//        assertEquals(DateConverter.civilToJdn(new CivilDate(-16, 3, 1)), 1715275);
//        assertEquals(DateConverter.civilToJdn(new CivilDate(16, 3, 1)), 1726964);
//        assertEquals(DateConverter.civilToJdn(new CivilDate(16, 2, 29)), 1726963);
//        assertEquals(DateConverter.civilToJdn(new CivilDate(16, 2, 28)), 1726962);
//        assertEquals(DateConverter.civilToJdn(new CivilDate(15, 3, 1)), 1726598);
//        assertEquals(DateConverter.civilToJdn(new CivilDate(15, 2, 29)), 1726598);
//        assertEquals(DateConverter.civilToJdn(new CivilDate(15, 2, 28)), 1726597);
        assertEquals(DateConverter.civilToJdn(new CivilDate(20000, 2, 28)), 9025968);
        assertEquals(DateConverter.civilToJdn(new CivilDate(2000, 12, 31)), 2451910);
        assertEquals(DateConverter.civilToJdn(new CivilDate(2001, 1, 1)), 2451911);
        assertEquals(DateConverter.civilToJdn(new CivilDate(2001, 11, 30)), 2452244);
        assertEquals(DateConverter.civilToJdn(new CivilDate(2001, 12, 1)), 2452245);
//        assertEquals(DateConverter.civilToJdn(new CivilDate(800, 12, 1)), 2013589);
//        assertEquals(DateConverter.civilToJdn(new CivilDate(800, 7, 11)), 2013446);
//        assertEquals(DateConverter.civilToJdn(new CivilDate(800, 3, 5)), 2013318);
//        assertEquals(DateConverter.civilToJdn(new CivilDate(801, 12, 1)), 2013954);
//        assertEquals(DateConverter.civilToJdn(new CivilDate(801, 7, 11)), 2013811);
//        assertEquals(DateConverter.civilToJdn(new CivilDate(801, 3, 5)), 2013683);
        assertEquals(DateConverter.civilToJdn(new CivilDate(2015, 1, 1)), 2457024);
        assertEquals(DateConverter.civilToJdn(new CivilDate(2015, 2, 1)), 2457055);
        assertEquals(DateConverter.civilToJdn(new CivilDate(2015, 3, 1)), 2457083);
        assertEquals(DateConverter.civilToJdn(new CivilDate(2015, 4, 1)), 2457114);
        assertEquals(DateConverter.civilToJdn(new CivilDate(2015, 5, 1)), 2457144);
        assertEquals(DateConverter.civilToJdn(new CivilDate(2015, 6, 1)), 2457175);
        assertEquals(DateConverter.civilToJdn(new CivilDate(2015, 7, 1)), 2457205);
        assertEquals(DateConverter.civilToJdn(new CivilDate(2015, 8, 1)), 2457236);
        assertEquals(DateConverter.civilToJdn(new CivilDate(2015, 9, 1)), 2457267);
        assertEquals(DateConverter.civilToJdn(new CivilDate(2015, 10, 1)), 2457297);
        assertEquals(DateConverter.civilToJdn(new CivilDate(2015, 11, 1)), 2457328);
        assertEquals(DateConverter.civilToJdn(new CivilDate(2015, 12, 1)), 2457358);
        assertEquals(DateConverter.civilToJdn(new CivilDate(2016, 1, 1)), 2457389);
        assertEquals(DateConverter.civilToJdn(new CivilDate(2016, 2, 1)), 2457420);
        assertEquals(DateConverter.civilToJdn(new CivilDate(2016, 3, 1)), 2457449);
        assertEquals(DateConverter.civilToJdn(new CivilDate(2016, 4, 1)), 2457480);
        assertEquals(DateConverter.civilToJdn(new CivilDate(2016, 5, 1)), 2457510);
        assertEquals(DateConverter.civilToJdn(new CivilDate(2016, 6, 1)), 2457541);
        assertEquals(DateConverter.civilToJdn(new CivilDate(2016, 7, 1)), 2457571);
        assertEquals(DateConverter.civilToJdn(new CivilDate(2016, 8, 1)), 2457602);
        assertEquals(DateConverter.civilToJdn(new CivilDate(2016, 9, 1)), 2457633);
        assertEquals(DateConverter.civilToJdn(new CivilDate(2016, 10, 1)), 2457663);
        assertEquals(DateConverter.civilToJdn(new CivilDate(2016, 11, 1)), 2457694);
        assertEquals(DateConverter.civilToJdn(new CivilDate(2016, 12, 1)), 2457724);
        assertEquals(DateConverter.civilToJdn(new CivilDate(2017, 1, 1)), 2457755);
        assertEquals(DateConverter.civilToJdn(new CivilDate(2017, 2, 1)), 2457786);
        assertEquals(DateConverter.civilToJdn(new CivilDate(2017, 3, 1)), 2457814);
        assertEquals(DateConverter.civilToJdn(new CivilDate(2017, 4, 1)), 2457845);
        assertEquals(DateConverter.civilToJdn(new CivilDate(2017, 5, 1)), 2457875);
        assertEquals(DateConverter.civilToJdn(new CivilDate(2017, 6, 1)), 2457906);
        assertEquals(DateConverter.civilToJdn(new CivilDate(2017, 7, 1)), 2457936);
        assertEquals(DateConverter.civilToJdn(new CivilDate(2017, 8, 1)), 2457967);
        assertEquals(DateConverter.civilToJdn(new CivilDate(2017, 9, 1)), 2457998);
        assertEquals(DateConverter.civilToJdn(new CivilDate(2017, 10, 1)), 2458028);
        assertEquals(DateConverter.civilToJdn(new CivilDate(2017, 11, 1)), 2458059);
        assertEquals(DateConverter.civilToJdn(new CivilDate(2017, 12, 1)), 2458089);
//        assertEquals(DateConverter.civilToJdn(new CivilDate(-4713, 11, 23)), 0);
//        assertEquals(DateConverter.civilToJdn(new CivilDate(-4713, 11, 22)), -1);
//        assertEquals(DateConverter.civilToJdn(new CivilDate(-4713, 11, 21)), -2);
//        assertEquals(DateConverter.civilToJdn(new CivilDate(-4713, 11, 1)), -22);
//        assertEquals(DateConverter.civilToJdn(new CivilDate(-4713, 10, 31)), -23);
//        assertEquals(DateConverter.civilToJdn(new CivilDate(-4713, 10, 30)), -24);
//        assertEquals(DateConverter.civilToJdn(new CivilDate(-4713, 8, 15)), -100);
//        assertEquals(DateConverter.civilToJdn(new CivilDate(-4776, 7, 27)), -23131);
    }
}