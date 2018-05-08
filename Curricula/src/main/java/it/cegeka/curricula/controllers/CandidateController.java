package it.cegeka.curricula.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import it.cegeka.curricula.entities.Candidate;
import it.cegeka.curricula.enums.Sector;
import it.cegeka.curricula.enums.SkillCategory;
import it.cegeka.curricula.repository.CandidateRepository;
import it.cegeka.curricula.service.CandidateService;
import it.cegeka.curricula.service.PositionService;
import it.cegeka.curricula.service.utility.SkillValue;



@Controller    
@RequestMapping(path="/candidate") 
public class CandidateController {


	@Autowired 
	CandidateService candidateService;
	
	@GetMapping(path="/asd")
	@ResponseBody
	public String test() {
		
		candidateService.setRealSkill(1, 5, "Java");
		return "pippo";
	
	}

	
	
	
}