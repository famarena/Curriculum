package it.cegeka.curricula.controllers;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.net.URI;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import it.cegeka.curricula.entities.Candidate;
import it.cegeka.curricula.entities.SkillRate;
import it.cegeka.curricula.service.CandidateService;
import it.cegeka.curricula.service.utility.CreateCandidate;

@RestController
@RequestMapping(path = "/candidate")
public class CandidateController {

	@Autowired
	private CandidateService candidateService;

	@GetMapping("/candidate")
	public List<Candidate> retrieveAllCandidate() {
		return candidateService.findAll();
	}

	@PostMapping(path = "/setCandidateRealSkill")
	public String setkCandidateRealSkill(@RequestParam("id") Long id, @RequestParam("name") String name,
			@RequestParam("value") int value) {
		candidateService.setRealSkill(id, value, name);
		return "Skill setted";
	}

	@GetMapping("/candidate/{id}")
	public Resource<Candidate> retrieveUser(@PathVariable Long id) {
		Candidate candidate = candidateService.findOne(id);
		// if(candidate==null)
		// throw new UserNotFoundException("id-"+ id);
		Resource<Candidate> resource = new Resource<Candidate>(candidate);
		
		ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retrieveAllCandidate());
		resource.add(linkTo.withRel("all-candidate"));
//		Resource<SkillRate> resource2 = new Resource<SkillRate>(candidate.getSkillrates());
		linkTo = linkTo(methodOn(this.getClass()).retrieveUser(id));
		
		resource.add(linkTo.withRel("this-candidate"));
		// HATEOAS
		return resource;
	}

	@PostMapping(path = "/candidate")
	public ResponseEntity<Object> addNewCandidate(@RequestBody Candidate candidate) {
		Candidate savedCandidate = candidateService.save(candidate);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedCandidate.getIdCandidate()).toUri();
		return ResponseEntity.created(location).build();
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
	public String setSkillRate(@RequestParam("id") CreateCandidate skill) {
		candidateService.setInitialSkill(skill);
		return "Skill inserted";
	}
	
	
}