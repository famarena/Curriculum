package it.cegeka.curricula.entities;

import java.time.LocalDate;
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

import org.hibernate.annotations.Cascade;


@Entity
@Table(name="candidate")

public class Candidate {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name = "id_candidate")
	private int idCandidate;
	@Column(name = "name")
	private String name;
	@Column(name = "surname")
	private String surname;
	@Column(name = "birthday")
	private LocalDate birthday;
	@Column(name = "age")
	private int age;
	@Column(name = "curriculum")
	private String curriculum;
	
	@OneToMany(cascade = CascadeType.ALL ,mappedBy = "candidate")
	private List<Interview> interviews = new ArrayList<Interview>();
	
	@OneToMany(cascade = CascadeType.ALL ,mappedBy = "candidate")
	private List<SkillRate> skillrates = new ArrayList<SkillRate>();
	
	public Candidate() {
		
	}

	public int getIdCandidate() {
		return idCandidate;
	}
	public void setIdCandidate(int idCandidate) {
		this.idCandidate = idCandidate;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}

	public String getCurriculum() {
		return curriculum;
	}

	public void setCurriculum(String curriculum) {
		this.curriculum = curriculum;
	}


	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public List<Interview> getInterviews() {
		return interviews;
	}
	public void setInterviews(List<Interview> interviews) {
		this.interviews = interviews;
	}
	public List<SkillRate> getSkillrates() {
		return skillrates;
	}
	public void setSkillrates(List<SkillRate> skillrates) {
		this.skillrates = skillrates;
	}
	
	
}
