package newCalendar;

public class Hijri {
    MonthDbHolder monthDb ;
    String name = "hijri";
    String desc = "Hijri(Islamic)";
    String origLang = "ar";

    public Hijri() {
        monthDb = new MonthDbHolder();
    }

    int ifloor(float x) {
        return (int) Math.floor(x);
    }

    String monthName[] = {
            "Muharram", "Safar", "Rabia' 1",
            "Rabia' 2", "Jumada 1", "Jumada 2",
            "Rajab", "Sha'aban", "Ramadan",
            "Shawwal", "Dhu'l Qidah", "Dhu'l Hijjah"
    };

    String monthNameAb[] = {
            "Moh", "Saf", "Rb1",
            "Rb2", "Jm1", "Jm2",
            "Raj", "Shb", "Ram",
            "Shw", "DhQ", "DhH"
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

    int epoch = 1948440;
    int minMonthLen = 29;
    int maxMonthLen = 30;
    double avgYearLen = 354.3666;

    int hijriAlg = 0;
    boolean hijriUseDB = true;

    boolean isLeap(int year) {
        return (((year * 11) + 14) % 30) < 11;
    }

    int to_jd_c(int year, int month, int day) {
        return day + iceil(29.5 * (month - 1)) +
                (year - 1) * 354 +
                (11 * year + 3) / 30 +
                epoch;
    }

    int to_jd(int year, int month, int day) {
        if (hijriUseDB) {
           int jd = monthDb.getJdFromDate(year, month, day);
            if (jd != Integer.MIN_VALUE) {
                return jd;
            }
        }
        return to_jd_c(year, month, day);
    }

    Date jd_to(int jd) {
        if (hijriUseDB) {
            Date date = monthDb.getDateFromJd(jd);
            if (date != null) {
                return date;
            }
        }

        int year = ifloor(((30 * (jd - 1 - epoch)) + 10646) / 10631);
        int month = Math.min(
                12,
                iceil(
                        (jd - (29 + to_jd(year, 1, 1))) / 29.5
                ) + 1
        );
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

    int iceil(double x) {
        return (int) Math.ceil(x);
    }

    class MonthDbHolder {
        private  String sysDbPath;
        private String userDbPath;
        private int endJd;
        private int[] monthLenByYm;
        private int startJd;
        private Date startDate;
        private int[] origVersion;

        public MonthDbHolder() {
            this.startDate = new Date(1426, 2, 1);
            this.startJd = 2453441;
            this.endJd = this.startJd;
            this.monthLenByYm = new int[0];
            load();
//            this.userDbPath = join(confDir, 'hijri-monthes.json');
//            this.sysDbPath = '%s/hijri-monthes.json' % modDir;
        }

        void setMonthLenByYear(int[][] monthLenByYear) {
            this.endJd = this.startJd;
            this.monthLenByYm = new int[monthLenByYear.length];
            for (int y = 0; y < monthLenByYear.length; y++) {
                int[] lst = monthLenByYear[y];
                for (int m = 0; m < lst.length; m++) {
                    int ml = lst[m];
                    if (ml > 0) {
                        this.monthLenByYm[y * 12 + m] = ml;
                        this.endJd += ml;
                    }
                }
            }
        }

        void setData(Data data) {
            this.startDate = data.startDate;
            this.startJd = data.startJd;
            int[][] monthLenByYear = new int[data.monthLen.length][];
            for (int row = 0; row < data.monthLen.length; row++) {
                System.arraycopy(data.monthLen[row], 1, monthLenByYear[row], 1, data.monthLen[row].length - 1);
            }
            this.setMonthLenByYear(monthLenByYear);
        }

        void load() {
            Data data = new Data(); //todo
            this.origVersion = data.version;

//            if (isfile(this.userDbPath)) {
//                userData = jsonToData(open(self.userDbPath).read())
//                if userData['origVersion'] >= self.origVersion:
//                data = userData
//                else:
//                print('---- ignoring user\'s old db', self.userDbPath)
            setData(data);

        }

//        int[] getMonthLenByYear() {
//
//            int[] monthLenByYear = {};
//            for (int ym = 0; ym <monthLenByYm.length; ym++) {
//                for (int mLen = 0; mLen<monthLenByYm[ym])
//                int year = ym / 12;
//                int month0 = ym % 12;
//                if (year < monthLenByYear.length) {
//                    monthLenByYear[year] =[0,]*month0;
//                }
//                monthLenByYear[year] = (mLen);
//            }
//            return monthLenByYear;
//        }

//        int[][] getMonthLenList() {
//            int[][] ls = {{}};
//            for (int index = 0, ym = 0; enumerate(sorted(monthLenByYm.keys())); ) {
//                ls[index][ym] = monthLenByYm[ym];
//            }
//            return ls;
//        }

        Date getDateFromJd(int jd) {
            if (endJd < jd || jd < startJd) {
                return null;
            }
            Date date = startDate;
            int ym = date.year * 12 + date.month - 1;
            while (jd > startJd) {
                int monthLen = monthLenByYm[ym];
                if (jd - monthLen > startJd) {
                    ym += 1;
                    jd -= monthLen;
                } else if (date.day + jd - startJd > monthLen) {
                    ym += 1;
                    date.day = date.day + jd - startJd - monthLen;
                    jd = startJd;
                } else {
                    date.day = date.day + jd - startJd;
                    jd = startJd;
                }
            }

            date.year = ym / 12;
            date.month = ym % 12;

            date.month += 1;
            return date;
        }

        int getJdFromDate(int year, int month, int day) {
            int ym = year * 12 + month - 1;
            Date date = startDate;
            int ym0 = date.year * 12 + date.month - 1;
            if (ym - 1 > monthLenByYm.length) {
                return Integer.MIN_VALUE;
            }
            int jd = startJd;
            for (int ymi = ym0; ymi < ym; ymi++) {
                jd += monthLenByYm[ymi];
            }
            return jd + day - 1;
        }

        class Data {
            int[] version = {1438, 5};
            Date startDate = new Date(1426, 2, 1);
            int startJd = 2453442;
            int[][] monthLen = {
                    {1426, 0, 29, 30, 29, 30, 30, 30, 30, 29, 30, 29, 29},
                    {1427, 30, 29, 29, 30, 29, 30, 30, 30, 30, 29, 29, 30},
                    {1428, 29, 30, 29, 29, 29, 30, 30, 29, 30, 30, 30, 29},
                    {1429, 30, 29, 30, 29, 29, 29, 30, 30, 29, 30, 30, 29},
                    {1430, 30, 30, 29, 29, 30, 29, 30, 29, 29, 30, 30, 29},
                    {1431, 30, 30, 29, 30, 29, 30, 29, 30, 29, 29, 30, 29},
                    {1432, 30, 30, 29, 30, 30, 30, 29, 29, 30, 29, 30, 29},
                    {1433, 29, 30, 29, 30, 30, 30, 29, 30, 29, 30, 29, 30},
                    {1434, 29, 29, 30, 29, 30, 30, 29, 30, 30, 29, 30, 29},
                    {1435, 29, 30, 29, 30, 29, 30, 29, 30, 30, 30, 29, 30},
                    {1436, 29, 30, 29, 29, 30, 29, 30, 29, 30, 29, 30, 30},
                    {1437, 29, 30, 30, 29, 30, 29, 29, 30, 29, 29, 30, 30},
                    {1438, 29, 30, 30, 30, 29}
            };
        }
    }
}
