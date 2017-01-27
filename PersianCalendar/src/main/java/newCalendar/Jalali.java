package newCalendar;

public class Jalali {
    String name = "jalali";
    String desc = "Jalali";
    String origLang = "fa";

    int monthNameMode = 0;
    int jalaliAlg = 0;

    String[][][] monthNameVars = {
            {
                    {"Farvardin", "Ordibehesht", "Khordad", "Teer", "Mordad", "Shahrivar",
                            "Mehr", "Aban", "Azar", "Dey", "Bahman", "Esfand"},
                    {"Far", "Ord", "Khr", "Tir", "Mor", "Shr",
                            "Meh", "Abn", "Azr", "Dey", "Bah", "Esf"},
            },
            {
                    {"Xakelêwe", "Gullan", "Cozerdan", "Pûşper", "Gelawêj", "Xermanan",
                            "Rezber", "Gelarêzan", "Sermawez", "Befranbar", "Rêbendan", "Reşeme"},
            },
            {
                    {"Hamal", "Sawr", "Jawzā", "Saratān", "Asad", "Sonbola",
                            "Mizān", "Aqrab", "Qaws", "Jadi", "Dalvæ", "Hūt"},
            },
            {
                    {"Wray", "Ǧwayay", "Ǧbargolay", "Čungāx̌", "Zmaray", "Waǵay",
                            "Təla", "Laṛam", "Līndəi", "Marǧūmay", "Salwāǧa", "Kab"},
            },
    };

    String getMonthName(int m) {
        return monthNameVars[monthNameMode][0][m - 1];
    }

    String getMonthNameAb(int m) {
        String[][] v = monthNameVars[monthNameMode];
        String[] l;
        try {
            l = v[1];
        } catch (Exception e) {
            l = v[0];
        }

        return l[m - 1];
    }

    int getMonthsInYear(int y) {
        return 12;
    }

    int epoch = 1948321;
    int minMonthLen = 29;
    int maxMonthLen = 31;
    double avgYearLen = 365.2425;// FIXME

    int GREGORIAN_EPOCH = 1721426;

    int[] monthLen = {31, 31, 31, 31, 31, 31, 30, 30, 30, 30, 30, 30};

    int[] monthLenSum = new int[12];

    void monthLenInit() {

        for (int i = 0; i < 12; i++) {
            monthLenSum[i] = monthLenSum[i - 1] + monthLen[i];
        }
    }

    boolean isLeap(int year) {
        if (jalaliAlg == 1) {
            int a = 0;
            if (year > 0) {
                a = 1;
            }
            return (((year - 473 - a) % 2820) * 682) % 2816 < 682;
        } else if (jalaliAlg == 0) {
            int jy = year - 979;
            int gdays = (365 * jy + (jy / 33) * 8 + (jy % 33 + 3) / 4 + 79) % 146097;

            if (gdays >= 36525) {

                gdays = (gdays - 1) % 36524 + 1;
                if (gdays < 366) {
                    return false;
                }
            }

            if (gdays % 1461 >= 366) {
                return false;
            }
            return true;
        } else {
            throw new RuntimeException("bad option jalaliAlg " + jalaliAlg);
        }
    }

    int getMonthFromYdays(int yday) {
        int month = java.util.Arrays.binarySearch(monthLenSum, yday);
        return month;
    }

    int getDayFromYdays(int yday) {
        int day = yday - monthLenSum[getMonthFromYdays(yday) - 1];
        return day;
    }

    int to_jd(int year, int month, int day) {
        if (jalaliAlg == 1) {
            int epbase = year >= 0 ? year - 474 : year - 473;
            int epyear = 474 + epbase % 2820;
            return day +
                    (month - 1) * 30 + Math.min(6, month - 1) +
                    (epyear * 682 - 110) / 2816 +
                    (epyear - 1) * 365 +
                    epbase / 2820 * 1029983 +
                    epoch - 1;
        } else if (jalaliAlg == 0) {
            int y2 = year - 979;
            int jdays = 365 * y2 + y2 / 33 * 8 + (y2 % 33 + 3) / 4 + monthLenSum[month - 1] + (day - 1);
            return jdays + 584101 + GREGORIAN_EPOCH;
        } else {
            throw new RuntimeException("bad option jalaliAlg" + jalaliAlg);
        }
    }

    Date jd_to(int jd) {
        int year, month, day;
        if (jalaliAlg == 1) {
            int cycle = (jd - to_jd(475, 1, 1)) / 1029983;
            int cyear = (jd - to_jd(475, 1, 1)) % 1029983;
            int ycycle;
            if (cyear == 1029982) {
                ycycle = 2820;
            } else {
                int aux1 = cyear / 366;
                int aux2 = cyear % 366;
                ycycle = (2134 * aux1 + 2816 * aux2 + 2815) / 1028522 + aux1 + 1;
            }
            year = 2820 * cycle + ycycle + 474;
            if (year <= 0) {
                year -= 1;
            }
            int yday = jd - to_jd(year, 1, 1) + 1;
            month = getMonthFromYdays(yday);
            day = getDayFromYdays(yday);
        } else if (jalaliAlg == 0) {
            int jdays = jd - GREGORIAN_EPOCH - 584101;

            int j_np = jdays / 12053;
            jdays %= 12053;
            year = 979 + 33 * j_np + 4 * (jdays / 1461);
            jdays %= 1461;
            if (jdays >= 366) {
                year += (jdays - 1) / 365;
                jdays = (jdays - 1) % 365;
            }
            int yday = jdays + 1;
            month = getMonthFromYdays(yday);
            day = getDayFromYdays(yday);
        } else {
            throw new RuntimeException("bad option jalaliAlg" + jalaliAlg);
        }
        return new Date(year, month, day);
    }


    int getMonthLen(int year, int month) {
        if (month == 12) {
            if (isLeap(year)) {
                return 30;
            } else {
                return 29;
            }
        } else {
            return monthLen[month - 1];
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
