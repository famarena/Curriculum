package it.cegeka.curricula.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import it.cegeka.curricula.repository.PositionRepository;

public class PositionService {

	@Autowired
	private PositionRepository positionRepository;
	
	public void newPosition(List<RequiredSkill> reqSkills, Enum Sector) {
		
	}
}
