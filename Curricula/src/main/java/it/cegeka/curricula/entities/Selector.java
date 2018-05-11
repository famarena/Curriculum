package it.cegeka.curricula.entities;

import java.time.LocalDate;

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

import it.cegeka.curricula.enums.Sector;
@Entity
@Table(name="selector")
public class Selector {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name = "id_selector")
	private Long idSelector;
	@Column(name = "name")
	private String name;
	@Column(name = "surname")
	private String surname;
	@Column(name = "sector")
	@Enumerated(EnumType.STRING)
	private Sector sector;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL ,mappedBy = "selector")
	private List<Interview> interviews;
	
	public Selector() {
		
	}

	public Long getIdSelector() {
		return idSelector;
	}

	public void setIdSelector(Long idSelector) {
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

	public Sector getSector() {
		return sector;
	}

	public void setSector(Sector sector) {
		this.sector = sector;
	}

	

}
