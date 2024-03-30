package assessment1;

public class DaysCalculate{
    public static void main(String[] args) {
        int[] dt1 = {10,2,2014};
        int[] dt2 = {10, 3, 2015};

        int totalDays = getTotalDaysBetweenDates(dt1, dt2);
        System.out.println("Total number of days between the two dates: " + totalDays);
    }

    public static int getTotalDaysBetweenDates(int[] dt1, int[] dt2) {
        int days1 = dt1[0] + getTotalDaysInMonths(dt1[1], dt1[2]) + dt1[2] * 365 + countLeapYears(dt1[2]);
        int days2 = dt2[0] + getTotalDaysInMonths(dt2[1], dt2[2]) + dt2[2] * 365 + countLeapYears(dt2[2]);
        
        return days2 - days1;
    }

    public static int getTotalDaysInMonths(int month, int year) {
        int[] daysInMonth = {31, 28 + isLeapYear(year), 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int totalDays = 0;
        for (int i = 0; i < month-1; i++) {
            totalDays += daysInMonth[i];
        }
        return totalDays;
    }

    public static int isLeapYear(int year) {
        if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
            return 1;
        } else {
            return 0;
        }
    }

    public static int countLeapYears(int year) {
        if (year <= 2)
            year--;
        return year / 4 - year / 100 + year / 400;
    }
}
