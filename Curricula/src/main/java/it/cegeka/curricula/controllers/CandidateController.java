package it.cegeka.curricula.controllers;

import java.time.LocalDate;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import it.cegeka.curricula.service.CandidateService;




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
	@GetMapping(path="/add")
	@ResponseBody
	public String addNewCandidate() {
		
		LocalDate data = null;
		candidateService.newCandidate("pippo", "caio", data, "link");
		return "Candidate saved";
	
		
	}

	
	
	
}