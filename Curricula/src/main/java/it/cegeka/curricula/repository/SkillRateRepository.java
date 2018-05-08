package it.cegeka.curricula.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import it.cegeka.curricula.entities.Candidate;
import it.cegeka.curricula.entities.SkillRate;

public interface SkillRateRepository extends JpaRepository<SkillRate, Long> {

	public SkillRate findByCandidateIdCandidateAndSkillName(Long Id, String name);
	
	public List<SkillRate>  findBySkillName(String nameSkill);
}
