package it.cegeka.curricula.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.cegeka.curricula.entities.Selector;
import it.cegeka.curricula.service.SelectorService;

@RestController
@RequestMapping(path = "/selector")
public class SelectorController {

	@Autowired
	private SelectorService selectorService;
	
	@GetMapping(path="/allSelectors")
	public List<Selector>  allSelectors(){
	 return selectorService.findAll();
	}
	
	
}
