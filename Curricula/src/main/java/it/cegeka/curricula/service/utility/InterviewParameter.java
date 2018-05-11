package it.cegeka.curricula.service.utility;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import it.cegeka.curricula.entities.Interview;

public class InterviewParameter {

	private LocalDateTime dateTime;
	private Long idCandidate;
	private Long idSelector;
	private Long idPosition;
	private String stringDateTime;
	private String positionName;
	private String candidateName;
	private String selectorName;
	
	public InterviewParameter(){
		
	}
	
	public InterviewParameter(Interview interview){
		this.idCandidate = interview.getCandidate().getIdCandidate();
		this.idSelector = interview.getSelector().getIdSelector();
		this.idPosition = interview.getJobPosition().getIdPosition();
		this.dateTime = interview.getDateTime();
		this.candidateName =  interview.getCandidate().getName();
		this.positionName = interview.getJobPosition().getPositionName();
		this.selectorName = interview.getSelector().getName();
		}
	
	public InterviewParameter(String stringDateTime,Long idCandidate, Long idSelector, Long idPosition) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		LocalDateTime dateTime = LocalDateTime.parse(stringDateTime, formatter);
		this.dateTime = dateTime;
		this.idCandidate = idCandidate;
		this.idSelector = idSelector;
		this.idPosition = idPosition;
		
	}
	
	
	
	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public Long getIdCandidate() {
		return idCandidate;
	}

	public void setIdCandidate(Long idCandidate) {
		this.idCandidate = idCandidate;
	}

	public Long getIdSelector() {
		return idSelector;
	}


	public Long getIdPosition() {
		return idPosition;
	}

	public void setIdPosition(Long idPosition) {
		this.idPosition = idPosition;
	}

	public String getStringDateTime() {
		return stringDateTime;
	}

	public void setStringDateTime(String stringDateTime) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		LocalDateTime dateTime = LocalDateTime.parse(stringDateTime, formatter);
		this.dateTime = dateTime;
		this.stringDateTime = stringDateTime;
	}

	public void setIdSelector(Long idSelector) {
		this.idSelector = idSelector;
	}

	public String getPositionName() {
		return positionName;
	}

	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}

	public String getCandidateName() {
		return candidateName;
	}
	
	
	

	public void setCandidateName(String candidateName) {
		this.candidateName = candidateName;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	public String getSelectorName() {
		return selectorName;
	}

	public void setSelectorName(String selectorName) {
		this.selectorName = selectorName;
	}

	@Override
	public String toString() {
		return "InterviewParameter [dateTime=" + dateTime + ", stringDateTime=" + stringDateTime + "]";
	}

	
}
