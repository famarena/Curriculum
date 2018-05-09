package it.cegeka.curricula.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;



import it.cegeka.curricula.entities.Candidate;

public interface CandidateRepository extends JpaRepository<Candidate, Long> {

	public Candidate findCandidateByIdCandidate(Long id);
	
}
