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
@Table(name="skill")
public class Skill {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name = "id_skill")
	private Long idSkill;
	@Column(name = "name")
	private String name;
	@Column(name = "category")
	private Enum category;
	
	@OneToMany(cascade = CascadeType.ALL ,mappedBy = "skill")
	private List<SkillRate> skillRates = new ArrayList<SkillRate>();
	
	@OneToMany(cascade = CascadeType.ALL ,mappedBy = "skill")
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
	public Enum getCategory() {
		return category;
	}
	public void setCategory(Enum category) {
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
