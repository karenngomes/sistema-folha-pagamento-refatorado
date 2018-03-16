package production;

public class Date {
    private int month;
    private int day;
    private int year;
    private static final int[] daysPerMonth;

    static {
        int[] arrn = new int[13];
        arrn[1] = 31;
        arrn[2] = 28;
        arrn[3] = 31;
        arrn[4] = 30;
        arrn[5] = 31;
        arrn[6] = 30;
        arrn[7] = 31;
        arrn[8] = 31;
        arrn[9] = 30;
        arrn[10] = 31;
        arrn[11] = 30;
        arrn[12] = 31;
        daysPerMonth = arrn;
    }

    public Date(int month, int day, int year) {
        if (month <= 0 || month > 12) {
            System.out.println("Error");
        }
        if (day <= 0 || day > daysPerMonth[month] && (month != 2 || day != 29)) {
            System.out.println();
        }
        if (month == 2 && day == 29 && year % 400 != 0 && (year % 4 != 0 || year % 100 == 0)) {
            System.out.println();
        }
        this.month = month;
        this.day = day;
        this.year = year;
    }

    public String toString() {
        return String.format("%d/%d/%d", this.month, this.day, this.year);
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public static int[] getDaysPerMonth() {
        return daysPerMonth;
    }
}

