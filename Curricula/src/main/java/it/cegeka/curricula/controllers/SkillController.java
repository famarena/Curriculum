package it.cegeka.curricula.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.cegeka.curricula.entities.Skill;
import it.cegeka.curricula.service.CandidateService;
import it.cegeka.curricula.service.SkillService;

@RestController
@RequestMapping(path = "/skill")

public class SkillController {
	
	@Autowired
	private SkillService skillService;
	
	@GetMapping(path = "/skills")
	public List<Skill> findAll(){
		
		return skillService.findAll();
	}
	
}
