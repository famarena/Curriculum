package it.cegeka.curricula.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.cegeka.curricula.entities.Interview;

public interface InterviewRepository extends JpaRepository<Interview, Long> {
	
	
}
