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
	private int idSkill;
	@Column(name = "name")
	private String name;
	
	@OneToMany(cascade = CascadeType.ALL ,mappedBy = "skill")
	private List<SkillRate> skillRates = new ArrayList<SkillRate>();
	
	@OneToMany(cascade = CascadeType.ALL ,mappedBy = "skill")
	private List<RequiredSkills> requiredSkills = new ArrayList<RequiredSkills>();

	
	
	
	public int getIdSkill() {
		return idSkill;
	}
	public void setIdSkill(int idSkill) {
		this.idSkill = idSkill;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
