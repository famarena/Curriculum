package it.cegeka.curricula.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import it.cegeka.curricula.entities.Skill;
import it.cegeka.curricula.repository.SkillRepository;
@Service

public class SkillService {
	
	@Autowired
	private SkillRepository skillRepository ;
	
public List<Skill> findAll(){
		
		return skillRepository.findAll();
	}


}
