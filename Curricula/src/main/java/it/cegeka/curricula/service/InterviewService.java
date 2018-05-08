package it.cegeka.curricula.service;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;

import it.cegeka.curricula.entities.Candidate;
import it.cegeka.curricula.entities.Selector;
import it.cegeka.curricula.repository.InterviewRepository;

public class InterviewService {
	
	@Autowired
	private InterviewRepository interviewRepository;
	
	public void newInterview(LocalDateTime dateTime, Candidate candidate, Selector selector) {
		
	}
	
	
	
}
