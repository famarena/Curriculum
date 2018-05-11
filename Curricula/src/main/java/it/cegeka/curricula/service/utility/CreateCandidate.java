package it.cegeka.curricula.service.utility;

import java.time.LocalDate;
import java.util.List;

public class CreateCandidate {

	private String name;
	private String surname;
	private LocalDate bday;
	private List<String> skills;
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
	public LocalDate getBday() {
		return bday;
	}
	public void setBday(LocalDate bday) {
		this.bday = bday;
	}
	public List<String> getSkills() {
		return skills;
	}
	public void setSkills(List<String> skillName) {
		this.skills = skillName;
	}
	public List<Integer> getValue() {
		return value;
	}
	public void setValue(List<Integer> value) {
		this.value = value;
	}
	



}