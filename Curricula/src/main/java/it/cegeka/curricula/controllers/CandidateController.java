package it.cegeka.curricula.controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import it.cegeka.curricula.entities.Candidate;
import it.cegeka.curricula.service.CandidateService;

@Controller
@RequestMapping(path = "/candidate")
public class CandidateController {

	@Autowired
	private CandidateService candidateService;

	@GetMapping(path = "/setCandidateRealSkill")
	@ResponseBody
	public String setkCandidateRealSkill(@RequestParam("id") Long id,@RequestParam("nome") String nome,@RequestParam("value") int value) {
		candidateService.setRealSkill(id, value, nome);
		return "Skill setted";
	}

	@GetMapping(path = "/add")
	@ResponseBody
	public String addNewCandidate(@RequestParam("name") String name,@RequestParam("surname") String surname,@RequestParam("cv") String cv) {
		LocalDate data = null;
		candidateService.newCandidate(name , surname , data, cv);
		return "Candidate saved";
	}

	@GetMapping(path = "/findBySkill")
	@ResponseBody
	public List<Candidate> findCandidatebySkillName() {
		List<Candidate> lcand = candidateService.getCandidatesBySkill("Java");
		return lcand;
	}

	@GetMapping(path = "/findBySurname")
	@ResponseBody
	public List<Candidate> findCandidatebySurname(@RequestParam("string") String string) {
		
		List<Candidate> lcand = candidateService.getCandidatesBySurname(string);
		return lcand;
	}

}