package it.cegeka.curricula.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import it.cegeka.curricula.entities.Candidate;
import it.cegeka.curricula.repository.CandidateRepository;



@Controller    
@RequestMapping(path="/candidate") 
public class CandidateController {
	
	@Autowired 
	CandidateRepository candidateRepo;
	
	
	@GetMapping(path="/newCandidate")
	@ResponseBody
	public String newCandidate() {
		Candidate c = new Candidate();
		c.setAge(30);
		c.setName("fff");
		c.setSurname("ddd");
		candidateRepo.save(c);
		return "all";
	}
}