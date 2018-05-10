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
import it.cegeka.curricula.repository.CandidateRepository;
import it.cegeka.curricula.service.PositionService;
import it.cegeka.curricula.service.utility.SkillValue;
@Controller
@RequestMapping(path="/position")
public class JobPositionController {

	@Autowired 
	CandidateRepository candidateRepo;
	
	
	@Autowired 
	PositionService positionServ;
	
	//jefjefn
	
	@GetMapping(path="/newPosition")
	@ResponseBody
	public String newPosition() {
		SkillValue s1 = new SkillValue();
		SkillValue s2 = new SkillValue();
		SkillValue s3 = new SkillValue();
		s1.setSkillName("Java");
		s1.setValue(1);
		s2.setSkillName("MySQL");
		s2.setValue(1);
		s3.setSkillName("C");
		s3.setValue(1);
		
		List<SkillValue> reqSkills = new ArrayList<>();
		reqSkills.add(s1);
		reqSkills.add(s2);
		reqSkills.add(s3);

		positionServ.newPosition(reqSkills, Sector.IT, "junior dev");
		return "all";
	}
	
	@GetMapping(path="/list")
	@ResponseBody
	public List<Candidate> listCandidate() {
		
		return positionServ.foundCandidate(5L);
	}
	
}
