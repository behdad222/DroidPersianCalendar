package newCalendar;

public class Julian {
    String name = "julian";
    String desc = "Julian";
    String origLang = "en";

    int ifloor(float x) {
        return (int) Math.floor(x);
    }

    String monthName[] = {
            "January", "February", "March",
            "April", "May", "June",
            "July", "August", "September",
            "October", "November", "December"
    };

    String monthNameAb[] = {
            "Jan", "Feb", "Mar",
            "Apr", "May", "Jun",
            "Jul", "Aug", "Sep",
            "Oct", "Nov", "Dec"
    };

    String getMonthName(int m) {
        return monthName[m - 1];
    }

    String getMonthNameAb(int m) {
        return monthNameAb[m - 1];
    }

    int getMonthsInYear(int y) {
        return 12;
    }

    int epoch = 1721058;
    int minMonthLen = 28;
    int maxMonthLen = 32;
    double avgYearLen = 365.25;

    int[] monthLenSum = {
            0, 31, 59,
            90, 120, 151,
            181, 212, 243,
            273, 304, 334,
            365,
    };

    boolean isLeap(int year) {
        return year % 4 == 0;
    }

    int getYearDays(int month, boolean leap) {
        int ydays = monthLenSum[month - 1];
        if (leap && month < 3)
            ydays -= 1;
        return ydays;
    }

    int getDayFromYdays(int yDays, boolean leap) {

        int month = 1;
        while (month < 12 && yDays > getYearDays(month + 1, leap)) {
            month += 1;
        }
        int day = yDays - getYearDays(month, leap);
        return day;
    }

    int getMonthFromYdays(int yDays, boolean leap) {

        int month = 1;
        while (month < 12 && yDays > getYearDays(month + 1, leap)) {
            month += 1;
        }
        int day = yDays - getYearDays(month, leap);
        return month;
    }

    int to_jd(int year, int month, int day) {
        int quadCount = year / 4;
        int yMode = year % 4;
        return epoch +
                1461 * quadCount +
                365 * yMode +
                getYearDays(month, yMode == 0) +
                day;
    }

    Date jd_to(int jd) {

        int quadCount = (jd - epoch) / 1461;
        int quadDays = (jd - epoch) % 1461;

        if (quadDays == 0) {
            return new Date(4 * quadCount, 1, 1);
        }

        int yMode = (quadDays - 1) / 365;
        int yDays = (quadDays - 1) % 365;

        yDays += 1;
        int year = 4 * quadCount + yMode;

        int month = getMonthFromYdays(yDays, yMode == 0);
        int day = getDayFromYdays(yDays, yMode == 0);

        return new Date(year, month, day);
    }

    int getMonthLen(int year, int month) {
        if (month == 12) {
            return to_jd(year + 1, 1, 1) - to_jd(year, 12, 1);
        } else {
            return to_jd(year, month + 1, 1) - to_jd(year, month, 1);
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
