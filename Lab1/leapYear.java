package Lab1;

public class leapYear {
    public static boolean isLeapYear(int year) {
        boolean isLeapYear;
        if (year % 4 == 0) {
            if (year % 100 != 0) {
                isLeapYear = true;
            } else if (year % 400 == 0) {
                isLeapYear = true;
            }else  {
                isLeapYear = false;
            }
        } else {
            isLeapYear = false;
        }
        return isLeapYear;
    }
}
