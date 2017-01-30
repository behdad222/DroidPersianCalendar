package newCalendar;

public class Gregorian {
    String name = "gregorian";
    String desc = "Gregorian";
    String origLang = "en";

    String monthName[] = {"January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"};

    String monthNameAb[] = {"Jan", "Feb", "Mar", "Apr", "May", "Jun",
            "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};

    String getMonthName(int m) {
        return monthName[m - 1];
    }

    String getMonthNameAb(int m) {
        return monthNameAb[m - 1];
    }

    int getMonthsInYear(int y) {
        return 12;
    }

    int epoch = 1721426;
    int minMonthLen = 29;
    int maxMonthLen = 31;
    double avgYearLen = 365.2425;// FIXME

    boolean isLeap(int y) {
        if (y < 1) {
            y += 1;
        }
        return y % 4 == 0 && !(y % 100 == 0 && y % 400 != 0);
    }

    int to_jd(int year, int month, int day) {
//        if (0 < year && year < 10000) {
//            return datetime(year, month, day).toordinal() + 1721425;
//        }

        int tm;
        if (month <= 2) {
            tm = 0;
        } else if (isLeap(year)) {
            tm = -1;
        } else {
            tm = -2;
        }

        return (int) (epoch - 1 + 365 * (year - 1) + Math.floor((double) (year - 1) / 4) - Math.floor((double) (year - 1) / 100) +
                Math.floor((double) (year - 1) / 400) + Math.floor((double) (367 * month - 362) / 12) + tm + day);
    }

    Date jd_to(int jd) {

//        int ordinal = jd - 1721425;
//        if (0 < ordinal && ordinal < 3652060) {
//            dt = datetime.fromordinal(ordinal)
//            return (dt.year,dt.month, dt.day)
//        }
        int qc = (jd - epoch) / 146097;
        int dqc = (jd - epoch) % 146097;

        int cent = dqc / 36524;
        int dcent = dqc % 36524;

        int quad = dcent / 1461;
        int dquad = dcent % 1461;

        int yindex = dquad / 365;

        int a = 0;
        if (cent != 4 && yindex != 4) {
            a = 1;
        }

        int year = qc * 400 + cent * 100 + quad * 4 + yindex + a;

        int yearday = jd - to_jd(year, 1, 1);

        int leapadj;
        if (jd < to_jd(year, 3, 1)) {
            leapadj = 0;
        } else if (isLeap(year)) {
            leapadj = 1;
        } else {
            leapadj = 2;
        }

        int month = ((yearday + leapadj) * 12 + 373) / 367;
        int day = jd - to_jd(year, month, 1) + 1;
        return new Date(year, month, day);
    }

    int getMonthLen(int y, int m) {
        if (m == 12) {
            return to_jd(y + 1, 1, 1) - to_jd(y, 12, 1);
        } else {
            return to_jd(y, m + 1, 1) - to_jd(y, m, 1);
        }
    }

    class Date {
        int year, month, day;

        public Date(int year, int month, int day) {
            this.day = day;
            this.month = month;
            this.year = year;
        }
    }
}