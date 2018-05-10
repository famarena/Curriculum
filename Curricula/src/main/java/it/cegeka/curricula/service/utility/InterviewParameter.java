package it.cegeka.curricula.service.utility;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class InterviewParameter {

	private LocalDateTime dateTime;
	private Long idCandidate;
	private Long idSelector;
	private Long idPosition;
	private String stringDateTime;
	
	public InterviewParameter(){
		
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

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
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
		this.stringDateTime = stringDateTime;
	}

	public void setIdSelector(Long idSelector) {
		this.idSelector = idSelector;
	}

	
}
