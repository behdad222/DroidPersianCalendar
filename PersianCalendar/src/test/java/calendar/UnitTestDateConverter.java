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
        assertEquals(DateConverter.civilToJdn(new CivilDate(2000, 1, 1)), 2451545);
        assertEquals(DateConverter.civilToJdn(new CivilDate(1800, 1, 1)), 2378497);
        assertEquals(DateConverter.civilToJdn(new CivilDate(1700, 1, 1)), 2341973);
        assertEquals(DateConverter.civilToJdn(new CivilDate(1600, 1, 1)), 2305448);
        assertEquals(DateConverter.civilToJdn(new CivilDate(1599, 12, 31)), 2305447);
        assertEquals(DateConverter.civilToJdn(new CivilDate(1599, 1, 1)), 2305083);
        assertEquals(DateConverter.civilToJdn(new CivilDate(1590, 1, 1)), 2301796);
        assertEquals(DateConverter.civilToJdn(new CivilDate(1583, 1, 1)), 2299239);
        assertEquals(DateConverter.civilToJdn(new CivilDate(1582, 11, 1)), 2299178);
        assertEquals(DateConverter.civilToJdn(new CivilDate(1582, 10, 15)), 2299161);
        assertEquals(DateConverter.civilToJdn(new CivilDate(1582, 10, 14)), 2299160);
        assertEquals(DateConverter.civilToJdn(new CivilDate(1582, 10, 1)), 2299147);
        assertEquals(DateConverter.civilToJdn(new CivilDate(1580, 1, 1)), 2298143);
        assertEquals(DateConverter.civilToJdn(new CivilDate(1550, 1, 1)), 2287186);
        assertEquals(DateConverter.civilToJdn(new CivilDate(1500, 1, 1)), 2268924);
        assertEquals(DateConverter.civilToJdn(new CivilDate(1000, 1, 1)), 2086303);
        assertEquals(DateConverter.civilToJdn(new CivilDate(2016, 2, 4)), 2457423);
//        assertEquals(DateConverter.civilToJdn(new CivilDate(0, 0, 0)), 1721028);
        assertEquals(DateConverter.civilToJdn(new CivilDate(1, 1, 1)), 1721426);
        assertEquals(DateConverter.civilToJdn(new CivilDate(-2, 1, 1)), 1720330);
//        assertEquals(DateConverter.civilToJdn(new CivilDate(-1, -1, -1)), 1720632);
//        assertEquals(DateConverter.civilToJdn(new CivilDate(-17, -1, -1)), 1714788);
        assertEquals(DateConverter.civilToJdn(new CivilDate(-17, 1, 1)), 1714851);
        assertEquals(DateConverter.civilToJdn(new CivilDate(-17, 2, 28)), 1714909);
//        assertEquals(DateConverter.civilToJdn(new CivilDate(-17, 2, 29)), 1714910);
        assertEquals(DateConverter.civilToJdn(new CivilDate(-17, 3, 1)), 1714910);
        assertEquals(DateConverter.civilToJdn(new CivilDate(-16, 2, 28)), 1715274);
        assertEquals(DateConverter.civilToJdn(new CivilDate(-16, 2, 29)), 1715275);
        assertEquals(DateConverter.civilToJdn(new CivilDate(-16, 3, 1)), 1715276);
        assertEquals(DateConverter.civilToJdn(new CivilDate(16, 3, 1)), 1726964);
        assertEquals(DateConverter.civilToJdn(new CivilDate(16, 2, 29)), 1726963);
        assertEquals(DateConverter.civilToJdn(new CivilDate(16, 2, 28)), 1726962);
        assertEquals(DateConverter.civilToJdn(new CivilDate(15, 3, 1)), 1726598);
//        assertEquals(DateConverter.civilToJdn(new CivilDate(15, 2, 29)), 1726598);
        assertEquals(DateConverter.civilToJdn(new CivilDate(15, 2, 28)), 1726597);
        assertEquals(DateConverter.civilToJdn(new CivilDate(20000, 2, 28)), 9025968);
        assertEquals(DateConverter.civilToJdn(new CivilDate(2000, 12, 31)), 2451910);
        assertEquals(DateConverter.civilToJdn(new CivilDate(2001, 1, 1)), 2451911);
        assertEquals(DateConverter.civilToJdn(new CivilDate(2001, 11, 30)), 2452244);
        assertEquals(DateConverter.civilToJdn(new CivilDate(2001, 12, 1)), 2452245);
        assertEquals(DateConverter.civilToJdn(new CivilDate(800, 12, 1)), 2013589);
        assertEquals(DateConverter.civilToJdn(new CivilDate(800, 7, 11)), 2013446);
        assertEquals(DateConverter.civilToJdn(new CivilDate(800, 3, 5)), 2013318);
        assertEquals(DateConverter.civilToJdn(new CivilDate(801, 12, 1)), 2013954);
        assertEquals(DateConverter.civilToJdn(new CivilDate(801, 7, 11)), 2013811);
        assertEquals(DateConverter.civilToJdn(new CivilDate(801, 3, 5)), 2013683);
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
        assertEquals(DateConverter.civilToJdn(new CivilDate(-4713, 11, 23)), -1);
        assertEquals(DateConverter.civilToJdn(new CivilDate(-4713, 11, 22)), -2);
        assertEquals(DateConverter.civilToJdn(new CivilDate(-4713, 11, 21)), -3);
        assertEquals(DateConverter.civilToJdn(new CivilDate(-4713, 11, 1)), -23);
        assertEquals(DateConverter.civilToJdn(new CivilDate(-4713, 10, 31)), -24);
        assertEquals(DateConverter.civilToJdn(new CivilDate(-4713, 10, 30)), -25);
        assertEquals(DateConverter.civilToJdn(new CivilDate(-4713, 8, 15)), -101);
        assertEquals(DateConverter.civilToJdn(new CivilDate(-4776, 7, 27)), -23130);
    }

    @Test
    public void jd_toTest() {
        assertEquals(DateConverter.jdnToCivil(2013683).getDate(), "801/3/5");
        assertEquals(DateConverter.jdnToCivil(2013811).getDate(), "801/7/11");
        assertEquals(DateConverter.jdnToCivil(2013954).getDate(), "801/12/1");
        assertEquals(DateConverter.jdnToCivil(2013318).getDate(), "800/3/5");
        assertEquals(DateConverter.jdnToCivil(2013446).getDate(), "800/7/11");
        assertEquals(DateConverter.jdnToCivil(2013589).getDate(), "800/12/1");
        assertEquals(DateConverter.jdnToCivil(1000).getDate(), "-4710/8/20");
        assertEquals(DateConverter.jdnToCivil(-1000).getDate(), "-4715/2/27");
        assertEquals(DateConverter.jdnToCivil(2457423).getDate(), "2016/2/4");
        assertEquals(DateConverter.jdnToCivil(1721028).getDate(), "-1/11/30");
        assertEquals(DateConverter.jdnToCivil(1721426).getDate(), "1/1/1");
        assertEquals(DateConverter.jdnToCivil(1720330).getDate(), "-2/1/1");
        assertEquals(DateConverter.jdnToCivil(1720632).getDate(), "-2/10/30");
        assertEquals(DateConverter.jdnToCivil(1714788).getDate(), "-18/10/30");
        assertEquals(DateConverter.jdnToCivil(1714851).getDate(), "-17/1/1");
        assertEquals(DateConverter.jdnToCivil(1714909).getDate(), "-17/2/28");
        assertEquals(DateConverter.jdnToCivil(1714910).getDate(), "-17/3/1");
        assertEquals(DateConverter.jdnToCivil(1714911).getDate(), "-17/3/2");
        assertEquals(DateConverter.jdnToCivil(1715274).getDate(), "-16/2/28");
        assertEquals(DateConverter.jdnToCivil(1715275).getDate(), "-16/2/29");
        assertEquals(DateConverter.jdnToCivil(1726964).getDate(), "16/3/1");
        assertEquals(DateConverter.jdnToCivil(1726963).getDate(), "16/2/29");
        assertEquals(DateConverter.jdnToCivil(1726962).getDate(), "16/2/28");
        assertEquals(DateConverter.jdnToCivil(1726598).getDate(), "15/3/1");
        assertEquals(DateConverter.jdnToCivil(1726597).getDate(), "15/2/28");
        assertEquals(DateConverter.jdnToCivil(9025968).getDate(), "20000/2/28");
        assertEquals(DateConverter.jdnToCivil(2451910).getDate(), "2000/12/31");
        assertEquals(DateConverter.jdnToCivil(2451911).getDate(), "2001/1/1");
        assertEquals(DateConverter.jdnToCivil(2452244).getDate(), "2001/11/30");
        assertEquals(DateConverter.jdnToCivil(2452245).getDate(), "2001/12/1");
        assertEquals(DateConverter.jdnToCivil(2013589).getDate(), "800/12/1");
        assertEquals(DateConverter.jdnToCivil(2013446).getDate(), "800/7/11");
        assertEquals(DateConverter.jdnToCivil(2013318).getDate(), "800/3/5");
        assertEquals(DateConverter.jdnToCivil(2013954).getDate(), "801/12/1");
        assertEquals(DateConverter.jdnToCivil(2013811).getDate(), "801/7/11");
        assertEquals(DateConverter.jdnToCivil(2013683).getDate(), "801/3/5");
        assertEquals(DateConverter.jdnToCivil(2457024).getDate(), "2015/1/1");
        assertEquals(DateConverter.jdnToCivil(2457055).getDate(), "2015/2/1");
        assertEquals(DateConverter.jdnToCivil(2457083).getDate(), "2015/3/1");
        assertEquals(DateConverter.jdnToCivil(2457114).getDate(), "2015/4/1");
        assertEquals(DateConverter.jdnToCivil(2457144).getDate(), "2015/5/1");
        assertEquals(DateConverter.jdnToCivil(2457175).getDate(), "2015/6/1");
        assertEquals(DateConverter.jdnToCivil(2457205).getDate(), "2015/7/1");
        assertEquals(DateConverter.jdnToCivil(2457236).getDate(), "2015/8/1");
        assertEquals(DateConverter.jdnToCivil(2457267).getDate(), "2015/9/1");
        assertEquals(DateConverter.jdnToCivil(2457297).getDate(), "2015/10/1");
        assertEquals(DateConverter.jdnToCivil(2457328).getDate(), "2015/11/1");
        assertEquals(DateConverter.jdnToCivil(2457358).getDate(), "2015/12/1");
        assertEquals(DateConverter.jdnToCivil(2457389).getDate(), "2016/1/1");
        assertEquals(DateConverter.jdnToCivil(2457420).getDate(), "2016/2/1");
        assertEquals(DateConverter.jdnToCivil(2457449).getDate(), "2016/3/1");
        assertEquals(DateConverter.jdnToCivil(2457480).getDate(), "2016/4/1");
        assertEquals(DateConverter.jdnToCivil(2457510).getDate(), "2016/5/1");
        assertEquals(DateConverter.jdnToCivil(2457541).getDate(), "2016/6/1");
        assertEquals(DateConverter.jdnToCivil(2457571).getDate(), "2016/7/1");
        assertEquals(DateConverter.jdnToCivil(2457602).getDate(), "2016/8/1");
        assertEquals(DateConverter.jdnToCivil(2457633).getDate(), "2016/9/1");
        assertEquals(DateConverter.jdnToCivil(2457663).getDate(), "2016/10/1");
        assertEquals(DateConverter.jdnToCivil(2457694).getDate(), "2016/11/1");
        assertEquals(DateConverter.jdnToCivil(2457724).getDate(), "2016/12/1");
        assertEquals(DateConverter.jdnToCivil(2457755).getDate(), "2017/1/1");
        assertEquals(DateConverter.jdnToCivil(2457786).getDate(), "2017/2/1");
        assertEquals(DateConverter.jdnToCivil(2457814).getDate(), "2017/3/1");
        assertEquals(DateConverter.jdnToCivil(2457845).getDate(), "2017/4/1");
        assertEquals(DateConverter.jdnToCivil(2457875).getDate(), "2017/5/1");
        assertEquals(DateConverter.jdnToCivil(2457906).getDate(), "2017/6/1");
        assertEquals(DateConverter.jdnToCivil(2457936).getDate(), "2017/7/1");
        assertEquals(DateConverter.jdnToCivil(2457967).getDate(), "2017/8/1");
        assertEquals(DateConverter.jdnToCivil(2457998).getDate(), "2017/9/1");
        assertEquals(DateConverter.jdnToCivil(2458028).getDate(), "2017/10/1");
        assertEquals(DateConverter.jdnToCivil(2458059).getDate(), "2017/11/1");
        assertEquals(DateConverter.jdnToCivil(2458089).getDate(), "2017/12/1");
        assertEquals(DateConverter.jdnToCivil(0).getDate(), "-4713/11/24");
        assertEquals(DateConverter.jdnToCivil(-1).getDate(), "-4713/11/23");
        assertEquals(DateConverter.jdnToCivil(-2).getDate(), "-4713/11/22");
        assertEquals(DateConverter.jdnToCivil(-22).getDate(), "-4713/11/2");
        assertEquals(DateConverter.jdnToCivil(-23).getDate(), "-4713/11/1");
        assertEquals(DateConverter.jdnToCivil(-24).getDate(), "-4713/10/31");
        assertEquals(DateConverter.jdnToCivil(-100).getDate(), "-4713/8/16");
        assertEquals(DateConverter.jdnToCivil(-23131).getDate(), "-4776/7/26");
    }

}