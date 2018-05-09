package it.cegeka.curricula.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import it.cegeka.curricula.enums.Demand;
import it.cegeka.curricula.enums.Sector;

@Entity
@Table(name="job_position")
public class JobPosition {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name = "id_position")
	private Long idPosition;
	@Column(name="sector")
	@Enumerated(EnumType.STRING)
	private Sector sector;
	@Column(name = "demand")
	@Enumerated(EnumType.STRING)
	private Demand demand;
	@Column(name ="position_name")
	private String positionName;
	
	
	@OneToMany(cascade = CascadeType.ALL ,mappedBy = "jobPosition")
	private List<RequiredSkill> requiredSkills = new ArrayList<RequiredSkill>();
	
	@OneToMany(cascade = CascadeType.ALL ,mappedBy = "jobPosition")
	private List<Interview> interviews = new ArrayList<Interview>();
	
	
	
	public List<Interview> getInterviews() {
		return interviews;
	}
	public void setInterviews(List<Interview> interviews) {
		this.interviews = interviews;
	}
	public Sector getSector() {
		return sector;
	}
	public void setSector(Sector sector) {
		this.sector = sector;
	}
	public Long getIdPosition() {
		return idPosition;
	}
	public void setIdPosition(Long idPosition) {
		this.idPosition = idPosition;
	}

	public List<RequiredSkill> getRequiredSkills() {
		return requiredSkills;
	}
	public void setRequiredSkills(List<RequiredSkill> requiredSkills) {
		this.requiredSkills = requiredSkills;
	}
	public String getPositionName() {
		return positionName;
	}
	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}
	public Demand getDemand() {
		return demand;
	}
	public void setDemand(Demand demand) {
		this.demand = demand;
	}
	
	
	
	
}
