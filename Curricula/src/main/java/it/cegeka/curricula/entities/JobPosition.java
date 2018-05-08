package it.cegeka.curricula.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="job_position")
public class JobPosition {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name = "id_candidate")
	private int idPosition;
	@Column(name="sector")
	private Enum Sector;
	@Column(name = "open")
	private boolean open;
	
	
	@OneToMany(cascade = CascadeType.ALL ,mappedBy = "jobPosition")
	private List<RequiredSkills> requiredSkills = new ArrayList<RequiredSkills>();
	
	@OneToMany(cascade = CascadeType.ALL ,mappedBy = "jobPosition")
	private List<Interview> interviews = new ArrayList<Interview>();
	
	
	
	public List<Interview> getInterviews() {
		return interviews;
	}
	public void setInterviews(List<Interview> interviews) {
		this.interviews = interviews;
	}
	public Enum getSector() {
		return Sector;
	}
	public void setSector(Enum sector) {
		Sector = sector;
	}
	public int getIdPosition() {
		return idPosition;
	}
	public void setIdPosition(int idPosition) {
		this.idPosition = idPosition;
	}
	public boolean isOpen() {
		return open;
	}
	public void setOpen(boolean open) {
		this.open = open;
	}
	public List<RequiredSkills> getRequiredSkills() {
		return requiredSkills;
	}
	public void setRequiredSkills(List<RequiredSkills> requiredSkills) {
		this.requiredSkills = requiredSkills;
	}
	
	
	
	
}