package it.cegeka.curricula.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.cegeka.curricula.repository.CandidateRepository;
import it.cegeka.curricula.repository.SkillRateRepository;
import it.cegeka.curricula.entities.Candidate;
import it.cegeka.curricula.entities.Skill;
import it.cegeka.curricula.entities.SkillRate;

@Service
public class CandidateService {
	
	@Autowired 
	CandidateRepository candidateRepo;
	@Autowired
	SkillRateRepository skillRateRepo;
	
	public void newCandidate(String name, String surname, LocalDate date, String curriculum )
	{
		Candidate candidate = new Candidate(); 
		candidate.setName(name);
		candidate.setSurname(surname);
		candidate.setBirthday(date);
//		candidate.setSkillrates(skills);
		candidate.setCurriculum(curriculum);
		candidateRepo.save(candidate);
		
	}
	
	public void setRealSkill(long id, int realValue, String name)
	{
	    
		SkillRate sr = skillRateRepo.findByCandidateIdCandidateAndSkillName(id, name);
		sr.setRealValue(realValue);
		skillRateRepo.save(sr);
		
	}
	
	public List<Candidate> getCandidatesBySkill(String skillName) {
		List <Candidate> lcand = new ArrayList <Candidate>();
		List<SkillRate> lsr= skillRateRepo.findBySkillName(skillName);
		for(SkillRate sr1: lsr)
		{
			lcand.add(sr1.getCandidate());
		}
		return lcand;
	}

}
