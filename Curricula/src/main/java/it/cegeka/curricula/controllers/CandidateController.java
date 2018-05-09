package it.cegeka.curricula.controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.cegeka.curricula.entities.Candidate;
import it.cegeka.curricula.service.CandidateService;

@RestController
@RequestMapping(path = "/candidate")
public class CandidateController {

	@Autowired
	private CandidateService candidateService;

	@PostMapping(path = "/setCandidateRealSkill")
	public String setkCandidateRealSkill(@RequestParam("id") Long id, @RequestParam("name") String name,
			@RequestParam("value") int value) {
		candidateService.setRealSkill(id, value, name);
		return "Skill setted";
	}

	@PostMapping(path = "/add")
	public String addNewCandidate(@RequestParam("name") String name, @RequestParam("surname") String surname,
			@RequestParam("cv") String cv) {
		LocalDate data = null;
		candidateService.newCandidate(name, surname, data, cv);
		return "Candidate saved";
	}

	@GetMapping(path = "/findBySkill")
	public List<Candidate> findCandidatebySkillName(@RequestParam("skill") String skill) {
		List<Candidate> lcand = candidateService.getCandidatesBySkill(skill);
		return lcand;
	}

	@GetMapping(path = "/findBySurname")
	public List<Candidate> findCandidatebySurname(@RequestParam("string") String string) {
		List<Candidate> lcand = candidateService.getCandidatesBySurname(string);
		return lcand;
	}

	@PostMapping(path = "/setSkillRate")
	public String setSkillRate(@RequestParam("id") Long id, @RequestParam("nameSkill") String name,
			@RequestParam("value") Integer value) {

		candidateService.setInitialSkill(id, name, value);
		return "Skill settata";
	}

}