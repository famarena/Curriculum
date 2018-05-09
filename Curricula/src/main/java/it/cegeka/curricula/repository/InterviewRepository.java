package it.cegeka.curricula.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import it.cegeka.curricula.entities.Interview;

public interface InterviewRepository extends JpaRepository<Interview, Long> {
	
	public Interview findByIdInterview(Long id);
	
	public List<Interview> findByDateTime(LocalDateTime date);
	
	public List<Interview> findByDateTimeBetween(LocalDateTime date1, LocalDateTime date2);
}
