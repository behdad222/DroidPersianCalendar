package newCalendar;

public class PersianAstronomical {
    double EPOCH = 1948320.5; // 622/03/19 Julian C.E.
    int EPOCH_RD= 226896;
//    TEHRAN_LOCATION: new Location (35.68, 51.42, 1100, 7 / 48),
//    WEEKDAYS: [ 'Yekshanbeh', 'Doshanbeh', 'Seshhanbeh', 'Chaharshanbeh', 'Panjshanbeh', 'Jomeh', 'Shanbeh' ],
//    MONTHS: [ 'Farvardin', 'Ordibehesht', 'Khordad', 'Tir', 'Mordad', 'Shahrivar', 'Mehr', 'Aban', 'Azar', 'Dey', 'Bahman', 'Esfand' ]


//    export class PersianAstronomicalCalendar extends LeapCalendar {
//        constructor(jdn: number, year: number, month: number, day: number) {
//            super(jdn, year, month, day, PersianAstronomicalCalendar.isLeapYear(year));
//        }

        // Is a given year in the Persian Astronmical calendar a leap year?
        public boolean isLeapYear(int year) {
            return this.toJdn(year + 1, 1, 1) - this.toJdn(year, 1, 1) > 365;
        }

        // Determine day number from Persian Astronmical calendar date
        public  int toJdn(int year,int  month,int  day) {
            this.validate(year, month, day);

            int  temp = year > 0 ? year - 1 : year;
            int nowRuz = this.persianNewYearOnOrBefore(EPOCH_RD + 180 +
                    Math.floor(MEAN_TROPICAL_YEAR * temp));

            return nowRuz - 1 + day +
                    ((month <= 7) ? 31 * (month - 1) : 30 * (month - 1) + 6) + J0000;
        }

        public void validate(int year, int month,int  day) {
            const maxDays = month < 7 ? 31 : (!this.isLeapYear(year) && month === 12) ? 29 : 30;

            if (day < 1 || day > maxDays) {
                throw new CalendarValidationException('Invalid day');
            }

            if (month < 1 || month > 12) {
                throw new CalendarValidationException('Invalid month');
            }
        }

        // Calculate Persian Astronmical calendar date from Julian day
        public static fromJdn(jdn: number): PersianAstronomicalCalendar {
            const depoch: number = jdn - this.toJdn(475, 1, 1);
            const cycle: number = Math.floor(depoch / 1029983);
            const cyear: number = mod(depoch, 1029983);
            let ycycle: number;

            if (cyear === 1029982) {
                ycycle = 2820;
            } else {
                const aux1: number = Math.floor(cyear / 366);
                const aux2: number = mod(cyear, 366);
                ycycle = Math.floor((2134 * aux1 + 2816 * aux2 + 2815) / 1028522) + aux1 + 1;
            }

            let year: number = ycycle + 2820 * cycle + 474;

            if (year <= 0) {
                year -= 1;
            }

            let yday: number = jdn - this.toJdn(year, 1, 1) + 1;
            let month: number, day: number;

            if (yday <= 186) {
                month = Math.ceil(yday / 31);
                day = amod(yday, 31);
            } else {
                yday -= 6;
                month = Math.ceil(yday / 30);
                day = amod(yday, 30);
            }

            return new PersianAstronomicalCalendar(jdn, year, month, day);
        }

        // Return the fixed date of Astronomical Persian New Year on or before fixed date
        private int  persianNewYearOnOrBefore(int jdn) {
            const approx: number = estimatePriorSolarLongitude(Season.SPRING, this.midDayInTehran(jdn));

            return next(Math.floor(approx) - 1, function (day: number) {
                return solarLongitude(PersianAstronomicalCalendar.midDayInTehran(day)) <= Season.SPRING + 2;
            });
        };

        // Return  Universal time of midday on fixed date, date, in Tehran
        private int  midDayInTehran(int jdn) {
            return standardToUniversal(midDay(jdn, persian.TEHRAN_LOCATION), persian.TEHRAN_LOCATION);
        }
    }
}
