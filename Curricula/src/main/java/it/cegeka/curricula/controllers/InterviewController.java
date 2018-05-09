package it.cegeka.curricula.controllers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import it.cegeka.curricula.service.InterviewService;

@Controller
@RequestMapping(path="/interview")
public class InterviewController {
	@Autowired 
	private InterviewService interviewService;
	
	@GetMapping(path="/newInterview")
	@ResponseBody
	public String newInterview() {
		String dateToDate ="2018-12-3 15:30";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		LocalDateTime dateTime = LocalDateTime.parse(dateToDate, formatter);
		
		
		interviewService.newInterview(dateTime, 1L, 1L, 1L);
		
		return "creato";
	}
}
