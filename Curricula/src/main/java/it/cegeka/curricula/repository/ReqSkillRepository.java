package it.cegeka.curricula.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.cegeka.curricula.entities.RequiredSkill;


public interface ReqSkillRepository extends JpaRepository<RequiredSkill, Long> {

}
