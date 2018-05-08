package it.cegeka.curricula.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.cegeka.curricula.entities.JobPosition;


public interface PositionRepository extends JpaRepository<JobPosition, Long> {

}
