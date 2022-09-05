package com.alok.aut.project.Util;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
public class DateManager {

	public static String getDate(String[] args) {
		LocalDateTime dateObj = LocalDateTime.now();
		DateTimeFormatter formatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		String formattedDate = dateObj.format(formatObj);
		return formattedDate;
	}
	public static String getDateAfterNDays (int days) {
		LocalDate dateObj = LocalDate.now ();
		LocalDate dateAfterNDays = dateObj.plusDays (days);
		return  dateAfterNDays.toString ();
	}
	public static String getDateBeforeNDays (int days) {
		LocalDate dateObj = LocalDate.now ();
		LocalDate dateBeforeNDays = dateObj.minusDays (days);
		return  dateBeforeNDays.toString ();
	}

	public static Boolean timeCompare(String timeOne, String timeTwo) throws ParseException {
		SimpleDateFormat parser = new SimpleDateFormat("HH:mm");
		Date dateOne = parser.parse(timeOne);
		Date dateTwo = parser.parse(timeTwo);
		if (dateTwo.after(dateOne) || dateTwo.equals(dateOne)) {
			return true;
		} else {
			return false;
		}
	}
	public static String getTimeStamp(){

		DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HH-mm-ss");
		Date date = new Date();
		String  timeStamp = dateFormat.format(date);
		return timeStamp;
	}

}
