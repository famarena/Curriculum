package it.cegeka.curricula.controllers;

import java.net.URI;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import it.cegeka.curricula.entities.Interview;
import it.cegeka.curricula.enums.Status;
import it.cegeka.curricula.service.InterviewService;
import it.cegeka.curricula.service.utility.InterviewParameter;

@RestController
@RequestMapping(path="/interview")
public class InterviewController {
	@Autowired 
	private InterviewService interviewService;
	
	@PostMapping(path="/interviews")
	public ResponseEntity<Object> newInterview(@RequestBody InterviewParameter parameter) {
		Interview i = interviewService.newInterview(parameter);
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(i.getIdInterview()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	
	@GetMapping(path="/interviews/{id}")
	public Resource<Interview> retrieveInterview(@PathVariable Long id){
		Interview interview =  interviewService.findInterviewById(id);
		Resource<Interview> resource = new Resource<Interiew>(interview);
		
		
		return null;
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
	
	@GetMapping(path="/updateStatus")
	@ResponseBody
	public String updateStatus() {
		interviewService.updateStatus(Status.ASSIGNED, 1L);
		return "updated";
	}
	
}
