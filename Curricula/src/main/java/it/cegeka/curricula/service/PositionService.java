package it.cegeka.curricula.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.cegeka.curricula.entities.JobPosition;
import it.cegeka.curricula.entities.RequiredSkill;
import it.cegeka.curricula.enums.Sector;
import it.cegeka.curricula.repository.PositionRepository;
import it.cegeka.curricula.repository.ReqSkillRepository;
import it.cegeka.curricula.repository.SkillRepository;
import it.cegeka.curricula.service.utility.SkillValue;


@Service
public class PositionService {

	@Autowired
	private PositionRepository positionRepository;
	@Autowired
	private SkillRepository skillRepository;
	@Autowired
	private ReqSkillRepository reqSkillRepository;


	
	public void newPosition(List<SkillValue> reqSkills, Sector sector, String namePosition) 
	{
		JobPosition position = new JobPosition();
		for(SkillValue sv : reqSkills) 
		{
			RequiredSkill r= new RequiredSkill();
			r.setSkill(skillRepository.findSkillByName(sv.getSkillName()));
			r.setMin(sv.getValue());
			r.setJobPosition(position);
			reqSkillRepository.save(r);
		}
		position.setSector(sector);
		position.setOpen(true);
		position.setPositionName(namePosition);
		positionRepository.save(position);
	}
	
	public void updatePosition(Long idPosition ) {
		
	}
}
