import java.util.Scanner;
/**
* To test if the month is printed out correcrly.
*/

public class CalendarTester {

  // tests if the century is returned correctly
  public static boolean testGetCentury() {
    if (CalendarPrinter.getCentury("2") != 0)
      return false;
    if (CalendarPrinter.getCentury("2019") != 20)
      return false;
    if (CalendarPrinter.getCentury("44444") != 444)
      return false;
    else
      return true;
  }

  // tests if the year in the century is returned correctly
  public static boolean testGetYearWithinCentury() {
    if (CalendarPrinter.getYearWithinCentury("1550") != 50)
      return false;
    else if (CalendarPrinter.getYearWithinCentury("6543") != 43)
      return false;
    else if (CalendarPrinter.getYearWithinCentury("15567") != 67)
      return false;
    else
      return true;
  }

  // tests if leap year was determined correctly
  public static boolean testGetIsLeapYear() {
    boolean leapYear = true;

    if (CalendarPrinter.getIsLeapYear("2020") != leapYear) {
      return false;
    }
    if (CalendarPrinter.getIsLeapYear("2036") != leapYear) {
      return false;
    }
    if (CalendarPrinter.getIsLeapYear("12800") != leapYear) {
      return false;
    } else {
      return true;
    }
  }

  // checks if the month index was determined correctly
  public static boolean testGetMonthIndex() {
    // Test 1: Gets the index of January
    if (CalendarPrinter.getMonthIndex("january") != 0)
      return false;
    if (CalendarPrinter.getMonthIndex("MarCH") != 2)
      return false;
    // Test 3: gets the index of December
    if (CalendarPrinter.getMonthIndex("dEcember") != 11)
      return false;
    // Test 4: if the input matches none of the months in MONTHS_OF_YEAR
    if (CalendarPrinter.getMonthIndex("flower") != -1)
      return false;
    else
      return true;
  }

  // checks if the number of days in the month was determined correctly
  public static boolean testGetNumberOfDaysInMonth() {
    // Test 1: gets the number of days in January during a common year
    if (CalendarPrinter.getNumberOfDaysInMonth("JaNuary", "2019") != 31)
      return false;
    // Test 2: gets number of days in February during a leap year
    if (CalendarPrinter.getNumberOfDaysInMonth("feBruary", "2020") != 29)
      return false;
    // Test 3: gets the number of days in February during a common year
    if (CalendarPrinter.getNumberOfDaysInMonth("february", "2035") != 28)
      return false;
    else
      return true;
  }
  

    // checks if the first day of the week in the month was determined correctly
  public static boolean testGetFirstDayOfWeekInMonth() {
    // Test 1: Test if method retrieves the day of the week correctly
    if (CalendarPrinter.getFirstDayOfWeekInMonth("march", "2019") != 4)
      return false;
    // Test 2: checks if February is calculated correctly
    if (CalendarPrinter.getFirstDayOfWeekInMonth("february", "1997") != 5)
      return false;
    // Test 3:
    if (CalendarPrinter.getFirstDayOfWeekInMonth("august", "3900") != 2)
      return false;
    if (CalendarPrinter.getFirstDayOfWeekInMonth("feb", "1975") != 5)
      return false;
    else
      return true;
  }
  // tests if the calendar was generated correctly
  public static boolean testGenerateCalendar() {

    String[] daysOfWeek = {"MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"};
    String[][] calendar = new String[7][7];
    CalendarPrinter.generateCalendar("march", "2019");
    int daysInMonth = CalendarPrinter.getNumberOfDaysInMonth("march", "2019");

    // for (int i = 0; i < 7; i++) {

    for (int i = 0; i < 7; i++) {
      for (int j = 0; j < daysInMonth; j++) {

      }
    }

    return false;
  }

  public static void main(String[] args) {

    System.out.println(testGetCentury());
    System.out.println(testGetYearWithinCentury());
    System.out.println(testGetIsLeapYear());
    System.out.println(testGetMonthIndex());
    System.out.println(testGetNumberOfDaysInMonth());
    System.out.println(testGetFirstDayOfWeekInMonth());
    System.out.println(testGenerateCalendar());


  }
}
