package com.market.api.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Implements of static function by calculate diff in two dates
 *
 * @author Samuel Stalschus
 */
public class JavaTimeDifference {

  /**
   * Diference between in days integer.
   *
   * @param timestamp1 the timestamp 1
   * @param timestamp2 the timestamp 2
   * @return the integer
   */
  public static Integer diferenceBetweenInDays(Timestamp timestamp1, Timestamp timestamp2) {
    long milliseconds = timestamp2.getTime() - timestamp1.getTime();
    int seconds = (int) milliseconds / 1000;
    int hours = seconds / 3600;
    return hours / 24;
  }

  /**
   * Date now timestamp.
   *
   * @return the timestamp
   */
  public static Timestamp dateNow() {
    Date date = new Date();
    return new Timestamp(date.getTime());
  }

  /**
   * To timestamp timestamp.
   *
   * @param date the date
   * @return the timestamp
   */
  public static Timestamp toTimestamp(String date) {
    try {
      return new Timestamp(new SimpleDateFormat("yyyy-MM-dd").parse(date)
          .getTime());
    } catch (ParseException e) {
      return null;
    }
  }

}
