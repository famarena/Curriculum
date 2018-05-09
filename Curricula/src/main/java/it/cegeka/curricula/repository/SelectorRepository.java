package it.cegeka.curricula.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.cegeka.curricula.entities.RequiredSkill;
import it.cegeka.curricula.entities.Selector;

public interface SelectorRepository extends JpaRepository<Selector, Long> {

	public Selector findSelectorById(Long id);
}
