package it.cegeka.curricula.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.cegeka.curricula.entities.Skill;


public interface SkillRepository extends JpaRepository<Skill, Long>{
	
	public Skill findByName(String name);

}
