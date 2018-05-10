package it.cegeka.curricula.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import it.cegeka.curricula.entities.Candidate;
import it.cegeka.curricula.entities.JobPosition;
import it.cegeka.curricula.entities.RequiredSkill;
import it.cegeka.curricula.enums.Sector;
import it.cegeka.curricula.repository.CandidateRepository;
import it.cegeka.curricula.service.PositionService;
import it.cegeka.curricula.service.utility.PositionViewModel;
import it.cegeka.curricula.service.utility.SkillValue;
@RestController
@RequestMapping(path="/position")
public class JobPositionController {
	
	@Autowired 
	PositionService positionServ;

	
	@GetMapping(path="/detail/{id}")
	public List<RequiredSkill> detailPosition(@PathVariable Long id){
		System.out.println("ciao");
		return positionServ.skillForThisPosition(id);
	}
	
	@GetMapping(path="/{id}")
	public JobPosition positionById(@PathVariable Long id){
		System.out.println("ciao");
		return positionServ.findById(id);
	}
	
	@GetMapping(path="/list")
	public List<Candidate> listCandidate() {
		return positionServ.foundCandidate(5L);
	}
	
	@GetMapping(path= "/allPosition")
	public List<JobPosition> allPosition(){
		return positionServ.allPosition();
	}
	
	@GetMapping(path= "/openPosition")
	public List<PositionViewModel> allOpenPositionsModel(){
		return positionServ.openPositionsModel();
	}
	
	@GetMapping(path= "/bestCandidates/{idPosition}/{num}")
	public List<Candidate> bestNCandidates(@PathVariable Long idPosition, int num){
		return positionServ.findBestNCandidates(num, idPosition);
	}

}
