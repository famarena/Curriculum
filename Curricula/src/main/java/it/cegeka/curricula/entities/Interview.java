package it.cegeka.curricula.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="interview")

public class Interview {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name = "id_interview")
	private int idInterview;
	@Column(name = "status")
	private String status;
	@Column(name = "feedback")
	private String feedback;
	@Column(name="date_time")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateTime;
	
	
	@ManyToOne(cascade= CascadeType.ALL)
	@JoinColumn(name="id_candidate")
	private Candidate candidate;
	
	@ManyToOne(cascade= CascadeType.ALL)
	@JoinColumn(name="id_selector")
	private Selector selector;
	
	@ManyToOne(cascade= CascadeType.ALL)
	@JoinColumn(name="job_position")
	private JobPosition jobPosition;
	
	

	
	
	public Interview() {
		
	}

	
	public int getIdInterview() {
		return idInterview;
	}

	public void setIdInterview(int idInterview) {
		this.idInterview = idInterview;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	public Candidate getCandidate() {
		return candidate;
	}

	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}

	public Selector getSelector() {
		return selector;
	}

	public void setSelector(Selector selector) {
		this.selector = selector;
	}


	public Date getDateTime() {
		return dateTime;
	}


	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}


	public JobPosition getJobPosition() {
		return jobPosition;
	}


	public void setJobPosition(JobPosition jobPosition) {
		this.jobPosition = jobPosition;
	}


	
}
