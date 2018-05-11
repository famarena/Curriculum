package it.cegeka.curricula.service.utility;

import java.time.LocalDate;
import java.util.List;

public class CreateCandidate {

	private String name;
	private String surname;
	private LocalDate birthday;
	private List<String> skillName;
	private List<Integer> value;
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
	public List<String> getSkillName() {
		return skillName;
	}
	public void setSkillName(List<String> skillName) {
		this.skillName = skillName;
	}
	public List<Integer> getValue() {
		return value;
	}
	public void setValue(List<Integer> value) {
		this.value = value;
	}
	



}