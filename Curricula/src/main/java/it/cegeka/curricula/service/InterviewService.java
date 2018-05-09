package it.cegeka.curricula.service;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.cegeka.curricula.entities.Candidate;
import it.cegeka.curricula.entities.Interview;
import it.cegeka.curricula.entities.JobPosition;
import it.cegeka.curricula.entities.Selector;
import it.cegeka.curricula.enums.Status;
import it.cegeka.curricula.repository.CandidateRepository;
import it.cegeka.curricula.repository.InterviewRepository;
import it.cegeka.curricula.repository.PositionRepository;
import it.cegeka.curricula.repository.SelectorRepository;
@Service
public class InterviewService {
	
	@Autowired
	private InterviewRepository interviewRepository;
	
	@Autowired
	private CandidateRepository candidateRepository;

	@Autowired
	private SelectorRepository selectorRepository;
	
	@Autowired
	private PositionRepository positionRepository;
	
	public void newInterview(LocalDateTime dateTime, Long idCandidate, Long idSelector, Long idPosition) {
			
		Interview interview = new Interview();
		Selector selector = selectorRepository.findByIdSelector(idSelector);
		Candidate candidate = candidateRepository.findByIdCandidate(idCandidate);
		JobPosition jobPosition = positionRepository.findByIdPosition(idPosition);
		interview.setCandidate(candidate);
		interview.setSelector(selector);
		interview.setDateTime(dateTime);
		interview.setJobPosition(jobPosition);
		interview.setStatus(Status.PLANNED);
		selector.getInterviews().add(interview);
		candidate.getInterviews().add(interview);
		jobPosition.getInterviews().add(interview);
		interviewRepository.save(interview);
		selectorRepository.save(selector);
		candidateRepository.save(candidate);
		positionRepository.save(jobPosition);
	}
	
	
	public void updateStatus(Status status, Long idInterview) {
		
		Interview interview = interviewRepository.findByIdInterview(idInterview);
		interview.setStatus(status);
		interviewRepository.save(interview);
	}
	
	public void updateFeedback(String feedback, Long idInterview) {
			
		Interview interview = interviewRepository.findByIdInterview(idInterview);
		if(interview.getDateTime().isBefore(LocalDateTime.now())) 
		{
			interview.setFeedback(feedback);
			interviewRepository.save(interview);
		}
		
	}
	
	
	
}
