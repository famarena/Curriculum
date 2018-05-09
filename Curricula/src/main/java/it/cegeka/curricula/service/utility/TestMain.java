package it.cegeka.curricula.service.utility;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class TestMain {

	public static void main(String[] args) {
		String dateToDate ="2018-12-03" + " 00:00";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		LocalDateTime dateTime = LocalDateTime.parse(dateToDate, formatter);
		LocalDateTime tomorrow = dateTime.plusDays(1L);
		
		System.out.print(dateTime.toString());
	}

}
