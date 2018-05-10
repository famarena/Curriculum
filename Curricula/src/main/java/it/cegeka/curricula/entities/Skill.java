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

import com.fasterxml.jackson.annotation.JsonIgnore;

import it.cegeka.curricula.enums.SkillCategory;

@Entity
@Table(name="skill")
public class Skill {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name = "id_skill")
	private Long idSkill;
	@Column(name = "name")
	private String name;
	@Column(name = "category")
	@Enumerated(EnumType.STRING)
	private SkillCategory category;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL ,mappedBy = "skill")
	private List<SkillRate> skillRates = new ArrayList<SkillRate>();
	
	@OneToMany(cascade = CascadeType.ALL ,mappedBy = "skill")
	@JsonIgnore
	private List<RequiredSkill> requiredSkills = new ArrayList<RequiredSkill>();

	
	
	
	public Long getIdSkill() {
		return idSkill;
	}
	public void setIdSkill(Long idSkill) {
		this.idSkill = idSkill;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public SkillCategory getCategory() {
		return category;
	}
	public void setCategory(SkillCategory category) {
		this.category = category;
	}
	public List<SkillRate> getSkillRates() {
		return skillRates;
	}
	public void setSkillRates(List<SkillRate> skillRates) {
		this.skillRates = skillRates;
	}
	public List<RequiredSkill> getRequiredSkills() {
		return requiredSkills;
	}
	public void setRequiredSkills(List<RequiredSkill> requiredSkills) {
		this.requiredSkills = requiredSkills;
	}
	
	
}
