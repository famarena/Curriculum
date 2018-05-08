package it.cegeka.curricula.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.cegeka.curricula.entities.Candidate;

public interface CandidateRepository extends JpaRepository<Candidate, Long> {

}
