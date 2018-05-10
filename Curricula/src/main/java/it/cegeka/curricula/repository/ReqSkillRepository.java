package it.cegeka.curricula.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import it.cegeka.curricula.entities.RequiredSkill;


public interface ReqSkillRepository extends JpaRepository<RequiredSkill, Long> {

	public List<RequiredSkill> findByJobPosition(Long idPosition);
}
