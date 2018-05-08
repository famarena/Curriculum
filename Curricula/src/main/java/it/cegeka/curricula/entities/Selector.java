package it.cegeka.curricula.entities;

import java.time.LocalDate;

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
@Table(name="selector")
public class Selector {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name = "id_selector")
	private int idSelector;
	@Column(name = "name")
	private String name;
	@Column(name = "surname")
	private String surname;
	@Column(name = "sector")
	private Enum sector;
	
	@OneToMany(cascade = CascadeType.ALL ,mappedBy = "selector")
	private List<Interview> interviews;
	
	public Selector() {
		
	}

	public int getIdSelector() {
		return idSelector;
	}

	public void setIdSelector(int idSelector) {
		this.idSelector = idSelector;
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

	public List<Interview> getInterviews() {
		return interviews;
	}

	public void setInterviews(List<Interview> interviews) {
		this.interviews = interviews;
	}

	public Enum getSector() {
		return sector;
	}

	public void setSector(Enum sector) {
		sector = sector;
	}

	

}
