package it.cegeka.curricula.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import it.cegeka.curricula.repository.CandidateRepository;
import it.cegeka.curricula.repository.SkillRateRepository;
import it.cegeka.curricula.repository.SkillRepository;
import it.cegeka.curricula.service.utility.CreateCandidate;
import it.cegeka.curricula.entities.Candidate;
import it.cegeka.curricula.entities.Skill;
import it.cegeka.curricula.entities.SkillRate;

@Service
public class CandidateService {

	@Autowired

	CandidateRepository candidateRepo;
	@Autowired
	SkillRateRepository skillRateRepo;
	@Autowired
	SkillRepository skillRepo;

	// public void newCandidate(String name, String surname, LocalDate date, String
	// curriculum) {
	// Candidate candidate = new Candidate();
	// candidate.setName(name);
	// candidate.setSurname(surname);
	// candidate.setBirthday(date);
	// candidate.setSkillrates(skills);
	// candidate.setCurriculum(curriculum);
	// candidateRepo.save(candidate);
	// }

	public void setRealSkill(long id, int realValue, String name) {
		SkillRate sr = skillRateRepo.findByCandidateIdCandidateAndSkillName(id, name);
		sr.setRealValue(realValue);
		skillRateRepo.save(sr);
	}

	public List<Candidate> getCandidatesBySkill(String skillName) {
		List<Candidate> lcand = new ArrayList<Candidate>();
		List<SkillRate> lsr = skillRateRepo.findBySkillName(skillName);
		for (SkillRate sr1 : lsr) {
			lcand.add(sr1.getCandidate());
		}
		return lcand;
	}

	public List<Candidate> getCandidatesBySurname(String surname) {
		List<Candidate> lcand = candidateRepo.findBySurnameStartsWith(surname);
		return lcand;
	}

	public void setInitialSkill(CreateCandidate newCandidate) {
		
//		Optional<Candidate> opt = candidateRepo.findById(skill.getId());
		Candidate candidate= new Candidate();
		candidate.setName(newCandidate.getName());
		candidate.setSurname(newCandidate.getSurname());
		candidate.setBirthday(newCandidate.getBday());
		List<String> skillNames = newCandidate.getSkills();
		List<Integer> skillValues = newCandidate.getValue();
		for(int i=0; i<skillNames.size();i++)
		{
			SkillRate e = new SkillRate();
	        Skill skill = skillRepo.findByName(skillNames.get(i));
	        e.setSkill(skill);
	        e.setDeclaredValue(skillValues.get(i));
			e.setCandidate(candidate);
			candidate.getSkillrates().add(e);
	       
		}
		 candidateRepo.save(candidate);
		
		
	}

	public Candidate save(Candidate candidate) {
		return candidateRepo.save(candidate);
	}

	public Candidate findOne(Long id) {
		Optional<Candidate> opt = candidateRepo.findById(id);
		return opt.get();

	}

	public List<Candidate> findAll() {
		return candidateRepo.findAll();
	}
}
