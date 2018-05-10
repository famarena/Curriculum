package it.cegeka.curricula.service.utility;

import java.time.LocalDateTime;
import java.util.List;

import it.cegeka.curricula.entities.JobPosition;
import it.cegeka.curricula.entities.RequiredSkill;
import it.cegeka.curricula.enums.Demand;
import it.cegeka.curricula.enums.Sector;

public class PositionViewModel {
	
	private Long idPosition;
	private String positionName;
	private Demand demand;
	private Sector sector;
	
	
	public PositionViewModel(JobPosition position) {
		this.idPosition = position.getIdPosition();
		this.positionName = position.getPositionName();
		this.demand = position.getDemand();
		this.sector = position.getSector();
	}
	public Long getIdPosition() {
		return idPosition;
	}
	public void setIdPosition(Long idPosition) {
		this.idPosition = idPosition;
	}
	public String getPositionName() {
		return positionName;
	}
	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}
	public Demand getDemand() {
		return demand;
	}
	public void setDemand(Demand demand) {
		this.demand = demand;
	}
	
	public Sector getSector() {
		return sector;
	}
	public void setSector(Sector sector) {
		this.sector = sector;
	}
	
	
}
