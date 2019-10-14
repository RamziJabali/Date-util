public class DateUtil {
    private boolean isItALeapYear = false;

    public boolean checkGregorianDate(String inDate) {
        String day, month, year;
        int _day, _month, _year;
        if (inDate.length() == 8) {
            day = inDate.charAt(6) + "" + inDate.charAt(7);
            month = inDate.charAt(4) + "" + inDate.charAt(5);
            year = inDate.charAt(0) + "" + inDate.charAt(1) + "" + inDate.charAt(2) + "" + inDate.charAt(3);
            _day = getValueOrNegativeOneForIntegers(day);
            _month = getValueOrNegativeOneForIntegers(month);
            _year = getValueOrNegativeOneForIntegers(year);
        } else {
            println("Enter a correct date EX(yyyy/mm/yy --> 03 07 2000) 8 CHARACTERS");
            return false;
        }

        if (_day < 1 || _month < 1 || _month > 12 || _year < 1) {
            println("Enter an integer that works please, Thank you!");
            return false;
        }

        if (!doesDayFitInMonth(_day, _month, _year)) {
            return false;
        }
        println("Your Gregorian date is good!");
        return true;
    }

    public boolean checkJulianDate(String inDate) {
        String day, year;
        int _day;
        if (inDate.length() == 7) {
            day = inDate.charAt(4) + "" + inDate.charAt(5) + "" + inDate.charAt(6);
            year = inDate.charAt(0) + "" + inDate.charAt(1) + "" + inDate.charAt(2) + "" + inDate.charAt(3);
            _day = getValueOrNegativeOneForIntegers(day);
        } else {
            println("Enter a correct date EX(yyyy/mm/yy --> 03 07 2000) 7 CHARACTERS");
            return false;
        }

        if (_day < 1 || _day > 365 || year.length() != 4) {
            println("Enter an integer that works please, Thank you!");
            return false;
        }
        println("Your Julian date is good!");
        return true;
    }

    private boolean doesDayFitInMonth(int day, int month, int year) {
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

    public String gregorianDateToJulianDate(String inDate) {
        String day = inDate.charAt(6) + "" + inDate.charAt(7);
        String month = inDate.charAt(4) + "" + inDate.charAt(5);
        String year = inDate.charAt(0) + "" + inDate.charAt(1) + "" + inDate.charAt(2) + "" + inDate.charAt(3);
        int _day = getValueOrNegativeOneForIntegers(day);
        int _month = getValueOrNegativeOneForIntegers(month);

        int totalDays = _day + monthToDays(_month);
        String julianDate;
        if ((_day + "").length() < 3) {
            julianDate = year + "0" + totalDays + "";
        } else {
            julianDate = year + "" + totalDays + "";
        }
        return julianDate;
    }

    public String julianDateToGregorianDate(String inDate) {
        int month = 0;
        String year = inDate.charAt(0) + "" + inDate.charAt(1) + "" + inDate.charAt(2) + "" + inDate.charAt(3);
        String day = inDate.charAt(4) + "" + inDate.charAt(5) + "" + inDate.charAt(6);
        String gregorianDate = "";
        int _day = getValueOrNegativeOneForIntegers(day);

        for (int i = 1; i <= 12; i++) {
            if (numberOfDaysInMonth(i) < _day) {
                _day -= numberOfDaysInMonth(i);
                month++;
            } else if (numberOfDaysInMonth(i) == _day) {
                break;
            } else {
                month++;
                break;
            }
        }
        if (_day < 10 && month < 10) {
            gregorianDate = year + "0" + month + "0" + _day;
        } else if (_day < 10 && month >= 10) {
            gregorianDate = year + "" + month + "0" + _day;
        } else if (_day >= 10 && month < 10) {
            gregorianDate = year + "0" + month + "" + _day;
        } else {
            gregorianDate = year + "" + month + "" + _day;
        }
        return gregorianDate;
    }

    public String dayOfTheWeekFromGregorianDate(String inDate) {
        String day = inDate.charAt(6) + "" + inDate.charAt(7);//k - day
        String month = inDate.charAt(4) + "" + inDate.charAt(5);//month
        String year = inDate.charAt(2) + "" + inDate.charAt(3);//year
        String century = inDate.charAt(0) + "" + inDate.charAt(1);//century
        int k = getValueOrNegativeOneForIntegers(day);
        int m = getValueOrNegativeOneForIntegers(month);
        int Y = getValueOrNegativeOneForIntegers(year);
        int C = getValueOrNegativeOneForIntegers(century);

        int W = (int) (k + (2.6 * (m) - .2) - 2 * C + Y + (Y / 4) + (C / 4)) % 7;
        return getDayOfTheWeek(W);
    }

    private String getDayOfTheWeek(int w) {
        switch (w) {
            case 0:
                return "Sunday";
            case 1:
                return "Monday";
            case 2:
                return "Tuesday";
            case 3:
                return "Wednesday";
            case 4:
                return "Thursday";
            case 5:
                return "Friday";
            case 6:
                return "Saturday";
        }
        return null;
    }

    public String daysDiff(String date1, String date2) {
        date1 = gregorianDateToJulianDate(date1);
        date2 = gregorianDateToJulianDate(date2);
        String year1 = date1.charAt(0) + "" + date1.charAt(1) + "" + date1.charAt(2) + "" + date1.charAt(3);
        String day1 = date1.charAt(4) + "" + date1.charAt(5) + "" + date1.charAt(6);
        String year2 = date2.charAt(0) + "" + date2.charAt(1) + "" + date2.charAt(2) + "" + date2.charAt(3);
        String day2 = date2.charAt(4) + "" + date2.charAt(5) + "" + date2.charAt(6);

        int _year1 = getValueOrNegativeOneForIntegers(year1);
        int _day1 = getValueOrNegativeOneForIntegers(day1);
        int _year2 = getValueOrNegativeOneForIntegers(year2);
        int _day2 = getValueOrNegativeOneForIntegers(day2);
        int yearDifference = Math.abs(_year1 - _year2);
        int yearDifferenceInDays = (yearDifference / 4) + (365 * yearDifference);
        int dayDifferenceIs = yearDifferenceInDays + (Math.abs(_day1 - _day2));

        if (getIsItALeapYear(_year1)) {
            dayDifferenceIs++;
        }
        if (getIsItALeapYear(_year2)) {
            dayDifferenceIs++;
        }
        return dayDifferenceIs + "";
    }

    private boolean getIsItALeapYear(int year) {
        if (year % 4 == 0) {
            return true;
        }
        return false;
    }

    private int monthToDays(int month) {
        int days = 0;
        for (int i = 1; i <= month; i++) {
            days += numberOfDaysInMonth(i);
        }
        return days;
    }

    private int numberOfDaysInMonth(int month) {
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return 31;
            case 2://February
                if (isItALeapYear) {
                    return 29;
                }
                return 28;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
        }
        return -1;
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


