package it.cegeka.curricula.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.cegeka.curricula.entities.Candidate;
import it.cegeka.curricula.entities.JobPosition;
import it.cegeka.curricula.entities.RequiredSkill;
import it.cegeka.curricula.entities.SkillRate;
import it.cegeka.curricula.enums.Demand;
import it.cegeka.curricula.enums.Sector;
import it.cegeka.curricula.repository.CandidateRepository;
import it.cegeka.curricula.repository.PositionRepository;
import it.cegeka.curricula.repository.ReqSkillRepository;
import it.cegeka.curricula.repository.SkillRepository;
import it.cegeka.curricula.service.utility.CandidatePoint;
import it.cegeka.curricula.service.utility.SkillValue;

@Service
public class PositionService {

	@Autowired
	private PositionRepository positionRepository;
	@Autowired
	private SkillRepository skillRepository;
	@Autowired
	private ReqSkillRepository reqSkillRepository;
	@Autowired
	private CandidateRepository candidateRepository;

	public void newPosition(List<SkillValue> reqSkills, Sector sector, String namePosition) {
		JobPosition position = new JobPosition();
		for (SkillValue sv : reqSkills) {
			RequiredSkill r = new RequiredSkill();
			r.setSkill(skillRepository.findByName(sv.getSkillName()));
			r.setMin(sv.getValue());
			r.setJobPosition(position);
			reqSkillRepository.save(r);
		}
		position.setSector(sector);
		position.setDemand(Demand.INSERT);
		position.setPositionName(namePosition);
		positionRepository.save(position);
	}

	public List<Candidate> foundCandidate(Long idPosition) {

		JobPosition position = positionRepository.findByIdPosition(idPosition);
		List<RequiredSkill> req = position.getRequiredSkills();
		List<Candidate> allCandidate = candidateRepository.findAll();
		List<CandidatePoint> candidateWithAtLeastOneSkill = new ArrayList<>();
		List<Candidate> finalCandidateList = new ArrayList<>();
		for (Candidate c : allCandidate) {
			CandidatePoint candidatePoint = new CandidatePoint();
			candidatePoint.setCandidate(c);
			boolean check = false;
			List<SkillRate> skillRates = c.getSkillrates();
			for (SkillRate s : skillRates) {
				for (RequiredSkill skill : req) {
					if (s.getSkill().equals(skill.getSkill())) {
						check = true;
						if (s.getRealValue() != 0) {
							candidatePoint.setPoint(candidatePoint.getPoint() + s.getRealValue());
						} else {
							candidatePoint.setPoint(candidatePoint.getPoint() + s.getDeclaredValue());
						}
					}
				}
			}
			if (check) {
				candidateWithAtLeastOneSkill.add(candidatePoint);

			}
		}
		candidateWithAtLeastOneSkill.sort(Comparator.comparing(CandidatePoint::getPoint).reversed());
		for (CandidatePoint can : candidateWithAtLeastOneSkill) {
			finalCandidateList.add(can.getCandidate());
		}
		return finalCandidateList;
	}
}
