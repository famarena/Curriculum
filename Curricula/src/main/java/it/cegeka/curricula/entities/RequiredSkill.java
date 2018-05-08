package it.cegeka.curricula.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="required_skill")
public class RequiredSkill {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name = "id_required_skill")
	private Long idRequiredSkill;
	@Column(name="min")
	private int min;
	
	
	
	@ManyToOne(cascade= CascadeType.ALL)
	@JoinColumn(name="job_position")
	private JobPosition jobPosition;
	
	@ManyToOne(cascade= CascadeType.ALL)
	@JoinColumn(name="skill")
	private Skill skill;
	
	
	public Skill getSkill() {
		return skill;
	}
	public void setSkill(Skill skill) {
		this.skill = skill;
	}
	public Long getIdRequiredSkill() {
		return idRequiredSkill;
	}
	public void setIdRequiredSkill(Long idRequiredSkill) {
		this.idRequiredSkill = idRequiredSkill;
	}
	public int getMin() {
		return min;
	}
	public void setMin(int min) {
		this.min = min;
	}
	public JobPosition getJobPosition() {
		return jobPosition;
	}
	public void setJobPosition(JobPosition jobPosition) {
		this.jobPosition = jobPosition;
	}

	
	
}
