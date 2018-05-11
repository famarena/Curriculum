package it.cegeka.curricula.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.cegeka.curricula.entities.Selector;
import it.cegeka.curricula.repository.SelectorRepository;

@Service
public class SelectorService {
	@Autowired
	public SelectorRepository selectorRepository;
	
	public List<Selector> findAll(){
		return selectorRepository.findAll(); 
	}
}
