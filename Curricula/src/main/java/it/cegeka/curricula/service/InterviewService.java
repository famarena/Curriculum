package it.cegeka.curricula.service;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;

import it.cegeka.curricula.entities.Candidate;
import it.cegeka.curricula.entities.Selector;
import it.cegeka.curricula.repository.CandidateRepository;
import it.cegeka.curricula.repository.InterviewRepository;

public class InterviewService {
	
	@Autowired
	private InterviewRepository interviewRepository;
	
	@Autowired
	private CandidateRepository candidateRepository;

	
	public void newInterview(LocalDateTime dateTime, Long idCandidate, Long idSelector) {
		
	}
	
	
	
	
	
}
