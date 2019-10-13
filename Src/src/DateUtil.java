public class DateUtil {

    public boolean checkGregorianDate(String inDate) {
        String day = inDate.charAt(6) + "" + inDate.charAt(7);
        String month = inDate.charAt(4) + "" + inDate.charAt(5);
        String year = inDate.charAt(0) + "" + inDate.charAt(1) + "" + inDate.charAt(2) + "" + inDate.charAt(3);

        int _day = getValueOrNegativeOneForIntegers(day);
        int _month = getValueOrNegativeOneForIntegers(month);
        int _year = getValueOrNegativeOneForIntegers(year);

        if (_day < 1 || _month < 1 || _month > 12 || _year < 1) {
            println("Enter an integer that works please, Thank you!");
            return false;
        }
        if (inDate.length() != 8) {
            println("Enter a correct date EX(yyyy/mm/yy --> 03 07 2000) 8 CHARACTERS");
            return false;
        }

        if (!doesDayFitInMonth(_day, _month, _year)) {
            return false;
        }
        println("Your date is good!");
        return true;
    }

    private boolean doesDayFitInMonth(int day, int month, int year) {
        boolean isItALeapYear = false;
        if (year % 4 == 0) {
            isItALeapYear = true;
        }
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                if (day > 31) {
                    return false;
                }
                break;//All months with 31 days
            case 2://February
                if (isItALeapYear && day > 29) {
                    return false;
                } else if (!isItALeapYear && day > 28) {
                    return false;
                }
            case 4:
            case 6:
            case 9:
            case 11:
                if (day > 30) {
                    return false;
                }
                break;//All months with 30 days
        }

        return true;
    }

    private void println(String text) {
        System.out.println(text);
    }


    private int getValueOrNegativeOneForIntegers(String input) {
        int result;
        try {
            result = Integer.valueOf(input);
        } catch (NumberFormatException exception) {
            result = -1;
        }
        return result;
    }
}


