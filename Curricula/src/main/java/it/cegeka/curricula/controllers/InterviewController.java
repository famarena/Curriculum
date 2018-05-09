package it.cegeka.curricula.controllers;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import it.cegeka.curricula.entities.Interview;
import it.cegeka.curricula.service.InterviewService;

@Controller
@RequestMapping(path="/interview")
public class InterviewController {
	@Autowired 
	private InterviewService interviewService;
	
	@GetMapping(path="/newInterview")
	@ResponseBody
	public String newInterview() {
		String dateToDate ="2018-12-03 15:30";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		LocalDateTime dateTime = LocalDateTime.parse(dateToDate, formatter);
		interviewService.newInterview(dateTime, 1L, 1L, 3L);
		
		return "creato";
	}
	@GetMapping(path="/date")
	@ResponseBody
	public String dateInterview() {
		String dateToDate ="2018-12-03" + " 00:00";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		LocalDateTime dateTime = LocalDateTime.parse(dateToDate, formatter);
		LocalDateTime tomorrow = dateTime.plusDays(1L);
		List<Interview> i = interviewService.findByDateTimeBetween(dateTime, tomorrow);
		return i.toString();
	}
}
