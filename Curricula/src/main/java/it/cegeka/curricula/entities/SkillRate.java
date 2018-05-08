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
@Table(name="skill_rate")
public class SkillRate {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name = "id_skill_rate")
	private Long idSkillRate;
	@Column(name = "declared_value")
	private int declaredValue;
	@Column(name = "real_value")
	private int realValue;
	
	
	@ManyToOne(cascade= CascadeType.ALL)
	@JoinColumn(name="skill")
	private Skill skill;
	
	@ManyToOne(cascade= CascadeType.ALL)
	@JoinColumn(name="candidate")
	private Candidate candidate;
	
	
	
	public Long getIdSkillRate() {
		return idSkillRate;
	}
	public void setIdSkillRate(Long idSkillRate) {
		this.idSkillRate = idSkillRate;
	}
	public Skill getSkill() {
		return skill;
	}
	public void setSkill(Skill skill) {
		this.skill = skill;
	}
	public Candidate getCandidate() {
		return candidate;
	}
	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}
	public int getDeclaredValue() {
		return declaredValue;
	}
	public void setDeclaredValue(int declaredValue) {
		this.declaredValue = declaredValue;
	}
	public int getRealValue() {
		return realValue;
	}
	public void setRealValue(int realValue) {
		this.realValue = realValue;
	}
	
	
}
