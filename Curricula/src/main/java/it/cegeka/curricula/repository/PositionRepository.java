package it.cegeka.curricula.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import it.cegeka.curricula.entities.JobPosition;
import it.cegeka.curricula.enums.Demand;


public interface PositionRepository extends JpaRepository<JobPosition, Long> {

	public JobPosition findByIdPosition(Long idPos);
	public List<JobPosition> findByDemand(Demand demand);
}
