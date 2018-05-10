package it.cegeka.curricula.service.utility;

import it.cegeka.curricula.entities.Candidate;

public class CandidatePoint {

	private Candidate candidate;
	private int point;
	public Candidate getCandidate() {
		return candidate;
	}
	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
}
