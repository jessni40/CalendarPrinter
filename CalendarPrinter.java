//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: CalendarPrinter
// Files: CalendarPrinter.java, CalendarTester.java
// Course: CS 300, FALL, 2019
//
// Author: Jessica Ni
// Email: jni29@wisc.edu
// Lecturer's Name: Gary Dahl
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name: (name of your pair programming partner)
// Partner Email: (email address of your programming partner)
// Partner Lecturer's Name: (name of your partner's lecturer)
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
// ___ Write-up states that pair programming is allowed for this assignment.
// ___ We have both read and understand the course Pair Programming Policy.
// ___ We have registered our team prior to the team registration deadline.
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Students who get help from sources other than their partner must fully
// acknowledge and credit those sources of help here. Instructors and TAs do
// not need to be credited here, but tutors, friends, relatives, room mates,
// strangers, and others do. If you received no outside help from either type
// of source, then please explicitly indicate NONE.
//
// Persons: None (identify each person and describe their help in detail)
// Online Sources: None (identify each URL and describe their assistance in detail)
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////

import java.util.Scanner;

/**
* Prints the calendar view of any specified month based on the month and year the user enters.
*/
public class CalendarPrinter {

  private final static String[] DAYS_OF_WEEK = {"MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"};
  private final static String[] MONTHS_OF_YEAR =
      {"JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG", "SEP", "OCT", "NOV", "DEC"};

  /**
   * Calculates the number of centuries (rounded down) that is represented by the specified year
   * (ie. the integer part of year/100).
   * 
   * @param year to compute the century of (based on the Gregorian Calendar AD) String must contain
   *             the digits of a single non-negative int for year.
   * @return number of centuries in the specified year
   */
  // Calculates the century
  public static int getCentury(String year) {

    int intYear = Integer.parseInt(year);
    int century = intYear / 100;

    return century;
  }

  /**
   * Calculates the number of years between the specified year and the first year in the specified
   * year's century. This number is always between 0 - 99.
   * 
   * @param year to compute the year within century of (Gregorian Calendar AD) String must contain
   *             the digits of a single non-negative int for year.
   * @return number of years since first year in the current century
   */

  public static int getYearWithinCentury(String year) {

    int intYear = Integer.parseInt(year);
    int yearDifference = intYear % 100;

    return yearDifference;
  }

  /**
   * This method computes whether the specified year is a leap year or not.
   * 
   * @param yearString is the year that is being checked for leap-year-ness String must contain the
   *                   digits of a single non-negative int for year.
   * @return true when the specified year is a leap year, and false otherwise
   */
  public static boolean getIsLeapYear(String yearString) {
    

    int intYearString = Integer.parseInt(yearString);

    if (intYearString % 4 != 0) {
      return false;
    } else if (intYearString % 100 != 0) {
      return true;
    } else if (intYearString % 400 != 0) {
      return false;
    } else {
      return true;
    }
  }

  /**
   * Converts the name or abbreviation for any month into the index of that month's abbreviation
   * within MONTHS_OF_YEAR. Matches the specified month based only on the first three characters,
   * and is case in-sensitive.
   * 
   * @param month which may or may not be abbreviated to 3 or more characters
   * @return the index within MONTHS_OF_YEAR that a match is found at and returns -1, when no match
   *         is found
   */

  public static int getMonthIndex(String month) {

    String alteredMonth = month.toUpperCase().substring(0, 3);

    for (int i = 0; i < MONTHS_OF_YEAR.length; i++) {
      // compares the month passed in to the months in MONTHS_OF_YEAR[] to identify the index of
      // that month
      if (alteredMonth.equals(MONTHS_OF_YEAR[i])) {
        return i;
      }
    }
    return -1; // if the month is not in MONTHS_OF_YEAR[], return -1
  }

  /**
   * Calculates the number of days in the specified month, while taking into consideration whether
   * or not the specified year is a leap year.
   * 
   * @param month which may or may not be abbreviated to 3 or more characters
   * @param year  of month that days are being counted for (Gregorian Calendar AD) String must
   *              contain the digits of a single non-negative int for year.
   * @return the number of days in the specified month (between 28-31)
   */

  public static int getNumberOfDaysInMonth(String month, String year) {

    int monthIndex = getMonthIndex(month);
    int numOfDays;

    switch (monthIndex) {
      case -1:
        numOfDays = -1;
        break;
      case 3:
      case 5:
      case 8:
      case 10:
        numOfDays = 30;
        break;
      case 1:
        if (getIsLeapYear(year)) {
          numOfDays = 29;
        } else {
          numOfDays = 28;
        }
        break;
      default:
        numOfDays = 31;
    }
    return numOfDays;
  }

  /**
   * Calculates the index of the first day of the week in a specified month. The index returned
   * corresponds to position of this first day of the week within the DAYS_OF_WEEK class field.
   * 
   * @param month which may or may not be abbreviated to 3 or more characters
   * @param year  of month to determine the first day from (Gregorian Calendar AD) String must
   *              contain the digits of a single non-negative int for year.
   * @return index within DAYS_OF_WEEK of specified month's first day
   */

  public static int getFirstDayOfWeekInMonth(String month, String year) {

    int dayOfTheWeek;
    int dayOfTheMonth = 1;
    int monthOfYear = getMonthIndex(month);
    int yearInCentury = getYearWithinCentury(year);

    monthOfYear = monthOfYear + 1;
    if (monthOfYear == 1 || monthOfYear == 2) {
      monthOfYear = monthOfYear + 12; // changes the index of Mar and Feb to 14 and 13
      yearInCentury--; // subtracts 1 from year in century since Mar and Feb are counted as the
                       // previous year
    }
    // Zeller's formula to find the first day of the week in the month
    dayOfTheWeek = (dayOfTheMonth + ((13 * (monthOfYear + 1)) / 5) + yearInCentury
        + (getYearWithinCentury(year) / 4) + (getCentury(year) / 4) + (5 * getCentury(year))) % 7;
    dayOfTheWeek = (dayOfTheWeek + 5) % 7; // changes the index of days of the week output by the
                                           // Zeller's formula
                                           // to match the indexes of DAYS_OF_WEEK[].

    return dayOfTheWeek;
  }

  /**
   * Creates and initializes a 2D String array to reflect the specified month. The first row of this
   * array [0] should contain labels representing the days of the week, starting with Monday, as
   * abbreviated in DAYS_OF_WEEK. Every later row should contain dates under the corresponding days
   * of week. Entries with no corresponding date in the current month should be filled with a single
   * period. There should not be any extra rows that are either blank, unused, or completely filled
   * with periods. For example, the contents for September of 2019 should look as follows, where
   * each horizontal row is stored in different array within the 2d result:
   *
   * Welcome to the Calendar Printer. ================================ Enter the month to print:
   * Februruru-ary Enter the year to print: 2020 MON TUE WED THU FRI SAT SUN . . . . . 1 2 3 4 5 6 7
   * 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 .
   * ================================ Thanks, and have a nice day.
   *
   * @param month which may or may not be abbreviated to 3 or more characters
   * @param year  of month generate calendar for (Gregorian Calendar AD) String must contain the
   *              digits of a single non-negative int for year.
   * @return 2d array of strings depicting the contents of a calendar
   */

  public static String[][] generateCalendar(String month, String year) {

    int daysInMonth = getNumberOfDaysInMonth(month, year);
    int firstDayOfWeek = getFirstDayOfWeekInMonth(month, year);
    String[][] specifiedMonth = new String[7][7];
    int day = 1;


    // populates specifiedMonth[0][k] with stuff in DAYS_OF_WEEK
    for (int k = 0; k < DAYS_OF_WEEK.length; k++) {
      specifiedMonth[0][k] = DAYS_OF_WEEK[k] + " ";
    }
    // fills in dots up to firstDayOfWeek
    for (int j = 0; j < firstDayOfWeek; j++) {
      specifiedMonth[1][j] = " .  ";
    } // days are added in the first week after the first day of the month
    for (int i = firstDayOfWeek; i < 7; i++) {
      specifiedMonth[1][i] = " " + Integer.toString(day++) + "  ";
    } // prints out the days in the remaining in the month
    for (int i = 2; i < 7; i++) {

      for (int j = 0; j < 7; j++) {
        if (day < daysInMonth) {
          if (day < 10 && i == 2)
            // numbers with 1 digit have one more space than 2 digit numbers
            specifiedMonth[i][j] = " " + Integer.toString(day++) + "  ";
          else
            specifiedMonth[i][j] = " " + Integer.toString(day++) + " ";
        } else
          specifiedMonth[i][j] = " .  ";
      }
    }

    return specifiedMonth;
  }

/**
* Calls the driver method to print out the calendar.
*/ 
  public static void main(String[] args) {

    driver(new Scanner(System.in));
  }

  // Prompts user for month and year then prints the contents of the 2D array containing the
  // calendar.
  private static void driver(Scanner input) {
    System.out.println("Welcome to the Calendar Printer. \n" + "================================");
    System.out.print("Enter the month to print: ");
    String month = input.next();
    month = month.trim();
    System.out.print("Enter the year to print: ");
    String year = input.next();

    String[][] calendar = generateCalendar(month, year);

    // Prints out the calendar
    for (int i = 0; i < 6; i++) {
      System.out.println();
      for (int j = 0; j < 7; j++) {
        System.out.print(calendar[i][j]);
      }
      if (!(calendar[6][0].equals(" .  "))) // if there are empty rows, they are not printed
        for (int j = 0; j < 6; j++) {
          System.out.print(calendar[6][j]);
        }
    }
    System.out.print("\n================================\n" + "Thanks, and have a nice day.");
  }
}

