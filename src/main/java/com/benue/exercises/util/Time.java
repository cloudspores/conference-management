package com.benue.exercises.util;

import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * Time representation utility
 *
 * @author Ade Lucas
 */
public class Time {

	private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm");

	/**
	* Convert supplied time in minutes to string representation in 12 hour and minutes
	*
	* @param minutes the time in minutes to be converted.
	* @return time in minutes to string representation in 12 hour and minutes
	*/
	public static String minutes2HoursMinutes(int minutes) {

		LocalTime localtime	 = LocalTime.MIN.plus(Duration.ofMinutes(minutes));
		String amPmIndicator = (minutes>=720) ? "PM" : "AM";

		return localtime.format(formatter) + amPmIndicator;
	}
}
