package it.cegeka.curricula.service;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.cegeka.curricula.entities.Candidate;
import it.cegeka.curricula.entities.Interview;
import it.cegeka.curricula.entities.Selector;
import it.cegeka.curricula.repository.CandidateRepository;
import it.cegeka.curricula.repository.InterviewRepository;
import it.cegeka.curricula.repository.SelectorRepository;
@Service
public class InterviewService {
	
	@Autowired
	private InterviewRepository interviewRepository;
	
	@Autowired
	private CandidateRepository candidateRepository;

	@Autowired
	private SelectorRepository selectorRepository;
	
	public void newInterview(LocalDateTime dateTime, Long idCandidate, Long idSelector) {
			
		Interview interview = new Interview();
		interview.setDateTime(dateTime);
		Selector selector = selectorRepository.findSelectorById(idSelector);
		Candidate candidate = candidateRepository.findCandidateById(idCandidate);
		interview.setCandidate(candidate);
		interview.setSelector(selector);
		selector.getInterviews().add(interview);
		candidate.getInterviews().add(interview);
		selectorRepository.save(selector);
		candidateRepository.save(candidate);
		interviewRepository.save(interview);
		
		
		
	}
	
	
	
	
	
}
