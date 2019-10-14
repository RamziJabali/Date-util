//TODO TEST TEST TEST TEST TEST TEST TEST TEST TEST TEST TEST TEST TEST TEST

import java.util.Scanner;

public class Test {
    private static Scanner kb = new Scanner(System.in);

    public static void main(String[] args) {
        DateUtil test = new DateUtil();
        int userChoice;
        do {
            System.out.println("[0] to quit \n" +
                    "[1] To Check Your gregorian date\n" +
                    "[2] To check your julian date\n" +
                    "[3] To convert gregorian to Julian\n" +
                    "[4] To convert Julian to Gregorian\n" +
                    "[5] To find what day of the week your gregorian date occurred in\n" +
                    "[6] To find the difference between two dates in DAYS\n" +
                    "[7] To find the number of days worked in a normal work schedule && \n" +
                    "number of days worked during a holiday");
            userChoice = kb.nextInt();
            switch (userChoice) {
                case 0:
                    quit();
                    break;
                default:
                case 1:
                    System.out.println("Enter Gregorian Date Ex yyyymmdd");
                    if (test.checkGregorianDate(kb.next())) {
                        System.out.println("Your date is Valid good job");
                    } else {
                        System.out.println("Invalid Gregorian Date");
                    }
                    System.out.println("Process Complete...");
                    break;
                case 2:
                    System.out.println("Enter Julian Date Ex yyyyddd");
                    if (test.checkJulianDate(kb.next())) {
                        System.out.println("Your date is Valid good job");
                    } else {
                        System.out.println("Invalid Julian Date");
                    }
                    System.out.println("Process Complete...");
                    break;
                case 3:
                    System.out.println("Enter Gregorian Date Ex yyyymmdd");
                    String gregorianDate = kb.next();
                    if (test.checkGregorianDate(gregorianDate)) {
                        System.out.println("Your Julian date is: " + test.gregorianDateToJulianDate(gregorianDate));
                        System.out.println("Process Complete...");
                    } else {
                        System.out.println("Sorry can't process this since it's incorrect");
                        System.out.println("Process Complete...");
                    }
                    break;
                case 4:
                    System.out.println("Enter Julian Date Ex yyyyddd");
                    String julianDate = kb.next();
                    if (test.checkJulianDate(julianDate)) {
                        System.out.println("Your Gregorian date is: " + test.julianDateToGregorianDate(julianDate));
                        System.out.println("Process Complete...");

                    } else {
                        System.out.println("Sorry can't process this since it's incorrect");
                    }
                    break;
                case 5:
                    System.out.println("Enter Gregorian Date Ex yyyymmdd");
                    String gregorianDate2 = kb.next();
                    if (test.checkGregorianDate(gregorianDate2)) {
                        System.out.println("Your date is Valid, I will continue");
                        System.out.println("Your date tells me that that day of the week is: " + test.dayOfTheWeekFromGregorianDate(gregorianDate2));
                    } else {
                        System.out.println("Invalid Gregorian Date");
                    }
                    System.out.println("Process Complete...");
                    break;
                case 6:
                    String startDate, endDate;
                    do {
                        System.out.println("Enter start date(Gregorian): ");
                        startDate = kb.next();
                    } while (!test.checkGregorianDate(startDate));
                    do {
                        System.out.println("Enter end date(Gregorian): ");
                        endDate = kb.next();
                    } while (!test.checkGregorianDate(endDate));
                    System.out.println("The difference between the two dates is: " + test.daysDiff(startDate, endDate));
                    break;
                case 7:
                    String startDateWork, endDateWork, startDateHoliday, endDateHoliday;
                    do {
                        System.out.println("Enter start work date(Gregorian): ");
                        startDateWork = kb.next();
                    } while (!test.checkGregorianDate(startDateWork));
                    do {
                        System.out.println("Enter end work date(Gregorian): ");
                        endDateWork = kb.next();
                    } while (!test.checkGregorianDate(endDateWork));
                    do {
                        System.out.println("Enter start holiday date(Gregorian): ");
                        startDateHoliday = kb.next();
                    } while (!test.checkGregorianDate(startDateHoliday));
                    do {
                        System.out.println("Enter end holiday date(Gregorian): ");
                        endDateHoliday = kb.next();
                    } while (!test.checkGregorianDate(endDateHoliday));
                    test.daysTypeCount(startDateWork, endDateWork, startDateHoliday, endDateHoliday);
                    System.out.println("The days you worked on the holidays are: " + test.getHolidaysWorked());
                    System.out.println("The days you worked on your normal work days are: " + test.getWorkDaysWorked());
                    break;
            }
        } while (userChoice != 0);

    }

    private static void quit() {
        System.out.print("App is shutting down....");
    }
}